package ReservationandCancellationModule;

import java.io.*;
import java.sql.ResultSet;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import usermodule.History;
@WebServlet("/Cancellation")
public class Cancellation extends HttpServlet {
	
	public void init(ServletConfig config) throws ServletException {
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		PrintWriter writer=response.getWriter();
		HttpSession session=request.getSession();  
		String FlightId=(String)session.getAttribute("FlightID");//
		int fno=Integer.parseInt(FlightId);
		String Username=(String)session.getAttribute("Username");//
		System.out.println(fno);
		String Q1="UPDATE TYPESEATS SET AVAILABLESEATS = AVAILABLESEATS + 1  WHERE FLIGHT_ID =" + fno + "and AVAILABLESEATS > 0 and AVAILABLESEATS < NOOFSEATS";
		String Q2="DELETE from HISTORY where FLIGHTID =" + "'"+ fno +"'";
		DatabaseMan db=new DatabaseMan();
		int a=db.UpdateData(Q1,Q2);
		System.out.println("cancellation");
		writer.println("<html><body><b>");
		writer.println("Your ticket has been cancelled");
		writer.println("<\b></html></body>");
		response.sendRedirect("History");

 }

}