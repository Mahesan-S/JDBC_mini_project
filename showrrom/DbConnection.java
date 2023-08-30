package showrrom;
import java.sql.*;
public class DbConnection {
	 	private static  final  String url = "jdbc:mysql://localhost/showroom";
		private static final String username = "root";
		private static final String password = "1234";
	
	public static Connection getconnection() throws SQLException {
		return DriverManager.getConnection(url,username,password);
	}
//----------------------------------------------------------------------------------------------------------
	public static void enginestart() throws SQLException {
		String start = "use showroom";
		Connection con = DbConnection.getconnection();
		Statement st = con.createStatement();
		st.executeQuery(start);
	}
	
}
