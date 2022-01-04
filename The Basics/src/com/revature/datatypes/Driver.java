package com.revature.datatypes;

public class Driver {
	public static void main(String[] args) {
		DataTypes dt = new DataTypes();
		System.out.println(dt.add(3, 4));
		
		
		Dog felix = new Dog(), henry = new Dog(), patty = new Dog();
		felix.name = "Felix";
		felix.age = 4;
		felix.breed = "Lab";
		felix.weight = 85.5;
		
		dt.printDogName(felix);
	}
}
