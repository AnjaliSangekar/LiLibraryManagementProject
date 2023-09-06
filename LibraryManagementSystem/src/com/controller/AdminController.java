package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.AdminBO;
import com.Dao.dao;

/**
 * Servlet implementation class AdminController
 */
@WebServlet("/AdminController")
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		pw.print("<link rel=\"stylesheet\" href=\"css\\style.css\">");
		
		pw.print("<a href='admin.html' > <input type='button' id='btn' value='Back'> </a> <br><br>");
		
		pw.print("<table width='100%'>");
		
		pw.print("<tr> <th>ID</th> <th>Name</th> <th>Email</th> <th>Phone</th> <th>Type</th> <th>Address</th> <th>Password</th> <th>Delete</th> </tr>");
		
		
		List<AdminBO> list = dao.getUserdata();
		
		for(AdminBO sb: list)
		{
			pw.print("<tr><td>"+sb.getId()+"</td><td>"+sb.getName()+"</td><td>"+sb.getEmail()+"</td><td>"+sb.getPhone()+"</td><td>"+sb.getType()+"</td><td>"+sb.getAddress()+"</td><td>"+sb.getPassword()+"</td><td><a href='DeleteController?id="+sb.getId()+"'> delete </a></td></tr>");
			
		}
	
		pw.print("</table>");
		
	}

}
