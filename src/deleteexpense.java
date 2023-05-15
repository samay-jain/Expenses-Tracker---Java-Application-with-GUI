import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.awt.Toolkit;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.JDesktopPane;
import java.awt.Frame;
import java.awt.SystemColor;

public class deleteexpense {

	private JFrame frmExpenseTracker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteexpense window = new deleteexpense();
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
	private JTable table;
	private JTextField textprice;
	private JTextField texteid;
	private JTextField textremark;
	private JTextField textdate;
	public deleteexpense() {
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
		frmExpenseTracker.setBounds(100, 100, 1390, 769);
		frmExpenseTracker.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblDeleteExpense = new JLabel("Delete Expense");
		lblDeleteExpense.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteExpense.setForeground(new Color(0, 0, 102));
		lblDeleteExpense.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblDeleteExpense.setBackground(new Color(0, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(204, 204, 255));
		table.setForeground(new Color(0, 102, 153));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(new Color(255, 204, 204));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 204, 204));
		GroupLayout groupLayout = new GroupLayout(frmExpenseTracker.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(61)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(desktopPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1249, Short.MAX_VALUE)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1249, Short.MAX_VALUE))
					.addGap(66))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(578)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 231, Short.MAX_VALUE)
					.addGap(567))
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDeleteExpense, GroupLayout.DEFAULT_SIZE, 1356, Short.MAX_VALUE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblDeleteExpense, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 333, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(desktopPane, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		
		JButton btnBack = new JButton("Back");
		panel_2.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmExpenseTracker.setVisible(false);
				homepage.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBackground(new Color(204, 204, 255));
		
		JButton btnDelete = new JButton("Delete");
		panel_2.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eid=texteid.getText();
				String price=textprice.getText();
				if(eid.isEmpty() || price.isEmpty())
				{
					JOptionPane.showMessageDialog(null, "please enter valid expense id!");
				}
				else
				{
					boolean b=db.deleteExpense(eid);
					if(b)
					{
						JOptionPane.showMessageDialog(null, "Expense deleted successfully!");
						printTable();
						texteid.setText("");
						textprice.setText("");
						textremark.setText("");
						textdate.setText("");
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Expense can't be deleted due to some Technical Issue!");
						printTable();
						texteid.setText("");
						textprice.setText("");
						textremark.setText("");
						textdate.setText("");
					}
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnDelete.setBackground(new Color(204, 204, 255));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 153));
		
		JLabel lblEnterFollowingDetails = new JLabel("Enter following details");
		lblEnterFollowingDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterFollowingDetails.setForeground(new Color(51, 0, 102));
		lblEnterFollowingDetails.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblEnterFollowingDetails.setBackground(new Color(0, 102, 102));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.menu);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(new Color(0, 102, 153));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPrice.setBackground(Color.WHITE);
		
		textprice = new JTextField();
		textprice.setEditable(false);
		textprice.setHorizontalAlignment(SwingConstants.CENTER);
		textprice.setForeground(new Color(0, 153, 204));
		textprice.setFont(new Font("Tahoma", Font.BOLD, 26));
		textprice.setColumns(10);
		
		JLabel lblEnterExpenseId = new JLabel("Enter Expense ID");
		lblEnterExpenseId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterExpenseId.setForeground(new Color(0, 102, 153));
		lblEnterExpenseId.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblEnterExpenseId.setBackground(Color.WHITE);
		
		texteid = new JTextField();
		texteid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String id = texteid.getText();
				String q = "select price,remark,dte from expense where eid=? and id=?";
				try {
						db.stmt = db.con.prepareStatement(q);
						db.stmt.setString(1, id);
						db.stmt.setString(2, login.getid);
						db.rs = db.stmt.executeQuery();
						if(db.rs.next()==true)
						{
							String price=db.rs.getString(1);
							String remark=db.rs.getString(2);
							String date=db.rs.getString(3);
							textprice.setText(price);
							textremark.setText(remark);
							textdate.setText(date);
						}
						else
						{
							texteid.setText("");
							textprice.setText("");
							textremark.setText("");
							textdate.setText("");
						}
				}
				catch(Exception e3)
				{
					e3.printStackTrace();
				}
			}
		});
		texteid.setHorizontalAlignment(SwingConstants.CENTER);
		texteid.setForeground(new Color(0, 153, 204));
		texteid.setFont(new Font("Tahoma", Font.BOLD, 26));
		texteid.setColumns(10);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setHorizontalAlignment(SwingConstants.LEFT);
		lblRemark.setForeground(new Color(0, 102, 153));
		lblRemark.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblRemark.setBackground(Color.WHITE);
		
		textremark = new JTextField();
		textremark.setEditable(false);
		textremark.setHorizontalAlignment(SwingConstants.CENTER);
		textremark.setForeground(new Color(0, 153, 204));
		textremark.setFont(new Font("Tahoma", Font.BOLD, 26));
		textremark.setColumns(10);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setForeground(new Color(0, 102, 153));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDate.setBackground(Color.WHITE);
		
		textdate = new JTextField();
		textdate.setEditable(false);
		textdate.setHorizontalAlignment(SwingConstants.CENTER);
		textdate.setForeground(new Color(0, 153, 204));
		textdate.setFont(new Font("Tahoma", Font.BOLD, 26));
		textdate.setColumns(10);
		GroupLayout gl_desktopPane = new GroupLayout(desktopPane);
		gl_desktopPane.setHorizontalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(21)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 1206, Short.MAX_VALUE)
					.addGap(22))
		);
		gl_desktopPane.setVerticalGroup(
			gl_desktopPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_desktopPane.createSequentialGroup()
					.addGap(10)
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
					.addGap(14))
		);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1186, Short.MAX_VALUE)
						.addComponent(lblEnterFollowingDetails, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 1186, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblEnterFollowingDetails, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(415)
					.addComponent(lblEnterExpenseId, GroupLayout.PREFERRED_SIZE, 240, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(texteid, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(320, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(33)
					.addComponent(lblPrice, GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(textprice, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addGap(211)
					.addComponent(lblRemark, GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
					.addGap(10)
					.addComponent(textremark, GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
					.addGap(142)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblDate, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
							.addGap(158))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(80)
							.addComponent(textdate, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)))
					.addGap(47))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(10)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblEnterExpenseId, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(texteid, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblPrice, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(textprice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblRemark, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(textremark, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
						.addComponent(textdate, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
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
