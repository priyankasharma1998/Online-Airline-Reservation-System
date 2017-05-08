package ReservationandCancellationModule;

import java.io.*;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class reservation
 */
@WebServlet("/reservation")
public class reservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public reservation() {
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String str = (String) session.getAttribute("FlightId");
		String Username = (String) session.getAttribute("Username");
		String str1 = (String) session.getAttribute("Source");
		String str2 = (String) session.getAttribute("Destination");
		String str3 = (String) session.getAttribute("Date");
		String str4 = (String) session.getAttribute("Time");
		String price1 = (String) session.getAttribute("Price");
		float price = Float.parseFloat(price1);
		String str5 = request.getParameter("Type");
		// String str5="economic";
		// float price=123;
		int flno = Integer.parseInt(str);
		String str6 = (String) session.getAttribute("FlightName");
		DatabaseMan dba = new DatabaseMan();

		String q1 = "UPDATE TYPESEATS SET  AVAILABLESEATS = AVAILABLESEATS - 1  WHERE FLIGHT_ID =" + flno
				+ "and AVAILABLESEATS > 0 and AVAILABLESEATS <= NOOFSEATS" + " and TYPE=" + "'" + str5 + "'";
		String q2 = "insert into HISTORY " + "values (" + "'" + Username + "'," + flno + ",'" + str6 + "'," + "'" + str1
				+ "'," + "'" + str2 + "'," + "'" + str3 + "'," + "'" + str4 + "','" + str5 + "'," + price + ")";
		int a = dba.UpdateData(q1, q2);
		PrintWriter writer2 = response.getWriter();
		
		writer2.println("<html><body background ="
				+ "'http://kulturwerke-deutschland.de/wp-content/uploads/2013/08/slider-3.jpg'>" + "<b>");
		if (a == 0) {

			writer2.println("<font size='6'>Sorry seats are full!</font>");
			writer2.println(
					"</b><FORM ACTION='History' method=post> <button type=submit>Proceed to Home Page</button></FORM>");

		} else {
			String QueryString = "SELECT * from HISTORY where FLIGHTID=" + flno + "and USERNAME=" + "'" + Username + "'"
					+ "and TYPE=" + "'" + str5 + "'";
			ResultSet rs = dba.UpdateData(QueryString);
			String QuStg = "SELECT * from USER where USERNAME=" + "'" + Username + "'";
			ResultSet rs2 = dba.UpdateData(QuStg);
			session.setAttribute("rs", rs);
			session.setAttribute("rs2", rs2);

			// setattr(rs)

			// RequestDispatcher rd =
			// request.getRequestDispatcher("resOut.html");
			// rd.forward(request, response);
			writer2.println("<font size='6'>Congratulations!Your ticket has been reserved</font>");
			writer2.println(
					"</b><FORM ACTION='reservation2.jsp' method=post> <button type=submit>Proceed to Ticket</button></FORM>");

		}
		writer2.println("</body></html>");
	}

}
