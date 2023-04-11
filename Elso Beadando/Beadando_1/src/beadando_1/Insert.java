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
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Insert extends JDialog implements ActionListener {
	private JButton btnInsert;
	private JButton btnBack;
	private JTextField txtDName;
	private JTextField txtDCity;
	private JTextField txtDStreet;
	private JTextField txtDAdnum;
	private JTextField txtDBday;
	private JTextField txtBFlevel;
	private JTextField txtBFConsumption;
	private JTextField txtBPassCount;
	private JTextField txtBBrand;
	private JTextField txtBLPlate;
	private JTable table;
	private JTextField txtRName;
	private JTextField txtRStopNum;
	private JTextField txtRLength;
	private Connection conn;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JPanel Table_conn;
	private JLabel lblR_1;
	private JTextField txtCDBBid;
	private JTextField txtCDBSid;
	private JLabel lblR_1_2_1;
	private JLabel lblRouteLengthkm_1;
	private JLabel lblRouteLengthkm_1_1;
	private JLabel lblRouteLengthkm_1_1_1;
	private JLabel lblRouteLengthkm_1_1_2;
	private JTextField txtCBRBid;
	private JTextField txtCBRDate;
	private JTextField txtCBRRid;
	private JButton btnFetch;
	@SuppressWarnings("rawtypes")
	private JComboBox txtBFuel;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Insert(Connection connp) {

		conn = connp;

		this.setTitle("Insert Data");

		setBounds(100, 100, 780, 665);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 747, 0 };
		gridBagLayout.rowHeights = new int[] { 210, 351, 43, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		getContentPane().add(tabbedPane, gbc_tabbedPane);

		JPanel Drivers = new JPanel();
		tabbedPane.addTab("Drivers", null, Drivers, "Add new Drivers to the Database");

		JLabel lblD_0 = new JLabel("Driver Name");
		lblD_0.setBounds(51, 10, 157, 19);
		lblD_0.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtDName = new JTextField();
		txtDName.setBounds(224, 10, 503, 19);
		txtDName.setColumns(10);

		JLabel lblD_1 = new JLabel("Driver Address City");
		lblD_1.setBounds(51, 45, 157, 19);
		lblD_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblD_2 = new JLabel("Driver Address Street");
		lblD_2.setBounds(51, 80, 157, 19);
		lblD_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblD_3 = new JLabel("Driver Address number");
		lblD_3.setBounds(51, 115, 155, 19);
		lblD_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblD_4 = new JLabel("Driver Birthday Year");
		lblD_4.setBounds(51, 150, 157, 19);
		lblD_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtDCity = new JTextField();
		txtDCity.setBounds(224, 45, 503, 19);
		txtDCity.setColumns(10);

		txtDStreet = new JTextField();
		txtDStreet.setBounds(224, 80, 503, 19);
		txtDStreet.setColumns(10);

		txtDAdnum = new JTextField();
		txtDAdnum.setBounds(224, 115, 503, 19);
		txtDAdnum.setColumns(10);

		txtDBday = new JTextField();
		txtDBday.setBounds(224, 150, 503, 19);
		txtDBday.setColumns(10);
		Drivers.setLayout(null);
		Drivers.add(lblD_1);
		Drivers.add(lblD_0);
		Drivers.add(txtDCity);
		Drivers.add(txtDName);
		Drivers.add(lblD_4);
		Drivers.add(lblD_3);
		Drivers.add(lblD_2);
		Drivers.add(txtDStreet);
		Drivers.add(txtDAdnum);
		Drivers.add(txtDBday);

		JPanel Buses = new JPanel();
		tabbedPane.addTab("Buses", null, Buses, "Add new Buses to the Database");

		JLabel lblB_2 = new JLabel("Bus Fuel Level");
		lblB_2.setBounds(51, 68, 157, 19);
		lblB_2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtBFlevel = new JTextField();
		txtBFlevel.setBounds(224, 68, 503, 19);
		txtBFlevel.setColumns(10);

		JLabel lblB_3 = new JLabel("Bus Fuel Consumption");
		lblB_3.setBounds(51, 97, 157, 19);
		lblB_3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtBFConsumption = new JTextField();
		txtBFConsumption.setBounds(224, 97, 503, 19);
		txtBFConsumption.setColumns(10);

		JLabel lblB_4 = new JLabel("Bus Passenger Count");
		lblB_4.setBounds(51, 126, 157, 19);
		lblB_4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtBPassCount = new JTextField();
		txtBPassCount.setBounds(224, 126, 503, 19);
		txtBPassCount.setColumns(10);

		JLabel lblB_1 = new JLabel("Bus Fuel Type");
		lblB_1.setBounds(51, 39, 157, 19);
		lblB_1.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lblB_0 = new JLabel("Bus Brand");
		lblB_0.setBounds(51, 10, 157, 19);
		lblB_0.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtBBrand = new JTextField();
		txtBBrand.setBounds(224, 10, 503, 19);
		txtBBrand.setColumns(10);
		Buses.setLayout(null);
		Buses.add(lblB_1);
		Buses.add(lblB_0);
		Buses.add(txtBBrand);
		Buses.add(lblB_4);
		Buses.add(lblB_2);
		Buses.add(lblB_3);
		Buses.add(txtBFlevel);
		Buses.add(txtBFConsumption);
		Buses.add(txtBPassCount);

		JLabel lblB_5 = new JLabel("License Plate");
		lblB_5.setBounds(51, 155, 86, 19);
		lblB_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Buses.add(lblB_5);

		txtBLPlate = new JTextField();
		txtBLPlate.setBounds(224, 155, 503, 19);
		txtBLPlate.setColumns(10);
		Buses.add(txtBLPlate);
		
		txtBFuel = new JComboBox();
		txtBFuel.setModel(new DefaultComboBoxModel(new String[] {"Dízel", "Gáz", "Elektromos"}));
		txtBFuel.setBounds(224, 40, 503, 21);
		txtBFuel.setEditable(false);
		Buses.add(txtBFuel);

		JPanel Routes = new JPanel();
		tabbedPane.addTab("Routes", null, Routes, "Add new Routes to the Database");
		Routes.setLayout(null);

		JLabel lblR = new JLabel("Route Name");
		lblR.setBounds(51, 30, 83, 19);
		lblR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Routes.add(lblR);

		txtRName = new JTextField();
		txtRName.setBounds(224, 30, 503, 19);
		Routes.add(txtRName);
		txtRName.setColumns(10);

		JLabel lblRouteStopNumber = new JLabel("Route Stop Number");
		lblRouteStopNumber.setBounds(51, 79, 157, 19);
		lblRouteStopNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Routes.add(lblRouteStopNumber);

		txtRStopNum = new JTextField();
		txtRStopNum.setBounds(224, 79, 503, 19);
		txtRStopNum.setColumns(10);
		Routes.add(txtRStopNum);

		JLabel lblRouteLengthkm = new JLabel("Route Length (Km)");
		lblRouteLengthkm.setBounds(51, 128, 157, 19);
		lblRouteLengthkm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Routes.add(lblRouteLengthkm);

		txtRLength = new JTextField();
		txtRLength.setBounds(224, 128, 503, 19);
		txtRLength.setColumns(10);
		Routes.add(txtRLength);

		Table_conn = new JPanel();
		tabbedPane.addTab("Assign 1", null, Table_conn, "Assign Driver to Bus");
		Table_conn.setLayout(null);

		JLabel lblR_1_2 = new JLabel("Assign driver to bus");
		lblR_1_2.setBounds(554, 26, 132, 19);
		lblR_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Table_conn.add(lblR_1_2);

		JLabel lblR_1_1 = new JLabel("Driver ID");
		lblR_1_1.setBounds(20, 45, 150, 19);
		lblR_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Table_conn.add(lblR_1_1);

		txtCDBSid = new JTextField();
		txtCDBSid.setBounds(180, 46, 280, 19);
		txtCDBSid.setColumns(10);
		Table_conn.add(txtCDBSid);

		lblR_1 = new JLabel("Bus ID");
		lblR_1.setBounds(20, 85, 150, 19);
		lblR_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Table_conn.add(lblR_1);

		txtCDBBid = new JTextField();
		txtCDBBid.setBounds(180, 86, 280, 19);
		txtCDBBid.setColumns(10);
		Table_conn.add(txtCDBBid);

		JPanel panel = new JPanel();
		tabbedPane.addTab("Assign 2", null, panel, "Assign Bus to Route");
		panel.setLayout(null);

		lblR_1_2_1 = new JLabel("Assign bus to route");
		lblR_1_2_1.setBounds(555, 20, 129, 19);
		lblR_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblR_1_2_1);

		lblRouteLengthkm_1 = new JLabel("Bus ID");
		lblRouteLengthkm_1.setBounds(20, 40, 114, 19);
		lblRouteLengthkm_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblRouteLengthkm_1);

		txtCBRBid = new JTextField();
		txtCBRBid.setBounds(180, 40, 280, 19);
		panel.add(txtCBRBid);
		txtCBRBid.setColumns(10);

		lblRouteLengthkm_1_1 = new JLabel("Start of Route");
		lblRouteLengthkm_1_1.setBounds(20, 80, 94, 19);
		lblRouteLengthkm_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblRouteLengthkm_1_1);

		txtCBRDate = new JTextField();
		txtCBRDate.setBounds(180, 80, 280, 19);
		panel.add(txtCBRDate);
		txtCBRDate.setColumns(10);

		lblRouteLengthkm_1_1_2 = new JLabel("<-- (Like \"10-DEC-23 10.20.00\")");
		lblRouteLengthkm_1_1_2.setBounds(488, 80, 226, 19);
		lblRouteLengthkm_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblRouteLengthkm_1_1_2);

		lblRouteLengthkm_1_1_1 = new JLabel("Route ID");
		lblRouteLengthkm_1_1_1.setBounds(20, 120, 101, 19);
		lblRouteLengthkm_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblRouteLengthkm_1_1_1);

		txtCBRRid = new JTextField();
		txtCBRRid.setBounds(180, 120, 280, 19);
		panel.add(txtCBRRid);
		txtCBRRid.setColumns(10);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);

		table = new JTable(DbMethods.getDefaultTable());
		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);

		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
			GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
			gbc_buttonPanel.fill = GridBagConstraints.BOTH;
			gbc_buttonPanel.gridx = 0;
			gbc_buttonPanel.gridy = 2;
			getContentPane().add(buttonPanel, gbc_buttonPanel);

			btnFetch = new JButton("Fetch Table");
			btnFetch.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnFetch.setActionCommand("Fetch");
			buttonPanel.add(btnFetch);
			btnFetch.addActionListener(this);

			btnInsert = new JButton("Insert data");
			btnInsert.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnInsert.setActionCommand("Send");
			buttonPanel.add(btnInsert);
			getRootPane().setDefaultButton(btnInsert);
			btnInsert.addActionListener(this);

			btnBack = new JButton("Back");
			btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnBack.setActionCommand("Back");
			buttonPanel.add(btnBack);
			btnBack.addActionListener(this);

		}
	}

	private void PushDataToTable(int index) {

		try {
			switch (index) {

			case 0: {

				Object[] data = { txtDName.getText(), txtDCity.getText(), txtDStreet.getText(), txtDAdnum.getText(),
						txtDBday.getText() };
				DbMethods.insertPreparedStatement(conn, "Sofõr", data);
				break;
			}
			case 1: {

				Object[] data = { txtBBrand.getText(), txtBFuel.getItemAt(txtBFuel.getSelectedIndex()), txtBFlevel.getText(),
						txtBFConsumption.getText(), txtBPassCount.getText(), txtBLPlate.getText() };
				DbMethods.insertPreparedStatement(conn, "Busz", data);
				break;
			}
			case 2: {

				Object[] data = { txtRName.getText(), txtRStopNum.getText(), txtRLength.getText() };
				DbMethods.insertPreparedStatement(conn, "Útvonal", data);
				break;
			}

			case 3: {
				Object[] data = {txtCDBSid.getText(), txtCDBBid.getText()};
				DbMethods.insertPreparedStatement(conn, "Vezeti", data);
				break;
			}

			case 4: {
				Object[] data = {txtCBRBid.getText(),txtCBRDate.getText(), txtCBRRid.getText()};
				DbMethods.insertPreparedStatement(conn, "Járat", data);
				break;
			}
			default:
				Program.SM("RefreshTable out of Index!", 0);
				break;
			}


		} catch (Exception e) {
			Program.SM(e.toString(), 0);
		}

	}

	private void FetchTable(int index) {

		String sql = "Select * from ";

		try {
			switch (index) {

			case 0: {
				sql += "Sofõr";
				break;
			}
			case 1: {
				sql += "Busz";
				break;
			}
			case 2: {
				sql += "Útvonal";
				break;
			}

			case 3: {
				sql += "Sofõr s inner join Vezeti v on s.SOID = v.SOID inner join Busz b on v.BID=b.BID";
				break;
			}

			case 4: {
				sql += "Útvonal u inner join Járat j on u.ÚTID = j.ÚTID inner join Busz b on j.BID=b.BID";
				break;
			}
			default:
				Program.SM("RefreshTable out of Index!", 0);
				break;
			}

			table = new JTable(DbMethods.getTableFromQuery(conn, sql));
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

		case "Fetch":

			FetchTable(tabbedPane.getSelectedIndex());

			break;

		case "Send":

			PushDataToTable(tabbedPane.getSelectedIndex());
			FetchTable(tabbedPane.getSelectedIndex());

			break;

		default:
			break;
		}

	}
}
