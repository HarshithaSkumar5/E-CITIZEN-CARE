import java.awt.EventQueue;

import javax.swing.JFrame;
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
import java.awt.Color;

public class addsolution {

	private JFrame frmAddSolution;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addsolution window = new addsolution();
					window.frmAddSolution.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public addsolution() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddSolution = new JFrame();
		frmAddSolution.setTitle("ADD SOLUTION");
		frmAddSolution.getContentPane().setBackground(Color.BLACK);
		frmAddSolution.setBounds(100, 100, 678, 482);
		frmAddSolution.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddSolution.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AADHAR NUMBER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(42, 57, 166, 23);
		frmAddSolution.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(245, 59, 195, 20);
		frmAddSolution.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("SOLUTION");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(42, 115, 136, 23);
		frmAddSolution.getContentPane().add(lblNewLabel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(75, 149, 469, 206);
		frmAddSolution.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query="insert into `addsol` (`aadhar`,`solution`) values(?,?)";
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/solution","root","");
					PreparedStatement pst = con.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textArea.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
					textField.setText("");
					textArea.setText("");
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(338, 388, 102, 23);
		frmAddSolution.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminpage o1=new adminpage();
				adminpage.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(171, 388, 102, 23);
		frmAddSolution.getContentPane().add(btnNewButton_1);
	}
}
