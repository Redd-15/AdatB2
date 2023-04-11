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
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

@SuppressWarnings("serial")
public class Prepared_query extends JDialog implements ActionListener {
	private JButton btnBack;
	private JTextField txtDCity;
	private JTable table;
	private Connection conn;
	private JTabbedPane tabbedPane;
	private JScrollPane scrollPane;
	private JButton btnFetch;
	private JPanel Drivers_1;
	private JLabel lblD;
	private JTextField txtD1Year;
	private JLabel lblD_3;
	private JRadioButton rdbtnDBefore;
	private JRadioButton rdbtnDAfter;
	private JPanel Bus;
	private JLabel lblFindBusesWith;
	private JLabel lblD_4;
	private JTextField txtBSeat;
	private JRadioButton rdbtnBLessThan;
	private JRadioButton rdbtnBMoreThan;
	private JPanel Bus_1;
	private JLabel lblFindBusesWith_2;
	private JLabel lblD_2;
	private JPanel Route;
	private JLabel lblFindRoutesWith;
	private JLabel lblD_5;
	private JTextField txtRStops;
	private JRadioButton rdbtnRLessThan;
	private JRadioButton rdbtnRMoreThan;
	private JPanel Complex;
	private JLabel lblFindRoutesAssigned;
	private JLabel lblD_6;
	private JTextField txtCBBrand;
	private JLabel lblD_7;
	private JTextField txtCBSeat;
	private JPanel Complex_1;
	private JLabel lblFindRoutesAssigned_1;
	private JLabel lblD_8;
	private JTextField txtC1RCount;
	private JLabel lblD_9;
	private JRadioButton rdbtnC1LessThan;
	private JRadioButton rdbtnC1MoreThan;
	private JRadioButton rdbtnCLessThan;
	private JRadioButton rdbtnCMoreThan;
	@SuppressWarnings("rawtypes")
	private JComboBox txtB1Fuel;
	@SuppressWarnings("rawtypes")
	private JComboBox txtC1BFuel;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Prepared_query(Connection connp) {

		conn = connp;

		this.setTitle("Prepared Query");

		setBounds(100, 100, 910, 665);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 747, 0 };
		gridBagLayout.rowHeights = new int[] { 210, 373, 43, 0 };
		gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		GridBagConstraints gbc_tabbedPane = new GridBagConstraints();
		gbc_tabbedPane.fill = GridBagConstraints.BOTH;
		gbc_tabbedPane.insets = new Insets(0, 0, 5, 0);
		gbc_tabbedPane.gridx = 0;
		gbc_tabbedPane.gridy = 0;
		getContentPane().add(tabbedPane, gbc_tabbedPane);

		JPanel Drivers = new JPanel();
		tabbedPane.addTab("Drivers City", null, Drivers, "Find Drivers from given City");
		GridBagLayout gbl_Drivers = new GridBagLayout();
		gbl_Drivers.columnWidths = new int[] { 51, 157, 503, 0 };
		gbl_Drivers.rowHeights = new int[] { 0, 19, 0, 0, 25, 19, 0 };
		gbl_Drivers.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_Drivers.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Drivers.setLayout(gbl_Drivers);

		JLabel lblD_0 = new JLabel("Find Drivers from given City");
		lblD_0.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD_0 = new GridBagConstraints();
		gbc_lblD_0.anchor = GridBagConstraints.NORTH;
		gbc_lblD_0.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblD_0.insets = new Insets(0, 0, 5, 0);
		gbc_lblD_0.gridx = 2;
		gbc_lblD_0.gridy = 1;
		Drivers.add(lblD_0, gbc_lblD_0);

		JLabel lblD_1 = new JLabel("Driver Address City");
		lblD_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD_1 = new GridBagConstraints();
		gbc_lblD_1.anchor = GridBagConstraints.NORTH;
		gbc_lblD_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblD_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblD_1.gridx = 1;
		gbc_lblD_1.gridy = 3;
		Drivers.add(lblD_1, gbc_lblD_1);

