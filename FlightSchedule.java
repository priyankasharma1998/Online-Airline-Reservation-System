package adminmodule;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class FlightSchedule {
	
	private int flightNo;
	private String flightName;
	private String source;
	private String destination;
	private String scheduleDate;
	private String scheduleTime;
	private String classType;
	private int totSeats;
	private int availableSeats;
	private float flightPrice;
	public int getFlightNo() {
		return flightNo;
	}
	public void setFlightNo(int flightNo) {
		this.flightNo = flightNo;
	}
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getScheduleDate() {
		return scheduleDate;
	}
	public void setScheduleDate(String scheduleDate) {
		this.scheduleDate = scheduleDate;
	}
	public String getScheduleTime() {
		return scheduleTime;
	}
	public void setScheduleTime(String scheduleTime) {
		this.scheduleTime = scheduleTime;
	}
	public String getClassType() {
		return classType;
	}
	public void setClassType(String classType) {
		this.classType = classType;
	}
	public int getTotSeats() {
		return totSeats;
	}
	public void setTotSeats(int totSeats) {
		this.totSeats = totSeats;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats1) {
		this.availableSeats = availableSeats1;
	}
	public float getFlightPrice() {
		return flightPrice;
	}
	public void setFlightPrice(float flightPrice1) {
		this.flightPrice = flightPrice1;
	}
	
	FlightSchedule(){
		
	}
	
	FlightSchedule(String Fid,String Fname,String Fsrc,String Fdest,String Fdate,String Ftime,String Fclass,String TotalSeats,String AvaiSeats,String Fprice){
		//System.out.println("Fid: "+Fid);
		int fid=Integer.parseInt(Fid);
		//System.out.println("hello Fid: "+fid);
		this.setFlightNo(fid);
		this.setFlightName(Fname);
		this.setSource(Fsrc);
		this.setDestination(Fdest);
		this.setScheduleDate(Fdate);
		//System.out.println("hello date: "+scheduleDate);
		this.setScheduleTime(Ftime);
		this.setClassType(Fclass);
		
		int total=Integer.parseInt(TotalSeats);
		this.setTotSeats(total);
		
		//System.out.println("hello seats: "+AvaiSeats);
		int avail=Integer.parseInt(AvaiSeats);
		//System.out.println("hello seats: "+availableSeats);
		this.setAvailableSeats(avail);
		
		float pri=Float.parseFloat(Fprice);
		this.setFlightPrice(pri);
		//System.out.println("hello price: "+pri);
		
	}
	
	FlightSchedule(String id1,String name){
		int idd=Integer.parseInt(id1);
		this.flightNo=idd;
		this.flightName=name;
		
	}
	
	FlightSchedule(String Nprice,String Fid,String Fname){
		//System.out.println("Fid: "+Fid);
		float pri=Float.parseFloat(Nprice);
		this.setFlightPrice(pri);
		int fid=Integer.parseInt(Fid);
		//System.out.println("hello Fid: "+fid);
		this.setFlightNo(fid);
		this.setFlightName(Fname);
		
		
		
		//System.out.println("hello price: "+pri);
		
	}
	
	
	
	int addFlight(){
		
		int i=0;
		try{
			
			databaseConnector dl = new databaseConnector();
			Connection con = dl.getCon();
			Statement st = dl.createStatement(con);
			String query="insert into FLIGHT "+ "values("+"'"+this.flightNo+"'"+","+"'"+this.flightName+"'"+","+"'"+this.source+"'"+","+"'"+this.destination+"'"+","+"'"+this.scheduleDate+"'"+","+"'"+this.scheduleTime+"'"+","+"'"+this.classType+"'"+")";
			String query1="insert into TYPESEATS "+ "values("+"'"+this.flightNo+"'"+","+"'"+this.classType+"'"+","+"'"+this.totSeats+"'"+","+"'"+this.availableSeats+"'"+","+"'"+this.flightPrice+"'"+","+"'"+this.flightName+"'"+")";
			st.executeQuery(query);
			//int i= st.updateQuery(query1);	
			i=st.executeUpdate(query1);
			
			databaseConnector.closeCon(con,st);
			
		} 
		catch(SQLException ex) {
		//	System.err.println("SQLException: " + ex.getMessage());
			
		}
		return i;
		
	}
		
	
	
	void deleteFlight(){
		

		try {
			databaseConnector dl = new databaseConnector();
			Connection con = dl.getCon();
			Statement st = dl.createStatement(con);
			String query1 = "delete from TYPESEATS where Flight_id="+"'"+this.flightNo+"'"+"and Flight_name="+"'"+this.flightName+"'";
			String query = "DELETE FROM FLIGHT where Flight_id="+"'"+this.flightNo+"'"+"and Flight_name="+"'"+this.flightName+"'";
			// System.out.println(query);
			st.executeUpdate(query1);
			st.executeQuery(query);
			databaseConnector.closeCon(con,st);
		} catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		
	}
	
	void updateFlight(){
		

		try {
			databaseConnector dl = new databaseConnector();
			Connection con = dl.getCon();
			Statement st = dl.createStatement(con);
			String query = "update TYPESEATS set PRICE="+"'"+this.flightPrice+"'"+"where Flight_id="+"'"+this.flightNo+"'";
			st.executeQuery(query);
			databaseConnector.closeCon(con,st);		
			} 
		catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
		}

		
	}
	
	ResultSet  displayflight(){
		try{
			databaseConnector dl = new databaseConnector();
			Connection con = dl.getCon();
			Statement st = dl.createStatement(con);
			String Query = "SELECT * from flight";
			//String Query1="select * from typeseats";
			    //   System.out.println(QueryString);
			ResultSet rs = st.executeQuery(Query); 
			//ResultSet rs1 = st.executeQuery(Query1); 
			 return rs  ;    
			
		}
		catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return null;
		}
		
		
		
		
	}
	
	ResultSet  displayclass(){
		try{
			databaseConnector dl = new databaseConnector();
			Connection con = dl.getCon();
			Statement st = dl.createStatement(con);
			//String Query = "SELECT * from flight";
			String Query1="select * from typeseats";
			    //   System.out.println(QueryString);
			//ResultSet rs = st.executeQuery(Query); 
			ResultSet rs1 = st.executeQuery(Query1); 
			 return rs1  ;    
			
		}
		catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return null;
		}
		
		
		
		
	}

	ResultSet  displayPassenger(){
		try{
			databaseConnector dl = new databaseConnector();
			Connection con = dl.getCon();
			Statement st = dl.createStatement(con);
			//String Query = "SELECT * from flight";
			String Query = "SELECT * from history order by flightid";
			ResultSet rs1 = st.executeQuery(Query); 
			 return rs1  ;    
			
		}
		catch (SQLException ex) {
			System.err.println("SQLException: " + ex.getMessage());
			return null;
		}
		
		
		
		
	}
	
	
}



