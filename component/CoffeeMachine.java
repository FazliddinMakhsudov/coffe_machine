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
		Coffee temp = null;
		for(Coffee cofee: drinks.keySet()){
			if(cofee.getName().equals(coffee.getName())){
				temp=cofee;
				break;
			}
		}
		if(temp!=null){
			Integer num = drinks.get(temp)+1;
			drinks.put(temp, num);
		} else {
			drinks.put(coffee, 1);
		}
	}
	public static boolean takeCoffee (Coffee coffee){
		Coffee temp = null;
		for(Coffee cofee: drinks.keySet()){
			if(cofee.getName().equals(coffee.getName())){
				temp=cofee;
				break;
			}
		}
		if(temp!=null){
			Integer num = drinks.get(temp)-1;
			if(num>0){
				drinks.put(temp, num);	
			} else{
				drinks.remove(coffee);
			}
			return true;
		} else {
			return false;
		}
	}
	
}
