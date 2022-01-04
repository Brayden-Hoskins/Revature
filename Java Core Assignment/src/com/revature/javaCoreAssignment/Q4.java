package com.revature.javaCoreAssignment;

public class Q4 {
	public static int factorial(int i) {
		if(i<=2) {
			return i;
		}
		return factorial(i-1)*i;
}
}