package coffe_machine.viewer;

import java.util.Map;

import coffe_machine.component.Coffee;

public class Show {
	public static void showChoice(Map<Coffee, Integer> drinks){
		
		System.out.println("---------------------------------");
		System.out.println("Coffee name          Portion");
		int i=1;
		for(Coffee coffee: drinks.keySet()){
			if(coffee.getName().toUpperCase().equals(CoffeeEnum.LATE.name())){
				i=2;
			} if (coffee.getName().toUpperCase().equals(CoffeeEnum.LYUVAK.name())){
				i=3;
			}
			System.out.println(i+"  "+coffee.getName() + "  ["+drinks.get(coffee)+"]");
		}
	}
	public static void showAvailableIngredient(){
		int i=0;
		System.out.println("---------------------------------");
		System.out.println("Ingredients         Price");
		for(IngredientEnum ie : IngredientEnum.values()){
			System.out.println((++i)+"  "+ie.name()+"    ["+ie.getPrice()+"]");
		}
		System.out.println("---------------------------------");
		System.out.println();
		System.out.println("Choose please item:   ");
	}
	public static void showAvailableCoffee(){
		System.out.println("---------------------------------");
		System.out.println("Item   Coffee name      Price");
		for(CoffeeEnum ce : CoffeeEnum.values()){
			System.out.println(ce.getIndex()+"      "+ce.name()+"           ["+ce.getPrice()+"]");
		}
		System.out.println("---------------------------------");
		System.out.println();
		System.out.println("Choose please item:   ");
	}
	public static void actions(){
		System.out.println("----------------");
		System.out.println("1   Put");
		System.out.println("2   Take");
		System.out.println("3   Exit");
		System.out.println("----------------");
		System.out.println();
		System.out.println("Choose please action:   ");
	}
	public static void actionsMakeCoffee(){
		System.out.println("----------------------------");
		System.out.println("1   I want to order coffee");
		System.out.println("2   No, I do not. Maybe later.");
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("Choose please action:   ");
	}
	public static void actionsPutIngredient(){
		System.out.println("-----------------------------");
		System.out.println("1   I want to put ingredient");
		System.out.println("2   No, I do not. Maybe later.");
		System.out.println("-----------------------------");
		System.out.println();
		System.out.println("Choose please action:   ");
	}
	public static void wrongValue(){
		System.err.println("Wrong argument. Be attentive.");
	};
	private static void showCoffeePrice(Coffee coffee){
		int totalPrice= coffee.getTotalPrice();
		System.out.println(totalPrice);
	}
	public static void showSuccessfulPurchase(Coffee coffee){
		System.out.println("Please take your coffee: ");
		System.out.println(coffee);
	}
	public static void showUnsuccessfulPurchase(){
		System.err.println("\nSorry, order is cancelled either your cash is not enough,");
		System.err.println("either you has cancelled yourself.");
	}
	public static void showCoffeePurchaseChoice(Coffee coffee){
		System.out.println("--------------------------");
		System.out.println("Your order: ");
		System.out.println(coffee);
		System.out.println("Would you like to pay the order? ");
		System.out.println("1    Yes");
		System.out.println("2    No");
	}
	public static void showExit(){
		System.out.println("exiting...");
	}
	public static void showEmptyCoffeeMachine(){
		System.out.println("\n Coffee Machine is empty. Sorry, you can try again after 1000 years.");
	}
}
