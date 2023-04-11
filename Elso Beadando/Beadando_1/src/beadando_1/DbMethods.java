package beadando_1;

import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DbMethods {

	public static void Reg() {

		try {
			Class.forName("org.sqlite.JDBC");
		} catch (Exception ex) {
			Program.SM(ex.toString(), 2);
		}

	}

	public Connection Connect() {
		Connection conn = null;
		String url = "jdbc:sqlite:C:/sql3/bus.db";
		try {
			conn = DriverManager.getConnection(url);
			conn.setAutoCommit(false);
			return conn;
		} catch (Exception ex) {
			Program.SM(ex.toString(), 0);
			return conn;
		}
	}

	public void Disconnect(Connection conn) {

		if (conn != null) {
			try {
				conn.close();

			} catch (Exception ex) {

				Program.SM(ex.toString(), 0);
			}

		}

	}

	public static ResultSet customQuery(Connection conn, String ststring) throws Exception {
		if (conn != null) {

			if (!ststring.split(" ")[0].equalsIgnoreCase("select"))
				throw new Exception("Not a Query command!");

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(ststring);

			return rs;

		} else
			throw new Exception("Connection Failure");

	}

	public static EmpTM getDefaultTable() {

		Object[] head = { "" };
		return new EmpTM(head, 0);
	}

	public static EmpTM getDefaultTable2() {

		Object[] head = { "a", "b", "c", "d" };
		return new EmpTM(head, 0);
	}

	public static EmpTM getTableFromQuery(Connection conn, String sql) throws Exception {

		ResultSet rs = customQuery(conn, sql);
		ResultSetMetaData rsMeta = rs.getMetaData();
		EmpTM retTable;

		int count = rsMeta.getColumnCount();

		Object[] head = new Object[count];

		for (int i = 1; i <= count; i++) {

			head[i - 1] = rsMeta.getColumnLabel(i);

		}

		retTable = new EmpTM(head, 0);
		Object[] row = new Object[rsMeta.getColumnCount()];

		while (rs.next()) {

			for (int i = 0; i < count; i++) {
				row[i] = rs.getString(i + 1);
			}

			retTable.addRow(row);

		}

		return retTable;

	}

	public static void saveTableToFile(EmpTM table, String sql, String filename) throws Exception {

		FileWriter fwrt = new FileWriter(filename);

		int Col = table.getColumnCount();
		int Row = table.getRowCount();

		for (int i = 0; i < Col; i++) {
			fwrt.write(table.getColumnName(i).toString());
			if (i < Col - 1) {
				fwrt.write(";");
			} else {
				fwrt.write("\n");
			}
		}

		for (int i = 0; i < Row; i++) {
			for (int j = 0; j < Col; j++) {
				fwrt.write(table.getValueAt(i, j).toString());
				if (j < Col - 1) {
					fwrt.write(";");
				} else {
					fwrt.write("\n");
				}
			}
		}

		fwrt.flush();
		fwrt.close();

	}

	public static boolean testLogin(Connection conn, String usr, String passwd) throws Exception {

		if (conn != null) {

			try {

				ResultSet rs = DbMethods.customQuery(conn, "SELECT passwd FROM login WHERE uname='" + usr + "'");

				if (rs.next()) {

					if (passwd.equals(rs.getString(1)))
						return true;

					else

						return false;

				} else
					return false;

			} catch (SQLException sqle) {

				Program.SM(sqle.toString(), 0);
				sqle.printStackTrace();
				return false;
			}
		} else
			return false;

	}

	public static void insertPreparedStatement(Connection conn, String table, Object[] data) throws Exception {

		String ID = "";
		int intID = 0;

		switch (table) {
		case "Sofõr":
			ID = "SOID";
			break;
		case "Busz":
			ID = "BID";
			break;
		case "Útvonal":
			ID = "ÚTID";
			break;
		case "Vezeti":
		case "Járat":
			break;
		default:
			throw new Exception("No such table exist in Database!");
		}

		if (!ID.equals("")) {
			ResultSet rs = DbMethods.customQuery(conn, "SELECT max(" + ID + ") from " + table);
			if (rs.next()) {
				intID = rs.getInt(1);
			}
		}

		String commandText = "";

		switch (table) {
		case "Sofõr":
			commandText = "INSERT INTO Sofõr VALUES(?,?,?,?,?,?)";
			break;
		case "Busz":
			commandText = "INSERT INTO Busz VALUES(?,?,?,?,?,?,?)";
			break;
		case "Útvonal":
			commandText = "INSERT INTO Útvonal VALUES(?,?,?,?)";
			break;
		case "Vezeti":
			commandText = "INSERT INTO Vezeti VALUES(?,?)";
			break;
		case "Járat":
			commandText = "INSERT INTO Járat VALUES(?,?,?)";
			break;
		default:
			break;
		}

		var pstmt = conn.prepareStatement(commandText);

		switch (table) {
		case "Sofõr":
			pstmt.setInt(1, intID + 1);
			pstmt.setString(2, (String) data[0]);
			pstmt.setString(3, (String) data[1]);
			pstmt.setString(4, (String) data[2]);
			pstmt.setInt(5, Integer.parseInt(data[3].toString()));
			pstmt.setInt(6, Integer.parseInt(data[4].toString()));
			break;
		case "Busz":
			pstmt.setInt(1, intID + 1);
			pstmt.setString(2, (String) data[0]);
			pstmt.setString(3, (String) data[1]);
			pstmt.setInt(4, Integer.parseInt(data[2].toString()));
			pstmt.setInt(5, Integer.parseInt(data[3].toString()));
			pstmt.setInt(6, Integer.parseInt(data[4].toString()));
			pstmt.setString(7, (String) data[5]);
			break;
		case "Útvonal":
			pstmt.setInt(1, intID + 1);
			pstmt.setString(2, (String) data[0]);
			pstmt.setInt(3, Integer.parseInt(data[1].toString()));
			pstmt.setInt(4, Integer.parseInt(data[2].toString()));
			break;
		case "Vezeti":
			pstmt.setInt(1, Integer.parseInt(data[0].toString()));
			pstmt.setInt(2, Integer.parseInt(data[1].toString()));
			break;
		case "Járat":

			if (!data[1].toString()
					.matches("\\d{2}-(JAN|FEB|MAR|APR|MAY|JUN|JUL|AUG|SEP|OCT|NOV|DEC)-\\d{2} \\d{2}.\\d{2}.\\d{2}"))
				throw new Exception("Illegal DateTime format!");

			pstmt.setInt(1, Integer.parseInt(data[0].toString()));
			pstmt.setString(2, (String) data[1]);
			pstmt.setInt(3, Integer.parseInt(data[2].toString()));
			break;
		default:
			break;
		}

		
		pstmt.execute();
		
		try {
			
			conn.commit();
		} catch (SQLException sqle) {
			conn.rollback();
		}
		

	}

	public static EmpTM preparedStatementQueryToTable(Connection conn, int tableIndex, Object[] data) throws Exception {

		String commandText = "";
		String op = "";
		switch (tableIndex) {

		case 0: {
			commandText = "Select * from Sofõr where Város=?";
			break;
		}
		case 1: {

			if ((boolean) data[1]) {
				op = "<";
			} else {
				op = ">";
			}

			commandText = "Select * from Sofõr where Születési_év" + op + "?";
			break;
		}
		case 2: {

			if ((boolean) data[1]) {
				op = "<";
			} else {
				op = ">";
			}

			commandText = "Select * from Busz where Férõhely" + op + "?";
			break;
		}

		case 3: {
			commandText = "Select * from Busz where Üzemanyag=?";
			break;
		}

		case 4: {

			if ((boolean) data[1]) {
				op = "<";
			} else {
				op = ">";
			}

			commandText = "Select * from Útvonal where Megállók_száma" + op + "?";
			break;
		}

		case 5: {

			if ((boolean) data[2]) {
				op = "<";
			} else {
				op = ">";
			}

			commandText = "Select b.BID,b.Márka,b.Üzemanyag,b.Férõhely,b.Rendszám,j.ÚTID,j.Indulási_idõ,u.Útvonal_név,u.Megállók_száma,u.Úthossz"
					+ " from Busz b inner join Járat j on b.BID=j.BID inner join Útvonal u on u.ÚTID=j.ÚTID where b.Márka = ? AND b.Férõhely "
					+ op + "? ";
			break;
		}

		case 6: {

			if ((boolean) data[2]) {
				op = "<";
			} else {
				op = ">";
			}

			commandText = "select b.BID,b.Márka,b.Fogyasztás,b.Férõhely,b.Rendszám,j.Indulási_idõ,u.Útvonal_név,u.Megállók_száma,u.Úthossz"
					+ " from Busz b inner join Járat j on b.BID=j.BID inner join Útvonal u on u.ÚTID=j.ÚTID where"
					+ " b.Üzemanyag = ? AND b.BID in(select BID from(select b.BID,count(*) darab from Busz b inner join"
					+ " Járat j on b.BID = j.BID inner join Útvonal u on u.ÚTID=j.ÚTID group by b.BID) where darab " + op + " ?) group by u.ÚTID";
			break;
		}
		default:
			Program.SM("FetchTable out of Index!", 0);
			break;
		}

		var pstmt = conn.prepareStatement(commandText);

		switch (tableIndex) {

		case 0: {
			pstmt.setString(1, (String) data[0]);
			break;
		}
		case 1: {
			pstmt.setInt(1, Integer.parseInt(data[0].toString()));
			break;
		}
		case 2: {
			pstmt.setInt(1, Integer.parseInt(data[0].toString()));
			break;
		}
		case 3: {
			pstmt.setString(1, (String) data[0]);
			break;
		}
		case 4: {
			pstmt.setInt(1, Integer.parseInt(data[0].toString()));
			break;
		}
		case 5: {
			pstmt.setString(1, (String) data[0]);
			pstmt.setInt(2, Integer.parseInt(data[1].toString()));
			break;
		}
		case 6: {
			pstmt.setString(1, (String) data[0]);
			pstmt.setInt(2, Integer.parseInt(data[1].toString()));
			break;
		}

		default:
			break;
		}

		return resultSetToTable(pstmt.executeQuery());
		
	}
	
	
	public static EmpTM resultSetToTable(ResultSet rs) throws Exception{
		
	ResultSetMetaData rsMeta = rs.getMetaData();
	EmpTM retTable;

	int count = rsMeta.getColumnCount();

	Object[] head = new Object[count];

	for (int i = 1; i <= count; i++) {

		head[i - 1] = rsMeta.getColumnLabel(i);

	}

	retTable = new EmpTM(head, 0);
	Object[] row = new Object[rsMeta.getColumnCount()];

	while (rs.next()) {

		for (int i = 0; i < count; i++) {
			row[i] = rs.getString(i + 1);
		}

		retTable.addRow(row);

	}

	return retTable;}

}
