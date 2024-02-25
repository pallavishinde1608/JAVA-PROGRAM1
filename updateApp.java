package g;
import java.sql.*;
import java.util.*;
public class updateApp {

	public static void main(String[] args)throws Exception {
	com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcjuly","root","pallavi");
	if(conn!=null)
	{
		Statement stmt=conn.createStatement();
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name,id and salary of employee");
		String name=sc.nextLine();
		int eId=sc.nextInt();
		int eSal=sc.nextInt();
		int value=stmt.executeUpdate("update  employee set name='"+name+"',salary="+eSal+" where id="+eId);
		if(value>0)
		{
			System.out.println("update employee record");
		}
		else {
			System.out.println("some problem is there...");
		}
	}
	else {
		System.out.println("database not connected..");
	}

	}

}
