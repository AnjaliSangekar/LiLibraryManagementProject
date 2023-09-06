package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.IssuedBO;
import com.Dao.issueDao;

/**
 * Servlet implementation class ReturnController
 */
@WebServlet("/ReturnController")
public class ReturnController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnController() {
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
		
		int Iid = Integer.parseInt(request.getParameter("iid"));
		String rdate = request.getParameter("rdate");
		
		IssuedBO sb = new IssuedBO();
		
		sb.setIid(Iid);
		sb.setRdate(rdate);
		
		int status = issueDao.returnbook(sb);
		
		if(status > 0)
		{
			
			pw.print("<script> alert('Return book successfully...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("librarian.html");
			rd.include(request, response);
			
		}
		else
		{
			
			pw.print("<script> alert('Something went wrong...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("return.html");
			rd.include(request, response);
			
		}
		
		
	}

}
