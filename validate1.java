package adminmodule;
import  usermodule.User;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class validate1
 */
@WebServlet("/validate1")
public class validate1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public validate1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		// pw.println("<html><body><b>Hello World!</b><br>");
		String username = request.getParameter("name");
		String password = request.getParameter("passw");
		String checkadmi = request.getParameter("type");
		
		if(checkadmi==null){
			
			System.out.println(checkadmi);
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Select Admin or User');");
			out.println("location='loginpage.jsp';");
			out.println("</script>");
			
			// response.sendRedirect("loginpage.jsp");
		
		
		}
		else if (checkadmi.equals("Admin")) {
			Admin a = new Admin(username, password);
			boolean result = a.valid();
			if (result == true) {
				HttpSession session = request.getSession();
				// session.setAttribute("loginStatus", new Boolean(true));
				session.setAttribute("uname", username);
				session.setAttribute("pass", password);
				
				response.sendRedirect("PassengerlistServ");
			} 
			else {
				HttpSession session = request.getSession();
				
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Username or password incorrect');");
				out.println("location='loginpage.jsp';");
				out.println("</script>");
				//response.sendRedirect("loginpage.jsp");
			}

		} 
		else if (checkadmi.equals("User")) {
			User userx = new User(username, password);

			boolean result = userx.LoginCheck();
			System.out.println(result);
			if (result == true) {

				HttpSession session = request.getSession();
				session.setAttribute("Username", username);
				session.setAttribute("Password", password);

				response.sendRedirect("History");
				// String us=(String)session.getAttribute("Username");
				// System.out.println(us);

			} else {
				HttpSession session = request.getSession();
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Username or password incorrect');");
				out.println("location='loginpage.jsp';");
				out.println("</script>");
				// System.out.println("Hello");
				//response.sendRedirect("loginpage.jsp");
			}
		}

	}

}
