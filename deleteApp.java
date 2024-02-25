package g;
import java.sql.*;
import java.util.*;
public class deleteApp {

	public static void main(String[] args)throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcjuly","root","pallavi");
		if(conn!=null)
		{
			Statement stmt=conn.createStatement();
			Scanner sc=new Scanner(System.in);
			System.out.println("enter id of employee");
			int eid=sc.nextInt();
			int value=stmt.executeUpdate("delete from employee where id="+eid);
			if(value>0)
			{
				System.out.println("emlpoyee record deleted");
			}
			else {
				System.out.println("not deleted some problem is there");
			}
		}
			else {
				System.out.println("some problem is there...");
			}
		

	}

}