		txtDCity = new JTextField();
		txtDCity.setColumns(10);
		GridBagConstraints gbc_txtDCity = new GridBagConstraints();
		gbc_txtDCity.anchor = GridBagConstraints.NORTH;
		gbc_txtDCity.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDCity.insets = new Insets(0, 0, 5, 0);
		gbc_txtDCity.gridx = 2;
		gbc_txtDCity.gridy = 3;
		Drivers.add(txtDCity, gbc_txtDCity);

		Drivers_1 = new JPanel();
		tabbedPane.addTab("Drivers Year", null, Drivers_1, "Find Drivers born before or after given Year");
		GridBagLayout gbl_Drivers_1 = new GridBagLayout();
		gbl_Drivers_1.columnWidths = new int[] { 51, 157, 503, 0 };
		gbl_Drivers_1.rowHeights = new int[] { 0, 19, 0, 0, 25, 19, 0 };
		gbl_Drivers_1.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_Drivers_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Drivers_1.setLayout(gbl_Drivers_1);

		lblD = new JLabel("Find Drivers born before or after given Year");
		lblD.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD = new GridBagConstraints();
		gbc_lblD.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblD.anchor = GridBagConstraints.NORTH;
		gbc_lblD.insets = new Insets(0, 0, 5, 0);
		gbc_lblD.gridx = 2;
		gbc_lblD.gridy = 1;
		Drivers_1.add(lblD, gbc_lblD);

		lblD_3 = new JLabel("Driver Birthday Year");
		lblD_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD_3 = new GridBagConstraints();
		gbc_lblD_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblD_3.anchor = GridBagConstraints.NORTH;
		gbc_lblD_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblD_3.gridx = 1;
		gbc_lblD_3.gridy = 3;
		Drivers_1.add(lblD_3, gbc_lblD_3);

		txtD1Year = new JTextField();
		txtD1Year.setColumns(10);
		GridBagConstraints gbc_txtD1Year = new GridBagConstraints();
		gbc_txtD1Year.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtD1Year.anchor = GridBagConstraints.NORTH;
		gbc_txtD1Year.insets = new Insets(0, 0, 5, 0);
		gbc_txtD1Year.gridx = 2;
		gbc_txtD1Year.gridy = 3;
		Drivers_1.add(txtD1Year, gbc_txtD1Year);

		rdbtnDBefore = new JRadioButton("Before Year");
		rdbtnDBefore.setSelected(true);
		rdbtnDBefore.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDBefore.setActionCommand("BeforeD");
		rdbtnDBefore.addActionListener(this);
		GridBagConstraints gbc_rdbtnDBefore = new GridBagConstraints();
		gbc_rdbtnDBefore.anchor = GridBagConstraints.WEST;
		gbc_rdbtnDBefore.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnDBefore.gridx = 2;
		gbc_rdbtnDBefore.gridy = 4;
		Drivers_1.add(rdbtnDBefore, gbc_rdbtnDBefore);

		rdbtnDAfter = new JRadioButton("After year");
		rdbtnDAfter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnDAfter.setActionCommand("AfterD");
		rdbtnDAfter.addActionListener(this);
		GridBagConstraints gbc_rdbtnDAfter = new GridBagConstraints();
		gbc_rdbtnDAfter.anchor = GridBagConstraints.WEST;
		gbc_rdbtnDAfter.gridx = 2;
		gbc_rdbtnDAfter.gridy = 5;
		Drivers_1.add(rdbtnDAfter, gbc_rdbtnDAfter);

		Bus = new JPanel();
		tabbedPane.addTab("Bus Seats", null, Bus, "Find Buses with more or less Seats than given");
		GridBagLayout gbl_Bus = new GridBagLayout();
		gbl_Bus.columnWidths = new int[] { 51, 157, 503, 0 };
		gbl_Bus.rowHeights = new int[] { 0, 19, 0, 0, 25, 19, 0 };
		gbl_Bus.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_Bus.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Bus.setLayout(gbl_Bus);

