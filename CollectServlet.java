package FlightInfoModule;

import java.util.*;
import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import FlightInfoModule.Jdbc_connect;

@WebServlet("/FlightInfoModule.CollectServlet")
public class CollectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
      public CollectServlet(){
        super();
       
      }

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String Source = (request.getParameter("Source"));
		String Destination = (request.getParameter("Destination"));
		String Date = (request.getParameter("Date"));
		ResultSet rs= null;
		
	    
		PrintWriter out = response.getWriter();
		System.out.println("HELLO");
	System.out.println(Source + "" + Destination + ""+ Date);
		HttpSession session = request.getSession();
		session.setAttribute("Source", Source);
		session.setAttribute("Destination", Destination);
		session.setAttribute("Date", Date);
		Jdbc_connect c = new Jdbc_connect(Source,Destination,Date);
		try{
			
		  rs = c.fun1(); 
			System.out.println("Query in servlet"+rs);
			session.setAttribute("rs",rs);
			String  str = rs.getString(1);
			System.out.println("String "+str);
	  //response.sendRedirect("AvailableFlight.jsp"); 
		}
		catch(Exception e){
			System.out.println("in servlet");
		}
		
		response.sendRedirect("AvailableFlight.jsp");
	}

}
