package com.revature.javaCoreAssignment;

import java.util.Scanner;

public class Q15 implements calculator{
	public double addition(double x, double y) {
		return x+y;
	}
	public double subtraction(double x, double y) {
		return x-y;
	}
	public double multiply(double x, double y) {
		return x*y;
	}
	public double divide(double x, double y) {
		return x/y;
	}
	public void display() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter operation (+,*,etc):");
		String myStr = input.nextLine();
		System.out.println("Enter a number:");
		double x = input.nextDouble();
		System.out.println("Enter a number:");
		double y = input.nextDouble();
		input.close();
		switch(myStr) {
		case "+":
			System.out.println(x + "+" + y + " = " + addition(x,y));
			break;
		case "-":
			System.out.println(x + "-" + y + " = " + subtraction(x,y));
			break;
		case "*":
			System.out.println(x + "*" + y + " = " + multiply(x,y));
			break;
		case "/":
			System.out.println(x + "/" + y + " = " + divide(x,y));
			break;
	}
}
}
