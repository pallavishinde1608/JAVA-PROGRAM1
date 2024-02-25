package g;
import java.util.*;
import java.sql.*;
public class EmployeeInfoApp {

	public static void main(String[] args)throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(d);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcjuly","root","pallavi");
		
		Statement stmt=conn.createStatement();
		if(conn!=null)
		{
			
			do {
				System.out.println("1.create table\n2.insert values");
			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter choice");
			int choice=sc.nextInt();
			switch(choice)
			
			{
			case 1:
				int value=stmt.executeUpdate("create table Employee(eid int(5),ename varchar(200),email varchar(200),esal int(5),econtact varchar(10))");
				if(value==0)
				{
					System.out.println("table created...");
				}
				else {
					System.out.println("table not created..");
				}
				break;
			case 2:
			
				for (int i = 1; i <=5; i++) {
					System.out.println("enter eid,ename,email,sal,contact");
					int eid=sc.nextInt();
					sc.nextLine();
					String ename=sc.nextLine();
					String email=sc.nextLine();
					int esal=sc.nextInt();
					sc.nextLine();
					String econtact=sc.nextLine();
					
					int value1=stmt.executeUpdate("insert into employee values("+eid+",'"+ename+"','"+email+"',"+esal+",'"+econtact+"')");
					if(value1==0)
					{
						System.out.println("insert data success...");
					}
					else {
						System.out.println("some problem is there..");
					}
				}
			
			break;
			case 3:
				ResultSet rs=stmt.executeQuery("select *from employee");
				while(rs.next())
				{
					int empid=rs.getInt("eid");
					String empname=rs.getString("ename");
					String empemail=rs.getString("email");
					int empsal=rs.getInt("esal");
					String empcontact=rs.getString("econtact");
					System.out.println(empid+"\t"+empname+"\t"+empemail+"\t"+empsal+"\t"+empcontact);
					
				}
				break;
			case 4:
				System.out.println("enter id,name,email from employee");
				int uid=sc.nextInt();
				String uname=sc.next();
				String uemail=sc.next();
				
				int value2=stmt.executeUpdate("update employee set ename='"+uname+"',email='"+uemail+"' where eid="+uid);
				if(value2>0)
				{
					System.out.println("employee updated..");
				}
				else {
					System.out.println("some problem is there..");
				}
				break;
			case 5:
				System.out.println("enter name ");
				String dname=sc.next();
				int value3=stmt.executeUpdate("delete from employee where ename='"+dname+"'");
				if(value3>0)
				{
					System.out.println("employee deleted..");
				}
				else {
					System.out.println("some problem is there..");
				}
			}
		}while(true);
		}
		else 
		{
			System.out.println("dataabase not connected");

		}
			
	}
}
