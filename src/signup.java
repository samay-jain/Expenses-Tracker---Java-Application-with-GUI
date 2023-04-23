import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class signup {

	private JFrame frmExpenseTracker;
	private JTextField getname;
	private JTextField getemail;
	private JTextField getpassword;
	private JTextField confirmpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					signup window = new signup();
					window.frmExpenseTracker.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	DB db = new DB();
	public signup() {
		db.connect();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExpenseTracker = new JFrame();
		frmExpenseTracker.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\compare.png"));
		frmExpenseTracker.setTitle("Expense Tracker");
		frmExpenseTracker.setResizable(false);
		frmExpenseTracker.getContentPane().setBackground(new Color(255, 255, 255));
		frmExpenseTracker.setBounds(100, 100, 1281, 754);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExpenseTracker.getContentPane().setLayout(null);
		
		JLabel lblSignUpPage = new JLabel("Signup Page");
		lblSignUpPage.setForeground(new Color(0, 0, 102));
		lblSignUpPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUpPage.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblSignUpPage.setBounds(10, 27, 1247, 56);
		frmExpenseTracker.getContentPane().add(lblSignUpPage);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(85, 105, 1096, 517);
		frmExpenseTracker.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the following details");
		lblEnterTheFollowing.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheFollowing.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblEnterTheFollowing.setBounds(10, 33, 1076, 56);
		panel.add(lblEnterTheFollowing);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblName.setBounds(127, 138, 108, 45);
		panel.add(lblName);
		
		getname = new JTextField();
		getname.setForeground(new Color(0, 102, 153));
		getname.setFont(new Font("Tahoma", Font.BOLD, 24));
		getname.setBounds(266, 138, 549, 42);
		panel.add(getname);
		getname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblEmail.setBounds(127, 214, 108, 45);
		panel.add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblPassword.setBounds(127, 299, 149, 45);
		panel.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblConfirmPassword.setBounds(127, 375, 231, 45);
		panel.add(lblConfirmPassword);
		
		getemail = new JTextField();
		getemail.setForeground(new Color(0, 102, 153));
		getemail.setFont(new Font("Tahoma", Font.BOLD, 24));
		getemail.setColumns(10);
		getemail.setBounds(266, 214, 549, 42);
		panel.add(getemail);
		
		getpassword = new JTextField();
		getpassword.setForeground(new Color(0, 102, 153));
		getpassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		getpassword.setColumns(10);
		getpassword.setBounds(266, 302, 276, 42);
		panel.add(getpassword);
		
		confirmpassword = new JPasswordField();
		confirmpassword.setForeground(new Color(0, 102, 153));
		confirmpassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		confirmpassword.setColumns(10);
		confirmpassword.setBounds(368, 378, 276, 42);
		panel.add(confirmpassword);
		
		JButton btnSignup = new JButton("signup");
		btnSignup.setBackground(new Color(204, 204, 255));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name,email,pass,cpass;
				name=getname.getText();
				email=getemail.getText();
				pass=getpassword.getText();
				cpass=confirmpassword.getText();
				if(name.isEmpty() || email.isEmpty() | pass.isEmpty() || cpass.isEmpty())
					JOptionPane.showMessageDialog(null, "Please enter all required details!");
				else if(!pass.equals(cpass))
					JOptionPane.showMessageDialog(null, "Password and Confirm Password doesn't match!");
				else
				{
					boolean b = db.insertData(name,email,pass);
					if(b==true)
					{
						JOptionPane.showMessageDialog(null, "Sign up successfull!");
						frmExpenseTracker.setVisible(false);
						login.main(null);
					}
					else
						JOptionPane.showMessageDialog(null, "Sign up unsuccessfull due to some Technical Issue!");
				}
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSignup.setBounds(441, 453, 211, 45);
		panel.add(btnSignup);
		
		JButton btnLogin = new JButton("login");
		btnLogin.setBackground(new Color(204, 204, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				login.main(null);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLogin.setBounds(527, 647, 211, 43);
		frmExpenseTracker.getContentPane().add(btnLogin);
	}

}
