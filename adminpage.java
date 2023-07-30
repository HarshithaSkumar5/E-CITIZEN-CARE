import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminpage {

	private JFrame frmAdmin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminpage window = new adminpage();
					window.frmAdmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public adminpage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdmin = new JFrame();
		frmAdmin.setTitle("ADMIN");
		frmAdmin.getContentPane().setBackground(Color.BLACK);
		frmAdmin.setBounds(100, 100, 804, 537);
		frmAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAdmin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 129, 502);
		frmAdmin.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("WELCOME");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(383, 32, 136, 30);
		frmAdmin.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("VIEW COMPLAINTS\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viecomplaint a1=new viecomplaint();
				viecomplaint.main(null);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(347, 142, 203, 30);
		frmAdmin.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VIEW FEEDBACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewfeedback o1=new viewfeedback();
				viewfeedback.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(347, 267, 203, 30);
		frmAdmin.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("LOGOUT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminlogin a1=new adminlogin();
				adminlogin.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(347, 333, 203, 30);
		frmAdmin.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("ADD SOLUTION");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addsolution a1=new addsolution();
				addsolution.main(null);
				
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(347, 202, 203, 30);
		frmAdmin.getContentPane().add(btnNewButton_3);
	}
}
