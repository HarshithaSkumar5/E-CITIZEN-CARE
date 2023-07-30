import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Color;

public class viecomplaint {

	private JFrame frmComplaints;
	private JTable table;
	private JLabel lblNewLabel;
	private JTextArea textArea;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viecomplaint window = new viecomplaint();
					window.frmComplaints.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public viecomplaint() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmComplaints = new JFrame();
		frmComplaints.setTitle("COMPLAINTS");
		frmComplaints.getContentPane().setBackground(Color.BLACK);
		frmComplaints.setBounds(100, 100, 935, 569);
		frmComplaints.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmComplaints.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 42, 853, 233);
		frmComplaints.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/complaint","root","");
					int row=table.getSelectedRow();
					String tblclick=(table.getModel().getValueAt(row, 0).toString());
					String query="select * from usercomplaint where compNo ="+tblclick+"";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					if(rs.next())
					{
						String aadhar = String.valueOf(rs.getString("aadhar"));
						textField.setText(aadhar);
						String complaint =String.valueOf(rs.getString("complaint"));
						textArea.setText(complaint);
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
				
			}
		});
		
		lblNewLabel = new JLabel("COMPLAINT");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel.setBounds(35, 342, 102, 14);
		frmComplaints.getContentPane().add(lblNewLabel);
		
		textArea = new JTextArea();
		textArea.setBounds(64, 367, 633, 103);
		frmComplaints.getContentPane().add(textArea);
		
		btnNewButton_1 = new JButton("DELETE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/complaint","root","");
					int row = table.getSelectedRow();
					String cell =(table.getModel().getValueAt(row, 0).toString());
					String query ="DELETE FROM usercomplaint where compNo="+cell;
					PreparedStatement pst=con.prepareStatement(query);
					pst.executeUpdate();
					DefaultTableModel model=(DefaultTableModel)table.getModel();
					model.setRowCount(0);
					JOptionPane.showMessageDialog(null, "DELETED SUCCESFULLY!!!");
					
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_1.setBounds(702, 299, 124, 23);
		frmComplaints.getContentPane().add(btnNewButton_1);
		
		lblNewLabel_1 = new JLabel("AADHAR NO.");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_1.setBounds(35, 303, 133, 14);
		frmComplaints.getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(203, 302, 209, 20);
		frmComplaints.getContentPane().add(textField);
		textField.setColumns(10);
		
		btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminpage a1=new adminpage();
				adminpage.main(null);
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewButton_2.setBounds(361, 475, 89, 23);
		frmComplaints.getContentPane().add(btnNewButton_2);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/complaint","root","");
	
			String query="Select * from usercomplaint ";
			
			


			PreparedStatement pst=con.prepareStatement(query);
	        ResultSet rs = pst.executeQuery(query);
	        table.setModel(DbUtils.resultSetToTableModel(rs));
	        
	        lblNewLabel_2 = new JLabel("COMPLAINTS");
	        lblNewLabel_2.setForeground(Color.WHITE);
	        lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 15));
	        lblNewLabel_2.setBounds(25, 17, 133, 14);
	        frmComplaints.getContentPane().add(lblNewLabel_2);
			  
		  
		   
			
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}
}
