package com.revature.javaCoreAssignment;

public class Q3 {
	public String wordReverse(String s) {
		String myStr = "";
		char c;
		for(int i = 0; i<s.length(); i++) {
			c = s.charAt(i);
			myStr = c + myStr;
		}
		return myStr;
	}
}
