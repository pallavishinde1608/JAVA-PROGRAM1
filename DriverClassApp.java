package g;

import java.sql.*;


public class DriverClassApp {

	public static void main(String[] args)throws SQLException {
		
		com.mysql.cj.jdbc.Driver d=new  com.mysql.cj.jdbc.Driver();
			DriverManager.registerDriver(d);
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","pallavi");
	    if(con!=null)
	    {
	    	System.out.println("database is connected");
	    }
	    else {
	    	System.out.println("some problem is here");
	    }
			
		
	}
}
