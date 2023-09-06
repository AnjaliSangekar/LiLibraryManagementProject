package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BO.AdminBO;

public class dao {

	
	public static Connection getconnection()
	{
		Connection con = null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "Codenera@123");
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return con;
		
	}
	
	
	public static int singup(AdminBO ob1)
	{
		int status = 0;
		
		
		try
		{
			
			Connection con = dao.getconnection();
			
			String sql = "insert into projects(name, email, phone, type, address, password) values(?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, ob1.getName());
			ps.setString(2, ob1.getEmail());
			ps.setString(3, ob1.getPhone());
			ps.setString(4, ob1.getType());
			ps.setString(5, ob1.getAddress());
			ps.setString(6, ob1.getPassword());
			
			status = ps.executeUpdate();
			
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	
	
	public static boolean adminLoginValid(String email, String password) {
	    return loginvalid(email, "Admin", password);
	}

	public static boolean librarianLoginValid(String email, String password) {
	    return loginvalid(email, "Librarian", password);
	}
	
	public static boolean loginvalid(String email, String type, String password)
	{
		boolean status = false;
		
		try
		{
			Connection con = dao.getconnection();
			
			String sql = "select * from projects where email=? and type=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, email);
			ps.setString(2, type);
			ps.setString(3, password);
			
			ResultSet rs = ps.executeQuery();
			
			status = rs.next();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	
	public static List getUserdata()
	{
		ArrayList<AdminBO> list = new ArrayList<AdminBO>();
		
		try
		{
			
			Connection con = dao.getconnection();
			
			String sql = "select * from projects";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				AdminBO sb = new AdminBO();
				
				sb.setId(rs.getInt(1));
				sb.setName(rs.getString(2));
				sb.setEmail(rs.getString(3));
				sb.setPhone(rs.getString(4));
				sb.setType(rs.getString(5));
				sb.setAddress(rs.getString(6));
				sb.setPassword(rs.getString(7));
				
				list.add(sb);
				
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return list;
		
		
	}
	
	
	
	public static int deletedata(int id)
	{
		int status = 0;
		
		try 
		{
			
			Connection con = dao.getconnection();
			
			String sql = "delete from projects where id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			status = ps.executeUpdate();
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	
	
	
}
