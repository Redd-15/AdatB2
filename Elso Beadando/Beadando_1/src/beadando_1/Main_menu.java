package beadando_1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Main_menu extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JButton btnRel_mod;
	private JButton btnPrep_query;
	private JButton btnCustom;
	private JButton btnFile;
	private JButton btnInsert;
	private JButton btnLogout;
	private JButton btnLogin;
	private JButton btnExit;

	public Main_menu() {
		this.setTitle("Main Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 471);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		btnLogin = new JButton("Login");
		btnLogin.setActionCommand("Login");
		contentPane.add(btnLogin);
		btnLogin.addActionListener(this);

		btnRel_mod = new JButton("Relations Model");
		btnRel_mod.setEnabled(false);
		btnRel_mod.setActionCommand("Rel_mod");
		contentPane.add(btnRel_mod);
		btnRel_mod.addActionListener(this);

		btnPrep_query = new JButton("Prepared Query");
		btnPrep_query.setEnabled(false);
		btnPrep_query.setActionCommand("Prep_query");
		contentPane.add(btnPrep_query);
		btnPrep_query.addActionListener(this);

		btnCustom = new JButton("Custom Query");
		btnCustom.setEnabled(false);
		btnCustom.setActionCommand("Custom_query");
		contentPane.add(btnCustom);
		btnCustom.addActionListener(this);
		
		btnFile = new JButton("Query to File");
		btnFile.setEnabled(false);
		btnFile.setActionCommand("File");
		contentPane.add(btnFile);
		btnFile.addActionListener(this);

		btnInsert = new JButton("Insert Data");
		btnInsert.setEnabled(false);
		btnInsert.setActionCommand("Insert");
		contentPane.add(btnInsert);
		btnInsert.addActionListener(this);

		btnLogout = new JButton("Logout");
		btnLogout.setEnabled(false);
		btnLogout.setActionCommand("Logout");
		contentPane.add(btnLogout);
		btnLogout.addActionListener(this);
		
		btnExit = new JButton("Exit");
		btnExit.setEnabled(true);
		btnExit.setActionCommand("Exit");
		contentPane.add(btnExit);
		btnExit.addActionListener(this);
	}

	void loginEnabling(boolean b) {

		btnRel_mod.setEnabled(b);
		btnPrep_query.setEnabled(b);
		btnCustom.setEnabled(b);
		btnFile.setEnabled(b);
		btnInsert.setEnabled(b);
		btnLogout.setEnabled(b);
		btnLogin.setEnabled(!b);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Login": 
			Program.initiateLogin();
			break;
		
		case "Logout": 
			Program.initiateLogout();
			break;
		
		case "Insert":
		case "Prep_query":
		case "Rel_mod":
		case "Custom_query":
		case "File":

			Program.switchToDialog(e.getActionCommand());
			break;
			
		case "Exit":
			Program.exit();
			break;
			
		default:
			Program.SM("Unexpected value: " + e.getActionCommand(), 1);
		

		}
	}
}
