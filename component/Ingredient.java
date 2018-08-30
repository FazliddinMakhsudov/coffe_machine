package coffe_machine.component;

public abstract class Ingredient {
	private String name;
	private int price;
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public Ingredient(String name, int price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", price=" + price + "]";
	}
	
}
