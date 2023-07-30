import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class adminlogin {

	private JFrame frmAdminLogin;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminlogin window = new adminlogin();
					window.frmAdminLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminlogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminLogin = new JFrame();
		frmAdminLogin.setTitle("ADMIN LOGIN");
		frmAdminLogin.getContentPane().setBackground(Color.BLACK);
		frmAdminLogin.setBounds(100, 100, 804, 536);
		frmAdminLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdminLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 137, 501);
		frmAdminLogin.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("ADMIN NAME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(216, 156, 137, 24);
		frmAdminLogin.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(216, 221, 137, 24);
		frmAdminLogin.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(419, 160, 231, 20);
		frmAdminLogin.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(419, 225, 231, 20);
		frmAdminLogin.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("WELCOME");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_2.setBounds(347, 37, 150, 30);
		frmAdminLogin.getContentPane().add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {Class.forName("com.mysql.jdbc.Driver");
				Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/db2","root","");
				String s="select * from alogin where adminname=? and password=?";
				PreparedStatement ps=con.prepareStatement(s);
				ps.setString(1,textField.getText() );
				ps.setString(2,passwordField.getText() );
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()==true)
				{
					JOptionPane.showMessageDialog(null, "WELCOME ADMIN!!!!!!");
					


					adminpage u1=new adminpage();
					adminpage.main(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "INCORRECT NAME AND PASSWORD");
					textField.setText(null);
					passwordField.setText(null);
				}
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(464, 322, 89, 23);
		frmAdminLogin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frontpage f1=new frontpage();
				frontpage.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(303, 322, 89, 23);
		frmAdminLogin.getContentPane().add(btnNewButton_1);
	}

}
