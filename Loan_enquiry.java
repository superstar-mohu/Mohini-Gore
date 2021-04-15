package bank_management;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;

public class Loan_enquiry {
	
	private JFrame frame;
	private JLabel lblNewLabel , lblNewLabel_1,lblNewLabel_2,lblNewLabel_3,lblNewLabel_4,lblNewLabel_9,lblNewLabel_10,lblNewLabel_11;
	private JTextField Name;
	private JTextField Age;
	private JTextField Salary;
	private JTextField Nationality;
	private JTextField Other;
	private JTextField Score;
	private JComboBox Experience,Occupation;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void Loan() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loan_enquiry window = new Loan_enquiry();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loan_enquiry() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0,0, 1112, 1200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 10, 1076, 62);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_5 = new JLabel("Home Loan Eligibility:");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 45));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(94)
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 928, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_5, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
	      
		
		lblNewLabel = new JLabel("Enter Your Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(124, 106, 404, 46);
		frame.getContentPane().add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Enter Your Age:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(123, 163, 367, 46);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Are you Self-Employed or Salaried:");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_2.setBounds(123, 267, 367, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		lblNewLabel_3 = new JLabel("Monthly Salary is Rs:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_3.setBounds(123, 376, 367, 46);
		frame.getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("CIBIL Score:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_4.setBounds(123, 210, 367, 46);
		frame.getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_9 = new JLabel("Work Experience/Business Continuity:");
		lblNewLabel_9.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_9.setBounds(123, 328, 367, 30);
		frame.getContentPane().add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Other Source is Rs:");
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_10.setBounds(123, 445, 210, 29);
		frame.getContentPane().add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Nationality:");
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_11.setBounds(123, 499, 155, 32);
		frame.getContentPane().add(lblNewLabel_11);
		
		
		
		Name = new JTextField();
		Name.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Name.setBounds(741, 112, 178, 32);
		frame.getContentPane().add(Name);
	    Name.setColumns(10);
		
		Age = new JTextField();
		Age.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Age.setBounds(741, 169, 178, 31);
		frame.getContentPane().add(Age);
		Age.setColumns(10);
		
		Score = new JTextField();
		Score.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Score.setBounds(741, 216, 178, 31);
		frame.getContentPane().add(Score);
		Score.setColumns(10);
		
		Experience = new JComboBox<>();
		Experience.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Experience.setModel(new DefaultComboBoxModel<String>(new String[] {"1", "2", "3", "4", "5", "Greater than 6"}));
		Experience.setBounds(741, 328, 178, 30);
		frame.getContentPane().add(Experience);
		
		Occupation = new JComboBox<>();
		Occupation.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Occupation.setModel(new DefaultComboBoxModel<String>(new String[] {"Salaried", "Self-Employed"}));
		Occupation.setMaximumRowCount(5);
		Occupation.setBounds(741, 275, 178, 30);
		frame.getContentPane().add(Occupation);
		
		Salary = new JTextField();
		Salary.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Salary.setBounds(741, 382, 178, 31);
		frame.getContentPane().add(Salary);
		Salary.setColumns(10);
		
		Other = new JTextField();
		Other.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Other.setBounds(741, 442, 178, 31);
		frame.getContentPane().add(Other);
		Other.setColumns(10);
		
		Nationality = new JTextField();
		Nationality.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		Nationality.setBounds(741, 498, 178, 31);
		frame.getContentPane().add(Nationality);
		Nationality.setColumns(10);
		
		JButton btnNewButton = new JButton("Check Eligibility");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 int age=Integer.parseInt(Age.getText());
				       int score=Integer.parseInt(Score.getText());
				       double salary=Double.parseDouble(Salary.getText());
				       double other=Double.parseDouble(Other.getText());
				       double total=salary+other;
				       //Experience = null;
				       String a=(String)Experience.getSelectedItem();
					int experience =Integer.parseInt(a);
				        //Occupation = null;
					String occupation=(String) Occupation.getSelectedItem();
				       String nationality=Nationality.getText();
				       
				       if(occupation.equals("Salaried") && experience>=3) {
				    	   if(age>23 && age<62) {
				    	     if(nationality.equals("Indian")) {
				    				 if(score>750){
				    					 if(total>=25000 && total<50000)
				    					   JOptionPane.showMessageDialog(null, "Congrats,You are Eligible For Home Loan Upto 18.64 Lakhs");
				    					 else if(total>=50000 && total<75000)
				    					   JOptionPane.showMessageDialog(null, "Congrats,You are Eligible For Home Loan Upto 37.28 Lakhs");
				    					   else if(total>75000)
				    						   JOptionPane.showMessageDialog(null, "Congrats,You are Eligible For Home Loan Upto 55.93 Lakhs");
				    					
				    				   }
				    				 else {
				    					 JOptionPane.showMessageDialog(null, "Sorry, Your Credit score is less to grant a loan");
				    				 }
				    				   
				    			   }
				    	     else {
				    	    	 JOptionPane.showMessageDialog(null, "Sorry, to take a loan you should be an Indian Citizen");
				    	     }
				    		   }
				    	   else {
				    	    	 JOptionPane.showMessageDialog(null, "Sorry, your age should be in between 25 to 70 to take a loan");
				    	     }
				    		   
				    	   }
				       else if(occupation.equals("Self-Employed") && experience>=5) {
					    	   if(age>25 && age<70) {
					    	     if(nationality.equals("Indian")) {
					    				 if(score>750){
					    					 if(total>=25000 && total<50000)
					    					   JOptionPane.showMessageDialog(null, "Congrats,You are Eligible For Home Loan Upto 18.64 Lakhs");
					    					 else if(total>=50000 && total<75000)
					    					   JOptionPane.showMessageDialog(null, "Congrats,You are Eligible For Home Loan Upto 37.28 Lakhs");
					    					   else if(total>75000) 
					    						   JOptionPane.showMessageDialog(null, "Congrats,You are Eligible For Home Loan Upto 55.93 Lakhs");
					    					
					    				   }
					    				 else {
					    					 JOptionPane.showMessageDialog(null, "Sorry, Your Credit score is less to grant a loan");
					    				 }
					    				   
					    			   }
					    	     else {
					    	    	 JOptionPane.showMessageDialog(null, "Sorry, to take a loan you should be an Indian Citizen");
					    	     }
					    		   }
					    	   else {
					    	    	 JOptionPane.showMessageDialog(null, "Sorry, your age should be in between 25 to 70 to take a loan");
					    	     }
					    		   
					    	   }
				       else {
				    	   JOptionPane.showMessageDialog(null, "Sorry,You are not eligible for Home Loan");
				    	   
				       }
					}
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null, e1);
					}
			
			}
		});
		btnNewButton.setBounds(665, 609, 178, 37);
		frame.getContentPane().add(btnNewButton);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Transaction().setVisible(true);
					frame.setVisible(false);
				}
				catch(Exception e2) {
					e2.printStackTrace();
                    System.out.println("error: "+e2);
				}
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.setBounds(170, 607, 178, 37);
		frame.getContentPane().add(btnBack);
		
				
	}
	}

