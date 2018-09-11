package coffe_machine.maker;

import coffe_machine.component.Coffee;
import coffe_machine.component.Ingredient;

public class CoffeeMaker {
	private Coffee coffee;

	public Coffee getCoffee() {
		return coffee;
	}
	public void setCoffee(Coffee coffee) {
		this.coffee = coffee;
	}
	public CoffeeMaker() {
	}
	public CoffeeMaker(String name, int price) {
		this.coffee = new Coffee(name, price);
	}
	
	
	public void addIngredient(Ingredient ingredient){
		this.coffee.getIngredients().add(ingredient);
		this.coffee.setTotalPrice(this.countTotalPrice());
	}
	public boolean removeIngredient(Ingredient ingredient){
		if(!this.coffee.getIngredients().contains(ingredient)){
			return false;
		}
		this.coffee.getIngredients().remove(ingredient);
		this.coffee.setTotalPrice(this.countTotalPrice());
		return true;
	}
	private int countTotalPrice (){
		int ingredientPrices =0;
		for(Ingredient ing : this.coffee.getIngredients()){
			ingredientPrices+=ing.getPrice();
		}
		return this.coffee.getPrice()+ingredientPrices;
	}

}
