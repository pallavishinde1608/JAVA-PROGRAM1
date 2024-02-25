package g;
import java.sql.*;
import java.util.*;
public class selectQueryApp {

	public static void main(String[] args)throws SQLException {
	com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
	DriverManager.registerDriver(d);
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcjuly","root","pallavi");
	if(conn!=null)
	{
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("select *from employee");
		while(rs.next())
		{
			int empid=rs.getInt("id");
			String empname=rs.getString("name");
			int empSal=rs.getInt("salary");
			System.out.println(empid+"\t"+empname+"\t"+empSal);
		}
	}
	else {
		System.out.println("database not connected");
	}

	}

}
