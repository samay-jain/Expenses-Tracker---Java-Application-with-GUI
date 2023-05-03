import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import net.proteanit.sql.DbUtils;

import java.text.*;
import java.time.LocalDate;
public class DB 
{
	static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	static Date date = new Date();
	public String datearr[] = formatter.format(date).split("-");
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	public void connect()
	{
		try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/project";
            String username = "root";
            String password = "Samayj04@";
            con = DriverManager.getConnection(url,username,password);
        }
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public boolean checkCredentials(String email,String password)
	{
		try {
			String pas="";
			String q = "select password from details where email=?";
			stmt = con.prepareStatement(q);
			stmt.setString(1, email);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				pas = rs.getString(1);
			}
			if(password.equals(pas))
				return true;
			return false;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public String[] getNameandId(String email,String password)
	{
		String arr[] = new String[2];
		try {
			String q="select name,id from details where email=? and password=?";
			stmt=con.prepareStatement(q);
			stmt.setString(1, email);
			stmt.setString(2, password);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				arr[0]=rs.getString(1);
				arr[1]=rs.getString(2);
			}
			return arr;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return arr;
		}
	}
	public boolean insertData(String name,String email,String pass)
	{
		try {
			String q="Insert into details(name,email,password) values(?,?,?)";
			stmt = con.prepareStatement(q);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, pass);
			stmt.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public int spentMonth(String id)
	{
		int spent=0;
		try {
			String q="select sum(price) from expense where id=? and month(dte)=?";
			stmt = con.prepareStatement(q);
			stmt.setString(1, id);
			stmt.setString(2, datearr[1]);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				spent=rs.getInt(1);
			}
			return spent;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	public int spentOverall(String id)
	{
		int spent=0;
		try {
			String q="select sum(price) from expense where id=?";
			stmt = con.prepareStatement(q);
			stmt.setString(1, id);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				spent=rs.getInt(1);
			}
			return spent;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	public boolean addExpense(String price,String remark,String date)
	{
		try {
			String q="insert into expense(id,dte,price,remark) values(?,?,?,?)";
			stmt = con.prepareStatement(q);
			stmt.setString(1, login.getid);
			stmt.setString(2, date);
			stmt.setString(3, price);
			stmt.setString(4, remark);
			stmt.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public boolean deleteExpense(String eid)
	{
		try {
			String q="delete from expense where eid=? and id=?";
			stmt = con.prepareStatement(q);
			stmt.setString(1, eid);
			stmt.setString(2, login.getid);
			stmt.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	public String dailyAverage()
	{
		try {
			String avg="";
			String q="select sum(price) from expense where id=? and month(dte)=?";
			stmt = con.prepareStatement(q);
			stmt.setString(1, login.getid);
			stmt.setString(2, datearr[1]+"");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				avg = rs.getString(1);
			}
			double div = Integer.parseInt(avg);
			div = (double)(div/Integer.parseInt(datearr[2]));
			avg=div+"";
			return avg;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1+"";
	}
	public String monthlyAverage()
	{
		try {
			String avg="";
			String q="select sum(price) from expense where id=? and year(dte)=?";
			stmt = con.prepareStatement(q);
			stmt.setString(1, login.getid);
			stmt.setString(2, datearr[0]+"");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				avg = rs.getString(1);
			}
			double div = Integer.parseInt(avg);
			div = (double)(div/Integer.parseInt(datearr[1]));
			avg = div+"";
			return avg;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1+"";
	}
	public String overallAverage()
	{
		
		long days = daysConverter();
		int sum = spentOverall(login.getid);
		double avg = (double)(sum/days);
		return String.valueOf(avg);
		/*try {
			String avg="";
			String q="select avg(price) from expense where id=?";
			stmt = con.prepareStatement(q);
			stmt.setString(1, login.getid);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				avg = rs.getString(1);
			}
			return avg;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1+"";*/
//		double s = spentOverall(login.getid);
//		int diff = Integer.parseInt(datediff());
//		System.out.println(s+" "+diff);
//		return "abc";
		
	}
	public long daysConverter()
	{
		try {
			String q="select dte from expense where id=? order by dte limit 1";
			stmt = con.prepareStatement(q);
			stmt.setString(1, login.getid);
			rs = stmt.executeQuery();
			String date1="";
			while(rs.next())
			{
				date1=rs.getString(1);
			}
			//String date2=formatter.format(date);
			//@SuppressWarnings("deprecation")
			//LocalDate d1 = LocalDate.parse(date1); 
			Date d1 = formatter.parse(date1);
			long time_difference = date.getTime() - d1.getTime();  
            long days = TimeUnit.MILLISECONDS.toDays(time_difference) % 365; 
            //System.out.println(days);
            days+=1;
			return days;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return -1;
		}
	}
	public String spentYear()
	{
		try {
			String sum="";
			String q="select sum(price) from expense where id=? and year(dte)=?";
			stmt = con.prepareStatement(q);
			stmt.setString(1, login.getid);
			stmt.setString(2, datearr[0]+"");
			rs = stmt.executeQuery();
			while(rs.next())
			{
				sum = rs.getString(1);
			}
			return sum;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return -1+"";
	}
}
