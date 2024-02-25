package g;
import java.sql.*;
import java.util.Scanner;
public class InsertApp {

	public static void main(String[] args)throws SQLException {
	
			com.mysql.cj.jdbc.Driver d=new  com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
	 
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcjuly","root","pallavi");
	    if(con!=null)
	    {
	    	System.out.println("database is connected");
	    	Statement stmt=con.createStatement();
	    	Scanner sc=new Scanner(System.in);
	    	System.out.println("enter name,id,salary");
	    	String name=sc.nextLine();
	    	int id=sc.nextInt();
	    	int salary=sc.nextInt();
	    	int value=stmt.executeUpdate("insert into employee values("+id+",'"+name+"',"+salary+")");
	    	if(value>0)
	    	{
	    		System.out.println("record save success..");
	    	}
	    	else {
	    		System.out.println("some problem is there...");
	    	}
	    }
	    else {
	    	System.out.println("some problem is here");
	    }
	}
}
