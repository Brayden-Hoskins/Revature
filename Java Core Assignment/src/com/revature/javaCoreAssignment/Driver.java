package com.revature.javaCoreAssignment;

public class Driver {
	public static void main(String[] args) {
		System.out.println("Question 1");
		System.out.println("");
		Q1 myQ1 = new Q1();
		int[] arr = {1,0,5,6,3,2,3,7,9,8,4};
		myQ1.bubbleSort(arr);
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
		System.out.println("");
		System.out.println("Question 2");
		Q2 myQ2 = new Q2();
		int idx = 25;
		for(int i=0;i<idx;i++) {
			System.out.print(myQ2.fibonaci(i) + " ");
		}
		System.out.println("");
		System.out.println("Question 3");	
		System.out.println("");
		System.out.println("Question 4");
		Q4 myQ4 = new Q4();
		System.out.println(myQ4.factorial(10));
	}
}
