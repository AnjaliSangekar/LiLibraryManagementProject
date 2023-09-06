package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.dao;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginController() {
        // TODO Auto-generated constructor stub
    }

		/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String email = request.getParameter("email");
		String type = request.getParameter("type");
		String password = request.getParameter("password");
		
		
        boolean isValid = false;

        if (type.equals("Admin"))
        {
            isValid = dao.adminLoginValid(email, password); // Assuming you have admin login validation method
        } 
        else if (type.equals("Librarian"))
        {
            isValid = dao.librarianLoginValid(email, password); // Assuming you have librarian login validation method
        }

        
        if (isValid)
        {
        	
            if (type.equals("Admin"))
            {
                pw.print("<script> alert('Admin Login successfully...') </script>");
                
                RequestDispatcher rd = request.getRequestDispatcher("admin.html");
                
                rd.include(request, response);
            } 
            else if (type.equals("Librarian"))
            {
                pw.print("<script> alert('Librarian Login successfully...') </script>");
                
                RequestDispatcher rd = request.getRequestDispatcher("librarian.html");
                
                rd.include(request, response);
            }
            
        }
        else
        {
            pw.print("<script> alert('Invalid credentials... Try again') </script>");
            
            RequestDispatcher rd = request.getRequestDispatcher("Login.html");
            
            rd.include(request, response);
        }
   
        
		
//		if(dao.loginvalid(email, type, password))
//		{
//			pw.print("<script> alert('Admin Login successfully...') </script>");
//			
//			RequestDispatcher rd = request.getRequestDispatcher("admin.html");
//			
//			rd.include(request, response);
//			
//			
//		}
//		else if(dao.loginvalid(email, type, password))
//		{
//			pw.print("<script> alert('Lidrarian Login successfully...') </script>");
//			
//			RequestDispatcher rd = request.getRequestDispatcher("librarian.html");
//			
//			rd.include(request, response);
//			
//			
//			
//		}
//		else
//		{
//			pw.print("<script> alert('Something went wrong...Try again') </script>");
//			
//			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
//			
//			rd.include(request, response);
//			
//		}
//		
	}

}
