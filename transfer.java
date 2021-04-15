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
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.event.PopupMenuListener;
import javax.swing.event.PopupMenuEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class transfer extends JFrame {

	private JPanel t14;
	private JTextField t3;
	private JTextField t6;
	private JTextField t8;
	private JTextField t10;
	private JTextField t11;
	private JTextField t15;
	private JTextField t16;
	private JTextField t19;
	private JLabel t,t1,t2,t5,t7,t9,t13;
	private JButton t4,t12,t17,t18;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					transfer frame = new transfer();
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
	public transfer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		t14 = new JPanel();
		t14.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(t14);
		t14.setLayout(null);
		
		t2 = new JLabel("Name");
		t2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t2.setBounds(235, 152, 164, 21);
		t14.add(t2);
		
		t5 = new JLabel("Account No");
		t5.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t5.setBounds(235, 209, 164, 21);
		t14.add(t5);
		
		t7 = new JLabel("Available Balance");
		t7.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t7.setBounds(235, 283, 164, 21);
		t14.add(t7);
		
		t9 = new JLabel("Transfer Amount");
		t9.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t9.setBounds(235, 350, 164, 26);
		t14.add(t9);
		
		t13 = new JLabel("Credit Account");
		t13.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t13.setBounds(235, 431, 164, 21);
		t14.add(t13);
		
		t3 = new JTextField();
		t3.setEditable(false);
		t3.setBounds(516, 154, 193, 23);
		t14.add(t3);
		t3.setColumns(10);
		
		t6 = new JTextField();
		t6.setEditable(false);
		t6.setBounds(516, 211, 193, 23);
		t14.add(t6);
		t6.setColumns(10);
		
		t8 = new JTextField();
		t8.setEditable(false);
		t8.setBounds(516, 285, 193, 23);
		t14.add(t8);
		t8.setColumns(10);
		
		t10 = new JTextField();
		t10.setBounds(516, 353, 101, 26);
		t14.add(t10);
		t10.setColumns(10);
		
		t4 = new JButton("Search");
		t4.setBackground(UIManager.getColor("Button.background"));
		t4.setForeground(Color.BLACK);
		t4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
				 String value1=t19.getText();
				 String sql="select * from signup3 where cardno='"+value1+"' ";
				 try{
				 connection c1=new connection();
				 //pat = c1.prepareStatement(sql);
				
				
				 ResultSet rs = c1.s.executeQuery(sql);
				 //rs.setString(1,t19.getText());
				 if(rs.next()){
				 	String add1=rs.getString("names");
				 	t3.setText(add1);
				 	String add2=rs.getString("account");
				 	t6.setText(add2);
				 	String add3=rs.getString("balance");
				 	t8.setText(add3);
				 	rs.close();
				 	//pat.close();
				 }
				 else{
				 JOptionPane.showMessageDialog(null, "Enter correct Account Number");
				 }
				 }catch(Exception e1){
				 JOptionPane.showMessageDialog(null,e1);
				 }
				
				 
			}
		});
		t4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t4.setBounds(852, 88, 119, 26);
		t14.add(t4);
		
		t11 = new JTextField();
		t11.setEditable(false);
		t11.setBounds(702, 353, 101, 26);
		t14.add(t11);
		t11.setColumns(10);
		
		t12 = new JButton("Total");
		t12.setBackground(UIManager.getColor("Button.background"));
		t12.setForeground(Color.BLACK);
		t12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 try{
				 String a1=t8.getText();
				 String a2=t10.getText();
				 int sum=Integer.parseInt(a1)-Integer.parseInt(a2);
				 if (sum>0){
				 String sum1=String.valueOf(sum);
				 t11.setText(sum1);
				 }
				 else{
				 JOptionPane.showMessageDialog(null, "You can not transfer the amount");
				 }
				 }catch(Exception e2){
				 JOptionPane.showMessageDialog(null, e2);
				 }
				 
			}
		});
		t12.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t12.setBounds(852, 346, 107, 35);
		t14.add(t12);
		
		t17 = new JButton("Show");
		t17.setBackground(UIManager.getColor("Button.background"));
		t17.setForeground(Color.BLACK);
		t17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connection c1=new connection();
				 try{
				 String a1=t10.getText();
				 String value1=textField.getText();
				 String sql="select balance from signup3 where cardno='"+value1+"'";
				 ResultSet rs=c1.s.executeQuery(sql);
				 if(rs.next()) {
					 String a2=rs.getString("balance");
					 t15.setText(a2);
				 int sum=Integer.parseInt(a1)+Integer.parseInt(a2);
				 String sum1=String.valueOf(sum);
				 t16.setText(sum1);
				 }
				 else {
					 JOptionPane.showMessageDialog(null, "Verify the account number and balance");
				 }
				 
				 }catch(Exception e3){
				 JOptionPane.showMessageDialog(null, e3);
				 }
				 
			}
		});
		t17.setFont(new Font("Times New Roman", Font.BOLD, 20));
		t17.setBounds(702, 536, 101, 45);
		t14.add(t17);
		/*public void TransferC() {
			
			 try{
			 String value1=textfield.getText();
			 String value2=t16.getText();
			 String sql="update table_name set Balance='"+value2+"' where Acc='"+value1+"'";
			 c1.s.executeUpdate(sql);
			 JOptionPane.showMessageDialog(null, "Successfully Transfered");
			 }catch(Exception e){
			 JOptionPane.showMessageDialog(null, e);
			 }
			
			
		}
		public void TransferD(){
		try{
		String value1=t19.getText();
		String value2=t11.getText();
		String sql="update table_name set Balance='"+value2+"' where Name='"+value1+"'";
		c1.s.executeUpdate(sql);
		}catch(Exception e){
		JOptionPane.showMessageDialog(null, e);
		}
		}
		 */
		t18 = new JButton("Transfer");
		t18.setForeground(Color.BLACK);
		t18.setBackground(UIManager.getColor("Button.background"));
		t18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				TransferD();
