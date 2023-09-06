package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.IssuedBO;
import com.Dao.issueDao;

/**
 * Servlet implementation class issuedViewController
 */
@WebServlet("/issuedViewController")
public class issuedViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public issuedViewController() {
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
		
		pw.print("<tr><th>Issued_Id</th> <th>Book_Id</th> <th>User_Id</th> <th>Issued_date</th> <th>Return_date</th></tr>");
		
		List<IssuedBO> list = issueDao.getIssuedbook();
		
		for(IssuedBO sb: list)
		{
			pw.print("<tr><td>"+sb.getIid()+"</td><td>"+sb.getBid()+"</td><td>"+sb.getLid()+"</td><td>"+sb.getDate()+"</td><td>"+sb.getRdate()+"</td></tr>");
		}
		
		pw.print("</table>");
		
	}

}
