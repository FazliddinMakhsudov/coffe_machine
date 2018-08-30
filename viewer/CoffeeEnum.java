package coffe_machine.viewer;

public enum CoffeeEnum {
	
	 CAPUCCINO(12, 1), LATE(11, 2), LYUVAK(15, 3);
	 
private int price;
private int index;	
	public int getPrice() {
		return price;
	}
	public int getIndex(){
		return index;
	}


	private CoffeeEnum(int price, int index) {
		this.price = price;
		this.index=index;
	}
}
