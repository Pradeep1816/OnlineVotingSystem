package Election2020;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.sql.*;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JTextField tf3;
	private JPasswordField pass;
	private JPasswordField pass1;
	private JLabel lbl1;
	private JLabel lbl2;
	private JLabel lbl3;
	private JLabel lbl4;
	private JLabel lbl5;
	private JTextField tf2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 435);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Election 2020");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(354, 11, 136, 27);
		contentPane.add(lblNewLabel);
		
		JLabel lblName = new JLabel("Voter id");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblName.setBounds(538, 99, 123, 27);
		contentPane.add(lblName);
		
		JLabel lblAdharNumber = new JLabel("password");
		lblAdharNumber.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdharNumber.setBounds(538, 205, 123, 20);
		contentPane.add(lblAdharNumber);
		
		tf1 = new JTextField();
		tf1.setBounds(538, 123, 182, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf1.getText();
				String text2=tf2.getText();
				String text3=pass1.getText();
				try
				{
				   Class.forName("com.mysql.cj.jdbc.Driver");
				   Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				   Statement stmt=con.createStatement();
				   String sql="select * from voterlist where voterId='"+tf1.getText()+"'And Password='"+pass1.getText()+"'";
				   String sql2="select * from voterlist where Name='"+tf2.getText()+"'";
				   String sql3="select * from votername where Name='"+tf2.getText()+"'";
				   String sql1="insert into votername  values(?,?)";
				   PreparedStatement pmt=con.prepareStatement(sql1);
				   ResultSet rs=stmt.executeQuery(sql);
				   if(text1.equals("")||text2.equals("")||text3.equals(""))
						   {
					        lbl3.setText("required field");
					        lbl4.setText("required field");
					        lbl5.setText("required field");
					   
						   }
				 
				  
				   else if(rs.next())
				   {
					  ResultSet rs2=stmt.executeQuery(sql3);
					  if(rs2.next())
					  {
						  JOptionPane.showMessageDialog(null, "You have already vote.you are arrested for illegal work");
					  }
					   
					   else
					   {
						   ResultSet rs1=stmt.executeQuery(sql2);
					   if(rs1.next()) 
					   {
						 
					JOptionPane.showMessageDialog(null, "login success");
					pmt.setString(1, tf2.getText());
					pmt.setString(2, tf1.getText());
					pmt.executeUpdate();
					new Board().setVisible(true);
					dispose();
					   }
					   else
					   {
						   JOptionPane.showMessageDialog(null, " This peson does'nt exist in votetlist");   
					   }
					   
					  }
				   
					  
				   }
				   else
				   {
					   JOptionPane.showMessageDialog(null, "Invalid VoterId");  
				   }
				   con.close();
					
				}
				catch(Exception e1)
				{
			    JOptionPane.showMessageDialog(null,e1);
					
				}
			}
			
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSubmit.setBounds(540, 269, 89, 23);
		contentPane.add(btnSubmit);
		
		JButton btnExit = new JButton("Clear");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				tf2.setText("");
				pass1.setText("");
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(673, 269, 89, 23);
		contentPane.add(btnExit);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 102));
		panel.setBounds(0, 0, 788, 63);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 204, 0));
		panel_1.setBounds(0, 333, 788, 63);
		contentPane.add(panel_1);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblUserName.setBounds(98, 99, 123, 27);
		contentPane.add(lblUserName);
		
		tf3 = new JTextField();
		tf3.setColumns(10);
		tf3.setBounds(98, 123, 182, 20);
		contentPane.add(tf3);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPassword.setBounds(98, 165, 123, 27);
		contentPane.add(lblPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf3.getText();
				String text2=pass.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root", "");
					Statement stmt=con.createStatement();
					String sql="select  * from login where username='"+tf3.getText()+"' And userpassword='"+pass.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					
					if(text1.equals("")||text2.equals(""))
					{
					lbl1.setText("required field");	
					 lbl2.setText("required field");
					}
					else if(rs.next())
					{
						JOptionPane.showMessageDialog(null,"login success");
						new User().setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"username and password incorrect");
					}
					con.close();
				}
				catch(ClassNotFoundException e1)
				{
					JOptionPane.showMessageDialog(null,e1);
					
				}
				catch(SQLException e1)
				{
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnLogin.setBounds(81, 269, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnReset = new JButton("Clear");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf3.setText(null);
				pass.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnReset.setBounds(244, 269, 76, 23);
		contentPane.add(btnReset);
		
		pass = new JPasswordField();
		pass.setBounds(98, 190, 182, 20);
		contentPane.add(pass);
		
		pass1 = new JPasswordField();
		pass1.setBounds(538, 227, 182, 20);
		contentPane.add(pass1);
		
		JLabel lblNewLabel_1 = new JLabel("for new admin");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(142, 292, 101, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblClickHere = new JLabel("Click here");
		lblClickHere.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {  
				new Admin().setVisible(true);
				dispose();
				
			}
		});
		lblClickHere.setForeground(Color.BLUE);
		lblClickHere.setBounds(81, 296, 61, 14);
		contentPane.add(lblClickHere);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.BLACK);
		separator.setBounds(81, 310, 51, 2);
		contentPane.add(separator);
		
	     lbl1 = new JLabel("");
		lbl1.setForeground(Color.RED);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl1.setBounds(98, 146, 106, 8);
		contentPane.add(lbl1);
	    
		lbl2 = new JLabel("");
		lbl2.setForeground(Color.RED);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl2.setBounds(98, 217, 106, 8);
		contentPane.add(lbl2);
		
		JButton btnReset_1 = new JButton("Reset");
		btnReset_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Reset().setVisible(true);
			}
		});
		btnReset_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset_1.setBounds(171, 269, 72, 23);
		contentPane.add(btnReset_1);
		
		JLabel lblYourName = new JLabel("Your Name");
		lblYourName.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblYourName.setBounds(538, 160, 123, 14);
		contentPane.add(lblYourName);
		
		tf2 = new JTextField();
		tf2.setBounds(538, 174, 182, 20);
		contentPane.add(tf2);
		tf2.setColumns(10);
		
		 lbl3 = new JLabel("");
		lbl3.setForeground(Color.RED);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl3.setBounds(537, 146, 106, 8);
		contentPane.add(lbl3);
		
	    lbl4 = new JLabel("");
		lbl4.setForeground(Color.RED);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl4.setBounds(537, 193, 106, 8);
		contentPane.add(lbl4);
		
		 lbl5 = new JLabel("");
		lbl5.setForeground(Color.RED);
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lbl5.setBounds(538, 246, 106, 8);
		contentPane.add(lbl5);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(Login.class.getResource("/images/download (4).jpg")));
		lblNewLabel_2.setBounds(354, 134, 123, 101);
		contentPane.add(lblNewLabel_2);
	}
}
