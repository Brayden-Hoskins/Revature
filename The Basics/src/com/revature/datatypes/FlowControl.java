package com.revature.datatypes;

public class FlowControl {
	public void flowControl() {
		boolean myBool = true;
		int i = 5;
		if(myBool) {
			//code to run 
		}else if(i>5) {
			// code to run
		}else {
			//Code to run if all other conditions aren't met
		}
		
		//Loops
		while(myBool) {
			//code to run while myBool is true
			
			//To stop the while loop
			myBool = false;
			// Or
			break;
		}
		// Do-While Loop
		do {
			//code to execute at least 1 time
		}while(myBool);
		String[] names = {"Jacob","Daniel","Aaron"};
		
		// Loops with a specific number of iterations
		for(int idx =0; idx<names.length; ++idx) {
			System.out.println(names[i]);
		}
		// Enhanced For Loop
		for(String s : names) { // iterates over every item
			System.out.println(s);
		}
		
		// Switch statements
		String name = names[0];
		switch (name) {
		case "Jacob":
			System.out.println("wow its Jacob");
			break;// if there is no break, switch statement will fall through to the next case
		case "Daniel":
			System.out.println("wow its Daniel");
			break;
		default:
			//code for when no applicable case is found
		}	
		}
		
	}
