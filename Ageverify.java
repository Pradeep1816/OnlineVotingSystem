package Election2020;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Ageverify extends JFrame {

	private JPanel contentPane;
	private JTextField tf;
	private JLabel lbl;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ageverify frame = new Ageverify();
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
	public Ageverify() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 354, 398);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 338, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Back");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new User().setVisible(true);
				dispose();
			}
		});
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 46, 14);
		panel.add(lblNewLabel);
		
		JLabel lblAgeVerification = new JLabel("Age Verification");
		lblAgeVerification.setBounds(134, 5, 120, 19);
		panel.add(lblAgeVerification);
		lblAgeVerification.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAgeVerification.setForeground(Color.WHITE);
		lblAgeVerification.setBackground(Color.RED);
		lblAgeVerification.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblExit = new JLabel("Exit");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblExit.setHorizontalAlignment(SwingConstants.CENTER);
		lblExit.setForeground(Color.WHITE);
		lblExit.setBounds(292, 0, 46, 14);
		panel.add(lblExit);
		
		JLabel lblPleaseEnterYour = new JLabel("Please Enter your Age");
		lblPleaseEnterYour.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPleaseEnterYour.setBounds(70, 103, 223, 23);
		contentPane.add(lblPleaseEnterYour);
		
		tf = new JTextField();
		tf.setBounds(70, 127, 189, 30);
		contentPane.add(tf);
		tf.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int min=18,max=60;
				String text=tf.getText();
				if(text.equals(""))
				{
					lbl.setText("required field");
				}
				else
				{
					int acc=Integer.parseInt(tf.getText());
				if(acc>=min && acc<max)
				{
					lbl.setText("");
				JOptionPane.showMessageDialog(null, "you are eligible for vote");	
				new Registration().setVisible(true);
				dispose();
				}
				else
				{
					lbl.setText("");
				 JOptionPane.showMessageDialog(null, "you are not eligible for vote");	
				}
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 51, 102));
		btnNewButton.setBounds(107, 208, 128, 23);
		contentPane.add(btnNewButton);
		
		lbl = new JLabel("");
		lbl.setForeground(Color.RED);
		lbl.setBounds(70, 157, 113, 14);
		contentPane.add(lbl);
	}
}
