package com.revature.javaCoreAssignment;

public class Q12 {
	int[] numArray = new int[100];
	public int[] populateArray() {
		int counter = 1;
		for(int i=0;i<100;i++) {
			this.numArray[i] = counter;
			counter++;
		}
		return numArray;
	}
	public void printEvens(int[] arr) {
		for(int i : arr) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		}
	}
}
