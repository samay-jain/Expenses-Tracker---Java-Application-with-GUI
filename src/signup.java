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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JDesktopPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Frame;
import java.awt.SystemColor;

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
		frmExpenseTracker.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmExpenseTracker.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\compare.png"));
		frmExpenseTracker.setTitle("Expense Tracker");
		frmExpenseTracker.getContentPane().setBackground(SystemColor.menu);
		frmExpenseTracker.setBounds(100, 100, 1281, 740);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSignUpPage = new JLabel("Signup Page");
		lblSignUpPage.setForeground(new Color(0, 0, 102));
		lblSignUpPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUpPage.setFont(new Font("Tahoma", Font.BOLD, 38));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		
		JLabel lblEnterTheFollowing = new JLabel("Enter the following details");
		lblEnterTheFollowing.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterTheFollowing.setFont(new Font("Tahoma", Font.BOLD, 28));
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		getname = new JTextField();
		getname.setForeground(new Color(0, 102, 153));
		getname.setFont(new Font("Tahoma", Font.BOLD, 24));
		getname.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		getemail = new JTextField();
		getemail.setForeground(new Color(0, 102, 153));
		getemail.setFont(new Font("Tahoma", Font.BOLD, 24));
		getemail.setColumns(10);
		
		getpassword = new JTextField();
		getpassword.setForeground(new Color(0, 102, 153));
		getpassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		getpassword.setColumns(10);
		
		confirmpassword = new JPasswordField();
		confirmpassword.setForeground(new Color(0, 102, 153));
		confirmpassword.setFont(new Font("Tahoma", Font.BOLD, 24));
		confirmpassword.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		GroupLayout groupLayout = new GroupLayout(frmExpenseTracker.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblSignUpPage, GroupLayout.DEFAULT_SIZE, 1247, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(84)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1096, Short.MAX_VALUE)
					.addGap(87))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(557)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
					.addGap(589))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(lblSignUpPage, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(33))
		);
		
		JButton btnLogin = new JButton("login");
		panel_2.add(btnLogin);
		btnLogin.setBackground(new Color(204, 204, 255));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				login.main(null);
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 204, 204));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(127)
					.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addComponent(getname, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(127)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(127)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(127)
					.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(confirmpassword, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(266)
					.addComponent(getpassword, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(lblEnterTheFollowing, GroupLayout.DEFAULT_SIZE, 1076, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(266)
					.addComponent(getemail, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(41)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 1019, Short.MAX_VALUE)
					.addGap(36))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(138)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblName, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(getname, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
					.addGap(31)
					.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(40)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(31)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblConfirmPassword, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(confirmpassword, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(302)
					.addComponent(getpassword, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(lblEnterTheFollowing, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(214)
					.addComponent(getemail, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(33)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
					.addGap(19))
		);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(432)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(462))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addContainerGap(425, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		
		JButton btnSignup = new JButton("signup");
		panel_1.add(btnSignup);
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
		desktopPane.setLayout(gl_desktopPane);
		panel.setLayout(gl_panel);
		frmExpenseTracker.getContentPane().setLayout(groupLayout);
	}
}
