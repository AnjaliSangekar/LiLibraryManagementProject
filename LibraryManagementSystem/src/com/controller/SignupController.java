package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.AdminBO;
import com.Dao.dao;

/**
 * Servlet implementation class SignupController
 */
@WebServlet("/SignupController")
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
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
		
		//int id = Integer.parseInt(request.getParameter("id"));
		
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String type = request.getParameter("type");
		String address = request.getParameter("address");
		String password = request.getParameter("password");
		
		
		AdminBO ob = new AdminBO();
		
		//ob.setId(id);
		ob.setName(name);
		ob.setEmail(email);
		ob.setPhone(phone);
		ob.setType(type);
		ob.setAddress(address);
		ob.setPassword(password);
		
		
		int status = dao.singup(ob);
		
		if(status > 0)
		{
			pw.print("<script> alert('Signup successfully...Please login...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			
		}
		else
		{
			pw.print("<script> alert('Something went wrong...Please try again...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("Signup.html");
			rd.include(request, response);
			
		}
		
		
	}

}
