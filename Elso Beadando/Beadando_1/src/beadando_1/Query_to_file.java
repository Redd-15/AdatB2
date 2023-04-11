package beadando_1;

import java.awt.FlowLayout;
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
public class Query_to_file extends JDialog implements ActionListener {
	private JTable table;
	private JScrollPane scrollPane;
	private Connection conn;
	private JTextField textField;
	private JTextField textFileName;

	public Query_to_file(Connection connp) {

		conn = connp;

		this.setTitle("Query to File");
		setBounds(100, 100, 909, 690);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 885, 0 };
		gridBagLayout.rowHeights = new int[] { 57, 547, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 103, 82, 0, 0 };
		gbl_panel.rowHeights = new int[] { 52, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("Command:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);

		textField = new JTextField();
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel.add(textField, gbc_textField);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);

		table = new JTable(DbMethods.getDefaultTable());
		scrollPane.setViewportView(table);

		table.setAutoCreateRowSorter(true);

		JPanel buttonPane = new JPanel();
		GridBagConstraints gbc_buttonPane = new GridBagConstraints();
		gbc_buttonPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonPane.gridx = 0;
		gbc_buttonPane.gridy = 2;
		getContentPane().add(buttonPane, gbc_buttonPane);
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));

		JLabel lblNewLabel_1 = new JLabel("File name:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		buttonPane.add(lblNewLabel_1);

		textFileName = new JTextField();
		textFileName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFileName.setColumns(10);
		buttonPane.add(textFileName);

		JButton btnSaveToFile = new JButton("Save to File");
		btnSaveToFile.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSaveToFile.setActionCommand("File");
		btnSaveToFile.addActionListener(this);
		buttonPane.add(btnSaveToFile);

		JButton btnFetch = new JButton("Fetch Table");
		btnFetch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFetch.setActionCommand("Refresh");
		btnFetch.addActionListener(this);
		getRootPane().setDefaultButton(btnFetch);
		buttonPane.add(btnFetch);

		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnBack.setActionCommand("Back");
		btnBack.addActionListener(this);
		buttonPane.add(btnBack);
	}

	private void RefreshTable(Boolean withFile) {

		try {

			if (withFile) {
				EmpTM TableModel = DbMethods.getTableFromQuery(conn, textField.getText());
				table = new JTable(TableModel);

				DbMethods.saveTableToFile(TableModel, textField.getText(), textFileName.getText());
				Program.SM("File written successfuly", 1);
			} else {
				table = new JTable(DbMethods.getTableFromQuery(conn, textField.getText()));
			}

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
			RefreshTable(false);
			break;

		case "File":
			RefreshTable(true);
			break;

		default:
			break;
		}

	}
}
