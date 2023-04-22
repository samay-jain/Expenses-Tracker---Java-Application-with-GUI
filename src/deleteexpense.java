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

public class deleteexpense {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteexpense window = new deleteexpense();
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
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(255, 204, 204));
		frame.setBounds(100, 100, 1390, 769);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDeleteExpense = new JLabel("Delete Expense");
		lblDeleteExpense.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteExpense.setForeground(new Color(0, 0, 102));
		lblDeleteExpense.setFont(new Font("Tahoma", Font.BOLD, 38));
		lblDeleteExpense.setBackground(new Color(0, 0, 0));
		lblDeleteExpense.setBounds(10, 22, 1356, 62);
		frame.getContentPane().add(lblDeleteExpense);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(61, 102, 1252, 330);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBackground(new Color(204, 204, 255));
		table.setForeground(new Color(0, 102, 153));
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				homepage.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnBack.setBackground(new Color(204, 204, 255));
		btnBack.setBounds(534, 671, 141, 51);
		frame.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 153, 153));
		panel.setBounds(61, 442, 1252, 219);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblEnterFollowingDetails = new JLabel("Enter following details");
		lblEnterFollowingDetails.setBounds(394, 0, 464, 44);
		lblEnterFollowingDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterFollowingDetails.setForeground(new Color(51, 0, 102));
		lblEnterFollowingDetails.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblEnterFollowingDetails.setBackground(new Color(0, 102, 102));
		panel.add(lblEnterFollowingDetails);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(10, 52, 1232, 157);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(new Color(0, 102, 153));
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblPrice.setBackground(Color.WHITE);
		lblPrice.setBounds(33, 72, 78, 38);
		panel_1.add(lblPrice);
		
		textprice = new JTextField();
		textprice.setEditable(false);
		textprice.setHorizontalAlignment(SwingConstants.CENTER);
		textprice.setForeground(new Color(0, 153, 204));
		textprice.setFont(new Font("Tahoma", Font.BOLD, 26));
		textprice.setColumns(10);
		textprice.setBounds(121, 72, 147, 38);
		panel_1.add(textprice);
		
		JLabel lblEnterExpenseId = new JLabel("Enter Expense ID");
		lblEnterExpenseId.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnterExpenseId.setForeground(new Color(0, 102, 153));
		lblEnterExpenseId.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblEnterExpenseId.setBackground(Color.WHITE);
		lblEnterExpenseId.setBounds(415, 10, 254, 38);
		panel_1.add(lblEnterExpenseId);
		
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
		texteid.setBounds(679, 10, 137, 38);
		panel_1.add(texteid);
		
		JLabel lblRemark = new JLabel("Remark");
		lblRemark.setHorizontalAlignment(SwingConstants.LEFT);
		lblRemark.setForeground(new Color(0, 102, 153));
		lblRemark.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblRemark.setBackground(Color.WHITE);
		lblRemark.setBounds(479, 72, 115, 38);
		panel_1.add(lblRemark);
		
		textremark = new JTextField();
		textremark.setEditable(false);
		textremark.setHorizontalAlignment(SwingConstants.CENTER);
		textremark.setForeground(new Color(0, 153, 204));
		textremark.setFont(new Font("Tahoma", Font.BOLD, 26));
		textremark.setColumns(10);
		textremark.setBounds(604, 72, 147, 38);
		panel_1.add(textremark);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setForeground(new Color(0, 102, 153));
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblDate.setBackground(Color.WHITE);
		lblDate.setBounds(926, 72, 88, 38);
		panel_1.add(lblDate);
		
		textdate = new JTextField();
		textdate.setEditable(false);
		textdate.setHorizontalAlignment(SwingConstants.CENTER);
		textdate.setForeground(new Color(0, 153, 204));
		textdate.setFont(new Font("Tahoma", Font.BOLD, 26));
		textdate.setColumns(10);
		textdate.setBounds(1020, 72, 166, 38);
		panel_1.add(textdate);
		
		JButton btnDelete = new JButton("Delete");
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
		btnDelete.setBounds(705, 671, 141, 51);
		frame.getContentPane().add(btnDelete);
	}
}
