package adminmodule;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateFlightServ
 */
@WebServlet("/UpdateFlightServ")
public class UpdateFlightServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateFlightServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		String newfare=request.getParameter("newfare");
		String id=request.getParameter("check");
		String name=request.getParameter("check1");
		PrintWriter out = response.getWriter();
		
		System.out.println("Heello"+newfare);
		if(newfare==""){
			out.println("<script type='text/javascript'>");
			out.println("alert('Enter new fare to be updated');");
			out.println("window.location.href = 'flightScheduleServ';");
			out.println("</script>");
			
		}
		else{
			FlightSchedule fl=new FlightSchedule(newfare,id,name);
			fl.updateFlight();
			
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('Flight Updated');");
	    	//out.println("location='loginpage.jsp';");
	    	out.println("</script>");
			response.sendRedirect("flightScheduleServ");
			
		}
		//response.sendRedirect("flightScheduleServ");
		
	}

}
