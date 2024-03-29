package voting_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JSeparator;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Adress;
	private JTextField PhoneNo;
	private JTextField BirthYear;
	private JTextField CNIC;
	private JTextField fathername;
	private JTextField name;
	private JTextField txtNumber;
	private final ButtonGroup gender1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	int number = 0;
	String winner;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminDashboard() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminDashboard.class.getResource("/Image_Resource/icons8-vote-100.png")));
		setTitle("Voting System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 985, 579);
		contentPane = new JPanel();

		contentPane.setBackground(new Color(45, 204, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Image_Resource/dash.png")));
		lblNewLabel_1.setBounds(10, 4, 87, 70);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Operations");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Calibri", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(33, 85, 110, 25);
		contentPane.add(lblNewLabel_2);

		JSeparator separator = new JSeparator();
		separator.setBounds(33, 174, 123, 2);
		contentPane.add(separator);

		JButton btnNewButton_2 = new JButton("Delete");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selection = JOptionPane.showConfirmDialog(contentPane, "Delete Data!", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (selection == 0) {
					JOptionPane.showMessageDialog(contentPane, "Data Deleted", "Operation Success",
							JOptionPane.INFORMATION_MESSAGE);
					Connect c = new Connect();
					c.delete(CNIC.getText());
					showuser();
				} else if (selection == 1) {
					JOptionPane.showMessageDialog(contentPane, "Data Not Deleted", "Operation Stopped",
							JOptionPane.OK_OPTION);
				}
			}
		});
		btnNewButton_2.setBackground(new Color(1, 179, 255));
		btnNewButton_2.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Image_Resource/delete.png")));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(33, 204, 123, 36);
		contentPane.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("Stats");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stats s = new Stats();
				Connect c = new Connect();
				ResultSet rs = c.party();
				s.setVisible(true);
				dispose();
				try {
					if (rs.next()) {
						s.setstat(rs.getString("PTI"), rs.getString("PMLN"), rs.getString("MQM"), rs.getString("ANP"),
								rs.getString("PPP"));

					}

				} catch (SQLException ex) {
					ex.printStackTrace(); // Log or show an error message
					System.err.println("ERROR");
				}
			}
		});
		btnNewButton_3.setBackground(new Color(1, 179, 255));
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Image_Resource/sats.png")));
		btnNewButton_3.setBounds(33, 344, 123, 36);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton("Logout");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminPanel adp = new AdminPanel();
				adp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBackground(new Color(1, 179, 255));
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Image_Resource/logout.png")));
		btnNewButton_4.setBounds(33, 415, 123, 36);
		contentPane.add(btnNewButton_4);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(33, 246, 123, 2);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(33, 314, 123, 2);
		contentPane.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(33, 386, 123, 2);
		contentPane.add(separator_3);

		JPanel panel = new JPanel();
		panel.setBounds(200, 111, 293, 288);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Details");
		lblNewLabel_3.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Image_Resource/detail.png")));
		lblNewLabel_3.setBounds(10, 11, 81, 30);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_5 = new JLabel("Name");
		lblNewLabel_5.setBounds(20, 52, 49, 14);
		panel.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Father Name");
		lblNewLabel_6.setBounds(20, 77, 81, 14);
		panel.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("CNIC");
		lblNewLabel_7.setBounds(20, 103, 49, 14);
		panel.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("Gender");
		lblNewLabel_8.setBounds(20, 128, 49, 14);
		panel.add(lblNewLabel_8);

		JLabel lblNewLabel_9 = new JLabel("Birth Year");
		lblNewLabel_9.setBounds(20, 153, 81, 14);
		panel.add(lblNewLabel_9);

		JLabel lblNewLabel_10 = new JLabel("Adress");
		lblNewLabel_10.setBounds(20, 203, 49, 14);
		panel.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("City");
		lblNewLabel_11.setBounds(20, 228, 49, 14);
		panel.add(lblNewLabel_11);

		JLabel lblNewLabel_12 = new JLabel("Eligible");
		lblNewLabel_12.setBounds(20, 253, 49, 14);
		panel.add(lblNewLabel_12);

		JRadioButton Male = new JRadioButton("Male");
		gender1.add(Male);
		Male.setBounds(120, 125, 72, 23);
		panel.add(Male);

		JRadioButton Female = new JRadioButton("Female");
		gender1.add(Female);
		Female.setBounds(200, 125, 80, 23);
		panel.add(Female);

		JRadioButton VoteY = new JRadioButton("Yes");
		buttonGroup_1.add(VoteY);
		VoteY.setBounds(120, 253, 50, 23);
		panel.add(VoteY);

		JRadioButton VoteN = new JRadioButton("No");
		buttonGroup_1.add(VoteN);
		VoteN.setBounds(200, 253, 50, 23);
		panel.add(VoteN);

		JLabel lblNewLabel_4 = new JLabel("Phone No.");
		lblNewLabel_4.setBounds(20, 178, 66, 14);
		panel.add(lblNewLabel_4);

		JComboBox City = new JComboBox();
		City.setModel(new DefaultComboBoxModel(new String[] { "Karachi", "Lahore", "Sindh", "Bahawalpur", "Multan",
				"Faislabad", "Sargodha", "Islamabad", "Rawalpindi", "Hyderabad", "Lodhran", "AhmedPur", "Sahiwal" }));
		City.setBounds(120, 224, 110, 22);
		panel.add(City);

		Adress = new JTextField();
		Adress.setBounds(120, 200, 110, 20);
		panel.add(Adress);
		Adress.setColumns(10);

		PhoneNo = new JTextField();
		PhoneNo.setBounds(120, 175, 110, 20);
		panel.add(PhoneNo);
		PhoneNo.setColumns(10);

		BirthYear = new JTextField();
		BirthYear.setBounds(120, 150, 110, 20);
		panel.add(BirthYear);
		BirthYear.setColumns(10);

		CNIC = new JTextField();
		CNIC.setBounds(120, 100, 110, 20);
		panel.add(CNIC);
		CNIC.setColumns(10);

		fathername = new JTextField();
		fathername.setBounds(120, 74, 110, 20);
		panel.add(fathername);
		fathername.setColumns(10);

		name = new JTextField();
		name.setBounds(120, 49, 110, 20);
		panel.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_16 = new JLabel("ID:");
		lblNewLabel_16.setBounds(240, 19, 20, 14);
		panel.add(lblNewLabel_16);

		JLabel id = new JLabel("");
		id.setBounds(260, 16, 20, 20);
		panel.add(id);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(503, 111, 452, 288);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_15 = new JLabel("Records");
		lblNewLabel_15.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_15.setForeground(new Color(0, 0, 0));
		lblNewLabel_15.setBounds(177, 5, 100, 25);
		panel_3.add(lblNewLabel_15);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 37, 432, 240);
		panel_3.add(scrollPane);

		table = new JTable();
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				int row = table.getSelectedRow();
				name.setText((String) table.getValueAt(row, 1));
				String id1 = (String) table.getValueAt(row, 0);
				id.setText(id1);
				fathername.setText((String) table.getValueAt(row, 2));
				CNIC.setText((String) table.getValueAt(row, 3));
				int gender;
				if (table.getValueAt(row, 4).equals("Male"))
					Male.setSelected(true);
				else if (table.getValueAt(row, 4).equals("Female"))
					Female.setSelected(true);

				BirthYear.setText((String) table.getValueAt(row, 5));
				PhoneNo.setText((String) table.getValueAt(row, 6));
				Adress.setText((String) table.getValueAt(row, 7));
				String city;
