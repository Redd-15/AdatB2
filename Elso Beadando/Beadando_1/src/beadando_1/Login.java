package beadando_1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class Login extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JButton btnLogin;
	private JTextField txtUsername;
	private JTextField txtPassw;
	private Connection conn;

	public Login(Connection connp) {

		conn = connp;
		this.setTitle("Login");
		setBounds(100, 100, 319, 199);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setBounds(27, 32, 96, 13);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(27, 90, 96, 13);
		contentPanel.add(lblNewLabel_1);

		txtUsername = new JTextField();
		txtUsername.setBounds(149, 29, 96, 19);
		contentPanel.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassw = new JPasswordField();
		txtPassw.setBounds(149, 87, 96, 19);
		contentPanel.add(txtPassw);
		txtPassw.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnLogin = new JButton("Login");
				buttonPane.add(btnLogin);
				getRootPane().setDefaultButton(btnLogin);
				btnLogin.addActionListener(this);
			}
			{
				JButton btnCancel = new JButton("Cancel");
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
				btnCancel.addActionListener(this);
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		try {
			
			switch (e.getActionCommand()) {
			case "Login":

				if (DbMethods.testLogin(conn, txtUsername.getText(), txtPassw.getText())) {
					Program.setLoggedIn(true);
					Program.SM("Login successful!", 1);
					Program.switchToMenuFromDialog(this);
				} else {
					txtPassw.setText("");
					Program.SM("Login unsuccessful! Try again!", 2);
				}
				break;

			case "Cancel":

				Program.switchToMenuFromDialog(this);

				break;
			default:
				break;
			}

		} catch (Exception ex) {
			Program.SM(ex.toString(), 0);
		}

	}
}
