package Election2020;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;

public class Board extends JFrame {
	private JPanel contentPane;
	
	public JLabel lbl3;
	int c=1;
	int c1=1;
	int c2=1;
	int c3=1;
	int c4=1;
	int c5=1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board frame = new Board();
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
	public Board() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WELLCOME TO ELECTION 2020");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(167, 11, 393, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("BJP");
		lblNewLabel_1.setIcon(new ImageIcon(Board.class.getResource("/images/download.jpg")));
		lblNewLabel_1.setBounds(76, 171, 81, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblGender = new JLabel("INC");
		lblGender.setIcon(new ImageIcon(Board.class.getResource("/images/download.png")));
		lblGender.setBounds(567, 171, 81, 48);
		contentPane.add(lblGender);
		
		JLabel lblAdharNmber = new JLabel("NPP");
		lblAdharNmber.setIcon(new ImageIcon(Board.class.getResource("/images/1200px-Indian_Election_Symbol_Book.svg.png")));
		lblAdharNmber.setBounds(370, 171, 81, 48);
		contentPane.add(lblAdharNmber);
		
		JLabel lblParty = new JLabel("CPI");
		lblParty.setIcon(new ImageIcon(Board.class.getResource("/images/images.png")));
		lblParty.setBounds(267, 171, 93, 48);
		contentPane.add(lblParty);
		
		JLabel lblNcp = new JLabel("NCP");
		lblNcp.setIcon(new ImageIcon(Board.class.getResource("/images/thumb4.jpg")));
		lblNcp.setBounds(469, 171, 81, 48);
		contentPane.add(lblNcp);
		
		JLabel lblBsp = new JLabel("BSP");
		lblBsp.setIcon(new ImageIcon(Board.class.getResource("/images/ele.jpg")));
		lblBsp.setBounds(167, 171, 81, 48);
		contentPane.add(lblBsp);
		
		JButton btnNewButton = new JButton("VOTE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		
				
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				String sql="insert into votecount (BJP) values(?)";
				PreparedStatement pmt=con.prepareStatement(sql);
				
				pmt.setString(1,""+c);
				pmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "your vote for bjp");
				new Login().setVisible(true);
				dispose();
				con.close();
			}
			catch(Exception e1)
			{
				JOptionPane.showMessageDialog(null, e1);
			}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 51, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBounds(68, 266, 89, 58);
		contentPane.add(btnNewButton);
		
		JButton btnVote = new JButton("VOTE");
		btnVote.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
					
					String sql="insert into votecount  (BSP)value(?)";
					PreparedStatement pmt=con.prepareStatement(sql);
					pmt.setString(1,""+c1);
					pmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "your vote for BSP");
					new Login().setVisible(true);
					dispose();
					con.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnVote.setForeground(new Color(255, 255, 255));
		btnVote.setBackground(new Color(0, 51, 102));
		btnVote.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVote.setBounds(167, 266, 89, 58);
		contentPane.add(btnVote);
		
		JButton btnVote_1 = new JButton("VOTE");
		btnVote_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
					
					String sql="insert into votecount  (CPI)value(?)";
					PreparedStatement pmt=con.prepareStatement(sql);
					
					pmt.setString(1,""+c2);
					pmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "your vote for CPI");
					new Login().setVisible(true);
					dispose();
					con.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnVote_1.setBackground(new Color(0, 51, 102));
		btnVote_1.setForeground(new Color(255, 255, 255));
		btnVote_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVote_1.setBounds(267, 266, 89, 58);
		contentPane.add(btnVote_1);
		
		JButton btnVote_2 = new JButton("VOTE");
		btnVote_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
					
					String sql="insert into votecount  (NPP)value(?)";
					PreparedStatement pmt=con.prepareStatement(sql);
					
					pmt.setString(1,""+c3);
					pmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "your vote for NPP");
					new Login().setVisible(true);
					dispose();
					con.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnVote_2.setForeground(new Color(255, 255, 255));
		btnVote_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVote_2.setBackground(new Color(0, 51, 102));
		btnVote_2.setBounds(370, 266, 89, 58);
		contentPane.add(btnVote_2);
		
		JButton btnVote_3 = new JButton("VOTE");
		btnVote_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
					
					String sql="insert into votecount  (NCP)value(?)";
					PreparedStatement pmt=con.prepareStatement(sql);
					
					pmt.setString(1,""+c4);
					pmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "your vote for NCP");
					new Login().setVisible(true);
					dispose();
					con.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnVote_3.setForeground(new Color(255, 255, 255));
		btnVote_3.setBackground(new Color(0, 51, 102));
		btnVote_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVote_3.setBounds(469, 266, 89, 58);
		contentPane.add(btnVote_3);
		
		JButton btnVote_4 = new JButton("VOTE");
		btnVote_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
					
					String sql="insert into votecount  (INC)value(?)";
					PreparedStatement pmt=con.prepareStatement(sql);
					
					pmt.setString(1,""+c5);
					pmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "your vote for INC");
					new Login().setVisible(true);
					dispose();
					con.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		btnVote_4.setForeground(new Color(255, 255, 255));
		btnVote_4.setBackground(new Color(0, 51, 102));
		btnVote_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnVote_4.setBounds(567, 266, 89, 58);
		contentPane.add(btnVote_4);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setForeground(Color.GRAY);
		separator.setBounds(10, 93, 700, 14);
		contentPane.add(separator);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
			}
		});
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBackground(new Color(0, 51, 153));
		btnBack.setBounds(0, 0, 64, 21);
		contentPane.add(btnBack);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setBackground(new Color(0, 51, 153));
		btnExit.setBounds(656, 0, 64, 21);
		contentPane.add(btnExit);
	}
}
