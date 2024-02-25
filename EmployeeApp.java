package g;
import java.util.*;
import java.sql.*;

public class EmployeeApp {

	public static void main(String[] args)throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcjuly","root","pallavi");
	if(conn!=null)
	{
		Scanner sc=new Scanner(System.in);
		do {
		System.out.println("enter choice");
		int choice=sc.nextInt();
		int id,sal,contact;
		String name,email;
		PreparedStatement stmt;
		ResultSet rs;
		switch(choice)
		{
		case 1:
			 stmt=conn.prepareStatement("create table EmpRecord(eid int(5),ename varchar(200),email varchar(200),esal int(10),econtact int(10))");
			int value=stmt.executeUpdate();
			if(value==0)
			{
				System.out.println("table created...");
			}
			else {
			System.out.println("some problem is there...");
			}
			break;
		case 2:
			System.out.println("enter id,name,email,salary,contact of employee");
			id=sc.nextInt();
			name=sc.next();
			email=sc.next();
			sal=sc.nextInt();
			contact=sc.nextInt();
		     stmt=conn.prepareStatement("insert into EmpRecord values(?,?,?,?,?)");
			stmt.setInt(1,id);
			stmt.setString(2,name);
			stmt.setString(3, email);
			stmt.setInt(4,sal);
			stmt.setInt(5, contact);
			int value2=stmt.executeUpdate();
			if(value2>0)
			{
				System.out.println("record insert successfuly.........");
			}
			else {
				System.out.println("some problem is there..........");
			}
			break;
		case 3:
			stmt=conn.prepareStatement("select *from emprecord");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
			System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
			}
			break;
		case 4:
			System.out.println("enter id name salary");
			id=sc.nextInt();
			name=sc.next();
			sal=sc.nextInt();
			
			stmt=conn.prepareStatement("select *from emprecord where eid=? and ename=? and esal>=?");
			stmt.setInt(1,id);
			stmt.setString(2, name);
			stmt.setInt(3,sal);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
			    email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
				
			}
			break;
		case 5:
			System.out.println("enter name salary");
			
			name=sc.next();
			sal=sc.nextInt();
			
		    stmt=conn.prepareStatement("select *from emprecord where  ename!=? and esal<?");
			
			stmt.setString(1, name);
			stmt.setInt(2,sal);
		    rs=stmt.executeQuery();
			while(rs.next())
			{
			    id=rs.getInt(1);
			    name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
				
			}
			break;
		case 6:
			System.out.println("enter name salary");
			
			name=sc.next();
			sal=sc.nextInt();
			
			stmt=conn.prepareStatement("select *from emprecord where ename=? and esal!=?");
			stmt.setString(1, name);
			stmt.setInt(2,sal);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
				
			}
		case 7:
            System.out.println("enter email,salary");		
			email=sc.next();
		    sal=sc.nextInt();
		    stmt=conn.prepareStatement("select *from emprecord where email=? and esal=?");
			stmt.setString(1, email);
			stmt.setInt(2,sal);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				 id=rs.getInt(1);
				 name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
				
			}
			break;
		
		case 8:
			
System.out.println("enter name salary");
			
			name=sc.next();
			sal=sc.nextInt();
			
			stmt=conn.prepareStatement("select *from emprecord where ename=? and esal<?");
			stmt.setString(1, name);
			stmt.setInt(2,sal);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
			}	
			break;
		case 9:
			System.out.println("enter name,email,id,name");
			
			name=sc.next();
			email=sc.next();
			id=sc.nextInt();
			String name1=sc.next();
			
			
			
			
			stmt=conn.prepareStatement("update  emprecord set ename=?,email=? where eid=? and ename=?");
			stmt.setString(1, name);
			stmt.setString(2,email);
			stmt.setInt(3,id);
			stmt.setString(4, name1);
			int value3=stmt.executeUpdate();
			if(value3>0)
			{
				System.out.println("updated successfuly........");
			}
			else {
				System.out.println("some problem is there......");
			}
			break;
		case 10:
			
			stmt=conn.prepareStatement("select *from emprecord where esal in(10000,20000,30000)");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
				
			}
			break;
		case 11:
			
			stmt=conn.prepareStatement("select *from emprecord where esal not in(10000,20000,30000)");
		    rs=stmt.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
			}
			break;
		case 12:
	        stmt=conn.prepareStatement("select *from emprecord where esal between 10000 and 20000");
			rs=stmt.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
			}
			break;
		case 13:
			System.out.println("enter name");
			name=sc.next();
			stmt=conn.prepareStatement("select *from emprecord where ename!=? and esal in(10000,20000,30000) ");
		    stmt.setString(1,name);
			rs=stmt.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
			}
			break;
		case 14:
			System.out.println("enter three name");
			name=sc.next();
			name1=sc.next();
			String name2=sc.next();
			stmt=conn.prepareStatement("select *from emprecord where ename=? or ename=? or ename=? ");
		    stmt.setString(1,name);
		    stmt.setString(2,name1);
		    stmt.setString(3,name2); 
			rs=stmt.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
			}
			break;
		case 15:
			System.out.println("enter three name");
			name=sc.next();
			name1=sc.next();
		
			stmt=conn.prepareStatement("select *from emprecord where ename=? or ename=?  and  esal<10000");
		    stmt.setString(1,name);
		    stmt.setString(2,name1);
			 rs=stmt.executeQuery();
			while(rs.next())
			{
				id=rs.getInt(1);
				name=rs.getString(2);
				email=rs.getString(3);
				sal=rs.getInt(4);
				contact=rs.getInt(5);
				System.out.println(id+"\t"+name+"\t"+email+"\t"+sal+"\t"+contact);
			}
			break;
			
		}
		}while(true);
	}
	else {
		System.out.println("database not connected");
	}

	}

}
