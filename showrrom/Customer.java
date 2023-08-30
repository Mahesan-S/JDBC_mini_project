package showrrom;

import java.sql.SQLException;
import java.util.*;

public class Customer extends Thread{
	String customername,bankname;
	String Mobilename;
	boolean paid,emipaid;
	int ph,emi;
	int addaharno,account_no,serial_no;

//	------------------------------------------------------------------------------------------
	public Customer() {
		
		Scanner s = new Scanner(System.in);
		System.out.println("1st enter ( serial_no ) AND enter u mobile name");
		serial_no = s.nextInt();
		Mobilename = s.next();
		
		
	}
	
//	------------------------------------------------------------------------------------------	
	public void customerdetail(){
		Scanner scan = new Scanner(System.in);
		
		System.out.println("enter u name");
		customername = scan.next();
		
//		System.out.println("paid or not");
//		paid = scan.nextBoolean();
		
		System.out.println("mobile number");
		ph = scan.nextInt();
		
	}

//	------------------------------------------------------------------------------------------
	public boolean getpaid() {
		return paid;
	}
	
	public void setpaid(boolean val) {
		this.paid = val;
	}
//	------------------------------------------------------------------------------------------
	
	public void setemipaid(boolean val) {
		emipaid = val;
	}
	
	public boolean getemipaid() {
		return emipaid;
	}
//	------------------------------------------------------------------------------------------
	
	public String getname() {
		return customername;
	}

//	------------------------------------------------------------------------------------------
	
	public int getemi() {
		return emi;
	}
	
	public void setemi(int val) {
		emi = val;
	}
	
//------------------------------------------------------------------------------------------
	public boolean isavailable() throws SQLException {
		int stock = 0;
		mobileDAO mobiledao = new mobileDAO();
		stock = mobiledao.getcapacity(serial_no);
		
		int buy = 0;
		customerDAO customerdao = new customerDAO();
		buy = customerdao.customergetcount(serial_no);
		 
			return buy!=stock?true:false; 
  }
//	------------------------------------------------------------------------------------------------
	public void print_customername() {
		System.out.println(customername + " " + ph + " " + paid + " " + Mobilename);
	}
//	------------------------------------------------------------------------------------------
	public void bill() throws InterruptedException {
		System.out.println("Loding.........");
		Thread.sleep(3000);
		String nl = System.lineSeparator();
		System.out.println("-------------------------------------------------------");
		System.out.println("customer name :- " + customername + nl + 
						   "mobile name :- " + Mobilename + '\n' +
						   
						   "paid :- "  + paid + nl + 
						   "contact number :- " + ph + '\n');
		System.out.println("-------------------------------------------------------");
	}
	

//	------------------------------------------------------------------------------------------	
	public boolean ispaid() {
			if(getpaid() == false) {
				setpaid(true);
			}
		return getpaid();
	}
	
//	------------------------------------------------------------------------------------------
	void emidetail() {
		Scanner scan = new Scanner(System.in);
		String nl = System.lineSeparator();
		
		 
		System.out.println("customer name :- " + customername + nl + 
					   "mobile name :- " + Mobilename + '\n' + 
					   "paid :- "  + paid + nl + 
					   "contact number :- " + ph + '\n');
		
		
		System.out.println("enter u addahar no");
		addaharno = scan.nextInt();
		System.out.println("enter bank name");
		bankname = scan.next();
		System.out.println("enter account number");
		account_no = scan.nextInt();
		
	}

//	------------------------------------------------------------------------------------------
	public void emicalculation() throws SQLException {
		mobileDAO getmobileprice = new mobileDAO();
		
		int val = 0; 
		int result = 0;
		int p = 0;
		int n = 10;
		int r = 0006;
		p = getmobileprice.mobileprice(serial_no);
		val =p*r*(1+r)*n % (1+r)*n-1;
		result =val;
	
		setemi(result);
//			P * r * (1 + r)n/((1 + r)n - 1);
		
		
	}
	
	
//	------------------------------------------------------------------------------------------	

	public boolean ispaidemi() {
			if(this.getemipaid() == false) {
				setemipaid(true);
			}
		return this.getemipaid();
	}

//	------------------------------------------------------------------------------------------
	public void emibill() throws InterruptedException {
		System.out.println("Loding.........");
		Thread.sleep(3000);
		String nl = System.lineSeparator();
		System.out.println("-------------------------------------------------------");
		System.out.println("customer name :- " + customername + nl + 
				   "mobile name :- " + Mobilename + '\n' +
				   "EMI :- " + emi + nl +
				   "ADDAHER no :- " + addaharno + '\n' +
				   "bank name & account no :- " + bankname + "  "+ account_no + nl +
				   "paid :- "  + emipaid + nl + 
				   "contact number :- " + ph + '\n');
		System.out.println("--------------------------------------------------------");
	}
}
