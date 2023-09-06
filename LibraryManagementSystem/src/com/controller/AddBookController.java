package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.BooksBO;
import com.Dao.bookDao;

/**
 * Servlet implementation class AddBookController
 */
@WebServlet("/AddBookController")
public class AddBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookController() {
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
		
		String bname = request.getParameter("bname");
		String auther = request.getParameter("auther");
		String genre = request.getParameter("genre");
		String price = request.getParameter("price");
		
		BooksBO sb = new BooksBO();
		
		//sb.setBid(bid);
		sb.setBname(bname);
		sb.setAuther(auther);
		sb.setGenre(genre);
		sb.setPrice(price);
		
		
		int status = bookDao.getaddbooks(sb);
		
		if(status > 0)
		{
			
			pw.print("<script> alert('book added successfully...') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("librarian.html");
			rd.include(request, response);
			
		}
		else
		{
			pw.print("<script> alert('Something went wrong...try again..') </script>");
			
			RequestDispatcher rd = request.getRequestDispatcher("addbooks.html");
			rd.include(request, response);
			
		}
		
	}

}
