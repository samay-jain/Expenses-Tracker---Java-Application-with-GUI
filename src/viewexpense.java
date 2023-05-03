import java.awt.EventQueue;

import javax.swing.JFrame;

import net.proteanit.sql.DbUtils;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Frame;

public class viewexpense {

	private JFrame frmExpenseTracker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewexpense window = new viewexpense();
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
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel panel;
	public void printTable()
	{
		try {
			String q="Select eid as Expense_ID,dte as Date,price as Price,remark as Remark from expense where id=? order by dte desc";
			db.stmt=db.con.prepareStatement(q);
			db.stmt.setString(1, login.getid);
			db.rs=db.stmt.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(db.rs));
		}
		catch(Exception e2)
		{
			e2.printStackTrace();
		}
	}
	public viewexpense() {
		db.connect();
		initialize();
		printTable();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmExpenseTracker = new JFrame();
		frmExpenseTracker.setExtendedState(Frame.MAXIMIZED_BOTH);
		frmExpenseTracker.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\compare.png"));
		frmExpenseTracker.setTitle("Expense Tracker");
		frmExpenseTracker.getContentPane().setBackground(new Color(255, 204, 204));
		frmExpenseTracker.setBounds(100, 100, 1123, 686);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAllYourExpenses = new JLabel("All your Expenses");
		lblAllYourExpenses.setForeground(new Color(0, 0, 102));
		lblAllYourExpenses.setBackground(new Color(0, 0, 102));
		lblAllYourExpenses.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllYourExpenses.setFont(new Font("Tahoma", Font.BOLD, 38));
		
		scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(new Color(0, 102, 102));
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 204, 204));
		GroupLayout groupLayout = new GroupLayout(frmExpenseTracker.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAllYourExpenses, GroupLayout.DEFAULT_SIZE, 1089, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(493)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
					.addGap(507))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(48)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
					.addGap(49))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAllYourExpenses, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(22))
		);
		
		JButton btnBack = new JButton("back");
		panel.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				homepage.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBackground(new Color(204, 204, 255));
		frmExpenseTracker.getContentPane().setLayout(groupLayout);
	}
}
