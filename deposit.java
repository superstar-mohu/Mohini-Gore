package bank_management;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class deposit extends JFrame {

	private JPanel contentPane;
	private JButton b1,b2,b3;
	private JLabel l1,l2,l3,l4;
	private JTextField t2;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deposit frame = new deposit();
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
	public deposit() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		l1 = new JLabel("ENTER AMOUNT YOU WANT \r\n");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		l1.setBounds(424, 39, 338, 36);
		contentPane.add(l1);
		
		l2 = new JLabel("TO DEPOSIT");
		l2.setFont(new Font("Times New Roman", Font.BOLD, 24));
		l2.setBounds(512, 85, 181, 36);
		contentPane.add(l2);
		
		l3 = new JLabel("PIN");
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		l3.setBounds(309, 190, 84, 36);
		contentPane.add(l3);
		
		l4 = new JLabel("AMOUNT");
		l4.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		l4.setBounds(290, 294, 114, 36);
		contentPane.add(l4);
		
		t2 = new JTextField();
		t2.setBounds(642, 294, 162, 36);
		contentPane.add(t2);
		t2.setColumns(10);
		
		b1 = new JButton("DEPOSIT");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{        
			           
		            String b = p1.getText();
		            String a = t2.getText();
		            
		            if(t2.getText().equals("")){
	                    
	                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
	                
	                }
		            else if(p1.getText().equals("")) {
		            	JOptionPane.showMessageDialog(null, "Please enter correct pin");
		            }
		            else{
	                    
	                    connection c1 = new connection();
	                    
	                    
	                    
	                    ResultSet rs = c1.s.executeQuery(" select * from signup3 where pin = '"+b+"' ");
	                    String bal=null;
	                    double balance = 0;
	                    if(rs.next()){
	                        String pin = rs.getString("pin");
	 						                       
	                        bal = rs.getString("balance");
	                        balance=Double.parseDouble(bal);
	                        
	                        
	                        double d = Double.parseDouble(a);
	                        balance=balance+d;
	                        //String q1= "insert into signup3(balance) values('"+balance+"') where pin='"+b+"' ";
	                        String q1="update signup3 set balance='"+balance+"' where pin='"+b+"' ";
	                    
	                        c1.s.executeUpdate(q1);
	                        String q2="insert into bank(pin,deposit,balance) values('"+b+"','"+d+"','"+balance+"')";
	                        c1.s.executeUpdate(q2);
	                    
	                    
	                    JOptionPane.showMessageDialog(null, "Rs. "+a+" Deposited Successfully");
	                    
	                    new Transaction().setVisible(true);
	                    setVisible(false);
	                    
	                    }    
	                    else {
	                    	JOptionPane.showMessageDialog(null, "Something went wrong");
	                    }
	                    
				}
				}
				catch(Exception e1){
	                e1.printStackTrace();
	                System.out.println("error: "+e1);
	        }
			}
		});
		b1.setBackground(UIManager.getColor("Button.background"));
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		b1.setBounds(456, 446, 134, 36);
		contentPane.add(b1);
		
		b3 = new JButton("EXIT");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		b3.setBackground(UIManager.getColor("Button.background"));try {
			new Transaction().setVisible(true);
			setVisible(false);
		}
		catch(Exception e2) {
			e2.printStackTrace();
            System.out.println("error: "+e2);
		}
		b3.setBounds(787, 529, 134, 36);
		contentPane.add(b3);
		
		b2 = new JButton("BACK");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Transaction().setVisible(true);
					setVisible(false);
				}
				catch(Exception e1) {
					e1.printStackTrace();
                    System.out.println("error: "+e1);
				}
				
			}
		});
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		b2.setBackground(UIManager.getColor("Button.background"));
		b2.setBounds(175, 529, 134, 36);
		contentPane.add(b2);
		
		p1 = new JPasswordField();
		p1.setBounds(642, 190, 162, 36);
		contentPane.add(p1);
	}
}
