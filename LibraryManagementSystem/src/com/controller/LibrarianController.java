package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.BooksBO;
import com.Dao.bookDao;

/**
 * Servlet implementation class LibrarianController
 */
@WebServlet("/LibrarianController")
public class LibrarianController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LibrarianController() {
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
		
		pw.print("<a href='librarian.html' > <input type='button' id='btn' value='Back'> </a> <br><br>");
		
		pw.print("<table width='100%'>");
		
		pw.print("<tr><th>Book_ID</th> <th>Book_name</th> <th>Auther</th> <th>Genre</th> <th>Price</th></tr>");
		
		List<BooksBO> list = bookDao.getallbooks();
		
		for(BooksBO sb: list)
		{
			pw.print("<tr><td>"+sb.getBid()+"</td><td>"+sb.getBname()+"</td><td>"+sb.getAuther()+"</td><td>"+sb.getGenre()+"</td><td>"+sb.getPrice()+"</td></tr>");
		}
		
		pw.print("</table>");
		
	}

}
