import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class addcomplaint {

	private JFrame frmAddComplaints;
	private JTextField textField;
	private JTextField textField_1;
	
	String username;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addcomplaint window = new addcomplaint();
					window.frmAddComplaints.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addcomplaint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddComplaints = new JFrame();
		frmAddComplaints.setTitle("ADD COMPLAINTS");
		frmAddComplaints.getContentPane().setBackground(Color.BLACK);
		frmAddComplaints.setBounds(100, 100, 806, 535);
		frmAddComplaints.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddComplaints.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DEPARTMENT NAME");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(59, 122, 171, 33);
		frmAddComplaints.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(317, 129, 316, 20);
		frmAddComplaints.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SUBJECT");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(59, 174, 147, 20);
		frmAddComplaints.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(317, 175, 316, 20);
		frmAddComplaints.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("COMPLAINT");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(59, 216, 147, 33);
		frmAddComplaints.getContentPane().add(lblNewLabel_2);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(94, 260, 539, 150);
		frmAddComplaints.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into `usercomplaint` (`aadhar`,`departname`,`sub`,`complaint`) values(?,?,?,?)";
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/complaint","root","");
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1,textField_2.getText());
					pst.setString(2, textField.getText());
					pst.setString(3, textField_1.getText());
					pst.setString(4,textArea.getText() );
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "COMPLAINT SUBMITTED!!!!");
					textField_2.setText("");
					textField.setText("");
					textField_1.setText("");
					textArea.setText("");
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(408, 434, 113, 23);
		frmAddComplaints.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userpage u1=new userpage();
				userpage.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(219, 434, 113, 23);
		frmAddComplaints.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("COMPLAINTS FORM");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_3.setBounds(282, 11, 233, 27);
		frmAddComplaints.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("AADHAR NUMBER");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setBounds(59, 88, 147, 14);
		frmAddComplaints.getContentPane().add(lblNewLabel_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(317, 86, 322, 20);
		frmAddComplaints.getContentPane().add(textField_2);
		textField_2.setColumns(10);
	}
}
