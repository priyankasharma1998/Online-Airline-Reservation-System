package ReservationandCancellationModule;


import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Cancell
 */
@WebServlet("/Cancell")
public class Cancell extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cancell() {
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
	
	 public void temporary(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException
	    {
	        DatabaseMan db=new DatabaseMan();
	        HttpSession session=request.getSession(); 
	        String FlightId=(String)session.getAttribute("FlightID");
	        String Username=(String)session.getAttribute("Username");
	        String str5=(String)session.getAttribute("Type");
	        //String str5=(String)session.getAttribute("Type");
	      //  String str5="economic";
	        int fno=Integer.parseInt(FlightId);
	        String QueryString = "SELECT * from HISTORY where " + "flightid=" + fno + " and TYPE="+"'"+str5+"'";;
	        String QuStg = "SELECT * from USER where username="+"'"+Username+"'";
	        ResultSet rs=db.UpdateData(QueryString);
	        ResultSet rs2=db.UpdateData(QuStg);
	        session.setAttribute("rs",rs);
	        session.setAttribute("rs2",rs2);
	        response.sendRedirect("Cancel.jsp");
	    }
	    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Cancell a=new Cancell();
	        a.temporary(request,response);
	    }

	    /**
	     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	     */
	    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Cancell a=new Cancell();
	        a.temporary(request,response);
	    }
}
