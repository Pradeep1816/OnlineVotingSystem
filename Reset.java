package Election2020;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Reset extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass3;
	private JPasswordField pass1;
	private JPasswordField pass2;
	private JLabel lbl1,lbl2,lbl3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reset frame = new Reset();
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
	public Reset() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setBackground(new Color(0, 153, 255));
		panel.setBounds(23, 11, 332, 365);
		contentPane.add(panel);
		
		JLabel lblNewPassword = new JLabel("New Password ");
		lblNewPassword.setForeground(new Color(255, 255, 255));
		lblNewPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewPassword.setBounds(87, 129, 99, 21);
		panel.add(lblNewPassword);
		
		JLabel lblRetype = new JLabel("Confirm Password");
		lblRetype.setForeground(new Color(255, 255, 255));
		lblRetype.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblRetype.setBounds(87, 196, 99, 21);
		panel.add(lblRetype);
		
		JButton button = new JButton("Submit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=pass2.getText();
				String text2=pass3.getText();
				String text3=pass1.getText();
	
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
					Statement stmt=con.createStatement();
					String sql="select * from login where userpassword='"+pass1.getText()+"'";
					String sql1	="update login set userpassword=? where userpassword='"+pass1.getText()+"'";
					
					
					ResultSet rs=stmt.executeQuery(sql);
					if(text1.equals("")||text2.equals("")||text3.equals(""))
					{
						lbl1.setText("required field");
						lbl2.setText("required field");
						lbl3.setText("required field");
					}
					
					else if(rs.next())
					{
						if(text1.equals("")||text2.equals(""))
						{
							JOptionPane.showMessageDialog(null, "input your field");	
						}
						else if(text1.equals(text2))
						{
						  PreparedStatement pmt=con.prepareStatement(sql1);
						pmt.setString(1, pass2.getText());
						pmt.executeUpdate();
						JOptionPane.showMessageDialog(null, "change successful");
						
						}
						else
						{
							JOptionPane.showMessageDialog(null, "Please cheak your confirm passcode");	
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid old Passcode");
					}
					con.close();
					
				}
				catch(Exception e1){
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 51, 102));
		button.setBounds(88, 269, 99, 21);
		panel.add(button);
		
		JLabel label_2 = new JLabel("Make admin for Election2020");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		label_2.setBounds(59, 11, 226, 21);
		panel.add(label_2);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(10, 43, 312, 7);
		panel.add(separator);
		
		lbl3 = new JLabel("");
		lbl3.setForeground(Color.RED);
		lbl3.setBounds(87, 235, 132, 14);
		panel.add(lbl3);
		
		pass3 = new JPasswordField();
		pass3.setBounds(87, 215, 171, 20);
		panel.add(pass3);
		
		JLabel label_5 = new JLabel("Back");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setBounds(0, 0, 46, 14);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Exit");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setBounds(286, 0, 46, 14);
		panel.add(label_6);
		
		JLabel lblOldpassword = new JLabel("OLD Password");
		lblOldpassword.setForeground(Color.WHITE);
		lblOldpassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOldpassword.setBounds(87, 71, 99, 21);
		panel.add(lblOldpassword);
		
		pass1 = new JPasswordField();
		pass1.setBounds(87, 90, 171, 20);
		panel.add(pass1);
		
		pass2 = new JPasswordField();
		pass2.setBounds(87, 148, 171, 20);
		panel.add(pass2);
		
		lbl1 = new JLabel("");
		lbl1.setForeground(Color.RED);
		lbl1.setBounds(87, 111, 114, 14);
		panel.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setForeground(Color.RED);
		lbl2.setBounds(87, 171, 114, 14);
		panel.add(lbl2);
	}
}
