package com.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.BO.BooksBO;

public class bookDao {

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
	 
	
	public static int getaddbooks(BooksBO sb1)
	{
		int status = 0;
		
		try
		{
			
			Connection con = bookDao.getconnection();
			
			String sql = "insert into books(book_name, author, genre, price) values(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, sb1.getBname());
			ps.setString(2, sb1.getAuther());
			ps.setString(3, sb1.getGenre());
			ps.setString(4, sb1.getPrice());
			
			status = ps.executeUpdate();
			
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	
	
	public static List getallbooks()
	{
		ArrayList<BooksBO> list = new ArrayList<BooksBO>();
		
		try 
		{
			
			Connection con = bookDao.getconnection();
			
			String sql = "select * from books";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next())
			{
				
				BooksBO sb = new BooksBO();
				
				sb.setBid(rs.getInt(1));
				sb.setBname(rs.getString(2));
				sb.setAuther(rs.getString(3));
				sb.setGenre(rs.getString(4));
				sb.setPrice(rs.getString(5));
				
				list.add(sb);
				
			}
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		return list;
			
	}
	
}
