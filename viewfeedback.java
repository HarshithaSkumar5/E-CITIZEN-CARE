import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JTable;

import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class viewfeedback {

	private JFrame frmFeedback;
	private JTable table;
	private JLabel lblNewLabel;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewfeedback window = new viewfeedback();
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
	public viewfeedback() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFeedback = new JFrame();
		frmFeedback.setTitle("FEEDBACK");
		frmFeedback.getContentPane().setBackground(Color.BLACK);
		frmFeedback.setBounds(100, 100, 788, 528);
		frmFeedback.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFeedback.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 50, 720, 373);
		frmFeedback.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/feedback","root","");
	
			String query="Select * from feed ";
			
			


			PreparedStatement pst=con.prepareStatement(query);
	        ResultSet rs = pst.executeQuery(query);
	        table.setModel(DbUtils.resultSetToTableModel(rs));
	        
	        lblNewLabel = new JLabel("FEEDBACK");
	        lblNewLabel.setForeground(Color.WHITE);
	        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
	        lblNewLabel.setBounds(340, 25, 194, 14);
	        frmFeedback.getContentPane().add(lblNewLabel);
	        
	        btnNewButton = new JButton("BACK");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		adminpage a1=new adminpage();
	        		adminpage.main(null);
	        	}
	        });
	        btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        btnNewButton.setBounds(348, 447, 89, 23);
	        frmFeedback.getContentPane().add(btnNewButton);
			  
		  
		   
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
		
	}

}
