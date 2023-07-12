package Election2020;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField tf1;
	private JLabel lbl1;
	private JLabel lbl2;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 404);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setBounds(87, 92, 132, 21);
		contentPane.add(lblNewLabel);
		
		tf1 = new JTextField();
		tf1.setBounds(87, 117, 171, 20);
		contentPane.add(tf1);
		tf1.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(87, 183, 132, 21);
		contentPane.add(lblPassword);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text1=tf1.getText();
				String  text2=pass.getText();
				try
				{
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
					String sql="insert into login values(?,?)";
					PreparedStatement pmt=con.prepareStatement(sql);
					if(text1.equals("")||text2.equals(""))
					{
						lbl1.setText("Required field");
						lbl2.setText("Required field");
					}
					else
					{
					pmt.setString(1, tf1.getText());
					pmt.setString(2, pass.getText());
					pmt.executeUpdate();
					JOptionPane.showMessageDialog(null,"Now you admin for election");
					con.close();
					new Login().setVisible(true);
					dispose();
					}
					con.close();
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null,e1);
				}
			}
		});
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(0, 51, 102));
		btnSubmit.setBounds(105, 274, 132, 21);
		contentPane.add(btnSubmit);
		
		JLabel lblMakeAdminFor = new JLabel("Make admin for Election2020");
		lblMakeAdminFor.setForeground(Color.RED);
		lblMakeAdminFor.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblMakeAdminFor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMakeAdminFor.setBounds(59, 11, 226, 21);
		contentPane.add(lblMakeAdminFor);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.DARK_GRAY);
		separator.setBounds(10, 43, 312, 7);
		contentPane.add(separator);
		
		lbl1 = new JLabel("");
		lbl1.setForeground(Color.RED);
		lbl1.setBounds(87, 136, 132, 14);
		contentPane.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setForeground(Color.RED);
		lbl2.setBounds(87, 228, 132, 14);
		contentPane.add(lbl2);
		
		pass = new JPasswordField();
		pass.setBounds(87, 201, 171, 20);
		contentPane.add(pass);
		
		JLabel lblNewLabel_1 = new JLabel("Back");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new Login().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblExit = new JLabel("Exit");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setBounds(286, 0, 46, 14);
		contentPane.add(lblExit);
	}
}
