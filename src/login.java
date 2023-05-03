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
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Frame;
import javax.swing.SpringLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.event.KeyEvent;
import javax.swing.JDesktopPane;
import java.awt.SystemColor;

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
		frmExpenseTracker.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmExpenseTracker.setMaximumSize(new Dimension(2147480000, 2147483647));
		frmExpenseTracker.setFocusTraversalPolicyProvider(true);
		frmExpenseTracker.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmExpenseTracker.getContentPane().setFocusCycleRoot(true);
		frmExpenseTracker.getContentPane().setFocusTraversalPolicyProvider(true);
		frmExpenseTracker.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\compare.png"));
		frmExpenseTracker.setTitle("Expense Tracker");
		frmExpenseTracker.getContentPane().setBackground(SystemColor.menu);
		frmExpenseTracker.setBounds(100, 100, 1174, 620);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblEmail.setBackground(Color.WHITE);
		lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		getemail = new JTextField();
		getemail.setForeground(new Color(0, 102, 153));
		getemail.setFont(new Font("Tahoma", Font.BOLD, 30));
		getemail.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setDisplayedMnemonic(KeyEvent.VK_ALT_GRAPH);
		lblPassword.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 32));
		
		getpassword = new JPasswordField();
		getpassword.setForeground(new Color(0, 102, 153));
		getpassword.setFont(new Font("Tahoma", Font.BOLD, 30));
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setAutoscrolls(true);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		GroupLayout groupLayout = new GroupLayout(frmExpenseTracker.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 1140, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(77)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(74))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(508)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addGap(505))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(25)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(17))
		);
		
		JButton btnSignup = new JButton("Sign up");
		panel_1.add(btnSignup);
		btnSignup.setBackground(new Color(204, 204, 255));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				signup.main(null);
			}
		});
		btnSignup.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 204, 204));
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 916, Short.MAX_VALUE)
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGap(0, 317, Short.MAX_VALUE)
		);
		desktopPane.setLayout(gl_desktopPane);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(71)
							.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
							.addGap(49)
							.addComponent(getemail, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(277)
							.addComponent(getpassword, GroupLayout.PREFERRED_SIZE, 638, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(451)
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(71)
							.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(44)
							.addComponent(desktopPane)))
					.addGap(49))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(94)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
						.addComponent(getemail, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
					.addGap(68)
					.addComponent(getpassword, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addGap(46)
					.addComponent(btnNewButton))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(218)
					.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(46)
					.addComponent(desktopPane)
					.addGap(37))
		);
		panel.setLayout(gl_panel);
		frmExpenseTracker.getContentPane().setLayout(groupLayout);
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
