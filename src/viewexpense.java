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

public class viewexpense {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewexpense window = new viewexpense();
					window.frame.setVisible(true);
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
	public void printTable()
	{
		try {
			String q="Select eid as Expense_ID,dte as Date,price as Price,remark as Remark from expense where id=? order by dte";
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
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 204, 204));
		frame.setBounds(100, 100, 1123, 686);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblAllYourExpenses = new JLabel("All your Expenses");
		lblAllYourExpenses.setForeground(new Color(0, 0, 102));
		lblAllYourExpenses.setBackground(new Color(0, 0, 102));
		lblAllYourExpenses.setHorizontalAlignment(SwingConstants.CENTER);
		lblAllYourExpenses.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblAllYourExpenses.setBounds(10, 10, 1089, 62);
		frame.getContentPane().add(lblAllYourExpenses);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				homepage.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBackground(new Color(204, 204, 255));
		btnBack.setBounds(484, 588, 141, 51);
		frame.getContentPane().add(btnBack);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 97, 1012, 481);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setForeground(new Color(0, 102, 102));
	}
}
