import java.awt.EventQueue;
import java.text.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.*;
import java.awt.Toolkit;
import java.awt.Frame;
import javax.swing.JDesktopPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

import java.awt.Component;
public class addexpense {

	private JFrame frmExpenseTracker;
	private JTable table;
	private JTextField textprice;
	private JTextField textdate;
	private JTextField textremark;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addexpense window = new addexpense();
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
	public void printTable()
	{
		try {
			String q="Select dte as Date,price as Price,remark as Remark from expense where id=? order by dte desc";
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
	public addexpense() {
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
		frmExpenseTracker.setBounds(100, 100, 1115, 670);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblAddExpenses = new JLabel("Add Expenses");
		lblAddExpenses.setForeground(new Color(0, 0, 102));
		lblAddExpenses.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddExpenses.setFont(new Font("Tahoma", Font.BOLD, 38));
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 204, 204));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		GroupLayout groupLayout = new GroupLayout(frmExpenseTracker.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(56)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 985, Short.MAX_VALUE)
							.addGap(2))
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 987, Short.MAX_VALUE))
					.addGap(58))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddExpenses, GroupLayout.DEFAULT_SIZE, 1081, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(458)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGap(460))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddExpenses, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(desktopPane, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(20))
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
		btnBack.setBackground(new Color(204, 204, 255));
		
		JButton btnAdd = new JButton("Add");
		panel_2.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String p = textprice.getText();
				String r = textremark.getText();
				String d = textdate.getText();
				boolean b = db.addExpense(p, r, d);
				if(b==true)
				{
					JOptionPane.showMessageDialog(null, "Expense Added Successfully!");
					printTable();
					textprice.setText("");
					textremark.setText("");
					//textdate.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "Expense can't be added due to Technical Issue!");
					printTable();
					textprice.setText("");
					textremark.setText("");
					//textdate.setText("");
				}
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnAdd.setBackground(new Color(204, 204, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 153));
		
		JLabel lblEnterFollowingDetails = new JLabel("Enter following details");
		lblEnterFollowingDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterFollowingDetails.setForeground(new Color(0, 0, 102));
		lblEnterFollowingDetails.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblEnterFollowingDetails.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(new Color(0, 102, 153));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPrice.setBackground(Color.WHITE);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setAlignmentX(Component.RIGHT_ALIGNMENT);
		lblRemark.setHorizontalAlignment(SwingConstants.LEFT);
		lblRemark.setForeground(new Color(0, 102, 153));
		lblRemark.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblRemark.setBackground(Color.WHITE);
		
		textprice = new JTextField();
		textprice.setHorizontalAlignment(SwingConstants.CENTER);
		textprice.setForeground(new Color(0, 153, 204));
		textprice.setFont(new Font("Tahoma", Font.BOLD, 26));
		textprice.setColumns(10);
		textdate = new JTextField();
		textdate.setText(formatter.format(date));
		//textdate.setS
		textdate.setHorizontalAlignment(SwingConstants.CENTER);
		textdate.setForeground(new Color(0, 153, 204));
		textdate.setFont(new Font("Tahoma", Font.BOLD, 26));
		textdate.setColumns(10);
		
		textremark = new JTextField();
		textremark.setForeground(new Color(0, 153, 204));
		textremark.setFont(new Font("Tahoma", Font.BOLD, 26));
		textremark.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setForeground(new Color(0, 102, 153));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDate.setBackground(Color.WHITE);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(28)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 924, Short.MAX_VALUE)
					.addGap(33))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 907, Short.MAX_VALUE)
					.addGap(7))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblEnterFollowingDetails, GroupLayout.DEFAULT_SIZE, 904, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(5)
					.addComponent(lblEnterFollowingDetails)
					.addGap(7)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
							.addGap(7)
							.addComponent(textprice, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(textdate, GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)))
					.addGap(104)
					.addComponent(lblRemark, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textremark, GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
					.addGap(13))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(10)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
								.addComponent(textdate, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblRemark, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
								.addComponent(textremark, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(8, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(gl_panel);
		desktopPane.setLayout(gl_desktopPane);
		frmExpenseTracker.getContentPane().setLayout(groupLayout);
		
		
		table.setFont(new Font("Segoe UI",Font.PLAIN, 18));
		table.setRowHeight(40);
		JTableHeader th = table.getTableHeader();
		th.setFont(new Font("Segoe UI", Font.BOLD, 20));
		((DefaultTableCellRenderer)table.getTableHeader().getDefaultRenderer())
	    .setHorizontalAlignment(JLabel.LEFT);
	}
}
