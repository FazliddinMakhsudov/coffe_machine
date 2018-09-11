package coffe_machine.component;

import java.util.ArrayList;
import java.util.List;

public class Coffee implements Comparable<Coffee>{
	private String name;
	private int price;
	private int totalPrice;
	private List<Ingredient> ingredients;
	public String getName() {
		return name;
	}
	public int getPrice() {
		return price;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	
	public List<Ingredient> getIngredients() {
		return ingredients;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
		this.ingredients = new ArrayList<>();
		this.totalPrice = price;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("-----------------------\n");
		sb.append("Coffee [name=" + name+ ", price=" + price+",\n");
		sb.append("ingredients=" + ingredients+",\n");
		sb.append("totalPrice="+ totalPrice+"]\n");
		sb.append("-----------------------\n");
		return sb.toString();
	}
	@Override
	public int compareTo(Coffee o) {
		// TODO Auto-generated method stub
		
		return this.name.compareTo(o.getName());
	}
}