//				TransferC();
				 connection c1=new connection();
				try{
					 String value1=textField.getText();
					 String value2=t16.getText();
					 String sql="update signup3 set balance='"+value2+"' where cardno='"+value1+"'";
					 c1.s.executeUpdate(sql);
					 JOptionPane.showMessageDialog(null, "Successfully Transfered");
					 new Transaction().setVisible(true);
						setVisible(false);
					 }catch(Exception e4){
					 JOptionPane.showMessageDialog(null, e4);
					 }
				try{
					String value1=t19.getText();
					String value2=t11.getText();
					String sql="update signup3 set balance='"+value2+"' where cardno='"+value1+"'";
					c1.s.executeUpdate(sql);
					}catch(Exception e5){
					JOptionPane.showMessageDialog(null, e5);
					}
					
			}
		});
		t18.setFont(new Font("Times New Roman", Font.BOLD, 20));
		t18.setBounds(491, 536, 131, 45);
		t14.add(t18);
		
		t15 = new JTextField();
		t15.setEditable(false);
		t15.setBounds(702, 431, 101, 25);
		t14.add(t15);
		t15.setColumns(10);
		
		t16 = new JTextField();
		t16.setEditable(false);
		t16.setBounds(852, 431, 107, 25);
		t14.add(t16);
		t16.setColumns(10);
		
		t1 = new JLabel("Transfer");
		t1.setFont(new Font("Times New Roman", Font.BOLD, 24));
		t1.setBounds(539, 21, 170, 33);
		t14.add(t1);
		
		t = new JLabel("Account No");
		t.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		t.setBounds(235, 88, 164, 26);
		t14.add(t);
		
		t19 = new JTextField();
		t19.setBounds(516, 90, 193, 26);
		t14.add(t19);
		t19.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(516, 431, 164, 25);
		t14.add(textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Logout");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(UIManager.getColor("Button.background"));
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.setBounds(896, 536, 119, 45);
		t14.add(btnNewButton);
		
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
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnBack.setBackground(UIManager.getColor("Button.background"));
		btnBack.setBounds(252, 536, 131, 45);
		t14.add(btnBack);
	}
}