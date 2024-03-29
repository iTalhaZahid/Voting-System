package voting_System;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Participants extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Participants frame = new Participants();
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
	public Participants() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Participants.class.getResource("/Image_Resource/icons8-vote-100.png")));
		setTitle("Voting System ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 897, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(45, 204, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Participants ");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
		lblNewLabel.setBounds(387, 20, 180, 30);
		contentPane.add(lblNewLabel);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(180, 86, 567, 376);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("PTI");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(Participants.class.getResource("/Image_Resource/260-2606690_pti-pakistan-imrankhan-imran-khan-bat-logo-ptilogo.png")));
		lblNewLabel_1.setBounds(40, 32, 100, 140);
		lblNewLabel_1.setVerticalTextPosition(JLabel.BOTTOM);
		lblNewLabel_1.setHorizontalTextPosition(JLabel.CENTER);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PMLN");
		lblNewLabel_2.setIcon(new ImageIcon(Participants.class.getResource("/Image_Resource/NicePng_rupee-sign-png_2458965 (3).png")));
		lblNewLabel_2.setBounds(230, 32, 100, 140);
		lblNewLabel_2.setVerticalTextPosition(JLabel.BOTTOM);
		lblNewLabel_2.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_2.setIconTextGap(15);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("PPP");
		lblNewLabel_3.setIcon(new ImageIcon(Participants.class.getResource("/Image_Resource/Pakistan_Peoples_Party_Logo (1).png")));
		lblNewLabel_3.setBounds(440, 35, 100, 140);
		lblNewLabel_3.setVerticalTextPosition(JLabel.BOTTOM);
		lblNewLabel_3.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_3.setIconTextGap(25);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("MQM");
		lblNewLabel_4.setIcon(new ImageIcon(Participants.class.getResource("/Image_Resource/mqm-modified (1).png")));
		lblNewLabel_4.setBounds(32, 180, 110, 140);
		lblNewLabel_4.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_4.setVerticalTextPosition(JLabel.BOTTOM);
		panel.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("ANP");
		lblNewLabel_5.setIcon(new ImageIcon(Participants.class.getResource("/Image_Resource/Awami_National_Party.png")));
		lblNewLabel_5.setBounds(230, 180, 120, 140);
		lblNewLabel_5.setHorizontalTextPosition(JLabel.CENTER);
		lblNewLabel_5.setVerticalTextPosition(JLabel.BOTTOM);
		panel.add(lblNewLabel_5);

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
		btnNewButton_1.setIcon(new ImageIcon(Participants.class.getResource("/Image_Resource/back.png")));
		btnNewButton_1.setBounds(10, 11, 40, 40);
		contentPane.add(btnNewButton_1);

	}
}
