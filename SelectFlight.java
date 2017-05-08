package FlightInfoModule;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/FlightInfoModule.SelectFlight")
public class SelectFlight extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SelectFlight() {
        super();
       
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String FlightId = request.getParameter("FlightId");
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		session.setAttribute("FlightId", FlightId);
		Jdbc_connect c = new Jdbc_connect(FlightId);
		try{
			
			ResultSet rs = c.fun2(); 
			System.out.println("Query in servlet"+rs);
			session.setAttribute("rs",rs);
		}
		catch(Exception e){
			System.out.println("in servlet");
		}
		response.sendRedirect("ShowFlight.jsp");
		
		
	}	
}