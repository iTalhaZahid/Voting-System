package voting_System;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class AdminPanel extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Username;
	private JTextField Password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminPanel frame = new AdminPanel();
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
	public AdminPanel() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AdminPanel.class.getResource("/Image_Resource/icons8-vote-100.png")));
		setResizable(false);
		setTitle("Voting System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(100, 80, 913, 562);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(45, 204, 130));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(420, 160, 100, 80);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Admin Login");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 21));
		lblNewLabel_1.setBackground(new Color(128, 128, 255));
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(290, 87, 370, 58);
		contentPane.add(lblNewLabel_1);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(215, 215, 215));
		desktopPane.setBounds(290, 145, 370, 250);
		contentPane.add(desktopPane);
		desktopPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Username :");
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_2.setBounds(55, 115, 95, 14);
		desktopPane.add(lblNewLabel_2);

		Username = new JTextField();
		Username.setBounds(180, 110, 140, 25);
		desktopPane.add(Username);
		Username.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Passsword :");
		lblNewLabel_3.setFont(new Font("Arial", Font.BOLD, 17));
		lblNewLabel_3.setBounds(55, 148, 105, 14);
		desktopPane.add(lblNewLabel_3);

		Password = new JTextField();
		Password.setBounds(180, 142, 140, 25);
		desktopPane.add(Password);
		Password.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(142, 45, 49, 14);
		lblNewLabel.setIcon(new ImageIcon(AdminPanel.class.getResource("/Image_Resource/icons8-user-64.png")));
		desktopPane.add(lblNewLabel_4);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(1, 179, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connect c = new Connect();
				AdminDashboard admd = new AdminDashboard();
				if (Username.getText().isEmpty() || Password.getText().isBlank())
					JOptionPane.showMessageDialog(contentPane, "Enter Valid Username or Password", "Error",
							JOptionPane.ERROR_MESSAGE);
				else if (c.selectadmin(Username.getText(), Password.getText()) == 1) {

					admd.setVisible(true);
					dispose();

				}

			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 17));
		btnNewButton.setBounds(126, 187, 89, 23);
		desktopPane.add(btnNewButton);

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
		btnNewButton_1.setIcon(new ImageIcon(AdminPanel.class.getResource("/Image_Resource/back.png")));
		btnNewButton_1.setBounds(10, 11, 40, 40);
		contentPane.add(btnNewButton_1);
	}
}