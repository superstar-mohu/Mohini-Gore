package bank_management;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.border.BevelBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Apply extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Apply frame = new Apply();
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
	public Apply() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0, 1112, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setBounds(128, 472, 96, -31);
		contentPane.add(table);
		
		JLabel lblNewLabel = new JLabel("Apply Now");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lblNewLabel.setBounds(479, 28, 136, 32);
		contentPane.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(27, 71, 1045, 137);
		contentPane.add(panel_1);
		
		JLabel lblDoYouWant = new JLabel("Do you want to apply for Credit Card ?  Just click on the button below and follow the process to get Credit Card online.");
		lblDoYouWant.setForeground(Color.BLACK);
		lblDoYouWant.setBackground(Color.BLACK);
		lblDoYouWant.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JButton Credit_button = new JButton("Proceed");
		Credit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Credit().setVisible(true);
					setVisible(false);
				}
				catch(Exception e2) {
					e2.printStackTrace();
                    System.out.println("error: "+e2);
				}
			}
		});
		Credit_button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addComponent(lblDoYouWant, GroupLayout.PREFERRED_SIZE, 971, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(462)
					.addComponent(Credit_button, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(449, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDoYouWant, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Credit_button, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(27, 324, 1045, 137);
		contentPane.add(panel);
		
		JButton Debit_button = new JButton("Proceed");
		Debit_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new Debit().setVisible(true);
					setVisible(false);
				}
				catch(Exception e2) {
					e2.printStackTrace();
                    System.out.println("error: "+e2);
				}
			}
		});
		Debit_button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		JLabel lblDoYouWant_1 = new JLabel("Do you want to apply for Debit Card ?  Just click on the button below and follow the process to get Debit Card online.");
		lblDoYouWant_1.setForeground(Color.BLACK);
		lblDoYouWant_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblDoYouWant_1.setBackground(Color.BLACK);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1045, Short.MAX_VALUE)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(48, Short.MAX_VALUE)
					.addComponent(lblDoYouWant_1, GroupLayout.PREFERRED_SIZE, 971, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(462)
					.addComponent(Debit_button, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(449, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 137, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDoYouWant_1, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(Debit_button, GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		
		JButton back_button = new JButton("Back");
		back_button.addActionListener(new ActionListener() {
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
		back_button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		back_button.setBounds(281, 563, 119, 42);
		contentPane.add(back_button);
		
		JButton logout_button = new JButton("Logout");
		logout_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		logout_button.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		logout_button.setBounds(760, 563, 119, 42);
		contentPane.add(logout_button);
	}
}
