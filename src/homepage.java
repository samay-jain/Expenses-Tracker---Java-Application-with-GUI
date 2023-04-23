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
		frmExpenseTracker.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\compare.png"));
		frmExpenseTracker.setTitle("Expense Tracker");
		frmExpenseTracker.setResizable(false);
		frmExpenseTracker.getContentPane().setBackground(new Color(255, 255, 255));
		frmExpenseTracker.setBounds(100, 100, 1389, 761);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExpenseTracker.getContentPane().setLayout(null);
		
		JLabel lblHomePage = new JLabel("Home Page");
		lblHomePage.setForeground(new Color(0, 0, 102));
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblHomePage.setBounds(10, 10, 1355, 62);
		frmExpenseTracker.getContentPane().add(lblHomePage);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		panel.setBounds(100, 100, 1165, 561);
		frmExpenseTracker.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 204, 204));
		panel_1.setBounds(10, 10, 478, 42);
		panel.add(panel_1);
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
		panel_2.setBounds(204, 62, 756, 224);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(135, 10, 487, 45);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblInterestingFactsAbout = new JLabel("Interesting Facts about you!");
		lblInterestingFactsAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblInterestingFactsAbout.setForeground(new Color(0, 102, 153));
		lblInterestingFactsAbout.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblInterestingFactsAbout.setBackground(Color.WHITE);
		lblInterestingFactsAbout.setBounds(10, 0, 467, 45);
		panel_3.add(lblInterestingFactsAbout);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 204, 204));
		panel_4.setBounds(28, 82, 699, 132);
		panel_2.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblYouHaveSpent = new JLabel("You have spent Rs."+db.spentMonth(login.getid)+" in this Month!");
		lblYouHaveSpent.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveSpent.setForeground(new Color(255, 0, 102));
		lblYouHaveSpent.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblYouHaveSpent.setBackground(Color.WHITE);
		lblYouHaveSpent.setBounds(10, 10, 679, 45);
		panel_4.add(lblYouHaveSpent);
		
		JLabel lblYouHaveSpent_1 = new JLabel("Overall you have spent Rs."+db.spentOverall(login.getid)+" till now!");
		lblYouHaveSpent_1.setBounds(10, 77, 679, 45);
		panel_4.add(lblYouHaveSpent_1);
		lblYouHaveSpent_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblYouHaveSpent_1.setForeground(new Color(255, 0, 102));
		lblYouHaveSpent_1.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblYouHaveSpent_1.setBackground(Color.WHITE);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 204, 204));
		panel_5.setBounds(69, 320, 1031, 204);
		panel.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblPerformOperations = new JLabel("Perform Operations");
		lblPerformOperations.setBounds(326, 5, 378, 32);
		lblPerformOperations.setHorizontalAlignment(SwingConstants.CENTER);
		lblPerformOperations.setForeground(new Color(0, 102, 153));
		lblPerformOperations.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPerformOperations.setBackground(Color.WHITE);
		panel_5.add(lblPerformOperations);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBounds(39, 46, 957, 130);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Expense");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				addexpense.main(null);
			}
		});
		btnNewButton.setBackground(new Color(255, 153, 153));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnNewButton.setBounds(44, 41, 195, 46);
		panel_6.add(btnNewButton);
		
		JButton btnDeleteExpense = new JButton("Delete Expense");
		btnDeleteExpense.setBackground(new Color(255, 153, 153));
		btnDeleteExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				deleteexpense.main(null);
			}
		});
		btnDeleteExpense.setFont(new Font("Tahoma", Font.BOLD, 21));
		btnDeleteExpense.setBounds(277, 41, 195, 46);
		panel_6.add(btnDeleteExpense);
		
		JButton btnViewExpense = new JButton("View Expense");
		btnViewExpense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				viewexpense.main(null);
			}
		});
		btnViewExpense.setBackground(new Color(255, 153, 153));
		btnViewExpense.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnViewExpense.setBounds(508, 41, 195, 46);
		panel_6.add(btnViewExpense);
		
		JButton btnNewButton_3 = new JButton("More Facts");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				morefacts.main(null);
			}
		});
		btnNewButton_3.setBackground(new Color(255, 153, 153));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton_3.setBounds(733, 41, 195, 46);
		panel_6.add(btnNewButton_3);
		
		JButton btnLogOut = new JButton("log out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				login.main(null);
			}
		});
		btnLogOut.setBounds(615, 676, 141, 37);
		frmExpenseTracker.getContentPane().add(btnLogOut);
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLogOut.setBackground(new Color(255, 204, 204));
	}
}
