package coffe_machine.component;

public class Customer {
	private static int cash;
	public static int getCash(){
		return cash;
	}
	public static int buy(int price){
		cash = cash-price;
		return cash;
	}
	public static int setCash(int cash1){
		cash = cash1;
		return cash;
	}
}
