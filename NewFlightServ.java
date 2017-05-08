package adminmodule;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewFlightServ
 */
@WebServlet("/NewFlightServ")
public class NewFlightServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewFlightServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String Fid=request.getParameter("fid");
		String Fname=request.getParameter("fname");
		String Fsrc=request.getParameter("fsrc");
		String Fdest=request.getParameter("fdest");
		String Fdate=request.getParameter("fdate");
		String Ftime=request.getParameter("ftime");
		String Fclass=request.getParameter("classN");
		String TotalSeats=request.getParameter("Tseats");
		String AvaiSeats=request.getParameter("ASeats");
		String Fprice=request.getParameter("fprice");
		
		PrintWriter writer = response.getWriter();
		//String htmlRespon = "<html><body>hello</body></html>";
		//writer.println(htmlRespon);
		
		//pw.println("Welcome ");
		response.setContentType("text/html");
			
		//writer.println("</body></html>");
		FlightSchedule fl=new FlightSchedule(Fid,Fname,Fsrc,Fdest,Fdate,Ftime,Fclass,TotalSeats,AvaiSeats,Fprice);
		int i=fl.addFlight();
		if(i!=1){
			PrintWriter out = response.getWriter();
			out.println("<html>");
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('Flight already Exists');");
	    	out.println("location='flightScheduleServ';");
	    	out.println("</script></html>");
	    	
		}
		else{
			PrintWriter out = response.getWriter();
			out.println("<html>");
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('Flight Inserted Succesfully');");
	    	out.println("location='flightScheduleServ';");
	    	out.println("</script></html>");
	    	
		}
			
		//	response.sendRedirect("flightScheduleServ");
		
	}

}