		lblFindBusesWith = new JLabel("Find Buses with more or less Seats than given");
		lblFindBusesWith.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblFindBusesWith = new GridBagConstraints();
		gbc_lblFindBusesWith.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFindBusesWith.anchor = GridBagConstraints.NORTH;
		gbc_lblFindBusesWith.insets = new Insets(0, 0, 5, 0);
		gbc_lblFindBusesWith.gridx = 2;
		gbc_lblFindBusesWith.gridy = 1;
		Bus.add(lblFindBusesWith, gbc_lblFindBusesWith);

		lblD_4 = new JLabel("Bus Passenger Seats count");
		lblD_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD_4 = new GridBagConstraints();
		gbc_lblD_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblD_4.anchor = GridBagConstraints.NORTH;
		gbc_lblD_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblD_4.gridx = 1;
		gbc_lblD_4.gridy = 3;
		Bus.add(lblD_4, gbc_lblD_4);

		txtBSeat = new JTextField();
		txtBSeat.setColumns(10);
		GridBagConstraints gbc_txtBSeat = new GridBagConstraints();
		gbc_txtBSeat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBSeat.anchor = GridBagConstraints.NORTH;
		gbc_txtBSeat.insets = new Insets(0, 0, 5, 0);
		gbc_txtBSeat.gridx = 2;
		gbc_txtBSeat.gridy = 3;
		Bus.add(txtBSeat, gbc_txtBSeat);

		rdbtnBLessThan = new JRadioButton("Less than");
		rdbtnBLessThan.setSelected(true);
		rdbtnBLessThan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnBLessThan.setActionCommand("LessB");
		rdbtnBLessThan.addActionListener(this);
		GridBagConstraints gbc_rdbtnBLessThan = new GridBagConstraints();
		gbc_rdbtnBLessThan.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBLessThan.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnBLessThan.gridx = 2;
		gbc_rdbtnBLessThan.gridy = 4;
		Bus.add(rdbtnBLessThan, gbc_rdbtnBLessThan);

		rdbtnBMoreThan = new JRadioButton("More than");
		rdbtnBMoreThan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnBMoreThan.setActionCommand("MoreB");
		rdbtnBMoreThan.addActionListener(this);
		GridBagConstraints gbc_rdbtnBMoreThan = new GridBagConstraints();
		gbc_rdbtnBMoreThan.anchor = GridBagConstraints.WEST;
		gbc_rdbtnBMoreThan.gridx = 2;
		gbc_rdbtnBMoreThan.gridy = 5;
		Bus.add(rdbtnBMoreThan, gbc_rdbtnBMoreThan);

		Bus_1 = new JPanel();
		tabbedPane.addTab("Bus Fuel", null, Bus_1, "Find Buses with given Fuel type");
		GridBagLayout gbl_Bus_1 = new GridBagLayout();
		gbl_Bus_1.columnWidths = new int[] { 51, 157, 452, 0, 0 };
		gbl_Bus_1.rowHeights = new int[] { 0, 19, 0, 0, 25, 19, 0 };
		gbl_Bus_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_Bus_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Bus_1.setLayout(gbl_Bus_1);

		lblFindBusesWith_2 = new JLabel("Find Buses with given Fuel type");
		lblFindBusesWith_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblFindBusesWith_2 = new GridBagConstraints();
		gbc_lblFindBusesWith_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFindBusesWith_2.anchor = GridBagConstraints.NORTH;
		gbc_lblFindBusesWith_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblFindBusesWith_2.gridx = 2;
		gbc_lblFindBusesWith_2.gridy = 1;
		Bus_1.add(lblFindBusesWith_2, gbc_lblFindBusesWith_2);

		lblD_2 = new JLabel("Bus Fuel type");
		lblD_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD_2 = new GridBagConstraints();
		gbc_lblD_2.anchor = GridBagConstraints.EAST;
		gbc_lblD_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblD_2.gridx = 1;
		gbc_lblD_2.gridy = 3;
		Bus_1.add(lblD_2, gbc_lblD_2);

