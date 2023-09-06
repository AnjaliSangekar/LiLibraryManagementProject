package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BO.IssuedBO;
import com.Dao.issueDao;

/**
 * Servlet implementation class ReturnServlet
 */
@WebServlet("/ReturnServlet")
public class ReturnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnServlet() {
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
		
		int iid = Integer.parseInt(request.getParameter("iid"));
		
		//IssuedBO sb = issueDao.getissuedid(iid);
		
//		pw.print("<form action='ReturnController' method='post'>");
//		
//		pw.print("<h1>Form</h1>");
//		
//		pw.print("<table>");
//		
//		pw.print("<tr><td>Issued  </td> <td> <input type='type' name='iid' value='"+sb.getIid()+"'/></td></tr>");
//		pw.print("<tr><td>Return Date : </td> <td> <input type='text' name='rdate' value='"+sb.getRdate()+"'/></td></tr>");
//		
//		//pw.print("<br>");
//		pw.print("<tr> <td> <input type='submit' value='Return' class='btn'/></td></tr>");
//		
//		pw.print("</table>");
//		
		
		
	}

}
