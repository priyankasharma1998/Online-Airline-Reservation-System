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
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
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
		
		String title=request.getParameter("title");
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String dob=request.getParameter("dob");
		String gender=request.getParameter("gender");
		String address=request.getParameter("address");
		String MobileNo=request.getParameter("MobileNo");
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		User userx=new User(title,firstname,lastname,dob,gender,address,MobileNo,username,password);
		//System.out.println(userx.getUsername());
		
	//	System.out.println(title+" "+firstname+" "+lastname+" "+dob+" "+gender+" "+address+" "+MobileNo+" "+username+" "+password);
		int result=userx.storeInDatabase();
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");
		
		if(result==0){
			PrintWriter out = response.getWriter();
			out.println("<html>");
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('Username already Exists');");
	    	out.println("location='SignUp.jsp';");
	    	out.println("</script></html>");
		}
		else{
			
			PrintWriter out = response.getWriter();
			out.println("<html>");
	    	out.println("<script type=\"text/javascript\">");
	    	out.println("alert('User is Signed Up Successfully ');");
	    	out.println("location='loginpage.jsp';");
	    	out.println("</script></html>");
		}
			
    	/*	HttpSession session=request.getSession();  
    		session.setAttribute("Username",username); 
    		session.setAttribute("Password",password);
    		
    		
    		response.sendRedirect("UserIndex.jsp");*/
    		//String us=(String)session.getAttribute("Username");
    		//System.out.println(us);
    		
    	/*}
    	else{
     		System.out.println("Hello");
     		response.sendRedirect("loginpage.jsp");
     	}
		
		 return response
		writer.println(htmlRespone);
		
		response.sendRedirect("loginpage.jsp");
		*/
	}

}
