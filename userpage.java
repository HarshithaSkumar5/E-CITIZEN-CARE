import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class userpage {

	private JFrame frmUser;

	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					userpage window = new userpage();
					window.frmUser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public userpage() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUser = new JFrame();
		frmUser.setTitle("USER");
		frmUser.getContentPane().setBackground(Color.BLACK);
		frmUser.setBounds(100, 100, 804, 520);
		frmUser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUser.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 125, 485);
		frmUser.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("WELCOME " );
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lblNewLabel.setBounds(367, 16, 183, 35);
		frmUser.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("ADD COMPLAINT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addcomplaint a1=new addcomplaint();
				addcomplaint.main(null);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton.setBounds(360, 135, 167, 35);
		frmUser.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("VIEW SOLUTION");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viesolution v1=new viesolution();
				viesolution.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(360, 198, 167, 35);
		frmUser.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("FEEDBACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				feedback f1=new feedback();
				feedback.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(360, 261, 167, 35);
		frmUser.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("LOGOUT");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				userlogin u1=new userlogin();
				userlogin.main(null);
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_3.setBounds(360, 325, 167, 35);
		frmUser.getContentPane().add(btnNewButton_3);
		
		
		
	}
}
