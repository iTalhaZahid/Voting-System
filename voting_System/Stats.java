package voting_System;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;
import java.awt.Toolkit;

public class Stats extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField PMLNS;
	private JTextField PPPS;
	private JTextField PTIS;
	private JTextField MQMS;
	private JTextField ANPS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stats frame = new Stats();
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
	public Stats() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Stats.class.getResource("/Image_Resource/icons8-vote-100.png")));
		setTitle("Voting System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(45, 204, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Participant Stats ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblNewLabel.setBounds(373, 21, 229, 30);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBounds(180, 86, 567, 376);
		contentPane.add(panel);
		panel.setLayout(null);

		PTIS = new JTextField();
		PTIS.setEditable(false);
		PTIS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PTIS.setHorizontalAlignment(SwingConstants.CENTER);
		PTIS.setText("5");
		PTIS.setForeground(new Color(255, 255, 255));
		PTIS.setBackground(new Color(0, 0, 0));
		PTIS.setBounds(124, 142, 49, 37);
		panel.add(PTIS);
		PTIS.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("PTI");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Stats.class.getResource("/Image_Resource/260-2606690_pti-pakistan-imrankhan-imran-khan-bat-logo-ptilogo.png")));
		lblNewLabel_1.setBounds(40, 32, 100, 140);
		lblNewLabel_1.setVerticalTextPosition(JLabel.BOTTOM);
		lblNewLabel_1.setHorizontalTextPosition(JLabel.CENTER);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PMLN");
		lblNewLabel_2.setIcon(new ImageIcon(Stats.class.getResource("/Image_Resource/NicePng_rupee-sign-png_2458965 (3).png")));
		lblNewLabel_2.setBounds(230, 32, 100, 140);
		lblNewLabel_2.setVerticalTextPosition(JLabel.BOTTOM);
		lblNewLabel_2.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_2.setIconTextGap(15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("PPP");
		lblNewLabel_3.setIcon(new ImageIcon(Stats.class.getResource("/Image_Resource/Pakistan_Peoples_Party_Logo (1).png")));
		lblNewLabel_3.setBounds(442, 37, 100, 140);
		lblNewLabel_3.setVerticalTextPosition(JLabel.BOTTOM);
		lblNewLabel_3.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_3.setIconTextGap(25);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("MQM");
		lblNewLabel_4.setIcon(new ImageIcon(Stats.class.getResource("/Image_Resource/mqm-modified (1).png")));
		lblNewLabel_4.setBounds(32, 180, 110, 140);
		lblNewLabel_4.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_4.setVerticalTextPosition(JLabel.BOTTOM);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("ANP");
		lblNewLabel_5.setIcon(new ImageIcon(Stats.class.getResource("/Image_Resource/Awami_National_Party.png")));
		lblNewLabel_5.setBounds(230, 180, 120, 140);
		lblNewLabel_5.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_5.setVerticalTextPosition(JLabel.BOTTOM);
		panel.add(lblNewLabel_5);

		PMLNS = new JTextField();
		PMLNS.setEditable(false);
		PMLNS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PMLNS.setText("5");
		PMLNS.setHorizontalAlignment(SwingConstants.CENTER);
		PMLNS.setBackground(new Color(0, 0, 0));
		PMLNS.setForeground(new Color(255, 255, 255));
		PMLNS.setBounds(320, 142, 49, 37);
		panel.add(PMLNS);
		PMLNS.setColumns(10);

		PPPS = new JTextField();
		PPPS.setEditable(false);
		PPPS.setHorizontalAlignment(SwingConstants.CENTER);
		PPPS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PPPS.setText("5");
		PPPS.setBackground(new Color(0, 0, 0));
		PPPS.setForeground(new Color(255, 255, 255));
		PPPS.setBounds(510, 142, 49, 37);
		panel.add(PPPS);
		PPPS.setColumns(10);

		MQMS = new JTextField();
		MQMS.setEditable(false);
		MQMS.setHorizontalAlignment(SwingConstants.CENTER);
		MQMS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		MQMS.setText("5");
		MQMS.setBackground(new Color(0, 0, 0));
		MQMS.setForeground(new Color(255, 255, 255));
		MQMS.setBounds(124, 280, 49, 37);
		panel.add(MQMS);
		MQMS.setColumns(10);

		ANPS = new JTextField();
		ANPS.setEditable(false);
		ANPS.setForeground(new Color(255, 255, 255));
		ANPS.setText("5");
		ANPS.setHorizontalAlignment(SwingConstants.CENTER);
		ANPS.setFont(new Font("Tahoma", Font.PLAIN, 20));
		ANPS.setBackground(new Color(0, 0, 0));
		ANPS.setBounds(320, 280, 49, 37);
		panel.add(ANPS);
		ANPS.setColumns(10);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminDashboard ad = new AdminDashboard();
				ad.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(45, 204, 130));
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setIcon(new ImageIcon(Stats.class.getResource("/Image_Resource/back.png")));
		btnNewButton_1.setBounds(10, 10, 40, 40);
		contentPane.add(btnNewButton_1);

	}

	public void setstat(String PTI, String PMLN, String MQM, String ANP, String PPP) {
		PTIS.setText(PTI);
		PMLNS.setText(PMLN);
		MQMS.setText(MQM);
		ANPS.setText(ANP);
		PPPS.setText(PPP);
	}
}
