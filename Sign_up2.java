package bank_management;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Sign_up2 extends JFrame {

	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	JComboBox c1 ,c2 ,c3, c4,c5;
	JLabel l1 , l2, l3,l4,l5,l6,l7,l8,l9,l10,l11;
	JButton b1;
	JRadioButton r1,r2,r3,r4;
	private JButton btnNewButton;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sign_up2 frame = new Sign_up2();
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
	public Sign_up2() {
		setTitle("NEW ACCOUNT APPLICATION FORM- PAGE 2 ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		l1= new JLabel("Page 2- Additional Details");
		l1.setFont(new Font("Raleway", Font.BOLD, 22));
		l1.setBounds(409, 27, 474, 34);
		contentPane.add(l1);
		
		l2 = new JLabel("Religion");
		l2.setFont(new Font("Raleway", Font.BOLD, 18));
		l2.setBounds(265, 77, 133, 34);
		contentPane.add(l2);
		
		l3 = new JLabel("Category");
		l3.setFont(new Font("Raleway", Font.BOLD, 18));
		l3.setBounds(265, 122, 133, 34);
		contentPane.add(l3);
		
		l4 = new JLabel("Income");
		l4.setFont(new Font("Raleway", Font.BOLD, 18));
		l4.setBounds(265, 167, 133, 34);
		contentPane.add(l4);
		
		l5 = new JLabel("Educational Qualification");
		l5.setFont(new Font("Raleway", Font.BOLD, 18));
		l5.setBounds(265, 212, 226, 34);
		contentPane.add(l5);
		
		l7 = new JLabel("Occupation");
		l7.setFont(new Font("Raleway", Font.BOLD, 18));
		l7.setBounds(265, 252, 133, 34);
		contentPane.add(l7);
		
		l8 = new JLabel("Pan Number");
		l8.setFont(new Font("Raleway", Font.BOLD, 18));
		l8.setBounds(265, 300, 133, 34);
		contentPane.add(l8);
		
		l9 = new JLabel("Adhar Number");
		l9.setFont(new Font("Raleway", Font.BOLD, 18));
		l9.setBounds(265, 345, 133, 34);
		contentPane.add(l9);
		
		l10 = new JLabel("Senior Citizen");
		l10.setFont(new Font("Raleway", Font.BOLD, 18));
		l10.setBounds(265, 390, 133, 34);
		contentPane.add(l10);
		
		l11 = new JLabel("Existing Account");
		l11.setFont(new Font("Raleway", Font.BOLD, 18));
		l11.setBounds(265, 432, 242, 34);
		contentPane.add(l11);
		
		b1 = new JButton("Next");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a=(String)c1.getSelectedItem();
				String b=(String)c2.getSelectedItem();
				String c=(String)c3.getSelectedItem();
				String d=(String)c4.getSelectedItem();
				String e1=(String)c5.getSelectedItem();
				
				String f=t1.getText();
				String g=t2.getText();
				
				String h="";
				if(r1.isSelected())
					h="Yes";
				else if(r2.isSelected())
					h="No";
				
				String i="";
				if(r3.isSelected())
					i="Yes";
				else if(r4.isSelected())
					i="No";
				
				
				 try{
			            
			            
			            
			            if(t2.getText().equals("")){
			                JOptionPane.showMessageDialog(null, "Fill all the required fields");
			            }else{
			                connection c1 = new connection();
			                Sign_up s1=new Sign_up();
			                	
			                
			                String q1 = "insert into signup2 (religion,category,income,education,occupation,panno,aadharno,senior,existing) values('"+a+"','"+b+"','"+c+"','"+d+"','"+e1+"','"+f+"','"+g+"','"+h+"','"+i+"')";
			                c1.s.executeUpdate(q1);
			                
			                new Sign_up3().setVisible(true);
			                setVisible(false);
			                }
			               
			            }
			                
			      
			            
			        catch(Exception ex){
			             ex.printStackTrace();
			        }
			    
				
				
			}
		});
		b1.setFont(new Font("Times New Roman", Font.BOLD, 20));
	    b1.setBackground(UIManager.getColor("Button.background"));
	    b1.setForeground(Color.BLACK);
	        
		b1.setBounds(829, 536, 127, 34);
		contentPane.add(b1);
		
		r1 = new JRadioButton("Yes");
		r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(Color.WHITE);
		r1.setBounds(700, 388, 79, 34);
		contentPane.add(r1);
		
		r2 = new JRadioButton("No");
		r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(Color.WHITE);
		r2.setBounds(820, 388, 79, 34);
		contentPane.add(r2);
		
		r3 = new JRadioButton("Yes");
		r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(Color.WHITE);
		r3.setBounds(700, 433, 79, 34);
		contentPane.add(r3);
		
		r4 = new JRadioButton("No");
		r4.setFont(new Font("Raleway", Font.BOLD, 14));
        r4.setBackground(Color.WHITE);
		r4.setBounds(820, 433, 79, 34);
		contentPane.add(r4);
		
		t1 = new JTextField();
		t1.setText("");
		t1.setBounds(700, 300, 262, 34);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setText("");
		t2.setBounds(700, 345, 262, 34);
		contentPane.add(t2);
		t2.setColumns(10);
		
		c1= new JComboBox();
		c1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		c1.setModel(new DefaultComboBoxModel(new String[] {"Hindu", "Muslim", "Sikh", "Christian", "Other"}));
		c1.setBounds(700, 71, 183, 40);
		contentPane.add(c1);
		
		c2= new JComboBox();
		c2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		c2.setModel(new DefaultComboBoxModel(new String[] {"General", "OBC", "SC", "ST", "Other"}));
		c2.setBounds(700, 122, 183, 34);
		contentPane.add(c2);
		
		c3 = new JComboBox();
		c3.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		c3.setModel(new DefaultComboBoxModel(new String[] {"Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"}));
		c3.setBounds(700, 164, 183, 34);
		contentPane.add(c3);
		
		c4= new JComboBox();
		c4.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		c4.setModel(new DefaultComboBoxModel(new String[] {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"}));
		c4.setBounds(700, 209, 183, 34);
		contentPane.add(c4);
		
		c5= new JComboBox();
		c5.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		c5.setModel(new DefaultComboBoxModel(new String[] {"Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others"}));
		c5.setBounds(700, 254, 183, 34);
		contentPane.add(c5);
		
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
		btnNewButton.setBounds(111, 536, 127, 34);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Sign_up().setVisible(true);
					setVisible(false);
				}
				catch(Exception e2) {
					e2.printStackTrace();
                    System.out.println("error: "+e2);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton_1.setBackground(UIManager.getColor("Button.background"));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBounds(483, 536, 127, 34);
		contentPane.add(btnNewButton_1);
	}
}
