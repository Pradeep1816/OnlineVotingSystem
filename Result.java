package Election2020;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
public class Result extends JFrame {

	

	
	private Board count;
	private JPanel contentPane;
	private JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6;
	private JLabel lvl;
	private JTable table;
	int  sum1;int sum2;int sum3;int sum4;int sum5;int sum6;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
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
	public Result() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 676, 482);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Click Here to Count");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 51, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(59, 382, 173, 35);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");
			
				  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				Statement stmt=con.createStatement();
				String sql1="SELECT SUM(BJP) from votecount";
				String sql2="SELECT SUM(BSP) from votecount";
				String sql3="SELECT SUM(CPI) from votecount";
				String sql4="SELECT SUM(INC) from votecount";
				String sql5="SELECT SUM(NCP) from votecount";
				String sql6="SELECT SUM(NPP) from votecount";
				ResultSet rs= stmt.executeQuery(sql1);
				if(rs.next())
				{
				String sum=rs.getString("sum(BJP)");
				
				lbl1.setText(""+sum);
			     
				}
				ResultSet rs1= stmt.executeQuery(sql2);
				if(rs1.next())
				{
				String sum1=rs1.getString("sum(BSP)");
				
				lbl2.setText(""+sum1);
			     
				}
				ResultSet rs2= stmt.executeQuery(sql3);
				if(rs2.next())
				{
				String sum2=rs2.getString("sum(CPI)");
				
				lbl3.setText(""+sum2);
			     
				}
				ResultSet rs3= stmt.executeQuery(sql4);
				if(rs3.next())
				{
				String sum3=rs3.getString("sum(INC)");
				
				lbl4.setText(""+sum3);
			     
				}
				ResultSet rs4= stmt.executeQuery(sql5);
				if(rs4.next())
				{
				String sum4=rs4.getString("sum(NCP)");
				
				lbl5.setText(""+sum4);
			     
				}
				ResultSet rs5= stmt.executeQuery(sql6);
				if(rs5.next())
				{
				String sum5=rs5.getString("sum(NPP)");
				
				lbl6.setText(""+sum5);
			     
				}
				
				con.close();
				
				}
			
			
				catch(Exception e1)
				{
				JOptionPane.showMessageDialog(null, e1);	
				}
			}
				
			
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 36, 660, 123);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Bhuja samaj Party", "BSP", "1984", "Mamta Banerjee", "Mamta Banerjee", "KolKata"},
				{"Bharatiya Janta Party", "BJP", "1980", "Syama Prasad Mookkerjee", "Jagat Prakash Nadda", "Mandi House, New Dlhi"},
				{"Commonist Party of india", "CPI", "1925", "Abani Mukheji", "D.Raja", "New Delhi"},
				{"Indian National Congress", "INC", "1885", "Dadabhai Naoroji", "Sonia Gandhi", "New delhi"},
				{"Nationalist Congress Party", "NCP", "1999", "Sharad Pawar", "Sharad Pawar", "New Delhi"},
				{"National People's Party", "NPP", "2013", "P.A.Sangma", "Conrad", "Imphal"},
			},
			new String[] {
				"Name", "Abbreviation ", "Foundation year", "Founder's ", "Party Supremo", "Headquarters "
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(145);
		table.getColumnModel().getColumn(2).setPreferredWidth(98);
		table.getColumnModel().getColumn(3).setPreferredWidth(132);
		table.getColumnModel().getColumn(4).setPreferredWidth(107);
		table.getColumnModel().getColumn(5).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("6 Recognized National Parties");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 660, 35);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 158, 329, 201);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel(" Vote Counting");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 0, 329, 24);
		panel.add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBackground(Color.GRAY);
		separator.setBounds(0, 23, 329, 11);
		panel.add(separator);
		
		JLabel lblNewLabel_2 = new JLabel("BJP");
		lblNewLabel_2.setBackground(Color.LIGHT_GRAY);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 23, 94, 17);
		panel.add(lblNewLabel_2);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.GRAY);
		separator_1.setBounds(137, 23, 16, 178);
		panel.add(separator_1);
		
		JLabel lblBsp = new JLabel("BSP");
		lblBsp.setHorizontalAlignment(SwingConstants.CENTER);
		lblBsp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBsp.setBackground(Color.LIGHT_GRAY);
		lblBsp.setBounds(10, 51, 94, 24);
		panel.add(lblBsp);
		
		JLabel lblCpi = new JLabel("CPI");
		lblCpi.setHorizontalAlignment(SwingConstants.CENTER);
		lblCpi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCpi.setBackground(Color.LIGHT_GRAY);
		lblCpi.setBounds(10, 80, 94, 24);
		panel.add(lblCpi);
		
		JLabel lblInc = new JLabel("INC");
		lblInc.setHorizontalAlignment(SwingConstants.CENTER);
		lblInc.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInc.setBackground(Color.LIGHT_GRAY);
		lblInc.setBounds(10, 116, 94, 24);
		panel.add(lblInc);
		
		JLabel lblNcp = new JLabel("NCP");
		lblNcp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNcp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNcp.setBackground(Color.LIGHT_GRAY);
		lblNcp.setBounds(10, 142, 94, 24);
		panel.add(lblNcp);
		
		JLabel lblNpp = new JLabel("NPP");
		lblNpp.setHorizontalAlignment(SwingConstants.CENTER);
		lblNpp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNpp.setBackground(Color.LIGHT_GRAY);
		lblNpp.setBounds(10, 177, 94, 24);
		panel.add(lblNpp);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBackground(Color.GRAY);
		separator_2.setBounds(0, 45, 329, 11);
		panel.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBackground(Color.GRAY);
		separator_3.setBounds(0, 81, 329, 11);
		panel.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBackground(Color.GRAY);
		separator_4.setBounds(0, 116, 329, 11);
		panel.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBackground(Color.GRAY);
		separator_5.setBounds(0, 139, 329, 11);
		panel.add(separator_5);
		
		JSeparator separator_6 = new JSeparator();
		separator_6.setBackground(Color.GRAY);
		separator_6.setBounds(0, 174, 329, 11);
		panel.add(separator_6);
		
		 lbl1 = new JLabel("");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl1.setBackground(Color.LIGHT_GRAY);
		lbl1.setBounds(191, 23, 94, 17);
		panel.add(lbl1);
		
		lbl2 = new JLabel("");
		lbl2.setHorizontalAlignment(SwingConstants.CENTER);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl2.setBackground(Color.LIGHT_GRAY);
		lbl2.setBounds(191, 51, 94, 24);
		panel.add(lbl2);
		
		 lbl3 = new JLabel("");
		lbl3.setHorizontalAlignment(SwingConstants.CENTER);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl3.setBackground(Color.LIGHT_GRAY);
		lbl3.setBounds(191, 80, 94, 24);
		panel.add(lbl3);
		
		 lbl4 = new JLabel("");
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl4.setBackground(Color.LIGHT_GRAY);
		lbl4.setBounds(191, 116, 94, 24);
		panel.add(lbl4);
		
		 lbl5 = new JLabel("");
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl5.setBackground(Color.LIGHT_GRAY);
		lbl5.setBounds(191, 142, 94, 24);
		panel.add(lbl5);
		
		 lbl6 = new JLabel("");
		lbl6.setHorizontalAlignment(SwingConstants.CENTER);
		lbl6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl6.setBackground(Color.LIGHT_GRAY);
		lbl6.setBounds(191, 177, 94, 24);
		panel.add(lbl6);
		
		 lvl = new JLabel("");
		 lvl.setFont(new Font("Tahoma", Font.BOLD, 12));
		 lvl.setHorizontalAlignment(SwingConstants.CENTER);
		lvl.setBounds(331, 182, 329, 177);
		contentPane.add(lvl);
		
		JLabel lblWinnerOfThe = new JLabel("Winner of the Election 2020");
		lblWinnerOfThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblWinnerOfThe.setForeground(Color.RED);
		lblWinnerOfThe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWinnerOfThe.setBounds(331, 159, 329, 24);
		contentPane.add(lblWinnerOfThe);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(331, 158, 329, 201);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(53, 50, 107, 62);
		panel_1.add(lblNewLabel_3);
		
		JButton btnClickHereFor = new JButton("Click Here for Result");
		btnClickHereFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try
				{
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				  Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/election?serverTimezone=UTC","root","");
				
				Statement stmt=con.createStatement();
				String sql1="SELECT SUM(BJP) from votecount";
				String sql2="SELECT SUM(BSP) from votecount";
				String sql3="SELECT SUM(CPI) from votecount";
				String sql4="SELECT SUM(INC) from votecount";
				String sql5="SELECT SUM(NCP) from votecount";
				String sql6="SELECT SUM(NPP) from votecount";
				ResultSet rs= stmt.executeQuery(sql1);
				if(rs.next())
				{
				 sum1=Integer.parseInt(rs.getString("SUM(BJP)"));
				
				}
				
				ResultSet rs1= stmt.executeQuery(sql2);
				if(rs1.next())
				{
				 sum2=Integer.parseInt(rs1.getString("SUM(BSP)"));
				
				}
				
				
				ResultSet rs2= stmt.executeQuery(sql3);
				if(rs2.next())
				{
				 sum3=Integer.parseInt(rs2.getString("SUM(CPI)"));
				
				}
				ResultSet rs3= stmt.executeQuery(sql4);
				if(rs3.next())
				{
				 sum4=Integer.parseInt(rs3.getString("SUM(INC)"));
				
				}
				ResultSet rs4= stmt.executeQuery(sql5);
				if(rs4.next())
				{
				 sum5=Integer.parseInt(rs4.getString("SUM(NCP)"));
				
				}
				
				ResultSet rs5= stmt.executeQuery(sql6);
				if(rs5.next())
				{
				 sum6=Integer.parseInt(rs5.getString("SUM(NPP)"));
				
				}
				
				
				con.close();
				}
				
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
				if(sum1>sum2 &&sum1>sum3&&sum1>sum4&&sum1>sum5&&sum1>sum6 )
				{
				 lvl.setText("BJP won the Election 2020, Total Vote="+sum1);
					
				}
				else if(sum2>sum1 &&sum2>sum3&&sum2>sum4&&sum2>sum5&&sum2>sum6 )
				{
				lvl.setText("BSP won the Election 2020, Total Vote="+sum2);
					
				}
				else if(sum3>sum1 &&sum3>sum2&&sum3>sum4&&sum3>sum5&&sum3>sum6 )
				{
				lvl.setText("CPI won the Election 2020, Total Vote="+sum3);
					
				}
				else if(sum4>sum1 &&sum4>sum2&&sum4>sum3&&sum4>sum5&&sum5>sum6 )
				{
				lvl.setText("INC won the Election 2020, Total Vote="+sum4);
					
				}
				else if(sum5>sum1 &&sum5>sum2&&sum5>sum3&&sum5>sum4&&sum5>sum6 )
				{
				lvl.setText("NCP won the Election 2020, Total Vote="+sum5);
					
				}
				else if(sum6>sum1 &&sum6>sum2&&sum6>sum3&&sum6>sum4&&sum6>sum5 )
				{
				lvl.setText("NPP won the Election 2020, Total Vote="+sum6);
					
				}
				else
				{
					lvl.setText("<html> Some Parties have same Vote.Please choose your party</html>");
				}
				
			}
		}); 
		btnClickHereFor.setForeground(Color.WHITE);
		btnClickHereFor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnClickHereFor.setBackground(new Color(0, 51, 153));
		btnClickHereFor.setBounds(439, 382, 173, 35);
		contentPane.add(btnClickHereFor);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new User().setVisible(true);
			}
		});
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(0, 51, 153));
		btnNewButton_1.setBounds(0, 0, 68, 17);
		contentPane.add(btnNewButton_1);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setForeground(Color.WHITE);
		btnExit.setBackground(new Color(0, 51, 153));
		btnExit.setBounds(592, 0, 68, 17);
		contentPane.add(btnExit);
		
	}
}
