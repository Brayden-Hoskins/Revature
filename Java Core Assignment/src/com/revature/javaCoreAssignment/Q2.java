package com.revature.javaCoreAssignment;

public class Q2 {
	static int fibonaci(int n) {
		if(n<= 1)
			return n;
		return fibonaci(n-1)+ fibonaci(n-2);
	}
}
