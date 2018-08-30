package coffe_machine.viewer;

public enum IngredientEnum {
	CREAM(1), MILK(3), SUGAR(2);
	private int price;
	
	public int getPrice() {
		return price;
	}

	private IngredientEnum(int price) {
		this.price = price;
	}
	
}
