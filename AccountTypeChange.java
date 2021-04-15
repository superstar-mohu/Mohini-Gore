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
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class AccountTypeChange extends JFrame {

	private JPanel contentPane;
	private JLabel l0,l2,l3,l1;
	private JComboBox c1,c2;
	private JButton b1;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AccountTypeChange frame = new AccountTypeChange();
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
	public AccountTypeChange() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		l0 = new JLabel("To Change Account Type");
		l0.setFont(new Font("Times New Roman", Font.BOLD, 24));
		l0.setBounds(396, 25, 355, 34);
		contentPane.add(l0);
		
		l2 = new JLabel("Current Account Type");
		l2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l2.setBounds(193, 208, 184, 34);
		contentPane.add(l2);
		
		c1 = new JComboBox();
		c1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		c1.setModel(new DefaultComboBoxModel(new String[] {"Select", "Savings", "Current", "Joint"}));
		c1.setBounds(583, 208, 168, 34);
		contentPane.add(c1);
		
		l3 = new JLabel("Change Account Type");
		l3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l3.setBounds(193, 313, 184, 34);
		contentPane.add(l3);
		
		c2 = new JComboBox();
		c2.setModel(new DefaultComboBoxModel(new String[] {"Select", "Savings", "Current", "Joint"}));
		c2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		c2.setBounds(583, 313, 168, 34);
		contentPane.add(c2);
		
		b1 = new JButton("Change");
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=textField.getText();
				String b=(String)c1.getSelectedItem();
				String c=(String)c2.getSelectedItem();
				try {
					connection c1=new connection();
					
					//String query="select * from login where cardno='"+a+"'and pin='"+b+"' ";
					String query="update signup3 set account='"+c+"' where cardno='"+a+"' ";
					c1.s.executeUpdate(query);
					
						JOptionPane.showMessageDialog(null, "Account type changed successfully");
						new Transaction().setVisible(true);
						setVisible(false);
						
				
					}catch(Exception ex) {
						ex.printStackTrace();
	                    System.out.println("error: "+ex);
					}
			}
		});
		b1.setForeground(Color.WHITE);
		b1.setBackground(Color.BLACK);
		b1.setBounds(408, 429, 146, 41);
		contentPane.add(b1);
		
		l1 = new JLabel("Account No");
		l1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		l1.setBounds(193, 107, 184, 32);
		contentPane.add(l1);
		
		textField = new JTextField();
		textField.setBounds(583, 107, 168, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Back");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Transaction().setVisible(true);
					setVisible(false);
				}
				catch(Exception e2) {
					e2.printStackTrace();
                    System.out.println("error: "+e2);
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(163, 509, 117, 41);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBackground(Color.BLACK);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBounds(693, 509, 117, 41);
		contentPane.add(btnNewButton_1);
	}
}
