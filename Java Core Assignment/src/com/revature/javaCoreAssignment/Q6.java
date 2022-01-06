package com.revature.javaCoreAssignment;

public class Q6 {
	public void modulus(int a) {
		int temp = a/2;
		int fin = a-temp*2;
		if(fin == 1) {
			System.out.println("Odd");
		}else {
			System.out.println("Even");
		}
	}
}
