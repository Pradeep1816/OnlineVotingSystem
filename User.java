package Election2020;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class User extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User frame = new User();
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
	public User() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 623, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(0, 204, 153));
		panel.setBounds(0, 45, 309, 395);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAddVoter = new JLabel("Add Voter");
		lblAddVoter.setForeground(new Color(204, 0, 204));
		lblAddVoter.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddVoter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Ageverify().setVisible(true);
				
			}
		});
		lblAddVoter.setBounds(96, 112, 119, 14);
		panel.add(lblAddVoter);
		
		JLabel lblUpdateVoter = new JLabel("Update Voter");
		lblUpdateVoter.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Update().setVisible(true);
				dispose();
			}
		});
		lblUpdateVoter.setForeground(new Color(204, 0, 204));
		lblUpdateVoter.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUpdateVoter.setBounds(96, 137, 119, 14);
		panel.add(lblUpdateVoter);
		
		JLabel lblDisplayVoterList = new JLabel("Display Voter List");
		lblDisplayVoterList.setForeground(new Color(204, 0, 204));
		lblDisplayVoterList.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDisplayVoterList.setBounds(96, 162, 119, 14);
		panel.add(lblDisplayVoterList);
		
		JLabel lblAddCandidate = new JLabel("Add candidate");
		lblAddCandidate.setForeground(new Color(204, 0, 204));
		lblAddCandidate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAddCandidate.setBounds(96, 206, 119, 14);
		panel.add(lblAddCandidate);
		
		JLabel lblUpdateCandidate = new JLabel("Update Candidate ");
		lblUpdateCandidate.setForeground(new Color(204, 0, 204));
		lblUpdateCandidate.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUpdateCandidate.setBounds(96, 231, 128, 14);
		panel.add(lblUpdateCandidate);
		
		JLabel label = new JLabel("Display Voter List");
		label.setForeground(new Color(255, 0, 204));
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(96, 256, 128, 14);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Voter Management Systems ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 289, 63);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(29, 55, 257, 8);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 204, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(308, 45, 299, 395);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("<html>If you want to check the votting status, click the button</html>");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 11, 279, 61);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Check Votting Status");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Result().setVisible(true);
				dispose();
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 51, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(23, 172, 250, 95);
		panel_1.add(btnNewButton);
		
		JLabel lblWelcomeToVotting = new JLabel("Welcome to votting stystem");
		lblWelcomeToVotting.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToVotting.setForeground(Color.RED);
		lblWelcomeToVotting.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWelcomeToVotting.setBackground(new Color(255, 255, 255));
		lblWelcomeToVotting.setBounds(0, 0, 607, 46);
		contentPane.add(lblWelcomeToVotting);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(0, 51, 153));
		btnBack.setBounds(0, 0, 71, 23);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(0, 51, 153));
		btnExit.setBounds(543, 0, 64, 23);
		contentPane.add(btnExit);
	}
}
