package voting_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JButton;
import java.awt.Panel;
import java.awt.Button;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MainPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel frame = new MainPanel();
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
	public MainPanel() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainPanel.class.getResource("/Image_Resource/icons8-vote-100.png")));
		setTitle("Voting System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 80, 819, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(45, 204, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Voting System");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel.setBackground(new Color(128, 128, 192));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(135, 44, 506, 61);
		lblNewLabel.setOpaque(true);
		contentPane.add(lblNewLabel);

		Panel panel = new Panel();
		panel.setBackground(new Color(215, 215, 215));
		panel.setBounds(135, 106, 506, 327);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("VOTE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VoterLogin vl = new VoterLogin();
				vl.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(40, 119, 89, 23);
		panel.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("CHECK VOTE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Eligibility el = new Eligibility();
				el.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(203, 119, 115, 23);
		panel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("PARTIES");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Participants p = new Participants();
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(387, 119, 89, 23);
		panel.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("EXIT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setBounds(216, 250, 89, 23);
		panel.add(btnNewButton_3);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(MainPanel.class.getResource("/Image_Resource/icons8-vote-100.png")));
		lblNewLabel_1.setBounds(15, 16, 127, 97);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(MainPanel.class.getResource("/Image_Resource/icons8-instagram-check-mark-100.png")));
		lblNewLabel_2.setBounds(203, 11, 115, 107);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(MainPanel.class.getResource("/Image_Resource/icons8-choice-96.png")));
		lblNewLabel_3.setBounds(387, 26, 89, 92);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setIcon(new ImageIcon(MainPanel.class.getResource("/Image_Resource/icons8-cancel-100.png")));
		lblNewLabel_4.setBounds(203, 145, 108, 107);
		panel.add(lblNewLabel_4);

		JButton btnNewButton_4 = new JButton("Admin Panel");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminPanel adp = new AdminPanel();
				adp.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(1, 179, 255));
		btnNewButton_4.setBounds(678, 11, 117, 23);
		contentPane.add(btnNewButton_4);
	}
}
