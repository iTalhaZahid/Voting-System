package voting_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Toolkit;

public class Eligibility extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CNIC;
	private JTextField Name;
	private JTextField FatherName;
	private JTextField BirthYear;
	private JTextField City;
	private JTextField Vote;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Eligibility frame = new Eligibility();
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
	public Eligibility() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Eligibility.class.getResource("/Image_Resource/icons8-vote-100.png")));
		setTitle("Voting System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 878, 504);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(45, 204, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Check Eligibility");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(360, 11, 250, 30);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBorder(new MatteBorder(3, 3, 0, 4, (Color) new Color(255, 255, 255)));
		panel.setBackground(new Color(45, 204, 130));
		panel.setBounds(204, 65, 470, 65);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("CNIC No.");
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(22, 24, 120, 20);
		panel.add(lblNewLabel_1);

		CNIC = new JTextField();
		CNIC.setBounds(130, 20, 189, 30);
		panel.add(CNIC);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(204, 130, 470, 249);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Voter Detail");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(184, 21, 118, 24);
		panel_1.add(lblNewLabel_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0), 6));
		panel_2.setBounds(59, 53, 370, 173);
		panel_1.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Name:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(20, 29, 77, 14);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Father Name:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(20, 60, 114, 16);
		panel_2.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Birth Year:");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(20, 85, 114, 14);
		panel_2.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("City:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(20, 108, 49, 23);
		panel_2.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Registered Voter:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_7.setBounds(20, 135, 156, 25);
		panel_2.add(lblNewLabel_7);

		Vote = new JTextField();
		Vote.setEditable(false);
		Vote.setBounds(163, 137, 162, 20);
		panel_2.add(Vote);
		Vote.setColumns(10);

		City = new JTextField();
		City.setEditable(false);
		City.setBounds(163, 107, 162, 20);
		panel_2.add(City);
		City.setColumns(10);

		BirthYear = new JTextField();
		BirthYear.setEditable(false);
		BirthYear.setBounds(163, 79, 162, 20);
		panel_2.add(BirthYear);
		BirthYear.setColumns(10);

		FatherName = new JTextField();
		FatherName.setEditable(false);
		FatherName.setBounds(163, 54, 162, 20);
		panel_2.add(FatherName);
		FatherName.setColumns(10);

		Name = new JTextField();
		Name.setEditable(false);
		Name.setBounds(163, 23, 162, 20);
		panel_2.add(Name);
		Name.setColumns(10);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainPanel mp = new MainPanel();
				mp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(45, 204, 130));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setIcon(new ImageIcon(Eligibility.class.getResource("/Image_Resource/back.png")));
		btnNewButton_1.setBounds(10, 11, 40, 40);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect c = new Connect();
				ResultSet rs = c.eligibility(CNIC.getText());
				if (CNIC.getText().isBlank()) {
					JOptionPane.showMessageDialog(contentPane, "ENTER CNIC Number", "Missing Information",
							JOptionPane.ERROR_MESSAGE);
				} else if (c.selectvoter(CNIC.getText()) == -1) {
					JOptionPane.showMessageDialog(contentPane, "You are not a Registered Voter.", "Invalid Data",
							JOptionPane.ERROR_MESSAGE);
				} else {
					try {
						rs.next();
						Name.setText(rs.getString("Name"));
						FatherName.setText(rs.getString("FatherName"));
						BirthYear.setText(rs.getString("BirthYear"));
						City.setText(rs.getString("City"));
						Vote.setText(rs.getString("Vote"));
					} catch (SQLException ex) {
					}
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setIcon(new ImageIcon("D:\\Eclipse\\voting_System\\src\\check.png"));
		btnNewButton.setBounds(329, 18, 120, 35);
		panel.add(btnNewButton);
	}

}
