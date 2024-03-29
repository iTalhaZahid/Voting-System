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

import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import java.awt.Toolkit;

public class Vote extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField CNIC;
	private JTextField Name;
	private JTextField FatherName;
	private JTextField BirthYear;
	private JTextField City;
	private JLabel img4;
	private JLabel img5;
	private JLabel img3;
	private JLabel image2;
	private JLabel image1;
	private JRadioButton PTI;
	private JRadioButton PPP;
	private JRadioButton MQM;
	private JRadioButton ANP;
	private final ButtonGroup VotedParty = new ButtonGroup();
	int PTIV, PPPV, PMLNV, MQMV, ANPV, votes;
	String selection;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vote frame = new Vote();
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
	public Vote() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Vote.class.getResource("/Image_Resource/icons8-vote-100.png")));
		setTitle("Voting System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(45, 204, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Vote");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 26));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(437, 22, 75, 28);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();

		panel.setBorder(new MatteBorder(3, 3, 0, 3, (Color) new Color(255, 255, 255)));
		panel.setBackground(new Color(45, 204, 130));
		panel.setBounds(205, 61, 545, 63);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("CNIC");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 11, 97, 14);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Name");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(116, 11, 96, 14);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Father Name");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(223, 11, 96, 14);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Birth Year");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(329, 11, 96, 14);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("City");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(435, 11, 94, 14);
		panel.add(lblNewLabel_5);

		CNIC = new JTextField();
		CNIC.setEditable(false);
		CNIC.setBounds(10, 32, 96, 20);
		panel.add(CNIC);
		CNIC.setColumns(10);

		Name = new JTextField();
		Name.setEditable(false);
		Name.setBounds(116, 32, 96, 20);
		panel.add(Name);
		Name.setColumns(10);

		FatherName = new JTextField();
		FatherName.setEditable(false);
		FatherName.setBounds(223, 32, 96, 20);
		panel.add(FatherName);
		FatherName.setColumns(10);

		BirthYear = new JTextField();
		BirthYear.setEditable(false);
		BirthYear.setBounds(329, 32, 96, 20);
		panel.add(BirthYear);
		BirthYear.setColumns(10);

		City = new JTextField();
		City.setEditable(false);
		City.setBounds(435, 32, 96, 20);
		panel.add(City);
		City.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(205, 122, 545, 400);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		image1 = new JLabel("");
		image1.setHorizontalAlignment(SwingConstants.CENTER);
		image1.setIcon(new ImageIcon(Vote.class.getResource("/Image_Resource/260-2606690_pti-pakistan-imrankhan-imran-khan-bat-logo-ptilogo.png")));
		image1.setBounds(40, 10, 100, 140);
		image1.setVerticalTextPosition(JLabel.BOTTOM);
		image1.setHorizontalTextPosition(JLabel.CENTER);
		panel_1.add(image1);

		image2 = new JLabel("");
		image2.setIcon(new ImageIcon(Vote.class.getResource("/Image_Resource/NicePng_rupee-sign-png_2458965 (3).png")));
		image2.setBounds(230, 10, 100, 140);
		image2.setVerticalTextPosition(JLabel.BOTTOM);
		image2.setHorizontalTextPosition(JLabel.CENTER);
		image2.setIconTextGap(15);
		panel_1.add(image2);

		img3 = new JLabel("");
		img3.setIcon(new ImageIcon(Vote.class.getResource("/Image_Resource/Pakistan_Peoples_Party_Logo (1).png")));
		img3.setBounds(400, 17, 100, 120);
		img3.setVerticalTextPosition(JLabel.BOTTOM);
		img3.setHorizontalTextPosition(JLabel.CENTER);
		img3.setIconTextGap(25);
		panel_1.add(img3);

		img4 = new JLabel();
		img4.setIcon(new ImageIcon(Vote.class.getResource("/Image_Resource/mqm-modified (1).png")));
		img4.setBounds(32, 160, 110, 140);
		img4.setHorizontalTextPosition(JLabel.CENTER);
		img4.setVerticalTextPosition(JLabel.BOTTOM);
		panel_1.add(img4);

		img5 = new JLabel("");
		img5.setIcon(new ImageIcon(Vote.class.getResource("/Image_Resource/Awami_National_Party.png")));
		img5.setBounds(230, 160, 120, 140);
		img5.setHorizontalTextPosition(JLabel.CENTER);
		img5.setVerticalTextPosition(JLabel.BOTTOM);
		panel_1.add(img5);

		PTI = new JRadioButton("PTI");
		VotedParty.add(PTI);
		PTI.setBounds(50, 145, 111, 23);
		panel_1.add(PTI);

		JRadioButton PMLN = new JRadioButton("PMLN");
		VotedParty.add(PMLN);
		PMLN.setBounds(240, 145, 111, 23);
		panel_1.add(PMLN);

		PPP = new JRadioButton("PPP");
		VotedParty.add(PPP);
		PPP.setBounds(420, 145, 111, 23);
		panel_1.add(PPP);

		MQM = new JRadioButton("MQM");
		VotedParty.add(MQM);
		MQM.setBounds(50, 292, 111, 23);
		panel_1.add(MQM);

		ANP = new JRadioButton("ANP");
		VotedParty.add(ANP);
		ANP.setBounds(240, 292, 111, 23);
		panel_1.add(ANP);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoterLogin vl = new VoterLogin();
				vl.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(45, 204, 130));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setIcon(new ImageIcon(Vote.class.getResource("/Image_Resource/back.png")));
		btnNewButton_1.setBounds(10, 11, 40, 40);
		contentPane.add(btnNewButton_1);

		JButton btnNewButton = new JButton("VOTE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect c = new Connect();
				ResultSet rs = c.party();
//				String selection;
				try {
					rs.next();
					PTIV = Integer.parseInt(rs.getString("PTI"));
					PPPV = Integer.parseInt(rs.getString("PPP"));
					MQMV = Integer.parseInt(rs.getString("MQM"));
					ANPV = Integer.parseInt(rs.getString("ANP"));
					PMLNV = Integer.parseInt(rs.getString("PMLN"));
				} catch (Exception ex) {

				}
				if (PTI.isSelected()) {
//					System.out.println("PTI");
					selection = "PTI";
					votes = PTIV;

				} else if (PPP.isSelected()) {
//					System.out.println("PPP");
					selection = "PPP";
					votes = PPPV;
				} else if (PMLN.isSelected()) {
//					System.out.println("PMLN");
					selection = "PMLN";
					votes = PMLNV;
				} else if (ANP.isSelected()) {
//					System.out.println("ANP");
					selection = "ANP";
					votes = ANPV;
				} else if (MQM.isSelected()) {
//					System.out.println("MQM");
					selection = "MQM";
					votes = MQMV;
				} else
					JOptionPane.showMessageDialog(contentPane, "Please Select A Party", "Invalid Choice",
							JOptionPane.OK_OPTION);

//				System.out.println(selection + votes);

				if (selection.equals("PTI")) {
					votes = ++PTIV;
				} else if (selection.equals("PPP"))
					votes = ++PPPV;
				else if (selection.equals("MQM"))
					votes = ++MQMV;
				else if (selection.equals("ANP"))
					votes = ++ANPV;
				else if (selection.equals("PMLN"))
					votes = ++PMLNV;
//				System.out.println(selection + votes);
				c.vote(CNIC.getText(), selection, votes);

				JOptionPane.showMessageDialog(contentPane, "Your vote has been submitted", "Vote Submitted",
						JOptionPane.INFORMATION_MESSAGE);
				VoterLogin n = new VoterLogin();
				n.setVisible(true);
				dispose();
			}
		});

		btnNewButton.setBounds(232, 360, 89, 23);
		btnNewButton.setBackground(new Color(1, 179, 255));
		btnNewButton.setForeground(new Color(255, 255, 255));
		panel_1.add(btnNewButton);

	}

	public void updateVoterInfo(String name, String fatherName, String cnic, String birthYear, String city) {
		Name.setText(name);
		FatherName.setText(fatherName);
		CNIC.setText(cnic);
		BirthYear.setText(birthYear);
		City.setText(city);
	}
}
