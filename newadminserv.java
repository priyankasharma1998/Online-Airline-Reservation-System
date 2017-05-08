package adminmodule;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class newadminserv
 */
@WebServlet("/newadminserv")
public class newadminserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public newadminserv() {
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
		response.setContentType("text/html");
		String username=request.getParameter("name");
        String password=request.getParameter("passw");
        
		
		Admin newa=new Admin(username,password);
		int i=newa.storeInDatabase();
		if(i==1){
			PrintWriter out = response.getWriter();
			out.println("<html>");
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('Admin made successfully');");  
	    	out.println("location='PassengerlistServ';");
	    	out.println("</script></html>");
			//response.sendRedirect("PassengerlistServ");
		}
		
			else{
				PrintWriter out = response.getWriter();
				out.println("<html>");
		    	out.println("<script type=\"text/javascript\">");
		    	out.println("alert('Admin already exists try again!!');");
		    	out.println("location='AddAdmin.jsp';");
		    	out.println("</script></html>");
			}
			
		
	}

}
