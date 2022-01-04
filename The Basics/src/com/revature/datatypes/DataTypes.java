package com.revature.datatypes;

public class DataTypes {
	public void dataTypes() {
		//Numbers
		int i = 0; // 32 bits, initialized variable
		short s; // 16 bits, variable declaration
		long l; //64 bits
		//Decimals/fractions
		float f = 3.9f; // 32 bits
		double d = 3.9; // 64 bits
		// Letters
		char c = 'c'; // 16 bits
		//True/False
		boolean b = true;
		//The Basic unit
		byte bt; //8 bits
	}
	public int add(int a, int b) {
		return a+b;
	}
	public void printDogName(Dog d) {
		System.out.println("Your dog's name is: " + d.name);
	}
}
