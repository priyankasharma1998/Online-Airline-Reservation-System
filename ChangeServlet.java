package usermodule;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangeServlet
 */
@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeServlet() {
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
		String old=request.getParameter("p1");
		String newpass=request.getParameter("p2");
		
		HttpSession session=request.getSession();  
		String username=(String)session.getAttribute("Username"); 
		User userx=new User(username,old);
		int result=userx.changePassword(newpass);
		
		
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		if(result==1){
			PrintWriter out = response.getWriter();
			out.println("<html>");
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('Password changed successfully,Now login Again');");
	    	 session.invalidate();  
	    	out.println("location='loginpage.jsp';");
	    	out.println("</script></html>");
		}
		else{
			PrintWriter out = response.getWriter();
			out.println("<html>");
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('Some error in changing the password');");
	    	out.println("location='changePassword.jsp';");
	    	out.println("</script></html>");
		}
		
	}

}
