package showrrom;

import java.sql.*;

public class customerDAO {
	public int customergetcount(int mobile_no) throws SQLException {
		String query = "select count(serail_no) from customer where serail_no = " + mobile_no;
		Connection con = DbConnection.getconnection();
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(query);
		rs.next();
		return rs.getInt(1);
	}
	//----------------------------------------------------------------------------------------------------------
	public void cus_emi_entry(Customer c) throws SQLException {
		String query = "insert into customer(serail_no ,mname, customername, mobile_no, bankname, account_no, addar_no, paid) value(?,?,?,?,?,?,?,?)";
		Connection con = DbConnection.getconnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setInt(1, c.serial_no);
		pst.setString(2, c.Mobilename);
		pst.setString(3, c.customername);
		pst.setInt(4, c.ph);
		pst.setString(5, c.bankname);
		pst.setInt(6, c.account_no);
		pst.setInt(7, c.addaharno);
		if(c.emipaid == true) {
			pst.setString(8, "true");
		}
		else
			pst.setString(8, "false");
		pst.executeUpdate();
		System.out.println("Billing Sucess");
		
	}
	public void cus_entry(Customer c) throws SQLException {
		String query = "insert into customer(customername, mname,mobile_no,serail_no, paid)value(?,?,?,?,?)";
		Connection con = DbConnection.getconnection();
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, c.customername);
		pst.setString(2, c.Mobilename);
		pst.setInt(3, c.ph);
		pst.setInt(4, c.serial_no);		
		if(c.paid == true)
				pst.setString(5, "true");
		pst.executeUpdate();
		System.out.println("Billing Sucess");
		
	}
}

/*String nl = System.lineSeparator();
System.out.println("-------------------------------------------------------");
System.out.println("customer name :- " + customername + nl + 
		   "mobile name :- " + Mobilename + '\n' +
		   "EMI :- " + emi + nl +
		   "ADDAHER no :- " + addaharno + '\n' +
		   "bank name & account no :- " + bankname + "  "+ account_no + nl +
		   "paid :- "  + emipaid + nl + 
		   "contact number :- " + ph + '\n');
System.out.println("--------------------------------------------------------");
*/