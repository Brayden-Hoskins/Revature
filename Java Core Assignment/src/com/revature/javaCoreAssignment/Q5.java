package com.revature.javaCoreAssignment;

public class Q5 {
	public static String makeSubStr(String s, int idx) {
		char[] myStr = s.toCharArray();
		char[] str = new char[idx];
		for(int i =0;i<idx;i++) {
			str[i] = myStr[i];
		}
		return new String(str);
	}
}
