package com.revature.addingMachine;
import java.util.Scanner;
public class Driver {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter operation (+,*,etc):");
		String myStr = input.nextLine();
		System.out.println("Enter an integer:");
		int x = input.nextInt();
		System.out.println("Enter an integer:");
		int y = input.nextInt();
		
		AddingMachine a1 = new AddingMachine();
		switch(myStr) {
		case "+":
			System.out.println(x + "+" + y + " = " + a1.addNums(x,y));
			break;
		case "-":
			System.out.println(x + "-" + y + " = " + a1.subNums(x,y));
			break;
		case "*":
			System.out.println(x + "*" + y + " = " + a1.multNums(x,y));
			break;
		case "/":
			System.out.println(x + "/" + y + " = " + a1.divNums(x,y));
			break;
		}
	}
}
