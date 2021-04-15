package bank_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class Credit extends JFrame {

	private JPanel contentPane;
	private JTextField lc9;
	private JLabel lc1,lc2,lc3,lc6,lc8,lblAddress;
	private JComboBox lc7;
	private JButton lc10;
	private JComboBox comboBox;
private JTextArea textArea ;
private JLabel lblPin;
private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Credit frame = new Credit();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Credit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lc1 = new JLabel("Apply Now");
		lc1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lc1.setBounds(524, 26, 129, 23);
		contentPane.add(lc1);
		
		lc2 = new JLabel("Category");
		lc2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lc2.setBounds(295, 165, 85, 23);
		contentPane.add(lc2);
		
		lc3 = new JLabel("Credit Cards");
		lc3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lc3.setBounds(625, 165, 115, 23);
		contentPane.add(lc3);
		
		lc6 = new JLabel("Select Account");
		lc6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lc6.setBounds(289, 305, 134, 23);
		contentPane.add(lc6);
		
		lc7 = new JComboBox();
		lc7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lc7.setModel(new DefaultComboBoxModel(new String[] {"Select", "Savings", "Current"}));
		lc7.setBounds(625, 300, 132, 32);
		contentPane.add(lc7);
		
		lc8 = new JLabel("Description");
		lc8.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lc8.setBounds(289, 506, 115, 32);
		contentPane.add(lc8);
		
		lc9 = new JTextField();
		lc9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lc9.setBounds(625, 491, 240, 62);
		contentPane.add(lc9);
		lc9.setColumns(10);
		
		lc10 = new JButton("PROCEED");
		lc10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Random ran = new Random();
			        long first7 = (ran.nextLong() % 90000000L) + 6060936000000000L;
			        long first8 = Math.abs(first7);
			        String a=passwordField.getText();
			        String b=(String)comboBox.getSelectedItem();
			        String c=(String)lc7.getSelectedItem();
			        String d=textArea.getText();
			        String f=lc9.getText();
			        connection c1=new connection();
			        String sql="Select * from login where pin='"+a+"'";
			        ResultSet rs=c1.s.executeQuery(sql);
			        if(rs.next()) {
						 String a2=rs.getString("cardno");
						 String sql0="Select * from apply_now where pin='"+a+"'";
						 ResultSet r=c1.s.executeQuery(sql0);
						 if(r.next()) {
							 String output1=r.getString("credit");
							 if(output1==null) {
								 String a1="Active";
								 String sql5="update apply_now set credit='"+first8+"',credit_category='"+b+"',credit_address='"+d+"' , credit_status='"+a1+"' where pin='"+a+"'";
								 c1.s.executeUpdate(sql5);
								 JOptionPane.showMessageDialog(null, "Successfully applied for Credit card and the Credit card will be delivered to your specified address");
								 JOptionPane.showMessageDialog(null, "Your Credit card no is "+first8);
							 }
							 else {
								 JOptionPane.showMessageDialog(null, "You Already have an exisiting Credit Card");
								 
							 }
						 }
						 else {
							 
							 String sql3="insert into apply_now (pin,cardno) select pin,cardno from login where pin='"+a+"'";
							 c1.s.executeUpdate(sql3);
							 String x="select * from apply_now where pin='"+a+"'";
							 ResultSet rs1=c1.s.executeQuery(x);
							
								 if(rs1.next()) {
									 String output=rs1.getString("credit");
									 if(output==null) {
							 
										 String a1="Active";
									
							 String sql1="update apply_now set credit='"+first8+"', credit_address='"+d+"' , credit_category='"+b+"' , credit_status='"+a1+"' where pin='"+a+"'";
							 c1.s.executeUpdate(sql1);
							 JOptionPane.showMessageDialog(null, "Successfully applied for Credit card and the Credit card will be delivered to your specified address");
							 JOptionPane.showMessageDialog(null, "Your Credit card no is "+first8);
									}
									 
								 }
						 }
			        }
					
			        else {
			        	JOptionPane.showMessageDialog(null, "Enter the correct pin");
			        }
					}
				
			        
				
				catch(Exception e1) {
					
				}
			}
		});
		lc10.setForeground(Color.BLACK);
		lc10.setBackground(UIManager.getColor("Button.background"));
		lc10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lc10.setBounds(705, 593, 160, 42);
		contentPane.add(lc10);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textArea.setBounds(625, 381, 240, 70);
		contentPane.add(textArea);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblAddress.setBounds(289, 399, 115, 32);
		contentPane.add(lblAddress);
		
		JLabel lblCategory = new JLabel("Sub Child Category");
		lblCategory.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblCategory.setBounds(289, 230, 189, 32);
		contentPane.add(lblCategory);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Master", "Rupay", "VISA"}));
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		comboBox.setBounds(625, 230, 134, 32);
		contentPane.add(comboBox);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Apply().setVisible(true);
					setVisible(false);
				}
				catch(Exception e2) {
					e2.printStackTrace();
                    System.out.println("error: "+e2);
				}
			}
		});
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(275, 593, 160, 42);
		contentPane.add(btnBack);
		
		lblPin = new JLabel("Pin");
		lblPin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblPin.setBounds(295, 94, 85, 23);
		contentPane.add(lblPin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(625, 94, 199, 23);
		contentPane.add(passwordField);
	}
}