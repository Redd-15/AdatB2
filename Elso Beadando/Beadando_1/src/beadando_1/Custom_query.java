package beadando_1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class Custom_query extends JDialog implements ActionListener {
	private JTextField textField;
	private JLabel lblNewLabel;
	private Connection conn;
	private JPanel panel_1;
	private JButton btnFetch;
	private JButton btnBack;
	private JPanel commandPanel;
	private JTable table;
	private JScrollPane scrollPane;

	public Custom_query(Connection connp) {

		conn = connp;

		this.setTitle("Custom query");
		setBounds(100, 100, 909, 690);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 725, 0 };
		gridBagLayout.rowHeights = new int[] { 46, 554, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		commandPanel = new JPanel();
		GridBagConstraints gbc_commandPanel = new GridBagConstraints();
		gbc_commandPanel.insets = new Insets(0, 0, 5, 0);
		gbc_commandPanel.fill = GridBagConstraints.HORIZONTAL;
		gbc_commandPanel.gridx = 0;
		gbc_commandPanel.gridy = 0;
		getContentPane().add(commandPanel, gbc_commandPanel);
		GridBagLayout gbl_commandPanel = new GridBagLayout();
		gbl_commandPanel.columnWidths = new int[] { 106, 96, 0, 0 };
		gbl_commandPanel.rowHeights = new int[] { 52, 0 };
		gbl_commandPanel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_commandPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		commandPanel.setLayout(gbl_commandPanel);
		{

			lblNewLabel = new JLabel("Command:");
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
			gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			commandPanel.add(lblNewLabel, gbc_lblNewLabel);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		}

		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		commandPanel.add(textField, gbc_textField);
		textField.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.EAST;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		getContentPane().add(panel_1, gbc_panel_1);

		btnFetch = new JButton("Fetch Table");
		btnFetch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFetch.setActionCommand("Refresh");
		getRootPane().setDefaultButton(btnFetch);
		btnFetch.addActionListener(this);
		panel_1.add(btnFetch);

		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setActionCommand("Back");
		btnBack.addActionListener(this);
		panel_1.add(btnBack);

		{
		}
	}

	private void RefreshTable() {

		try {

			table = new JTable(DbMethods.getTableFromQuery(conn, textField.getText()));
			scrollPane.setViewportView(table);

		} catch (Exception e) {
			Program.SM(e.toString(), 0);
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "Back":
			Program.switchToMenuFromDialog(this);
			break;

		case "Refresh":

			RefreshTable();

			break;

		default:
			Program.SM("RefreshTable out of Index!", 0);
			break;
		}

	}

}
