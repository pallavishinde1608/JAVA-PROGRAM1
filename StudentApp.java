package g;
import java.util.*;
import java.sql.*;
public class StudentApp {

	public static void main(String[] args)throws SQLException {
		com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
        DriverManager.registerDriver(d);
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcjuly","root","pallavi");
        if(conn!=null)
        {
        	Scanner sc=new Scanner(System.in);
        	do {
        		System.out.println("1.create table\n2.insert value\n3.display records\n4.display name,email,contact\n5.dislpay distinct name\n6.delete student from id\n7.delete student from id,name\n8.update student from id\n9.update student from id,name");
        		System.out.println("enter choice");
        		int choice=sc.nextInt();
        		switch(choice)
        		{
        		case 1:
        			PreparedStatement pstmt=conn.prepareStatement("create table Student(sid int(5),sname varchar(200),semail varchar(200),sAddress varchar(200),scontact int(10))");
        			int value=pstmt.executeUpdate();
        			if(value==0)
        			{
        				System.out.println("table created.......");
        			}
        			else {
        				System.out.println("table not created.......");
        			}
        			break;
        			
        		case 2:
        			System.out.println("enter id,name,email,address,contact");
        			int id=sc.nextInt();
        			String name=sc.next();
        			String email=sc.next();
        			String address=sc.next();
        		    sc.nextLine();
        			int contact=sc.nextInt();
        			PreparedStatement pstmt1=conn.prepareStatement("insert into Student Values(?,?,?,?,?)");
        			pstmt1.setInt(1,id);
        			pstmt1.setString(2,name);
        			pstmt1.setString(3, email);
        			pstmt1.setString(4, address);
        			pstmt1.setInt(5, contact);
        			int value1=pstmt1.executeUpdate();
        			if(value1>0)
        			{
        				System.out.println("student added sussessfully.......");
        			}
        			else {
        				System.out.println("some problem is there..........");
        			}
        			break;
        		case 3:
        			PreparedStatement pstmt2=conn.prepareStatement("select *from Student");
        			
        			ResultSet rs=pstmt2.executeQuery();
        			while(rs.next())
    				{
    					int sid=rs.getInt(1);
    					String sname=rs.getString(2);
    					String semail=rs.getString(3);
    					String saddress=rs.getString(4);
    					int scontact=rs.getInt(5);
    					System.out.println(sid+"\t"+sname+"\t"+semail+"\t"+saddress+"\t"+scontact);
    					
    				}
        			break;
        		case 4:
        			PreparedStatement pstmt3=conn.prepareStatement("select sname,semail,scontact from Student");
        			
        			ResultSet rs1=pstmt3.executeQuery();
        			while(rs1.next())
    				{
    				
    					String sname1=rs1.getString(1);
    					String semail1=rs1.getString(2);
    					int scontact1=rs1.getInt(3);
    					System.out.println(sname1+"\t"+semail1+"\t"+scontact1);
    				}
        			
        			break;
        		case 5:
                    PreparedStatement pstmt4=conn.prepareStatement("select distinct sname from Student");
        			
        			ResultSet rs2=pstmt4.executeQuery();
        			while(rs2.next())
    				{
    				
    					String sname2=rs2.getString(1);
    				
        			System.out.println(sname2);
    				}
        			break;
        		case 6:
        			System.out.println("enter id to deleted........");
        			int did=sc.nextInt();
        			PreparedStatement pstmt5=conn.prepareStatement("delete from Student where sid=?");
        			pstmt5.setInt(1,did);
        			int value4=pstmt5.executeUpdate();
        			if(value4>0)
        			{
        				System.out.println("student deleted.........");
        			}
        			else {
        				System.out.println("some problem is there.......");
        			}
        			break;
        		case 7:
        
        			System.out.println("enter id,name to deleted.......");
        			int did1=sc.nextInt();
        			String dname=sc.next();
        			PreparedStatement pstmt6=conn.prepareStatement("delete from Student where sid=? and sname=?");
        			pstmt6.setInt(1,did1);
        			pstmt6.setString(2, dname);
        			int value5=pstmt6.executeUpdate();
        			if(value5>0)
        			{
        				System.out.println("student deleted........");
        			}
        			else {
        				System.out.println("some problem is there.........");
        			}
        			break;
        		case 8:
        			
//        		
        			System.out.println("enter id,name,email,address from employee");
    				int uid=sc.nextInt();
    				String uname=sc.next();
    				String uemail=sc.next();
    				int ucontact=sc.nextInt();
        			PreparedStatement pstmt7=conn.prepareStatement("update Student set sname=?,semail=?,scontact=? where sid=?");
        			pstmt7.setString(1,uname);
        			pstmt7.setString(2, uemail);
        			pstmt7.setInt(3,ucontact);
        			pstmt7.setInt(4, uid);

        			int value6=pstmt7.executeUpdate();
        			if(value6>0)
        			{
        				System.out.println("record updated........");
        			}
        			else {
        				System.out.println("some problem is there........");
        			}
        			
        			break;		
        		case 9:
        			System.out.println("enter id,name,email,address,contact from employee");		
        			    
        			int uid1=sc.nextInt();
    				String uname1=sc.next();
    				String uemail1=sc.next();
    				String uaddress1=sc.next();
    				int ucontact1=sc.nextInt();
        			PreparedStatement pstmt8=conn.prepareStatement("update Student set semail=?,saddress=?,scontact=? where sid=? and sname=?");	
        			
        			pstmt8.setString(1,uemail1);
        			pstmt8.setString(2,uaddress1);
        			pstmt8.setInt(3,ucontact1);
        			pstmt8.setInt(4,uid1);
        			pstmt8.setString(5,uname1);
        			int value7=pstmt8.executeUpdate();
        			if(value7>0)
        			{
        				System.out.println("record updated........");
        			}
        			else {
        			    System.out.println("some problem is there.......");
        			}
        			break;		
        			
        		}
        	}while(true);
        	
        	
        }
        else {
        	System.out.println("database not connected........");
        }
	}

}
