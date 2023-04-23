import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;

public class login {

	private JFrame frmExpenseTracker;
	private JTextField getemail;
	private JPasswordField getpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	static String em,pas;
	public static String getname,getid;
	public login() {
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
		frmExpenseTracker.setBounds(100, 100, 1174, 671);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExpenseTracker.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 25, 1140, 56);
		frmExpenseTracker.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(77, 99, 1009, 417);
		frmExpenseTracker.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblEmail.setBounds(118, 92, 141, 56);
		panel.add(lblEmail);
		
		getemail = new JTextField();
		getemail.setForeground(new Color(0, 102, 153));
		getemail.setFont(new Font("Tahoma", Font.BOLD, 30));
		getemail.setBounds(320, 92, 565, 56);
		panel.add(getemail);
		getemail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblPassword.setBounds(118, 221, 192, 56);
		panel.add(lblPassword);
		
		getpassword = new JPasswordField();
		getpassword.setForeground(new Color(0, 102, 153));
		getpassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		getpassword.setBounds(320, 221, 565, 56);
		panel.add(getpassword);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setBackground(new Color(204, 204, 255));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				em = getemail.getText();
				pas = getpassword.getText();
				if(em.isEmpty() || pas.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Please enter all the required details!");
				}
				else
				{
					boolean b = db.checkCredentials(em,pas);
					if(b==true)
					{
						String details[] = db.getNameandId(em,pas);
						getname=details[0];
						getid=details[1];
						frmExpenseTracker.setVisible(false);
						homepage.main(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid email or password!");
						getemail.setText("");
						getpassword.setText("");
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnNewButton.setBounds(406, 344, 198, 37);
		panel.add(btnNewButton);
		
		JButton btnSignup = new JButton("Sign up");
		btnSignup.setBackground(new Color(204, 204, 255));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				signup.main(null);
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnSignup.setBounds(482, 554, 200, 37);
		frmExpenseTracker.getContentPane().add(btnSignup);
	}
	public static String getn()
	{
		return getname;
	}
	public static String geti()
	{
		return getid;
	}
}