//				City=table.getValueAt(row, 8);
//				City.setText(table.getValueAt(row, 8));
				int vote;
				if (table.getValueAt(row, 9).equals("Yes"))
					VoteY.setSelected(true);
				else if (table.getValueAt(row, 9).equals("No"))
					VoteN.setSelected(true);
			}
		});
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null, null }, },
				new String[] { "ID", "Name", "Father Name", "CNIC", "Gender", "Birth Year", "Phone No", "Adress",
						"City", "Eligible", "Voted" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false, false, false, false,
					false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(30);

		showuser();
//		Connect c=new Connect();

		JButton btnNewButton_5 = new JButton("Insert");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender;
				if (VoteY.isSelected())
					gender = "Male";
				else
					gender = "Female";

				String vote;
				if (VoteY.isSelected())
					vote = "Yes";
				else
					vote = "No";
				if (name.getText().isBlank() || fathername.getText().isBlank() || CNIC.getText().isBlank()
						|| PhoneNo.getText().isBlank() || Adress.getText().isBlank() || BirthYear.getText().isBlank()) {
					JOptionPane.showMessageDialog(contentPane, "Please fill all details!", "Incomplete Data",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int selection = JOptionPane.showConfirmDialog(contentPane, "Insert Data!", "Confirm",
							JOptionPane.YES_NO_OPTION);
					if (selection == 0) {
						JOptionPane.showMessageDialog(contentPane, "Data Inserted", "Operation Success",
								JOptionPane.INFORMATION_MESSAGE);
						Connect c = new Connect();
						c.insert(name.getText(), fathername.getText(), CNIC.getText(), gender, BirthYear.getText(),
								PhoneNo.getText(), Adress.getText(), (String) City.getSelectedItem(), vote);
						showuser();
					} else if (selection == 1) {
						JOptionPane.showMessageDialog(contentPane, "Data Not Inserted", "Operation Stopped",
								JOptionPane.OK_OPTION);
					}
				}
			}
		});
		btnNewButton_5.setBackground(new Color(1, 179, 255));
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Image_Resource/insert.png")));
		btnNewButton_5.setBounds(33, 272, 123, 36);
		contentPane.add(btnNewButton_5);

		JButton btnNewButton_1 = new JButton("Update");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gender;
				if (Male.isSelected())
					gender = "Male";
				else
					gender = "Female";
				String vote;
				if (VoteY.isSelected())
					vote = "Yes";
				else
					vote = "No";

				int selection = JOptionPane.showConfirmDialog(contentPane, "Update Data!", "Confirm",
						JOptionPane.YES_NO_OPTION);
				if (selection == 0) {
					JOptionPane.showMessageDialog(contentPane, "Data Updated", "Operation Success",
							JOptionPane.INFORMATION_MESSAGE);
					Connect c = new Connect();
					c.update(id.getText(), name.getText(), fathername.getText(), CNIC.getText(), gender,
							BirthYear.getText(), PhoneNo.getText(), Adress.getText(), (String) City.getSelectedItem(),
							vote);
					showuser();
				} else if (selection == 1) {
					JOptionPane.showMessageDialog(contentPane, "Data Not Updated", "Operation Stopped",
							JOptionPane.OK_OPTION);
				}

			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(1, 179, 255));
		btnNewButton_1.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Image_Resource/update.png")));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(33, 129, 123, 40);
		contentPane.add(btnNewButton_1);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(33, 461, 123, 2);
		contentPane.add(separator_4);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 128, 255));
		panel_1.setBounds(200, 415, 290, 80);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_13 = new JLabel("TOTAL");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_13.setForeground(new Color(255, 255, 255));
		lblNewLabel_13.setIcon(new ImageIcon("D:\\Eclipse\\voting_System\\src\\total.png"));
		lblNewLabel_13.setBounds(10, 11, 150, 60);
		panel_1.add(lblNewLabel_13);

		txtNumber = new JTextField();
		txtNumber.setEditable(false);
		txtNumber.setForeground(new Color(255, 255, 255));
		txtNumber.setFont(new Font("Arial", Font.BOLD, 20));
		txtNumber.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumber.setText("Number");
		txtNumber.setBackground(new Color(0, 128, 255));
		txtNumber.setBounds(370, 11, 96, 60);
		panel_1.add(txtNumber);
		txtNumber.setColumns(10);

		JLabel total = new JLabel(String.valueOf(number));
		total.setFont(new Font("Tahoma", Font.BOLD, 28));
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setForeground(new Color(255, 255, 255));
		total.setBounds(170, 9, 110, 60);
		panel_1.add(total);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 128, 255));
		panel_2.setBounds(503, 415, 452, 80);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_14 = new JLabel("Winner");
		lblNewLabel_14.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_14.setForeground(new Color(255, 255, 255));
		lblNewLabel_14.setIcon(new ImageIcon(AdminDashboard.class.getResource("/Image_Resource/win.png")));
		lblNewLabel_14.setBounds(33, 11, 200, 60);
		panel_2.add(lblNewLabel_14);

		JLabel total_1 = new JLabel(winner);
		total_1.setBounds(219, 9, 110, 60);
		panel_2.add(total_1);
		total_1.setHorizontalAlignment(SwingConstants.CENTER);
		total_1.setForeground(Color.WHITE);
		total_1.setFont(new Font("Tahoma", Font.PLAIN, 32));

		JLabel lblNewLabel = new JLabel("Admin Dashboard");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(407, 32, 283, 36);
		contentPane.add(lblNewLabel);

		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				name.setText(null);
				fathername.setText(null);
				CNIC.setText(null);
				Adress.setText(null);
				fathername.setText(null);
				PhoneNo.setText(null);
				BirthYear.setText(null);
				id.setText(null);

			}
		});

	}

	public void showuser() {
		Connection con;
		Statement s;
		String path = "jdbc:mysql://localhost:3306/votingsystem";
		String username = "root";
		String password = "";

		try {
			String query = "SELECT * FROM voter";
			String query1 = "SELECT * FROM stats ";
			con = DriverManager.getConnection(path, username, password);
			s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			DefaultTableModel df = (DefaultTableModel) table.getModel();
			df.setRowCount(0);
			while (rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("ID"));
				v.add(rs.getString("Name"));
				v.add(rs.getString("FatherName"));
				v.add(rs.getString("CNIC"));
				v.add(rs.getString("Gender"));
				v.add(rs.getString("BirthYear"));
				v.add(rs.getString("PhoneNo"));
				v.add(rs.getString("Adress"));
				v.add(rs.getString("City"));
				v.add(rs.getString("Vote"));
				v.add(rs.getString("Voted"));
				df.addRow(v);
				if (rs.getString("Voted").equals("Yes"))
					number++;

			}
			ResultSet rs1 = s.executeQuery(query1);
			while (rs1.next()) {
				String PTIV = rs1.getString("PTI");
				String ANPV = rs1.getString("ANP");
				String PMLNV = rs1.getString("PMLN");
				String PPPV = rs1.getString("PPP");
				String MQMV = rs1.getString("MQM");
				if (Integer.parseInt(PTIV) > Integer.parseInt(PMLNV) && Integer.parseInt(PTIV) > Integer.parseInt(PPPV)
						&& Integer.parseInt(PTIV) > Integer.parseInt(MQMV)
						&& Integer.parseInt(PTIV) > Integer.parseInt(ANPV))
					winner = "PTI";
				else if (Integer.parseInt(PMLNV) > Integer.parseInt(PTIV)
						&& Integer.parseInt(PMLNV) > Integer.parseInt(PPPV)
						&& Integer.parseInt(PMLNV) > Integer.parseInt(MQMV)
						&& Integer.parseInt(PMLNV) > Integer.parseInt(ANPV))
					winner = "PMLN";
				else if (Integer.parseInt(PPPV) > Integer.parseInt(PTIV)
						&& Integer.parseInt(PPPV) > Integer.parseInt(PMLNV)
						&& Integer.parseInt(PPPV) > Integer.parseInt(MQMV)
						&& Integer.parseInt(PPPV) > Integer.parseInt(ANPV))
					winner = "PPP";
				else if (Integer.parseInt(ANPV) > Integer.parseInt(PTIV)
						&& Integer.parseInt(ANPV) > Integer.parseInt(PPPV)
						&& Integer.parseInt(ANPV) > Integer.parseInt(MQMV)
						&& Integer.parseInt(ANPV) > Integer.parseInt(PMLNV))
					winner = "ANP";
				else if (Integer.parseInt(MQMV) > Integer.parseInt(PTIV)
						&& Integer.parseInt(MQMV) > Integer.parseInt(PPPV)
						&& Integer.parseInt(MQMV) > Integer.parseInt(PMLNV)
						&& Integer.parseInt(MQMV) > Integer.parseInt(ANPV))
					winner = "MQM";
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
