package coffe_machine.controller;

import coffe_machine.component.CoffeeMachine;
import coffe_machine.component.Customer;

public class FrontController {

public static void main(String[] args) {
	Customer.setCash(33);
	boolean flag = true;
	System.out.println("At first we should supply coffee machine. Is not it?\n");
	while(flag){
		flag=Controller.supplyCoffeeMachine();
	}
	flag=true;
	System.out.println("\nNow you can go to the order of coffee.");
	while(flag){
		flag = Controller.makeCoffee(); 
	}
	
}
}
