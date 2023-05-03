import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Frame;
import java.awt.SystemColor;

public class homepage {

	private JFrame frmExpenseTracker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					homepage window = new homepage();
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
	public homepage() {
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
		frmExpenseTracker.setBounds(100, 100, 1389, 761);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setForeground(new Color(0, 0, 102));
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setFont(new Font("Tahoma", Font.BOLD, 38));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setLayout(null);
		
		JLabel lbname = new JLabel("Name - "+login.getname);
		lbname.setForeground(new Color(0, 102, 153));
		lbname.setBounds(10, 0, 468, 42);
		panel_1.add(lbname);
		lbname.setHorizontalAlignment(SwingConstants.LEFT);
		lbname.setFont(new Font("Tahoma", Font.BOLD, 26));
		lbname.setBackground(new Color(255, 255, 255));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 255));
		
		JPanel panel_3 = new JPanel();
		
		JLabel lblInterestingFactsAbout = new JLabel("Interesting Facts about you!");
		lblInterestingFactsAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterestingFactsAbout.setForeground(new Color(0, 102, 153));
		lblInterestingFactsAbout.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblInterestingFactsAbout.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 204, 204));
		
		JLabel lblYouHaveSpent = new JLabel("You have spent Rs."+db.spentMonth(login.getid)+" in this Month!");
		lblYouHaveSpent.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveSpent.setForeground(new Color(255, 0, 102));
		lblYouHaveSpent.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblYouHaveSpent.setBackground(Color.WHITE);
		
		JLabel lblYouHaveSpent_1 = new JLabel("Overall you have spent Rs."+db.spentOverall(login.getid)+" till now!");
		lblYouHaveSpent_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveSpent_1.setForeground(new Color(255, 0, 102));
		lblYouHaveSpent_1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblYouHaveSpent_1.setBackground(Color.WHITE);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 204, 204));
		
		JLabel lblPerformOperations = new JLabel("Perform Operations");
		lblPerformOperations.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerformOperations.setForeground(new Color(0, 102, 153));
		lblPerformOperations.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPerformOperations.setBackground(Color.WHITE);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		
		JButton btnNewButton = new JButton("Add Expense");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				addexpense.main(null);
			}
		});
		btnNewButton.setBackground(new Color(255, 153, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JButton btnDeleteExpense = new JButton("Delete Expense");
		btnDeleteExpense.setBackground(new Color(255, 153, 153));
		btnDeleteExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				deleteexpense.main(null);
			}
		});
		btnDeleteExpense.setFont(new Font("Tahoma", Font.BOLD, 21));
		
		JButton btnViewExpense = new JButton("View Expense");
		btnViewExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				viewexpense.main(null);
			}
		});
		btnViewExpense.setBackground(new Color(255, 153, 153));
		btnViewExpense.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JButton btnNewButton_3 = new JButton("More Facts");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				morefacts.main(null);
			}
		});
		btnNewButton_3.setBackground(new Color(255, 153, 153));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.menu);
		GroupLayout groupLayout = new GroupLayout(frmExpenseTracker.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(73)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(27)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1165, Short.MAX_VALUE)
							.addGap(29))
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 1221, Short.MAX_VALUE))
					.addGap(81))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHomePage, GroupLayout.DEFAULT_SIZE, 1355, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblHomePage, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(11)
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
							.addGap(14))
						.addComponent(panel_7, GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE))
					.addGap(51))
		);
		GroupLayout gl_panel_7 = new GroupLayout(panel_7);
		gl_panel_7.setHorizontalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1221, Short.MAX_VALUE)
		);
		gl_panel_7.setVerticalGroup(
			gl_panel_7.createParallelGroup(Alignment.LEADING)
				.addGap(0, 616, Short.MAX_VALUE)
		);
		panel_7.setLayout(gl_panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.menu);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(102, 204, 255));
		
		JButton btnLogOut = new JButton("log out");
		panel_9.add(btnLogOut);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				login.main(null);
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnLogOut.setBackground(new Color(255, 204, 204));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(58)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(11)
							.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE)
							.addGap(11))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(158)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 756, Short.MAX_VALUE)
							.addGap(139))
						.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 1053, Short.MAX_VALUE))
					.addGap(54))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(531)
					.addComponent(panel_9, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
					.addGap(503))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 42, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(246)
							.addComponent(panel_5, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
							.addGap(10))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(12)
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(224))
						.addComponent(panel_8, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6))
		);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(326)
					.addComponent(lblPerformOperations, GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
					.addGap(327))
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(39)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 957, Short.MAX_VALUE)
					.addGap(35))
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_5.createSequentialGroup()
					.addGap(5)
					.addComponent(lblPerformOperations)
					.addGap(9)
					.addComponent(panel_6, GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
					.addGap(28))
		);
		GroupLayout gl_panel_6 = new GroupLayout(panel_6);
		gl_panel_6.setHorizontalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(44)
					.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(38)
					.addComponent(btnDeleteExpense, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(36)
					.addComponent(btnViewExpense, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(30)
					.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
					.addGap(29))
		);
		gl_panel_6.setVerticalGroup(
			gl_panel_6.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_6.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_panel_6.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addComponent(btnDeleteExpense, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addComponent(btnViewExpense, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
						.addComponent(btnNewButton_3, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
					.addGap(43))
		);
		panel_6.setLayout(gl_panel_6);
		panel_5.setLayout(gl_panel_5);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(135)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
					.addGap(134))
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(28)
					.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
					.addGap(29))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.LEADING)
						.addComponent(lblYouHaveSpent, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE)
						.addComponent(lblYouHaveSpent_1, GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))
					.addGap(10))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(10)
					.addComponent(lblYouHaveSpent, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addGap(22)
					.addComponent(lblYouHaveSpent_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
		);
		panel_4.setLayout(gl_panel_4);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addGap(10)
					.addComponent(lblInterestingFactsAbout, GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addComponent(lblInterestingFactsAbout, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
		);
		panel_3.setLayout(gl_panel_3);
		panel_2.setLayout(gl_panel_2);
		GroupLayout gl_panel_8 = new GroupLayout(panel_8);
		gl_panel_8.setHorizontalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1053, Short.MAX_VALUE)
		);
		gl_panel_8.setVerticalGroup(
			gl_panel_8.createParallelGroup(Alignment.LEADING)
				.addGap(0, 460, Short.MAX_VALUE)
		);
		panel_8.setLayout(gl_panel_8);
		panel.setLayout(gl_panel);
		frmExpenseTracker.getContentPane().setLayout(groupLayout);
	}
}
