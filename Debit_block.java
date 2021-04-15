package bank_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Debit_block extends JFrame {

	private JPanel contentPane;
	private JLabel b2,b5,b1;
	private JRadioButton bb3,bb4;
	private JComboBox b6;
	private JButton bb7;
	private JPasswordField p1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Debit_block frame = new Debit_block();
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
	public Debit_block() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		b2 = new JLabel("Do you want to block ?");
		b2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		b2.setBounds(250, 222, 286, 29);
		contentPane.add(b2);
		
		bb3 = new JRadioButton("YES");
		bb3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		bb3.setBounds(652, 227, 103, 21);
		contentPane.add(bb3);
		
		bb4 = new JRadioButton("NO");
		bb4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		bb4.setBounds(776, 227, 103, 21);
		contentPane.add(bb4);
		
		b5 = new JLabel("Reason to block ?");
		b5.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		b5.setBounds(250, 298, 231, 29);
		contentPane.add(b5);
		
		b6 = new JComboBox();
		b6.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		b6.setModel(new DefaultComboBoxModel(new String[] {"card is lost", "Technical error ", "others"}));
		b6.setEditable(true);
		b6.setBounds(652, 300, 201, 29);
		contentPane.add(b6);
		
		bb7 = new JButton("Sumbit Request");
		bb7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=null;
				String c=p1.getText();
		        if(bb3.isSelected()){ 
		            a = "Yes";
		        }
		        else if(bb4.isSelected()){ 
		            a = "No";
		        }
		        String b=(String)b6.getSelectedItem();
		        try {
		        	connection c1=new connection();
		        	if(a==null) {
		        		JOptionPane.showMessageDialog(null, "Fill all the fields");
		        	}
		        	else if(a=="No") {
		        		JOptionPane.showMessageDialog(null, "No Action performed");
		        	}
		        	else if(c=="") {
		        		JOptionPane.showMessageDialog(null, "Enter the pin");
		        	}
		        	else {
		        		String sql1="select * from apply_now where pin='"+c+"'";
		        		ResultSet rs=c1.s.executeQuery(sql1);
		        		if(rs.next()) {
		        			String d="blocked";
		        			String sql2="update apply_now set debit_status='"+d+"' where pin='"+c+"'";
		        			c1.s.executeUpdate(sql2);
		        			JOptionPane.showMessageDialog(null, "Your Debit card status has been changed from active to blocked");
		        		}
		        		
		        		else {
		        			JOptionPane.showMessageDialog(null, "Enter the correct pin");
		        		}
		        	}
		        	
		        }catch(Exception e1) {
		        	JOptionPane.showMessageDialog(null, e1);
		        }
			}
		});
		bb7.setFont(new Font("Times New Roman", Font.BOLD, 22));
		bb7.setBounds(508, 390, 185, 41);
		contentPane.add(bb7);
		
		b1 = new JLabel("Block Debit Card");
		b1.setFont(new Font("Times New Roman", Font.BOLD, 25));
		b1.setBounds(519, 63, 208, 29);
		contentPane.add(b1);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
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
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnBack.setBounds(220, 508, 185, 41);
		contentPane.add(btnBack);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnLogout.setFont(new Font("Times New Roman", Font.BOLD, 22));
		btnLogout.setBounds(776, 508, 185, 41);
		contentPane.add(btnLogout);
		
		JLabel lblEnterThePin = new JLabel("Enter the pin");
		lblEnterThePin.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lblEnterThePin.setBounds(250, 153, 231, 29);
		contentPane.add(lblEnterThePin);
		
		p1 = new JPasswordField();
		p1.setBounds(652, 153, 155, 28);
		contentPane.add(p1);
	}
}