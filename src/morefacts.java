import java.awt.EventQueue;

import javax.swing.JFrame;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Toolkit;

public class morefacts {

	private JFrame frmExpenseTracker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					morefacts window = new morefacts();
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
	private JTable table1;
	private JTable table2;
	public void printTable1()
	{
		try {
			String q="Select sum(price) as Price,remark as Remark from expense where id=? and month(dte)=? group by remark order by price desc";
			db.stmt=db.con.prepareStatement(q);
			db.stmt.setString(1, login.getid);
			db.stmt.setString(2, db.datearr[1]+"");
			db.rs=db.stmt.executeQuery();
			table1.setModel(DbUtils.resultSetToTableModel(db.rs));
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public void printTable2()
	{
		try {
			String q="Select sum(price) as Price,remark as Remark from expense where id=? and year(dte)=? group by remark order by price desc";
			db.stmt=db.con.prepareStatement(q);
			db.stmt.setString(1, login.getid);
			db.stmt.setString(2, db.datearr[0]+"");
			db.rs=db.stmt.executeQuery();
			table2.setModel(DbUtils.resultSetToTableModel(db.rs));
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public morefacts() {
		db.connect();
		initialize();
		printTable1();
		printTable2();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExpenseTracker = new JFrame();
		frmExpenseTracker.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\compare.png"));
		frmExpenseTracker.setTitle("Expense Tracker");
		frmExpenseTracker.setResizable(false);
		frmExpenseTracker.setBounds(100, 100, 1436, 779);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExpenseTracker.getContentPane().setLayout(null);
		
		JLabel lblSomeInterestingFacts = new JLabel("Some Interesting Facts about your Expense Activity");
		lblSomeInterestingFacts.setHorizontalAlignment(SwingConstants.CENTER);
		lblSomeInterestingFacts.setForeground(new Color(0, 102, 153));
		lblSomeInterestingFacts.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblSomeInterestingFacts.setBackground(new Color(51, 204, 204));
		lblSomeInterestingFacts.setBounds(10, 10, 1402, 62);
		frmExpenseTracker.getContentPane().add(lblSomeInterestingFacts);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		panel.setBounds(32, 82, 1361, 602);
		frmExpenseTracker.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 72, 577, 237);
		panel.add(scrollPane);
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(701, 72, 577, 237);
		panel.add(scrollPane_1);
		
		table2 = new JTable();
		scrollPane_1.setViewportView(table2);
		
		JLabel lblThisMonthYou = new JLabel("This Month you spend more on");
		lblThisMonthYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisMonthYou.setForeground(new Color(0, 102, 153));
		lblThisMonthYou.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblThisMonthYou.setBackground(new Color(51, 204, 204));
		lblThisMonthYou.setBounds(56, 10, 577, 52);
		panel.add(lblThisMonthYou);
		
		JLabel lblThisYearYou = new JLabel("This Year you spend more on");
		lblThisYearYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisYearYou.setForeground(new Color(0, 102, 153));
		lblThisYearYou.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblThisYearYou.setBackground(new Color(51, 204, 204));
		lblThisYearYou.setBounds(701, 10, 577, 52);
		panel.add(lblThisYearYou);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(56, 366, 1222, 200);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblYourMonthlySpend = new JLabel("Your monthly spend average is Rs."+db.monthlyAverage());
		lblYourMonthlySpend.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourMonthlySpend.setForeground(new Color(0, 102, 153));
		lblYourMonthlySpend.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblYourMonthlySpend.setBackground(new Color(51, 204, 204));
		lblYourMonthlySpend.setBounds(10, 72, 615, 52);
		panel_1.add(lblYourMonthlySpend);
		
		JLabel lblYourDailySpend = new JLabel("Your Daily spend Average is Rs."+db.dailyAverage());
		lblYourDailySpend.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourDailySpend.setForeground(new Color(0, 102, 153));
		lblYourDailySpend.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblYourDailySpend.setBackground(new Color(51, 204, 204));
		lblYourDailySpend.setBounds(10, 10, 615, 52);
		panel_1.add(lblYourDailySpend);
		
		JLabel lblYourYearlySpend = new JLabel("This year you spent Rs."+db.spentYear());
		lblYourYearlySpend.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourYearlySpend.setForeground(new Color(0, 102, 153));
		lblYourYearlySpend.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblYourYearlySpend.setBackground(new Color(51, 204, 204));
		lblYourYearlySpend.setBounds(635, 72, 577, 52);
		panel_1.add(lblYourYearlySpend);
		
		JLabel lblThisMonthYou_1 = new JLabel("This month you spent Rs."+db.spentMonth(login.getid));
		lblThisMonthYou_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisMonthYou_1.setForeground(new Color(0, 102, 153));
		lblThisMonthYou_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblThisMonthYou_1.setBackground(new Color(51, 204, 204));
		lblThisMonthYou_1.setBounds(635, 10, 577, 52);
		panel_1.add(lblThisMonthYou_1);
		
		JLabel lblYourOverallSpend = new JLabel("Your overall daily spend average is Rs."+db.overallAverage());
		lblYourOverallSpend.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourOverallSpend.setForeground(new Color(0, 102, 153));
		lblYourOverallSpend.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblYourOverallSpend.setBackground(new Color(51, 204, 204));
		lblYourOverallSpend.setBounds(313, 134, 577, 52);
		panel_1.add(lblYourOverallSpend);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				homepage.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBackground(new Color(255, 204, 204));
		btnBack.setBounds(616, 694, 141, 38);
		frmExpenseTracker.getContentPane().add(btnBack);
	}

}
