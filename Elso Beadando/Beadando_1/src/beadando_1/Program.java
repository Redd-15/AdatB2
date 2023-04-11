package beadando_1;

import java.sql.Connection;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Program {

	private static DbMethods dbm = new DbMethods();
	private static Main_menu menu = new Main_menu();
	private static boolean loggedIn;
	private static Connection conn = null;

	public static void main(String[] args) {
		DbMethods.Reg();
		loggedIn = false;
		menu.setVisible(true);
		//usrname and passwd: admin admin
	}

	public static void initiateLogin() {

		conn = dbm.Connect();
		JDialog login = new Login(conn);
		login.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

		menu.setVisible(false);
		login.setVisible(true);

	}

	public static void initiateLogout() {

		dbm.Disconnect(conn);
		setLoggedIn(false);
		SM("Logout completed!", 2);
	}

	public static boolean getLoggedIn() {
		return loggedIn;
	}

	public static void setLoggedIn(boolean b) {
		menu.loginEnabling(b);
		loggedIn = b;
	}

	public static void SM(String s, int type) {
		JOptionPane.showMessageDialog(null, s, "Message", type);
		// type: 0-X 1-! 2-!! 3-?;
	}

	public static void switchToDialog(String window) {
		JDialog newWindow = null;
		
		switch (window) {
		
		case "Rel_mod":
			
			newWindow = new Rel_modell();
			break;
			
		case "Insert":
			newWindow = new Insert(conn);
			break;

		case "Prep_query":
			newWindow = new Prepared_query(conn);
			break;
			
		case "Custom_query":
			newWindow = new Custom_query(conn);
			break;
		case "File":
			newWindow = new Query_to_file(conn);
			break;

		default:
			break;
		}
		
		newWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		menu.setVisible(false);
		newWindow.setVisible(true);


	}

	public static void switchToMenuFromDialog(JDialog prevWindow) {

		JDialog prev = prevWindow;
		menu.setVisible(true);
		prev.dispose();

	}
	
	public static void exit() {
		dbm.Disconnect(conn);
		menu.dispose();
		
		
	}

}
