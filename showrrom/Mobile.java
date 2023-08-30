package showrrom;

public class Mobile  extends Object{ 
	protected final String mobilename; // --------- protected
	protected int price;
	double version;
	int stocks,serial_no;
	
	Mobile(int no,String name,int price,double version,int stocks){
		this.mobilename = name;
		this.serial_no = no;
		this.price = price;
		this.version = version;
		this.stocks = stocks;
	}
	public void displaydetail() {
		System.out.println("serial_no " + serial_no +  " mobile name :- " + mobilename + " price :- " + price + " stocks is " + stocks);
	}
	public void mobilename() {
		System.out.println("mobile name :- " + mobilename);
	}
	
	public int getstocks() {
		return stocks;
	}
	public void setstocks(int val) {
		stocks = val;
	}
	
	public String getname() {
		return mobilename;
	}
	public int getprice() {
		return price;
	}
}

//-----------------------------------------------------------------------------------------------------------

class Iphone extends Mobile{     //-------------inheritance
	int discount;
	
	Iphone(int no,String name,int price,double version,int stocks,int dicount){
		super(no,name,price,version,stocks); //------------------super class
		this.discount = dicount;
	}
	public int getprice() {
		return super.getprice()-discount;
	}
}
