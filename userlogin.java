import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.sql.*;

public class userlogin {

	private JFrame frmUserLogin;
	private JPasswordField passwordField;
	private JTextField textField;

	String username;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userlogin window = new userlogin();
					window.frmUserLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public userlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUserLogin = new JFrame();
		frmUserLogin.setTitle("USER LOGIN");
		frmUserLogin.getContentPane().setBackground(Color.BLACK);
		frmUserLogin.setBounds(100, 100, 804, 536);
		frmUserLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 135, 502);
		frmUserLogin.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("USER NAME");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(195, 151, 135, 31);
		frmUserLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(195, 218, 126, 31);
		frmUserLogin.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(366, 225, 193, 20);
		frmUserLogin.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setBounds(366, 158, 193, 20);
		frmUserLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(304, 22, 156, 48);
		frmUserLogin.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NOTE:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setBounds(184, 354, 48, 20);
		frmUserLogin.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("'USER NAME' should be same as AADHAR card name.");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setBounds(184, 372, 375, 14);
		frmUserLogin.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("'PASSWORD' is your AADHAR card number. ");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel_5.setBounds(184, 392, 294, 14);
		frmUserLogin.getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db1","root","");
					String s="select * from ulogin where username=? and password=?";
					PreparedStatement ps=con.prepareStatement(s);
					ps.setString(1,textField.getText() );
					ps.setString(2,passwordField.getText() );
					ResultSet rs=ps.executeQuery();
					
					if(rs.next()==true)
					{
						JOptionPane.showMessageDialog(null, "WELCOME !!!!!");
						
					
					userpage u1=new userpage();
					userpage.main(null);
					}
					else {
						JOptionPane.showMessageDialog(null, "INCORRECT USERNAME AND PASSWORD");
						textField.setText(null);
						passwordField.setText(null);
					}
				} catch (Exception e2) {
					
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(389, 293, 89, 23);
		frmUserLogin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage f1=new frontpage();
				frontpage.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(241, 293, 89, 23);
		frmUserLogin.getContentPane().add(btnNewButton_1);
	}
}
