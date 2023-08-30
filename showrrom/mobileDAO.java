package showrrom;
import java.sql.*;
public class mobileDAO {
	public void displaymobile() throws SQLException{
		
		String query = "select * from mobile";
		 Connection con = DbConnection.getconnection();
		 Statement st = con.createStatement();
		 ResultSet rs = st.executeQuery(query);
		 
		 System.out.println("*****************************************************");
		 
		 while(rs.next()) {
			 System.out.println(   "serial no :- " + rs.getInt(1)
					 			 + " mobile name :- " + rs.getString(2)
					 			 + " version :- " + rs.getDouble(3) 
					 			 + " price :- " + rs.getInt(4)
					 			 + " stocks :- " + rs.getInt(5));
		 }
		 System.out.println("*****************************************************");
	}
	
//------------------------------------------------------------------------------------------------------
	
	public int getcapacity(int mobile_number) throws SQLException {
			String query = "select stocks from mobile where serail_no = " + mobile_number;
			Connection con = DbConnection.getconnection();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			rs.next();
			return rs.getInt(1);
	}

//----------------------------------------------------------------------------------------------------------
public int mobileprice(int serial_no) throws SQLException {
	String query = "select price from mobile where serail_no = "+serial_no;
	Connection con = DbConnection.getconnection();
	Statement st = con.createStatement();
	ResultSet rs = st.executeQuery(query);
	rs.next();
	return rs.getInt(1);
}
}
