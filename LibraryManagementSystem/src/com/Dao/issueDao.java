package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BO.IssuedBO;

public class issueDao {

	
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
	
	
	public static int issuedbook(IssuedBO sb1)
	{
		int status = 0;
		
		try
		{
		
			Connection con = issueDao.getconnection();
			
			String sql = "insert into issuedbook(book_id, user_id, issued_date, return_date) values(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, sb1.getBid());
			ps.setInt(2, sb1.getLid());
			ps.setString(3, sb1.getDate());
			ps.setString(4, sb1.getRdate());
			
			status = ps.executeUpdate();
			
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return status;
			
	}
	
	
	public static List getIssuedbook()
	{
		ArrayList<IssuedBO> list = new ArrayList<IssuedBO>();
		
		try 
		{
			Connection con = issueDao.getconnection();
			
			String sql = "select * from issuedbook";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				IssuedBO sb = new IssuedBO();
				
				sb.setIid(rs.getInt(1));
				sb.setBid(rs.getInt(2));
				sb.setLid(rs.getInt(3));
				sb.setDate(rs.getString(4));
				sb.setRdate(rs.getString(5));
				
				list.add(sb);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
			
	}
	
	
//	public static IssuedBO getissuedid(int iid)
//	{
//		IssuedBO sb = new IssuedBO();
//		
//		try
//		{
//			
//			Connection con = issueDao.getconnection();
//			
//			String sql = "select return_date from issuedbook where issue_id=?";
//			
//			PreparedStatement ps = con.prepareStatement(sql);
//			
//			ps.setInt(1, iid);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next())
//			{
//				
//			}
//			
//		} 
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//		
//		return sb;
//		
//		
//	}
//	
	
	
	public static int returnbook(IssuedBO sb)
	{
		int status = 0;
		
		try 
		{
			
			Connection con = issueDao.getconnection();
			
			String sql = "update issuedbook set return_date=? where issue_id=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, sb.getRdate());
			ps.setInt(2, sb.getIid());
			
			status = ps.executeUpdate();
			
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
			
	}
	
	
}
