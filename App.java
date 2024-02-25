package g;
import java.sql.*;
public class App {

	public static void main(String[] args)throws SQLException {
		try {
//			com.mysql.cj.jdbc.Driver d=new  com.mysql.cj.jdbc.Driver();
//			DriverManager.registerDriver(d);
			Class.forName("com.mysql.cj.jdbc.Driver");
	    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/july2023","root","pallavi");
	    if(con!=null)
	    {
	    	System.out.println("database is connected");
	    }
	    else {
	    	System.out.println("some problem is here");
	    }

		
		}catch(SQLException |ClassNotFoundException f ) {
			f.printStackTrace();
		}
	}
}
