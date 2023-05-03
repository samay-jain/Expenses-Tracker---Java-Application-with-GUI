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
import java.awt.Frame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.SystemColor;

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
		frmExpenseTracker.getContentPane().setBackground(SystemColor.menu);
		frmExpenseTracker.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmExpenseTracker.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\compare.png"));
		frmExpenseTracker.setTitle("Expense Tracker");
		frmExpenseTracker.setBounds(100, 100, 1436, 779);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSomeInterestingFacts = new JLabel("Some Interesting Facts about your Expense Activity");
		lblSomeInterestingFacts.setHorizontalAlignment(SwingConstants.CENTER);
		lblSomeInterestingFacts.setForeground(new Color(0, 102, 153));
		lblSomeInterestingFacts.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblSomeInterestingFacts.setBackground(new Color(51, 204, 204));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		
		JScrollPane scrollPane = new JScrollPane();
		
		table1 = new JTable();
		scrollPane.setViewportView(table1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		table2 = new JTable();
		scrollPane_1.setViewportView(table2);
		
		JLabel lblThisMonthYou = new JLabel("This Month you spend more on");
		lblThisMonthYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisMonthYou.setForeground(new Color(0, 102, 153));
		lblThisMonthYou.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblThisMonthYou.setBackground(new Color(51, 204, 204));
		
		JLabel lblThisYearYou = new JLabel("This Year you spend more on");
		lblThisYearYou.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisYearYou.setForeground(new Color(0, 102, 153));
		lblThisYearYou.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblThisYearYou.setBackground(new Color(51, 204, 204));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		
		JLabel lblYourMonthlySpend = new JLabel("Your monthly spend average is Rs. "+db.monthlyAverage());
		lblYourMonthlySpend.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourMonthlySpend.setForeground(new Color(0, 102, 153));
		lblYourMonthlySpend.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblYourMonthlySpend.setBackground(new Color(51, 204, 204));
		
		JLabel lblYourDailySpend = new JLabel("Your Daily spend Average is Rs. "+db.dailyAverage());
		lblYourDailySpend.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourDailySpend.setForeground(new Color(0, 102, 153));
		lblYourDailySpend.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblYourDailySpend.setBackground(new Color(51, 204, 204));
		
		JLabel lblYourYearlySpend = new JLabel("This year you spent Rs. "+db.spentYear());
		lblYourYearlySpend.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourYearlySpend.setForeground(new Color(0, 102, 153));
		lblYourYearlySpend.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblYourYearlySpend.setBackground(new Color(51, 204, 204));
		
		JLabel lblThisMonthYou_1 = new JLabel("This month you spent Rs. "+db.spentMonth(login.getid));
		lblThisMonthYou_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblThisMonthYou_1.setForeground(new Color(0, 102, 153));
		lblThisMonthYou_1.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblThisMonthYou_1.setBackground(new Color(51, 204, 204));
		
		JLabel lblYourOverallSpend = new JLabel("Your overall daily spend average is Rs. "+db.overallAverage());
		lblYourOverallSpend.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourOverallSpend.setForeground(new Color(0, 102, 153));
		lblYourOverallSpend.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblYourOverallSpend.setBackground(new Color(51, 204, 204));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.menu);
		GroupLayout groupLayout = new GroupLayout(frmExpenseTracker.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblSomeInterestingFacts, GroupLayout.DEFAULT_SIZE, 1402, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(32)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1361, Short.MAX_VALUE)
					.addGap(29))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(649)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(674))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(10)
					.addComponent(lblSomeInterestingFacts, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 602, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(5))
		);
		
		JButton btnBack = new JButton("back");
		panel_2.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				homepage.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBackground(new Color(255, 204, 204));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(56)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblThisMonthYou, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
							.addGap(68)
							.addComponent(lblThisYearYou, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
							.addGap(68)
							.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE))
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 1222, Short.MAX_VALUE))
					.addGap(83))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblThisMonthYou, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThisYearYou, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
					.addGap(57)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(lblYourDailySpend, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblThisMonthYou_1, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addComponent(lblYourMonthlySpend, GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(lblYourYearlySpend, GroupLayout.DEFAULT_SIZE, 577, Short.MAX_VALUE)
					.addGap(10))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(20)
					.addComponent(lblYourOverallSpend, GroupLayout.DEFAULT_SIZE, 1192, Short.MAX_VALUE)
					.addGap(10))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblYourDailySpend, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblThisMonthYou_1, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblYourMonthlySpend, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblYourYearlySpend, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
					.addGap(10)
					.addComponent(lblYourOverallSpend, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		frmExpenseTracker.getContentPane().setLayout(groupLayout);
	}

}
