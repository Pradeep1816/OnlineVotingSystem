package Election2020;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;


public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JTextField tf2;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField tf3;
	private JTextField tf1;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 495);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Election Form");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(148, 11, 169, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(73, 99, 114, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblFathersName = new JLabel("Father's name :\r\n");
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFathersName.setBounds(73, 170, 114, 25);
		contentPane.add(lblFathersName);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(73, 241, 114, 25);
		contentPane.add(lblAge);
		
		JLabel lblCity = new JLabel("City :");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCity.setBounds(73, 273, 114, 25);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State :");
		lblState.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblState.setBounds(73, 304, 114, 25);
		contentPane.add(lblState);
		
		JLabel lblFullAddress = new JLabel("Full Address :");
		lblFullAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFullAddress.setBounds(73, 328, 114, 25);
		contentPane.add(lblFullAddress);
		
		tf = new JTextField();
		tf.setBounds(242, 103, 154, 20);
		contentPane.add(tf);
		tf.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(242, 174, 154, 20);
		contentPane.add(tf2);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(242, 241, 154, 20);
		contentPane.add(tf4);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		tf5.setBounds(242, 277, 154, 20);
		contentPane.add(tf5);
		
		tf6 = new JTextField();
		tf6.setColumns(10);
		tf6.setBounds(242, 308, 154, 20);
		contentPane.add(tf6);
		
		tf7 = new JTextField();
		tf7.setColumns(10);
		tf7.setBounds(242, 339, 154, 20);
		contentPane.add(tf7);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
					
					String sql="insert into voterlist value(?,?,?,?,?,?,?,?,?)";
					PreparedStatement pmt=con.prepareStatement(sql);
					pmt.setString(1, tf.getText());
					pmt.setString(2, tf1.getText());
					pmt.setString(3, tf2.getText());
					pmt.setString(4, tf3.getText());
					pmt.setInt(5, Integer.parseInt(tf4.getText()));
					pmt.setString(6, tf5.getText());
					pmt.setString(7, tf7.getText());
					pmt.setString(8, tf6.getText());
					pmt.setString(9, pass.getText());
					pmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "insertion sucessfull");
					con.close();
					
				}
				catch(Exception e1)
				{
					
				JOptionPane.showMessageDialog(null,e1);
				}
			}
			
		});
		btnNewButton.setBackground(new Color(0, 51, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(176, 411, 142, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Voter Details");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(176, 38, 141, 25);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setForeground(new Color(160, 160, 160));
		separator.setBounds(148, 68, 179, 9);
		contentPane.add(separator);
		
		JLabel lblAdharNumber = new JLabel("Password");
		lblAdharNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdharNumber.setBounds(73, 364, 124, 25);
		contentPane.add(lblAdharNumber);
		
		JLabel lblGender = new JLabel("Gender :");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(73, 205, 114, 25);
		contentPane.add(lblGender);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(242, 205, 154, 20);
		contentPane.add(tf3);
		
		JLabel lblYourId = new JLabel("Your Id :");
		lblYourId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYourId.setBounds(73, 134, 114, 25);
		contentPane.add(lblYourId);
		
		tf1 = new JTextField();
		tf1.setColumns(10);
		tf1.setBounds(242, 134, 154, 20);
		contentPane.add(tf1);
		
		pass = new JPasswordField();
		pass.setBounds(242, 368, 154, 20);
		contentPane.add(pass);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 51, 153));
		btnNewButton_1.setBounds(0, 0, 71, 20);
		contentPane.add(btnNewButton_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(0, 51, 153));
		btnExit.setBounds(419, -1, 71, 20);
		contentPane.add(btnExit);
	}
}
