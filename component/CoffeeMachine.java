package coffe_machine.component;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CoffeeMachine {
	private static Map<Coffee, Integer> drinks = new TreeMap<Coffee, Integer>();
	public static Map<Coffee, Integer> getDrinks() {
		return drinks;
	}
	public static void addCoffee (Coffee coffee){
			drinks.put(coffee, drinks.getOrDefault(coffee, 0)+1);
	}
	public static boolean takeCoffee (Coffee coffee){
		if(drinks.containsKey(coffee)){
			if(drinks.getOrDefault(coffee, 1)!=1){
				drinks.put(coffee, drinks.get(coffee)-1);
			} else{
				drinks.remove(coffee);
			}			
			return true;
		} else {
			return false;
		}
	}
	
}