		String[] comboString = { "Dízel", "Gáz", "Elektromos" };
		txtB1Fuel = new JComboBox(comboString);
		txtB1Fuel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtB1Fuel.setEditable(false);
		GridBagConstraints gbc_txtB1Fuel = new GridBagConstraints();
		gbc_txtB1Fuel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtB1Fuel.insets = new Insets(0, 0, 5, 5);
		gbc_txtB1Fuel.gridx = 2;
		gbc_txtB1Fuel.gridy = 3;
		Bus_1.add(txtB1Fuel, gbc_txtB1Fuel);

		Route = new JPanel();
		tabbedPane.addTab("Route Stop", null, Route, "Find Routes with more or less Stop count");
		GridBagLayout gbl_Route = new GridBagLayout();
		gbl_Route.columnWidths = new int[] { 51, 126, 503, 0 };
		gbl_Route.rowHeights = new int[] { 0, 19, 0, 0, 25, 19, 0 };
		gbl_Route.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_Route.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Route.setLayout(gbl_Route);

		lblFindRoutesWith = new JLabel("Find Routes with more or less Stop count");
		lblFindRoutesWith.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblFindRoutesWith = new GridBagConstraints();
		gbc_lblFindRoutesWith.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFindRoutesWith.anchor = GridBagConstraints.NORTH;
		gbc_lblFindRoutesWith.insets = new Insets(0, 0, 5, 0);
		gbc_lblFindRoutesWith.gridx = 2;
		gbc_lblFindRoutesWith.gridy = 1;
		Route.add(lblFindRoutesWith, gbc_lblFindRoutesWith);

		lblD_5 = new JLabel("Route Stop count");
		lblD_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD_5 = new GridBagConstraints();
		gbc_lblD_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblD_5.anchor = GridBagConstraints.NORTH;
		gbc_lblD_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblD_5.gridx = 1;
		gbc_lblD_5.gridy = 3;
		Route.add(lblD_5, gbc_lblD_5);

		txtRStops = new JTextField();
		txtRStops.setColumns(10);
		GridBagConstraints gbc_txtRStops = new GridBagConstraints();
		gbc_txtRStops.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRStops.anchor = GridBagConstraints.NORTH;
		gbc_txtRStops.insets = new Insets(0, 0, 5, 0);
		gbc_txtRStops.gridx = 2;
		gbc_txtRStops.gridy = 3;
		Route.add(txtRStops, gbc_txtRStops);

		rdbtnRLessThan = new JRadioButton("Less than");
		rdbtnRLessThan.setSelected(true);
		rdbtnRLessThan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnRLessThan.setActionCommand("LessR");
		rdbtnRLessThan.addActionListener(this);
		GridBagConstraints gbc_rdbtnRLessThan = new GridBagConstraints();
		gbc_rdbtnRLessThan.anchor = GridBagConstraints.WEST;
		gbc_rdbtnRLessThan.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnRLessThan.gridx = 2;
		gbc_rdbtnRLessThan.gridy = 4;
		Route.add(rdbtnRLessThan, gbc_rdbtnRLessThan);

		rdbtnRMoreThan = new JRadioButton("More than");
		rdbtnRMoreThan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnRMoreThan.setActionCommand("MoreR");
		rdbtnRMoreThan.addActionListener(this);
		GridBagConstraints gbc_rdbtnRMoreThan = new GridBagConstraints();
		gbc_rdbtnRMoreThan.anchor = GridBagConstraints.WEST;
		gbc_rdbtnRMoreThan.gridx = 2;
		gbc_rdbtnRMoreThan.gridy = 5;
		Route.add(rdbtnRMoreThan, gbc_rdbtnRMoreThan);

		Complex = new JPanel();
		tabbedPane.addTab("Complex 1", null, Complex,
				"Find Routes assigned to given Brand of Busses with more than the given seat count");
		GridBagLayout gbl_Complex = new GridBagLayout();
		gbl_Complex.columnWidths = new int[] { 51, 157, 572, 94, 0 };
		gbl_Complex.rowHeights = new int[] { 0, 19, 0, 0, 25, 19, 0 };
		gbl_Complex.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_Complex.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Complex.setLayout(gbl_Complex);

