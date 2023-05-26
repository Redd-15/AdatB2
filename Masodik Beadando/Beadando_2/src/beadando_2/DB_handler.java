package beadando_2;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DB_handler {
	private String connectionString;
	private String password;
	private String userName;
	private DateTimeFormatter dtf;

	public DB_handler(String connectionString, String userName, String password, String format){
		this.connectionString = connectionString;
		this.userName=userName;
		this.password=password;
		this.dtf = DateTimeFormatter.ofPattern(format);
	}
	public void readCalls() {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.FILE_FELTOLT_HIVAS}");
			cstmt.execute();
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		disconnect(conn);
	}
	
	public void randomGenerateCars() {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.RAND_FELTOLT_AUTO()}");
			cstmt.execute();
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		disconnect(conn);
	}
	
	public void addCall(String name, String phone, String address, int priority) {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.UJ_HIVAS(?, ?, ?, ?)}");
			cstmt.setString(1, name);
			cstmt.setString(2, phone);
			cstmt.setString(3, address);
			cstmt.setInt(4, priority);
			cstmt.execute();
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		disconnect(conn);
	}
	
	public void addCar(String plate, String brand) {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.UJ_AUTO(?, ?)}");
			cstmt.setString(1, plate);
			cstmt.setString(2, brand);
			cstmt.execute();
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		disconnect(conn);
	}
	
	public void addDoc(String name, String job) {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.UJ_MENTOS(?, ?)}");
			cstmt.setString(1, name);
			cstmt.setString(2, job);
			cstmt.execute();
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		disconnect(conn);
	}
	
	public void addSquad(int OID, int MID) {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.UJ_OSZTAG(?, ?)}");
			cstmt.setInt(1, OID);
			cstmt.setInt(2, MID);
			cstmt.execute();
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		disconnect(conn);
	}
	
	public void assignToSite(int HID, int AID) {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.KIVONULAS_HOZZARENDELES(?, ?, ?)}");
			cstmt.setInt(1, HID);
			cstmt.setInt(2, AID);
			cstmt.registerOutParameter(3, Types.INTEGER);
			cstmt.execute();
			int PID = cstmt.getInt(1);
			System.out.println("Kivonulas ID: " + PID );
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		disconnect(conn);
	}
	
	public void endSite(int KID, LocalDateTime kierkezes, String kimenetel) {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.KIVONULAS_KIMENETEL(?, ?, ?)}");
			cstmt.setInt(1, KID);
			cstmt.setTimestamp(2, Timestamp.valueOf(kierkezes));
			cstmt.setString(3, kimenetel);
			cstmt.execute();
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		disconnect(conn);
	}
	
	public void filterCallsByName(String nev) {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.HIVASOK_SZURES_NEV(?)}");
			cstmt.setString(1, nev);
			cstmt.execute();
			ResultSet rs = (ResultSet)cstmt.getObject(2);
			System.out.format("%4s%20s%20s%35s%6s%n", "id","idõpont", "név", "telefonszám", "cím", "prioritási szint");
			while(rs.next()) {
				System.out.format("%4s%20s%20s%35s%6s%n", rs.getInt(1), rs.getTimestamp(2).toLocalDateTime().format(dtf), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
			rs.close();
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		disconnect(conn);
	}
	
	public void filterCallsByTime(LocalDateTime begin, LocalDateTime end) {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.HIVASOK_SZURES_IDOSZAK(?, ?)}");
			cstmt.setTimestamp(1, Timestamp.valueOf(begin));
			cstmt.setTimestamp(2, Timestamp.valueOf(end));
			cstmt.execute();
			ResultSet rs = (ResultSet)cstmt.getObject(3);
			System.out.format("%4s%20s%20s%35s%6s%n", "id","idõpont", "név", "telefonszám", "cím", "prioritási szint");
			while(rs.next()) {
				System.out.format("%4s%20s%20s%35s%6s%n", rs.getInt(1), rs.getTimestamp(2).toLocalDateTime().format(dtf), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6));
			}
			rs.close();
			cstmt.close();
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		disconnect(conn);
	}

	
	public int numberOfCallsOn(LocalDate day) {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{?=call MENTOSZOLGALAT.NAPI_HIVASOK_SZAMA(?)}");
			cstmt.registerOutParameter(1, Types.INTEGER);
			cstmt.setDate(2, Date.valueOf(day));
			cstmt.execute();
			int out = cstmt.getInt(1);
			cstmt.close();
			disconnect(conn);
			return out;
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			disconnect(conn);
			return -1;
		}
	}
	
	/*public void delete() {
		Connection conn = connect();
		try {
			CallableStatement cstmt = conn.prepareCall("{call MENTOSZOLGALAT.TORLES_MIND()}");
			cstmt.execute();
			cstmt.close();
			disconnect(conn);
		}catch(SQLException ex) {
			System.out.println(ex.getMessage());
			disconnect(conn);
		}
	}*/
	
	public boolean isValidConnection() {
		Connection conn = connect();
		if(conn==null)return false;
		else {
			disconnect(conn);
			return true;
		}
	}
	
	private Connection connect() {
		Connection conn=null;
		try {
			conn=DriverManager.getConnection(connectionString, userName, password);
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return conn;
		
	}
	
	private void disconnect(Connection conn) {
		try {
			if(conn!=null) {
				conn.close();
			}
		} catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public DateTimeFormatter getDtf() {
		return dtf;
	}
}
