package showrrom;

import java.sql.SQLException;
import java.util.*;

public class Showroom {
	
	
	public static void main(String args[]) throws SQLException, InterruptedException {
		
		Scanner scan =  new Scanner(System.in);
//		-----------------------------------------------start sql engine

//		DbConnection.enginestart();
		
		
		int input = 1;
		while(input == 1) {
			System.out.println("do want attend next customer press ( 1 ) or ( 0 )");
			input = scan.nextInt();
			if(input == 1 ) {
				
				System.out.println("welcom sir:)");
				System.out.println("if want to buy a mobile press( 1 ) to exits ( 2 )" );
				int loopcase = 1;
				while(loopcase == 1) {
					
					System.out.println("----------------------------------------------------");
					int opt = scan.nextInt();
//case 1 -----------------------------------------------------------------------
					switch(opt) {
					case 1:
						
						System.out.println("these our mobile collection");
						
						mobileDAO mobiledao = new mobileDAO();
						mobiledao.displaymobile();
						
						System.out.println("which mobile sir :-");
										
						Customer customer = new Customer();
						
						if(customer.isavailable()){
							
							customerDAO customerdao = new customerDAO();
							
							
							System.out.println("yes sir we have this mobile");
							System.out.println("-------------------------------------");
							
							System.out.println("fill the customer detail");
							customer.customerdetail();
							System.out.println("--------------------------------------");
							System.out.println("u r details");
								
							customer.print_customername();
							System.out.println("----------------------------------------");
													
							System.out.println("EMI ( 1 ) or CASH ( 2 )");
							int ec = scan.nextInt();
							switch(ec) {
							
								
							case 1:
								
								customer.emidetail();
								customer.emicalculation();
								
									
								if(customer.ispaidemi()) {
									
									System.out.println("customer EMI paid :- " + customer.getemipaid());
									System.out.println("u r emi amount is :- " + customer.getemi());
									}
									customer.emibill();
									customerdao.cus_emi_entry(customer);
									break;
														
								case 2:
									
									if(customer.ispaid()) {
										
										//customer.customername();
										System.out.println("paid " + customer.getpaid());
										System.out.println("-----------------------------");
										customer.bill();
										}
									customerdao.cus_entry(customer);
										break;
										
								default :
									System.out.println("u r enter the wrong option ");
									break;
									
								}
												
								 }
								else {
									System.out.println("sorry dont't have this mobile");
									break;
									}
									
//-------------------------------------------------------------------------------------					
								default :
									System.out.println("THANKS VISITING AGAIN");
									loopcase = 0;
									break;
								}
				}

				
			}
			else {
				System.out.println("wrong option pls exit");
				break;
			}
				
			
		}
		
		
		
		
	}
}
