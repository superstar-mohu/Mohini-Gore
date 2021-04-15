package bank_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Sign_up3 extends JFrame {

	private JPanel contentPane;
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l7,l8,l9,l10;
	JRadioButton r1,r2,r3,r4;
	JCheckBox c7;
	private JTextField t1;
	private JLabel l11;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_up3 frame = new Sign_up3();
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
	public Sign_up3() {
		setTitle("NEW ACCOUNT APPLICATION FORM-PAGE 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		l1 = new JLabel("Page 3- Account Details");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		l1.setBounds(469, 31, 296, 31);
		contentPane.add(l1);
		
		l2 = new JLabel("Account Type");
		l2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l2.setBounds(221, 69, 161, 31);
		contentPane.add(l2);
		
		r1 = new JRadioButton("Savings Account");
		r1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		r1.setBounds(221, 107, 146, 31);
		contentPane.add(r1);
		
		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		r2.setBounds(635, 114, 212, 31);
		contentPane.add(r2);
		
		r3 = new JRadioButton("Current Account");
		r3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		r3.setBounds(221, 148, 146, 31);
		contentPane.add(r3);
		
		r4 = new JRadioButton("Recurring Deposit Account");
		r4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		r4.setBounds(635, 148, 227, 31);
		contentPane.add(r4);
		
		l3 = new JLabel("Account No");
		l3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l3.setBounds(221, 290, 161, 31);
		contentPane.add(l3);
		
		l4 = new JLabel("XXXX-XXXX-XXXX-4184");
		l4.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l4.setBounds(635, 290, 261, 31);
		contentPane.add(l4);
		
		l7 = new JLabel("PIN");
		l7.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l7.setBounds(221, 357, 146, 31);
		contentPane.add(l7);
		
		l8 = new JLabel("XXXX");
		l8.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l8.setBounds(635, 357, 97, 31);
		contentPane.add(l8);
		
		l9 = new JLabel("(4-digit password)");
		l9.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		l9.setBounds(221, 390, 91, 20);
		contentPane.add(l9);
		
		c7 = new JCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.");
		c7.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		c7.setBounds(221, 452, 468, 31);
		contentPane.add(c7);
		
		b2 = new JButton("Cancel");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new home().setVisible(true);
					setVisible(false);
				}
				catch(Exception e2) {
					e2.printStackTrace();
                    System.out.println("error: "+e2);
				}
			}
		});
		b2.setForeground(Color.BLACK);
		b2.setBackground(UIManager.getColor("Button.background"));
		b2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		b2.setBounds(774, 549, 122, 31);
		contentPane.add(b2);
		
		b1 = new JButton("Submit");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String a = null;
			        if(r1.isSelected()){ 
			            a = "Saving Account";
			        }
			        else if(r2.isSelected()){ 
			            a = "Fixed Deposit Account";
			        }
			        else if(r3.isSelected()){ 
			            a = "Current Account";
			        }else if(r4.isSelected()){ 
			            a = "Recurring Deposit Account";
			        }
			        
			        Random ran = new Random();
			        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
			        long first8 = Math.abs(first7);
			        
			        long first3 = (ran.nextLong() % 9000L) + 1000L;
			        long first4 = Math.abs(first3);
			        
			        String b=t1.getText();
			       
			        
			        try {
			        	if(b.equals(""))
			        		JOptionPane.showMessageDialog(null, "Fill all the required fields");
			        	else {
			        		connection c1=new connection();
			        		String query3=null;
			        		String query4=null;
			        		query3="select name from signup ORDER BY sign_id DESC LIMIT 1";
			        		ResultSet rs=c1.s.executeQuery(query3);
			        		if(rs.next()) {
			        		query4=rs.getString("name");
			        		}
			        		String query1 = "insert into signup3 (account,cardno,pin,balance,names) values('"+a+"','"+first8+"','"+first4+"',500,'"+query4+"')";  
		                    String query2 = "insert into login values('"+first8+"','"+first4+"')";
		                    c1.s.executeUpdate(query1);
		                    c1.s.executeUpdate(query2);
		                    JOptionPane.showMessageDialog(null, "Card Number: " + first8 + "\n Pin:"+ first4 + "\n Do remember the card number and pin");
		                    new Login().setVisible(true);
		                    setVisible(false);
			        		
			        	}
			        	
			        }catch(Exception ex) {
			        	ex.printStackTrace();
			        	
			        }
			}
		});
		b1.setForeground(Color.BLACK);
		b1.setBackground(UIManager.getColor("Button.background"));
		b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		b1.setBounds(129, 549, 123, 31);
		contentPane.add(b1);
		
		l10 = new JLabel("Balance");
		l10.setFont(new Font("Times New Roman", Font.BOLD, 20));
		l10.setBounds(221, 215, 146, 31);
		contentPane.add(l10);
		
		t1 = new JTextField();
		t1.setBounds(635, 219, 212, 27);
		contentPane.add(t1);
		t1.setColumns(10);
		
		l11 = new JLabel("(Minimum amount to be deposit is Rs 500/-)");
		l11.setFont(new Font("Times New Roman", Font.PLAIN, 9));
		l11.setBounds(221, 249, 183, 20);
		contentPane.add(l11);
		
		btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Sign_up2().setVisible(true);
					setVisible(false);
				}
				catch(Exception e2) {
					e2.printStackTrace();
                    System.out.println("error: "+e2);
				}
			}
		});
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(463, 549, 123, 31);
		contentPane.add(btnNewButton);
	}
}
