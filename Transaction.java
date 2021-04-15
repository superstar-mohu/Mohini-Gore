package bank_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Transaction extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transaction frame = new Transaction();
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
	public Transaction() {
		setTitle("TRANSACTIONS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Please  Select From Transcation");
		l1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		l1.setBounds(412, 37, 446, 38);
		contentPane.add(l1);
		
		JButton b1 = new JButton("Deposit");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new deposit().setVisible(true);
					setVisible(false);
				}
				catch(Exception ex) {
					ex.printStackTrace();
                    System.out.println("error: "+ex);
				}
			}
		});
		b1.setBackground(UIManager.getColor("Button.background"));
		b1.setForeground(Color.BLACK);
		b1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b1.setBounds(152, 132, 177, 38);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Apply Now");
		b2.addActionListener(new ActionListener() {
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
		b2.setForeground(Color.BLACK);
		b2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b2.setBackground(UIManager.getColor("Button.background"));
		b2.setBounds(774, 132, 177, 38);
		contentPane.add(b2);
		
		JButton b3 = new JButton("Trasfer Amount");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new transfer().setVisible(true);
					setVisible(false);
				}
				catch(Exception e1) {
					e1.printStackTrace();
                    System.out.println("error: "+e1);
				}
			}
		});
		b3.setForeground(Color.BLACK);
		b3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b3.setBackground(UIManager.getColor("Button.background"));
		b3.setBounds(152, 250, 177, 38);
		contentPane.add(b3);
		
		JButton b4 = new JButton("Block/Unblock Cards");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new BlockUnblockCards().setVisible(true);
					setVisible(false);
				}
				catch(Exception e2) {
					e2.printStackTrace();
                    System.out.println("error: "+e2);
				}
			}
		});
		b4.setForeground(Color.BLACK);
		b4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b4.setBackground(UIManager.getColor("Button.background"));
		b4.setBounds(774, 250, 177, 38);
		contentPane.add(b4);
		
		JButton b5 = new JButton("Pin Change");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new pin_change().setVisible(true);
					setVisible(false);
				}
				catch(Exception e2) {
					e2.printStackTrace();
                    System.out.println("error: "+e2);
				}
			}
		});
		b5.setForeground(Color.BLACK);
		b5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b5.setBackground(UIManager.getColor("Button.background"));
		b5.setBounds(152, 355, 177, 38);
		contentPane.add(b5);
		
		JButton b6 = new JButton("EMI calculator");
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					loanemi lo=new loanemi();
					lo.Newscreen();
					setVisible(false);
				} catch (Exception e10) {
					e10.printStackTrace();
				}
				
			}
		});
		b6.setForeground(Color.BLACK);
		b6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b6.setBackground(UIManager.getColor("Button.background"));
		b6.setBounds(774, 355, 177, 38);
		contentPane.add(b6);
		
		JButton b7 = new JButton("Logout");
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		b7.setForeground(Color.BLACK);
		b7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b7.setBackground(UIManager.getColor("Button.background"));
		b7.setBounds(774, 465, 177, 38);
		contentPane.add(b7);
		
		JButton b8 = new JButton("Loan Enquiry");
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Loan_enquiry le=new Loan_enquiry();
					le.Loan();
					setVisible(false);
				} catch (Exception e10) {
					e10.printStackTrace();
				}
				
			}
		});
		b8.setForeground(Color.BLACK);
		b8.setFont(new Font("Times New Roman", Font.BOLD, 14));
		b8.setBackground(UIManager.getColor("Button.background"));
		b8.setBounds(152, 465, 177, 38);
		contentPane.add(b8);
	}
}