		lblFindRoutesAssigned = new JLabel(
				"Find Routes assigned to given Brand of Busses with more than the given seat count");
		lblFindRoutesAssigned.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblFindRoutesAssigned = new GridBagConstraints();
		gbc_lblFindRoutesAssigned.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFindRoutesAssigned.anchor = GridBagConstraints.NORTH;
		gbc_lblFindRoutesAssigned.insets = new Insets(0, 0, 5, 5);
		gbc_lblFindRoutesAssigned.gridx = 2;
		gbc_lblFindRoutesAssigned.gridy = 1;
		Complex.add(lblFindRoutesAssigned, gbc_lblFindRoutesAssigned);

		lblD_6 = new JLabel("Bus Brand");
		lblD_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD_6 = new GridBagConstraints();
		gbc_lblD_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblD_6.anchor = GridBagConstraints.NORTH;
		gbc_lblD_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblD_6.gridx = 1;
		gbc_lblD_6.gridy = 3;
		Complex.add(lblD_6, gbc_lblD_6);

		txtCBBrand = new JTextField();
		txtCBBrand.setColumns(10);
		GridBagConstraints gbc_txtCBBrand = new GridBagConstraints();
		gbc_txtCBBrand.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCBBrand.anchor = GridBagConstraints.NORTH;
		gbc_txtCBBrand.insets = new Insets(0, 0, 5, 5);
		gbc_txtCBBrand.gridx = 2;
		gbc_txtCBBrand.gridy = 3;
		Complex.add(txtCBBrand, gbc_txtCBBrand);

		rdbtnCLessThan = new JRadioButton("Less than");
		rdbtnCLessThan.setActionCommand("LessC");
		rdbtnCLessThan.setSelected(true);
		rdbtnCLessThan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCLessThan.addActionListener(this);
		GridBagConstraints gbc_rdbtnCLessThan = new GridBagConstraints();
		gbc_rdbtnCLessThan.anchor = GridBagConstraints.EAST;
		gbc_rdbtnCLessThan.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCLessThan.gridx = 1;
		gbc_rdbtnCLessThan.gridy = 4;
		Complex.add(rdbtnCLessThan, gbc_rdbtnCLessThan);

		rdbtnCMoreThan = new JRadioButton("More than");
		rdbtnCMoreThan.setActionCommand("MoreC");
		rdbtnCMoreThan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnCMoreThan.addActionListener(this);
		GridBagConstraints gbc_rdbtnCMoreThan = new GridBagConstraints();
		gbc_rdbtnCMoreThan.anchor = GridBagConstraints.WEST;
		gbc_rdbtnCMoreThan.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnCMoreThan.gridx = 2;
		gbc_rdbtnCMoreThan.gridy = 4;
		Complex.add(rdbtnCMoreThan, gbc_rdbtnCMoreThan);

		lblD_7 = new JLabel("Bus Seat Count");
		lblD_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD_7 = new GridBagConstraints();
		gbc_lblD_7.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblD_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblD_7.gridx = 1;
		gbc_lblD_7.gridy = 5;
		Complex.add(lblD_7, gbc_lblD_7);

		txtCBSeat = new JTextField();
		txtCBSeat.setColumns(10);
		GridBagConstraints gbc_txtCBSeat = new GridBagConstraints();
		gbc_txtCBSeat.insets = new Insets(0, 0, 0, 5);
		gbc_txtCBSeat.anchor = GridBagConstraints.NORTH;
		gbc_txtCBSeat.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCBSeat.gridx = 2;
		gbc_txtCBSeat.gridy = 5;
		Complex.add(txtCBSeat, gbc_txtCBSeat);

