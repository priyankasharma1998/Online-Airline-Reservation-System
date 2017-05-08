package adminmodule;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteFlightServ
 */
@WebServlet("/DeleteFlightServ")
public class DeleteFlightServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteFlightServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String id=request.getParameter("check");
		String name=request.getParameter("check1");
		FlightSchedule fl=new FlightSchedule(id,name);
		fl.deleteFlight();
		PrintWriter out = response.getWriter();
    	out.println("<script type=\"text/javascript\">");
    	out.println("alert('Flight Deleted');");
    	//out.println("location='loginpage.jsp';");
    	out.println("</script>");
		response.sendRedirect("flightScheduleServ");
		
	}

}
