package bank_management;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.UIManager;

public class pin_change extends JFrame {

	private JPanel contentPane;
	private JTextField p3;
	private JPasswordField p5,p8;
	private JLabel p1,p2,p4;
	private JButton p6,p7;
	private JPasswordField p10;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pin_change frame = new pin_change();
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
	public pin_change() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		p1 = new JLabel("Pin Change");
		p1.setBackground(Color.BLACK);
		p1.setFont(new Font("Times New Roman", Font.BOLD, 28));
		p1.setBounds(506, 28, 217, 29);
		contentPane.add(p1);
		
		p2 = new JLabel("Enter Old Pin");
		p2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		p2.setBounds(295, 124, 151, 29);
		contentPane.add(p2);
		
		p4 = new JLabel("Enter New Pin");
		p4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		p4.setBounds(295, 218, 151, 26);
		contentPane.add(p4);
		
		p3 = new JTextField();
		p3.setBounds(653, 126, 157, 27);
		contentPane.add(p3);
		p3.setColumns(10);
		
		p5 = new JPasswordField();
		p5.setBounds(653, 219, 157, 30);
		contentPane.add(p5);
		p5.setColumns(10);
		
		p6 = new JButton("Change");
		p6.setForeground(Color.BLACK);
		p6.setBackground(UIManager.getColor("Button.background"));
		p6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
					 connection c1=new connection();
				 String value1=p3.getText();
				 String value2=p5.getText();
				 String value3=p10.getText();
				 if (value2.equals(value3)) {
				 String sql="update signup3 set pin='"+value2+"' where pin='"+value1+"'";
				 c1.s.executeUpdate(sql);
				 String sql1="update login set pin='"+value2+"' where pin='"+value1+"'";
				 c1.s.executeUpdate(sql1);
				 String sql2="update apply_now set pin='"+value2+"' where pin='"+value1+"'";
				 c1.s.executeUpdate(sql2);
				 JOptionPane.showMessageDialog(null, "Pin successfully changed");
				 new Transaction().setVisible(true);
					setVisible(false);
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "Please comfirm the pin correctly");
				 }
				 }catch(Exception e1){
				 JOptionPane.showMessageDialog(null, e1);
				 }
				 
			}
			});
		p6.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		p6.setBounds(275, 420, 135, 42);
		contentPane.add(p6);
		
		p7 = new JButton("Clear");
		p7.setBackground(UIManager.getColor("Button.background"));
		p7.setForeground(Color.BLACK);
		p7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 p3.setText("");
				 p5.setText("");
				 p10.setText("");
				 
			}
		});
		p7.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		p7.setBounds(755, 420, 135, 42);
		contentPane.add(p7);
		
		JLabel l9 = new JLabel("Comfirm Password");
		l9.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		l9.setBounds(295, 318, 184, 26);
		contentPane.add(l9);
		
		p10 = new JPasswordField();
		p10.setBounds(653, 320, 157, 29);
		contentPane.add(p10);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setBounds(755, 516, 144, 42);
		contentPane.add(btnNewButton);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
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
		btnBack.setForeground(Color.BLACK);
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(275, 516, 144, 42);
		contentPane.add(btnBack);
	}
}
