package bank_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Login extends JFrame  {
	JLabel l1,l2;
	private JPanel l3;
	private JLabel l4;
	JButton b1,b2,b3;
	private JTextField tf1;
	private JPasswordField pf1;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		l3 = new JPanel();
		l3.setBackground(Color.WHITE);
		l3.setMaximumSize(new Dimension(50000, 50000));
		l3.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(l3);
		l3.setLayout(null);
		
		l1 = new JLabel("Welcome to Bank");
		l1.setFont(new Font("Osward", Font.BOLD, 38));
		l1.setMaximumSize(new Dimension(45, 45));
		l1.setBounds(404, 40, 350, 35);
		l3.add(l1);
		
		l2 = new JLabel("Account No");
		l2.setFont(new Font("Raleway", Font.BOLD, 28));
		l2.setBounds(252, 143, 169, 35);
		l3.add(l2);
		
		l4 = new JLabel("PIN");
		l4.setFont(new Font("Raleway", Font.BOLD, 28));
		l4.setBounds(252, 249, 141, 28);
		l3.add(l4);
		
		b1 = new JButton("Sign In");
		b1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				connection c1=new connection();
				String a=tf1.getText();
				String b=pf1.getText();
				String query="select * from login where cardno='"+a+"'and pin='"+b+"' ";
				ResultSet rs=c1.s.executeQuery(query); 
				if(rs.next()) {
					new Transaction().setVisible(true);
					setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
				}
				}catch(Exception ex) {
					ex.printStackTrace();
                    System.out.println("error: "+ex);
				}
			}
		});
		
		b1.setBackground(UIManager.getColor("Button.background"));
	    b1.setForeground(Color.BLACK);
		b1.setBounds(252, 404, 169, 46);
		l3.add(b1);
		
		b2 = new JButton("Clear");
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf1.setText("");
				pf1.setText("");
				
			}
		});
		b2.setBackground(UIManager.getColor("Button.background"));
	    b2.setForeground(Color.BLACK);
		b2.setBounds(660, 404, 165, 46);
		l3.add(b2);
		
		b3 = new JButton("Sign Up");
		b3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Sign_up().setVisible(true);
                setVisible(false);
			}
		});
		b3.setBackground(UIManager.getColor("Button.background"));
	    b3.setForeground(Color.BLACK);
		b3.setBounds(252, 537, 169, 46);
		l3.add(b3);
		
		tf1 = new JTextField();
		tf1.setBounds(627, 143, 229, 35);
		l3.add(tf1);
		tf1.setColumns(10);
		
		pf1 = new JPasswordField();
		pf1.setBounds(627, 242, 229, 35);
		l3.add(pf1);
		
		btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
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
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(660, 537, 165, 46);
		l3.add(btnNewButton);
	}
}