		Complex_1 = new JPanel();
		tabbedPane.addTab("Complex 2", null, Complex_1,
				"Find Buses with less or more than given assigned routes with the given Fuel Type");
		GridBagLayout gbl_Complex_1 = new GridBagLayout();
		gbl_Complex_1.columnWidths = new int[] { 51, 157, 503, 89, 0 };
		gbl_Complex_1.rowHeights = new int[] { 0, 19, 0, 0, 25, 19, 0 };
		gbl_Complex_1.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_Complex_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		Complex_1.setLayout(gbl_Complex_1);

		lblFindRoutesAssigned_1 = new JLabel(
				"Find Buses with less or more than given assigned routes with the given Fuel Type");
		lblFindRoutesAssigned_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblFindRoutesAssigned_1 = new GridBagConstraints();
		gbc_lblFindRoutesAssigned_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblFindRoutesAssigned_1.anchor = GridBagConstraints.NORTH;
		gbc_lblFindRoutesAssigned_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblFindRoutesAssigned_1.gridx = 2;
		gbc_lblFindRoutesAssigned_1.gridy = 1;
		Complex_1.add(lblFindRoutesAssigned_1, gbc_lblFindRoutesAssigned_1);

		lblD_9 = new JLabel("Bus Fuel Type");
		lblD_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD_9 = new GridBagConstraints();
		gbc_lblD_9.anchor = GridBagConstraints.WEST;
		gbc_lblD_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblD_9.gridx = 1;
		gbc_lblD_9.gridy = 3;
		Complex_1.add(lblD_9, gbc_lblD_9);

		rdbtnC1LessThan = new JRadioButton("Less than");
		rdbtnC1LessThan.setActionCommand("LessC1");
		rdbtnC1LessThan.setSelected(true);
		rdbtnC1LessThan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnC1LessThan.addActionListener(this);

		txtC1BFuel = new JComboBox(new Object[] {});
		txtC1BFuel.setModel(new DefaultComboBoxModel(new String[] { "D\u00EDzel", "G\u00E1z", "Elektromos" }));
		txtC1BFuel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtC1BFuel.setEditable(false);
		GridBagConstraints gbc_txtC1BFuel = new GridBagConstraints();
		gbc_txtC1BFuel.insets = new Insets(0, 0, 5, 5);
		gbc_txtC1BFuel.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtC1BFuel.gridx = 2;
		gbc_txtC1BFuel.gridy = 3;
		Complex_1.add(txtC1BFuel, gbc_txtC1BFuel);
		GridBagConstraints gbc_rdbtnC1LessThan = new GridBagConstraints();
		gbc_rdbtnC1LessThan.anchor = GridBagConstraints.EAST;
		gbc_rdbtnC1LessThan.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnC1LessThan.gridx = 1;
		gbc_rdbtnC1LessThan.gridy = 4;
		Complex_1.add(rdbtnC1LessThan, gbc_rdbtnC1LessThan);

		rdbtnC1MoreThan = new JRadioButton("More than");
		rdbtnC1MoreThan.setActionCommand("MoreC1");
		rdbtnC1MoreThan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnC1MoreThan.addActionListener(this);
		GridBagConstraints gbc_rdbtnC1MoreThan = new GridBagConstraints();
		gbc_rdbtnC1MoreThan.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnC1MoreThan.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnC1MoreThan.gridx = 2;
		gbc_rdbtnC1MoreThan.gridy = 4;
		Complex_1.add(rdbtnC1MoreThan, gbc_rdbtnC1MoreThan);

		lblD_8 = new JLabel("Route count");
		lblD_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_lblD_8 = new GridBagConstraints();
		gbc_lblD_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblD_8.anchor = GridBagConstraints.NORTH;
		gbc_lblD_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblD_8.gridx = 1;
		gbc_lblD_8.gridy = 5;
		Complex_1.add(lblD_8, gbc_lblD_8);

