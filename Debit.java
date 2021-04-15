package bank_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class Debit extends JFrame {

	private JPanel contentPane;
	private JButton l11;
	private JLabel l1;
	private JTextField tf;
	private JLabel l2;
	private JLabel l3,l4,l5,l6,l8,l10,lblAddress;
	private JComboBox l7,l9;
	private JButton btnBack;
	private JTextArea textArea;
	private JLabel lblEnterPin;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Debit frame = new Debit();
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
	
	public Debit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("Button.background"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	    l1 = new JLabel("Category");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l1.setBounds(280, 164, 95, 29);
		contentPane.add(l1);
		
	    l2 = new JLabel("Apply Now");
		l2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		l2.setBounds(458, 24, 217, 38);
		contentPane.add(l2);
		
		l3 = new JLabel("Debit Card");
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l3.setBounds(651, 167, 160, 23);
		contentPane.add(l3);
		
	    l4 = new JLabel("Sub Category");
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4.setBounds(280, 228, 115, 23);
		contentPane.add(l4);
		
		l5 = new JLabel("Issue New Debit Card");
		l5.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l5.setBounds(653, 231, 186, 16);
		contentPane.add(l5);
		
		l6 = new JLabel("Sub Child Category");
		l6.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l6.setBounds(280, 289, 167, 29);
		contentPane.add(l6);
		
		l7 = new JComboBox();
		l7.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l7.setModel(new DefaultComboBoxModel(new String[] {"Master", "Rupay", "VISA"}));
		l7.setBounds(651, 293, 172, 21);
		contentPane.add(l7);
		
		l8 = new JLabel("Select Account");
		l8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l8.setBounds(280, 358, 134, 23);
		contentPane.add(l8);
		
		l9 = new JComboBox();
		l9.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l9.setModel(new DefaultComboBoxModel(new String[] {"Select", "Savings", "Current"}));
		l9.setBounds(651, 359, 172, 21);
		contentPane.add(l9);
		
		l10 = new JLabel("Description");
		l10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l10.setBounds(280, 530, 122, 23);
		contentPane.add(l10);
		
		tf = new JTextField();
		tf.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tf.setBounds(651, 520, 264, 52);
		contentPane.add(tf);
		tf.setColumns(10);
		
		l11 = new JButton("PROCEED");
		l11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
				Random ran = new Random();
		        long first7 = (ran.nextLong() % 90000000L) + 2020936000000000L;
		        long first8 = Math.abs(first7);
		        String a=(String)l7.getSelectedItem();
		        String b=(String)l9.getSelectedItem();
		        String c=textArea.getText();
		        String d=tf.getText();
		        String e=passwordField.getText();
		        connection c1=new connection();
		        String sql="Select * from login where pin='"+e+"'";
		        ResultSet rs=c1.s.executeQuery(sql);
		        if(rs.next()) {
					 String a2=rs.getString("cardno");
					 String sql0="Select * from apply_now where pin='"+e+"'";
					 ResultSet r=c1.s.executeQuery(sql0);
					 if(r.next()) {
						 String output1=r.getString("debit");
						 if(output1==null) {
							 String a1="Active";
							 String sql5="update apply_now set debit='"+first8+"',debit_category='"+a+"',debit_address='"+c+"' , debit_status='"+a1+"' where pin='"+e+"'";
							 c1.s.executeUpdate(sql5);
							 JOptionPane.showMessageDialog(null, "Successfully applied for debit card and the debit card will be delivered to your specified address");
							 JOptionPane.showMessageDialog(null, "Your debit card no is "+first8);
						 }
						 else {
							 JOptionPane.showMessageDialog(null, "You Already have an exisiting debit Card");
							 
						 }
					 }
					 else {
						 
						 String sql3="insert into apply_now (pin,cardno) select pin,cardno from login where pin='"+e+"'";
						 c1.s.executeUpdate(sql3);
						 String x="select * from apply_now where pin='"+e+"'";
						 ResultSet rs1=c1.s.executeQuery(x);
						
							 if(rs1.next()) {
								 String output=rs1.getString("debit");
								 if(output==null) {
						 
									 String a1="Active";
								
						 String sql1="update apply_now set debit='"+first8+"', debit_address='"+c+"' , debit_category='"+a+"' , debit_status='"+a1+"' where pin='"+e+"'";
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
					System.out.println(e1);
				}
			}
		});
		l11.setBackground(UIManager.getColor("Button.background"));
		l11.setForeground(Color.BLACK);
		l11.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l11.setBounds(697, 613, 160, 38);
		contentPane.add(l11);
		
		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblAddress.setBounds(280, 439, 134, 23);
		contentPane.add(lblAddress);
		
		textArea = new JTextArea();
		textArea.setBounds(651, 411, 264, 71);
		contentPane.add(textArea);
		
		btnBack = new JButton("Back");
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
		btnBack.setBounds(263, 613, 160, 38);
		contentPane.add(btnBack);
		
		lblEnterPin = new JLabel("Enter Pin");
		lblEnterPin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblEnterPin.setBounds(280, 101, 95, 29);
		contentPane.add(lblEnterPin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(651, 101, 108, 26);
		contentPane.add(passwordField);
	}
}