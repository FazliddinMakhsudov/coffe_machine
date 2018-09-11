package coffe_machine.controller;

import java.util.Map;
import java.util.Scanner;

import coffe_machine.component.Capuccino;
import coffe_machine.component.Coffee;
import coffe_machine.component.CoffeeMachine;
import coffe_machine.component.Cream;
import coffe_machine.component.Customer;
import coffe_machine.component.Ingredient;
import coffe_machine.component.Late;
import coffe_machine.component.Lyuvak;
import coffe_machine.component.Milk;
import coffe_machine.component.Sugar;
import coffe_machine.maker.CoffeeMaker;
import coffe_machine.viewer.CoffeeEnum;
import coffe_machine.viewer.Show;

public class Controller {
	private static Scanner scan = new Scanner(System.in);
	private static Map<Coffee, Integer> drinks = CoffeeMachine.getDrinks(); 
	public static boolean supplyCoffeeMachine (){
		Show.actions();
		try{
			int choice = scan.nextInt();
			switch(choice){
			case 1:
				Show.showAvailableCoffee();
				choice = scan.nextInt();
				supplyCoffeeMachine(choice);
				break;
			case 2:
				Show.showChoice(drinks);
				choice = scan.nextInt();
				unSupplyCoffeeMachine(choice);
				break;
			case 3:
				Show.showExit();
				
				return false;
			}
			
		} catch(Exception e){
			Show.wrongValue();
		}
		return true;
	}
	private static boolean supplyCoffeeMachine(int choice){
		Coffee coffee=null;
		switch(choice){
			case 1:
				coffee = new Capuccino();
				break;
			case 2:
				coffee = new Late();
				break;
			case 3: 
				coffee = new Lyuvak();
				break;
		}
		if(coffee!=null){
			CoffeeMachine.addCoffee(coffee);
			return true;
		} else{
			Show.wrongValue();
		}
		return false;
	}
	private static boolean unSupplyCoffeeMachine(int choice){
		Coffee coffee=null;
		switch(choice){
			case 1:
				coffee = new Capuccino();
		
				break;
			case 2:
				coffee = new Late();
				break;
			case 3: 
				coffee = new Lyuvak();
				break;
		}
		if(coffee!=null){
			CoffeeMachine.takeCoffee(coffee);
			return true;
		} else{
			Show.wrongValue();
			return false;
		}
	}
	public static boolean makeCoffee (){
		Show.actionsMakeCoffee();
		try{
			int choice = scan.nextInt();
			switch(choice){
			case 1:
				if(drinks.isEmpty()){
					Show.showEmptyCoffeeMachine();
					System.exit(0);
				}
				Show.showChoice(drinks);
				choice = scan.nextInt();
				unSupplyCoffeeMachine(choice, Customer.getCash());
				break;
			case 2:
				Show.showExit();
				return false;
			}
			
		} catch(Exception e){
			Show.wrongValue();
		}
		return true;
	}
	private static boolean unSupplyCoffeeMachine(int choice, int cash){
		Coffee coffee=null;
		switch(choice){
		case 1:
			coffee = new Capuccino();
		
			break;
		case 2:
			coffee = new Late();
			break;
		case 3: 
			coffee = new Lyuvak();
			break;
		}
		if(coffee!=null){
			putIngredient(coffee);
		} else{
			Show.wrongValue();
			return false;
		}
		if(cash<coffee.getTotalPrice()){
			Show.showUnsuccessfulPurchase();
			return false;
		} 
		Show.showCoffeePurchaseChoice(coffee);
		choice = scan.nextInt();
		boolean flag = false;
		switch(choice){
			case 1: 
				flag=CoffeeMachine.takeCoffee(coffee);
				if(flag){
					Show.showSuccessfulPurchase(coffee);
					Customer.buy(coffee.getTotalPrice());
				} 
				break;
			case 2:
				Show.showUnsuccessfulPurchase();
				break;
		}
		return flag;
	}
	private static Coffee putIngredient(Coffee coffee){
		Ingredient ingredient;
		Show.actionsPutIngredient();
		CoffeeMaker cm = new CoffeeMaker();
		cm.setCoffee(coffee);
		int choic= scan.nextInt();
		while(choic!=2){
			Show.showAvailableIngredient();
			choic = scan.nextInt();
			ingredient = null;
			switch(choic){
				case 1:
					ingredient = new Cream();
					break;
				case 2:
						ingredient = new Milk();
						break;
				case 3: 
					ingredient = new Sugar();
					break;
			}
			if(ingredient!=null){
				cm.addIngredient(ingredient);
			} else{
				Show.wrongValue();
			}
			Show.actionsPutIngredient();
			choic= scan.nextInt();
		}
		return cm.getCoffee();
	}
}
