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
		if(drinks.containsKey(coffee)){
			Integer num = drinks.get(coffee)+1;
			drinks.put(coffee, num);
		} else {
			drinks.put(coffee, 1);
		}
	}
	public static boolean takeCoffee (Coffee coffee){
	
		if(drinks.getOrDefault(coffee, -1)!=-1){
			Integer num = drinks.get(coffee)-1;
			if(num>0){
				drinks.put(coffee, num);	
			} else{
				drinks.remove(coffee);
			}
			return true;
		} else {
			return false;
		}
	}
	
}
