import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JInternalFrame;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class frontpage {

	private JFrame frmGrievanceSystem;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frontpage window = new frontpage();
					window.frmGrievanceSystem.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public frontpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGrievanceSystem = new JFrame();
		frmGrievanceSystem.setTitle("GRIEVANCE SYSTEM");
		frmGrievanceSystem.getContentPane().setBackground(Color.BLACK);
		frmGrievanceSystem.setBounds(100, 100, 789, 481);
		frmGrievanceSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGrievanceSystem.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 136, 497);
		frmGrievanceSystem.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("ADMIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin a=new adminlogin();
				adminlogin.main(null);
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton.setBounds(343, 161, 154, 23);
		frmGrievanceSystem.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("USER\r\n");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userlogin u =new userlogin();
				userlogin.main(null);
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		btnNewButton_1.setBounds(343, 247, 154, 23);
		frmGrievanceSystem.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("GRIEVANCE  HANDLING");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(281, 11, 324, 52);
		frmGrievanceSystem.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("SYSTEM");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel_1.setBounds(367, 60, 130, 30);
		frmGrievanceSystem.getContentPane().add(lblNewLabel_1);
	}
}
