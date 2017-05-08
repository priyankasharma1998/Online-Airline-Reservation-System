package ReservationandCancellationModule;

import java.sql.*;

public class DatabaseMan {

	Connection con;
	Statement stmt;
	int result;
	int result1;
	ResultSet rs;

	public int UpdateData(String s1, String s2) {
		try {
			try {
				Class.forName("org.hsqldb.jdbcDriver");
			} catch (java.lang.ClassNotFoundException e) {
				System.err.print("ClassNotFoundException: ");
				System.err.println(e.getMessage());
			}
			try {

				String url = "jdbc:hsqldb:hsql://localhost/";
				con = DriverManager.getConnection(url, "sa", "");
				stmt = con.createStatement();
				System.out.println("Qquery "+s1);
				result = stmt.executeUpdate(s1);
				System.out.println("Reservation "+result);
				if (result == 0)
					return 0;
				result1 = stmt.executeUpdate(s2);

				stmt.close();
				con.close();

			} catch (SQLException ex) {
				System.err.println("SQLException: " + ex.getMessage());
			}
		} catch (Exception ex) {
			System.out.println("Unable to connect database");
		}
		return 1;
	}

	public ResultSet UpdateData(String s1) {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
		} catch (java.lang.ClassNotFoundException e) {
			System.err.print("ClassNotFoundException: ");
			System.err.println(e.getMessage());
		}
		try {

			String url = "jdbc:hsqldb:hsql://localhost/";
			con = DriverManager.getConnection(url, "sa", "");
			stmt = con.createStatement();
			rs = stmt.executeQuery(s1);
			stmt.close();
			con.close();

		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}
		return rs;
	}

}
