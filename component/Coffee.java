package coffe_machine.component;

import java.util.ArrayList;
import java.util.List;

public abstract class Coffee implements Comparable<Coffee>{
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
	public Coffee(String name, int price) {
		this.name = name;
		this.price = price;
		this.ingredients = new ArrayList<>();
		this.totalPrice = this.countTotalPrice();
	}
	public void addIngredient(Ingredient ingredient){
		this.ingredients.add(ingredient);
		this.totalPrice=this.countTotalPrice();
	}
	public boolean removeIngredient(Ingredient ingredient){
		if(!this.ingredients.contains(ingredient)){
			return false;
		}
		this.ingredients.remove(ingredient);
		this.totalPrice=this.countTotalPrice();
		return true;
	}
	private int countTotalPrice (){
		int ingredientPrices =0;
		for(Ingredient ing : this.ingredients){
			ingredientPrices+=ing.getPrice();
		}
		return this.price+ingredientPrices;
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
