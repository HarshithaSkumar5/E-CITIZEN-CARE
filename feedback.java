import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;

public class feedback {

	private JFrame frmFeedback;
	String username;
	private JTextField textField;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					feedback window = new feedback();
					window.frmFeedback.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public feedback() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFeedback = new JFrame();
		frmFeedback.setTitle("FEEDBACK");
		frmFeedback.getContentPane().setBackground(Color.BLACK);
		frmFeedback.setBounds(100, 100, 804, 528);
		frmFeedback.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFeedback.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("FEEDBACK  FORM");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(288, 11, 208, 37);
		frmFeedback.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("WAS THE SOLUTION HELPFUL ?");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(52, 120, 288, 14);
		frmFeedback.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("WERE YOUR EXPECTATIONS MET ?");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(52, 228, 269, 14);
		frmFeedback.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("OTHER SUGGESTIONS:");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(52, 348, 182, 14);
		frmFeedback.getContentPane().add(lblNewLabel_4);
		
		JTextArea suggArea = new JTextArea();
		suggArea.setBounds(52, 384, 462, 87);
		frmFeedback.getContentPane().add(suggArea);
	
		JTextArea q1 = new JTextArea();
		q1.setBounds(62, 158, 508, 43);
		frmFeedback.getContentPane().add(q1);
		
		JTextArea q2 = new JTextArea();
		q2.setBounds(62, 265, 508, 43);
		frmFeedback.getContentPane().add(q2);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into `feed` (`username`,`Q1`,`Q2`,`suggestions`) values(?,?,?,?)";
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/feedback","root","");
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, q1.getText());
					pst.setString(3,q2.getText());
					pst.setString(4, suggArea.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "THANK YOU!!!!");
					textField.setText("");
					q1.setText("");
					q2.setText("");
					suggArea.setText("");
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(632, 322, 109, 23);
		frmFeedback.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {


				
				userpage u1=new userpage();
				userpage.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(637, 401, 104, 23);
		frmFeedback.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_5 = new JLabel("USER NAME");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(52, 71, 120, 14);
		frmFeedback.getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(244, 69, 252, 20);
		frmFeedback.getContentPane().add(textField);
		textField.setColumns(10);
		
		
	}
}
