package Election2020;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;

public class Update extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf2;
	private JTextField tf3;
	private JTextField tf4;
	private JTextField tf5;
	private JTextField tf6;
	private JTextField tf7;
	private JTextField tf8;
	private JTextField tf9;
	private JTextField tf10;
	private JTextField tf11;
	private JTextField tf12;
	private JTextField tf13;
	private JTextField tf14;
	private JTextField tf15;
	private JTextField tf16;
	private JTextField tf17;
	private JTextField tf18;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update frame = new Update();
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
	public Update() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 631, 492);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name ");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(26, 68, 114, 25);
		contentPane.add(lblName);
		
		JLabel lblYourId = new JLabel("Your Id ");
		lblYourId.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYourId.setBounds(26, 104, 114, 25);
		contentPane.add(lblYourId);
		
		JLabel lblFathersName = new JLabel("Father's name ");
		lblFathersName.setHorizontalAlignment(SwingConstants.CENTER);
		lblFathersName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFathersName.setBounds(26, 140, 114, 25);
		contentPane.add(lblFathersName);
		
		JLabel lblGender = new JLabel("Gender ");
		lblGender.setHorizontalAlignment(SwingConstants.CENTER);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(26, 171, 114, 25);
		contentPane.add(lblGender);
		
		JLabel lblAge = new JLabel("Age ");
		lblAge.setHorizontalAlignment(SwingConstants.CENTER);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(26, 202, 114, 25);
		contentPane.add(lblAge);
		
		JLabel lblCity = new JLabel("City ");
		lblCity.setHorizontalAlignment(SwingConstants.CENTER);
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCity.setBounds(26, 233, 114, 25);
		contentPane.add(lblCity);
		
		JLabel lblState = new JLabel("State ");
		lblState.setHorizontalAlignment(SwingConstants.CENTER);
		lblState.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblState.setBounds(26, 269, 114, 25);
		contentPane.add(lblState);
		
		JLabel lblFullAddress = new JLabel("Full Address ");
		lblFullAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblFullAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFullAddress.setBounds(26, 305, 114, 25);
		contentPane.add(lblFullAddress);
		
		JLabel lblAdharNumber = new JLabel("Password");
		lblAdharNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdharNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdharNumber.setBounds(26, 340, 124, 25);
		contentPane.add(lblAdharNumber);
		
		JButton button = new JButton("Update");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf1.getText();
				String text2=tf10.getText();
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");	
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				String sql="Update voterlist set Name=? where voterId='"+tf10.getText()+"'";
				String sql1="select * from voterlist where voterId='"+tf10.getText()+"'";
				PreparedStatement pmt=con.prepareStatement(sql);
				Statement stmt =con.createStatement();
				ResultSet rs=stmt.executeQuery(sql1);
				if(text1.equals("")||text2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Empaty Firld");	
				}
				else if(rs.next())
		        {
				pmt.setString(1,tf1.getText());		
				pmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "update successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Loation incorrect");
				}
				con.close();
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(new Color(0, 153, 255));
		button.setBounds(430, 68, 142, 23);
		contentPane.add(button);
		
		JButton button_1 = new JButton("Update");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf2.getText();
				String text2=tf11.getText();
				String text3=tf10.getText();
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");	
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				String sql="Update voterlist set voterId=? where Name='"+tf11.getText()+"'";
				String sql1="select * from voterlist where Name='"+tf11.getText()+"'";// and YourId='"+tf11.getText()+"'";
				PreparedStatement pmt=con.prepareStatement(sql);
				Statement stmt =con.createStatement();
				ResultSet rs=stmt.executeQuery(sql1);
				if(text1.equals("")||text2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Empaty Firld");	
				}
				else if(rs.next())
		         {
				pmt.setString(1,tf2.getText());		
				pmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "update successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Loation incorrect");
				}
				con.close();
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
		
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_1.setBackground(new Color(0, 153, 255));
		button_1.setBounds(430, 102, 142, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Update");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf3.getText();
				String text2=tf12.getText();
				String text3=tf10.getText();
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");	
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				String sql="Update voterlist set FatherName=? where Name='"+tf12.getText()+"'";
				String sql1="select * from voterlist where Name='"+tf12.getText()+"'";// and YourId='"+tf11.getText()+"'";
				PreparedStatement pmt=con.prepareStatement(sql);
				Statement stmt =con.createStatement();
				ResultSet rs=stmt.executeQuery(sql1);
				if(text1.equals("")||text2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Empaty Firld");	
				}
				else if(rs.next())
		         {
				pmt.setString(1,tf3.getText());		
				pmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "update successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Loation incorrect");
				}
				con.close();
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
		
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_2.setBackground(new Color(0, 153, 255));
		button_2.setBounds(430, 138, 142, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Update");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf4.getText();
				String text2=tf13.getText();
				String text3=tf10.getText();
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");	
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				String sql="Update voterlist set Gender=? where Name='"+tf13.getText()+"'";
				String sql1="select * from voterlist where Name='"+tf13.getText()+"'";// and YourId='"+tf11.getText()+"'";
				PreparedStatement pmt=con.prepareStatement(sql);
				Statement stmt =con.createStatement();
				ResultSet rs=stmt.executeQuery(sql1);
				if(text1.equals("")||text2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Empaty Firld");	
				}
				else if(rs.next())
		         {
				pmt.setString(1,tf4.getText());		
				pmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "update successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Loation incorrect");
				}
				con.close();
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
		
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_3.setBackground(new Color(0, 153, 255));
		button_3.setBounds(430, 172, 142, 23);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("Update");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf5.getText();
				String text2=tf14.getText();
				String text3=tf10.getText();
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");	
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				String sql="Update voterlist set Age=? where Name='"+tf14.getText()+"'";
				String sql1="select * from voterlist where Name='"+tf14.getText()+"'";// and YourId='"+tf11.getText()+"'";
				PreparedStatement pmt=con.prepareStatement(sql);
				Statement stmt =con.createStatement();
				ResultSet rs=stmt.executeQuery(sql1);
				if(text1.equals("")||text2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Empaty Firld");	
				}
				else if(rs.next())
		         {
				pmt.setString(1,tf5.getText());		
				pmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "update successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Loation incorrect");
				}
				con.close();
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
		
			}
		});
		button_4.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_4.setBackground(new Color(0, 153, 255));
		button_4.setBounds(430, 200, 142, 23);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("Update");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf6.getText();
				String text2=tf15.getText();
				String text3=tf10.getText();
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");	
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				String sql="Update votelistr set City=? where Name='"+tf15.getText()+"'";
				String sql1="select * from voterlist where Name='"+tf15.getText()+"'";// and YourId='"+tf11.getText()+"'";
				PreparedStatement pmt=con.prepareStatement(sql);
				Statement stmt =con.createStatement();
				ResultSet rs=stmt.executeQuery(sql1);
				if(text1.equals("")||text2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Empaty Firld");	
				}
				else if(rs.next())
		         {
				pmt.setString(1,tf6.getText());		
				pmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "update successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Loation incorrect");
				}
				con.close();
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
		
			}
		});
		button_5.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_5.setBackground(new Color(0, 153, 255));
		button_5.setBounds(430, 231, 142, 23);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("Update");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf7.getText();
				String text2=tf16.getText();
				String text3=tf10.getText();
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");	
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				String sql="Update voterlist set State=? where Name='"+tf16.getText()+"'";
				String sql1="select * from voterlist where Name='"+tf16.getText()+"'";// and YourId='"+tf11.getText()+"'";
				PreparedStatement pmt=con.prepareStatement(sql);
				Statement stmt =con.createStatement();
				ResultSet rs=stmt.executeQuery(sql1);
				if(text1.equals("")||text2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Empaty Firld");	
				}
				else if(rs.next())
		         {
				pmt.setString(1,tf7.getText());		
				pmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "update successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Loation incorrect");
				}
				con.close();
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
		
			}
		});
		button_6.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_6.setBackground(new Color(0, 153, 255));
		button_6.setBounds(430, 267, 142, 23);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("Update");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf8.getText();
				String text2=tf17.getText();
				String text3=tf10.getText();
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");	
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				String sql="Update voterlist set Address =? where Name='"+tf17.getText()+"'";
				String sql1="select * from voterlist where Name='"+tf17.getText()+"'";// and YourId='"+tf11.getText()+"'";
				PreparedStatement pmt=con.prepareStatement(sql);
				Statement stmt =con.createStatement();
				ResultSet rs=stmt.executeQuery(sql1);
				if(text1.equals("")||text2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Empaty Firld");	
				}
				else if(rs.next())
		         {
				pmt.setString(1,tf8.getText());		
				pmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "update successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Loation incorrect");
				}
				con.close();
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
		
			}
		});
		button_7.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_7.setBackground(new Color(0, 153, 255));
		button_7.setBounds(430, 303, 142, 23);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("Update");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf9.getText();
				String text2=tf18.getText();
				String text3=tf10.getText();
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");	
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				String sql="Update voterlist set Password=? where Name='"+tf18.getText()+"'";
				String sql1="select * from voterlist where Name='"+tf18.getText()+"'";// and YourId='"+tf11.getText()+"'";
				PreparedStatement pmt=con.prepareStatement(sql);
				Statement stmt =con.createStatement();
				ResultSet rs=stmt.executeQuery(sql1);
				if(text1.equals("")||text2.equals(""))
				{
					JOptionPane.showMessageDialog(null, "Empaty Firld");	
				}
				else if(rs.next())
		         {
				pmt.setString(1,tf9.getText());		
				pmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "update successful");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Loation incorrect");
				}
				con.close();
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
		
			}
		});
		button_8.setFont(new Font("Tahoma", Font.BOLD, 15));
		button_8.setBackground(new Color(0, 153, 255));
		button_8.setBounds(430, 338, 142, 23);
		contentPane.add(button_8);
		
		tf1 = new JTextField();
		tf1.setBounds(154, 72, 114, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		tf2 = new JTextField();
		tf2.setColumns(10);
		tf2.setBounds(154, 108, 114, 20);
		contentPane.add(tf2);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(154, 144, 114, 20);
		contentPane.add(tf3);
		
		tf4 = new JTextField();
		tf4.setColumns(10);
		tf4.setBounds(154, 175, 114, 20);
		contentPane.add(tf4);
		
		tf5 = new JTextField();
		tf5.setColumns(10);
		tf5.setBounds(154, 206, 114, 20);
		contentPane.add(tf5);
		
		tf6 = new JTextField();
		tf6.setColumns(10);
		tf6.setBounds(154, 237, 114, 20);
		contentPane.add(tf6);
		
		tf7 = new JTextField();
		tf7.setColumns(10);
		tf7.setBounds(154, 273, 114, 20);
		contentPane.add(tf7);
		
		tf8 = new JTextField();
		tf8.setColumns(10);
		tf8.setBounds(154, 309, 114, 20);
		contentPane.add(tf8);
		
		tf9 = new JTextField();
		tf9.setColumns(10);
		tf9.setBounds(154, 344, 114, 20);
		contentPane.add(tf9);
		
		tf10 = new JTextField();
		tf10.setColumns(10);
		tf10.setBounds(292, 73, 114, 20);
		contentPane.add(tf10);
		
		tf11 = new JTextField();
		tf11.setColumns(10);
		tf11.setBounds(292, 109, 114, 20);
		contentPane.add(tf11);
		
		tf12 = new JTextField();
		tf12.setColumns(10);
		tf12.setBounds(292, 145, 114, 20);
		contentPane.add(tf12);
		
		tf13 = new JTextField();
		tf13.setColumns(10);
		tf13.setBounds(292, 176, 114, 20);
		contentPane.add(tf13);
		
		tf14 = new JTextField();
		tf14.setColumns(10);
		tf14.setBounds(292, 207, 114, 20);
		contentPane.add(tf14);
		
		tf15 = new JTextField();
		tf15.setColumns(10);
		tf15.setBounds(292, 238, 114, 20);
		contentPane.add(tf15);
		
		tf16 = new JTextField();
		tf16.setColumns(10);
		tf16.setBounds(292, 274, 114, 20);
		contentPane.add(tf16);
		
		tf17 = new JTextField();
		tf17.setColumns(10);
		tf17.setBounds(292, 310, 114, 20);
		contentPane.add(tf17);
		
		tf18 = new JTextField();
		tf18.setColumns(10);
		tf18.setBounds(292, 345, 114, 20);
		contentPane.add(tf18);
		
		JLabel lblNewLabel = new JLabel("Update Field");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(154, 49, 114, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLocationField = new JLabel("Location Field");
		lblLocationField.setForeground(Color.RED);
		lblLocationField.setHorizontalAlignment(SwingConstants.CENTER);
		lblLocationField.setBounds(292, 48, 114, 14);
		contentPane.add(lblLocationField);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User().setVisible(true);
				dispose();
			}
		});
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(0, 51, 102));
		btnBack.setBounds(0, 0, 83, 25);
		contentPane.add(btnBack);
	}
}
