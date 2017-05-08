package adminmodule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class PassengerlistServ
 */
@WebServlet("/PassengerlistServ")
public class PassengerlistServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassengerlistServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session1=request.getSession();
		String usename = (String) session1.getAttribute("uname");
		//System.out.println("Helllo "+usename);
		if (usename == null) {
			response.sendRedirect("loginpage.jsp");
			
		}
		else{
		response.getWriter().append("Served at: ").append(request.getContextPath());
		FlightSchedule fl=new FlightSchedule();
		ResultSet rs=fl.displayPassenger();
		
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
		session.setAttribute("rs1", rs);
	
		out.println("Hello"+rs);
		response.sendRedirect("passengerlist.jsp");
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