		txtC1RCount = new JTextField();
		txtC1RCount.setColumns(10);
		GridBagConstraints gbc_txtC1RCount = new GridBagConstraints();
		gbc_txtC1RCount.insets = new Insets(0, 0, 0, 5);
		gbc_txtC1RCount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtC1RCount.anchor = GridBagConstraints.NORTH;
		gbc_txtC1RCount.gridx = 2;
		gbc_txtC1RCount.gridy = 5;
		Complex_1.add(txtC1RCount, gbc_txtC1RCount);

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
			getRootPane().setDefaultButton(btnFetch);
			buttonPanel.add(btnFetch);
			btnFetch.addActionListener(this);

			btnBack = new JButton("Back");
			btnBack.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnBack.setActionCommand("Back");
			buttonPanel.add(btnBack);
			btnBack.addActionListener(this);

		}
	}

	private EmpTM FetchTable(int index) {

		try {
			switch (index) {

			case 0: {

				Object[] data = { txtDCity.getText() };
				return DbMethods.preparedStatementQueryToTable(conn, index, data);
			}
			case 1: {

				Object[] data = { txtD1Year.getText(), rdbtnDBefore.isSelected() };
				return DbMethods.preparedStatementQueryToTable(conn, index, data);
			}
			case 2: {

				Object[] data = { txtBSeat.getText(), rdbtnBLessThan.isSelected() };
				return DbMethods.preparedStatementQueryToTable(conn, index, data);
			}

			case 3: {
				Object[] data = { txtB1Fuel.getItemAt(txtB1Fuel.getSelectedIndex()) };
				return DbMethods.preparedStatementQueryToTable(conn, index, data);
			}

			case 4: {
				Object[] data = { txtRStops.getText(), rdbtnRLessThan.isSelected() };
				return DbMethods.preparedStatementQueryToTable(conn, index, data);
			}

			case 5: {
				Object[] data = { txtCBBrand.getText(), txtCBSeat.getText(), rdbtnCLessThan.isSelected() };
				return DbMethods.preparedStatementQueryToTable(conn, index, data);
			}

			case 6: {
				Object[] data = { txtC1BFuel.getItemAt(txtC1BFuel.getSelectedIndex()), txtC1RCount.getText(),
						rdbtnC1LessThan.isSelected() };
				return DbMethods.preparedStatementQueryToTable(conn, index, data);
			}
			default:
				Program.SM("RefreshTable out of Index!", 0);
				break;
			}

			scrollPane.setViewportView(table);

		} catch (Exception e) {
			Program.SM(e.toString(), 0);
		}
		return null;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case "BeforeD":
			rdbtnDAfter.setSelected(!rdbtnDBefore.isSelected());
			break;
		case "AfterD":
			rdbtnDBefore.setSelected(!rdbtnDAfter.isSelected());
			break;
		case "LessB":
			rdbtnBMoreThan.setSelected(!rdbtnBLessThan.isSelected());
			break;
		case "MoreB":
			rdbtnBLessThan.setSelected(!rdbtnBMoreThan.isSelected());
			break;
		case "LessR":
			rdbtnRMoreThan.setSelected(!rdbtnRLessThan.isSelected());
			break;
		case "MoreR":
			rdbtnRLessThan.setSelected(!rdbtnRMoreThan.isSelected());
			break;
		case "LessC":
			rdbtnCMoreThan.setSelected(!rdbtnCLessThan.isSelected());
			break;
		case "MoreC":
			rdbtnCLessThan.setSelected(!rdbtnCMoreThan.isSelected());
			break;
		case "LessC1":
			rdbtnC1MoreThan.setSelected(!rdbtnC1LessThan.isSelected());
			break;
		case "MoreC1":
			rdbtnC1LessThan.setSelected(!rdbtnC1MoreThan.isSelected());
			break;
		case "Back":
			Program.switchToMenuFromDialog(this);
			break;
		case "Fetch": {

			EmpTM tableModel = FetchTable(tabbedPane.getSelectedIndex());
			RefreshTable(tableModel);

			break;
		}
		default:
			break;
		}

	}

	private void RefreshTable(EmpTM tableModel) {

		try {

			table = new JTable(tableModel);
			scrollPane.setViewportView(table);

		} catch (Exception e) {
			Program.SM(e.toString(), 0);
		}

	}
}
