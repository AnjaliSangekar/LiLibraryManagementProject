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
 * Servlet implementation class IssuedBookController
 */
@WebServlet("/IssuedBookController")
public class IssuedBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IssuedBookController() {
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
		
		//int Iid = request.getParameter("iid");
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		int lid = Integer.parseInt(request.getParameter("lid"));
		String date = request.getParameter("date");
		String rdate = request.getParameter("rdate");
		
		IssuedBO sb = new IssuedBO();
		
		sb.setBid(bid);
		sb.setLid(lid);
		sb.setDate(date);
		sb.setRdate(rdate);
		
		int status = issueDao.issuedbook(sb);
		
		if(status > 0)
		{
		
			pw.print("<script> alert('Book Issued...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("librarian.html");
			rd.include(request, response);
			
		}
		else
		{
			
			pw.print("<script> alert('Something went wrong..try again..') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("issued.html");
			rd.include(request, response);
			
		}
		
	}

}
