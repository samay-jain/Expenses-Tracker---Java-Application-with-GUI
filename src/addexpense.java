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
			String q="Select dte as Date,price as Price,remark as Remark from expense where id=? order by dte";
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
		frmExpenseTracker.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Admin\\Downloads\\compare.png"));
		frmExpenseTracker.setTitle("Expense Tracker");
		frmExpenseTracker.setResizable(false);
		frmExpenseTracker.getContentPane().setBackground(new Color(255, 204, 204));
		frmExpenseTracker.setBounds(100, 100, 1115, 670);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmExpenseTracker.getContentPane().setLayout(null);
		
		JLabel lblAddExpenses = new JLabel("Add Expenses");
		lblAddExpenses.setForeground(new Color(0, 0, 102));
		lblAddExpenses.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddExpenses.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblAddExpenses.setBounds(10, 10, 1081, 62);
		frmExpenseTracker.getContentPane().add(lblAddExpenses);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 153));
		panel.setBounds(56, 400, 989, 162);
		frmExpenseTracker.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterFollowingDetails = new JLabel("Enter following details");
		lblEnterFollowingDetails.setBounds(305, 5, 378, 32);
		lblEnterFollowingDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterFollowingDetails.setForeground(new Color(0, 0, 102));
		lblEnterFollowingDetails.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblEnterFollowingDetails.setBackground(Color.WHITE);
		panel.add(lblEnterFollowingDetails);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 47, 969, 105);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(23, 10, 78, 38);
		panel_1.add(lblPrice);
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(new Color(0, 102, 153));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPrice.setBackground(Color.WHITE);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setBounds(402, 10, 116, 38);
		panel_1.add(lblRemark);
		lblRemark.setHorizontalAlignment(SwingConstants.LEFT);
		lblRemark.setForeground(new Color(0, 102, 153));
		lblRemark.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblRemark.setBackground(Color.WHITE);
		
		textprice = new JTextField();
		textprice.setHorizontalAlignment(SwingConstants.CENTER);
		textprice.setForeground(new Color(0, 153, 204));
		textprice.setFont(new Font("Tahoma", Font.BOLD, 26));
		textprice.setColumns(10);
		textprice.setBounds(108, 10, 190, 38);
		panel_1.add(textprice);
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		textdate = new JTextField();
		textdate.setText(formatter.format(date));
		//textdate.setS
		textdate.setHorizontalAlignment(SwingConstants.CENTER);
		textdate.setForeground(new Color(0, 153, 204));
		textdate.setFont(new Font("Tahoma", Font.BOLD, 26));
		textdate.setColumns(10);
		textdate.setBounds(108, 58, 190, 39);
		panel_1.add(textdate);
		
		textremark = new JTextField();
		textremark.setForeground(new Color(0, 153, 204));
		textremark.setFont(new Font("Tahoma", Font.BOLD, 26));
		textremark.setColumns(10);
		textremark.setBounds(528, 10, 431, 38);
		panel_1.add(textremark);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(23, 58, 79, 39);
		panel_1.add(lblDate);
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setForeground(new Color(0, 102, 153));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDate.setBackground(Color.WHITE);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				homepage.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBackground(new Color(204, 204, 255));
		btnBack.setBounds(388, 572, 141, 51);
		frmExpenseTracker.getContentPane().add(btnBack);
		
		JButton btnAdd = new JButton("Add");
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
		btnAdd.setBounds(562, 572, 141, 51);
		frmExpenseTracker.getContentPane().add(btnAdd);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 82, 987, 308);
		frmExpenseTracker.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}
}
