import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class viesolution {

	private JFrame frmSolution;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viesolution window = new viesolution();
					window.frmSolution.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viesolution() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSolution = new JFrame();
		frmSolution.setTitle("SOLUTION");
		frmSolution.getContentPane().setBackground(Color.BLACK);
		frmSolution.setBounds(100, 100, 706, 502);
		frmSolution.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSolution.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AADHAR NUMBER");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(65, 47, 171, 14);
		frmSolution.getContentPane().add(lblNewLabel);
		
		JTextArea solutionArea = new JTextArea();
		solutionArea.setBounds(76, 166, 489, 172);
		frmSolution.getContentPane().add(solutionArea);
		
		JButton btnNewButton = new JButton("DISPLAY");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/solution","root","");
					Statement st = con.createStatement();
					String query="Select `solution` from `addsol` WHERE `aadhar` ='"+textField.getText()+"' ";
					
					
					ResultSet rs = st.executeQuery(query);
					if(rs.next())
					{
						solutionArea.setText(rs.getString("solution"));
						
					}
					
					else {
						solutionArea.setText("");
					}
					
				} catch (Exception e1) {
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton.setBounds(267, 98, 114, 23);
		frmSolution.getContentPane().add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(294, 45, 210, 20);
		frmSolution.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userpage u1=new userpage();
				userpage.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(267, 375, 114, 23);
		frmSolution.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("SOLUTION");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(65, 141, 102, 14);
		frmSolution.getContentPane().add(lblNewLabel_1);
		
		
	}
}
