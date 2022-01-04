package com.revature.javaCoreAssignment;

public class Q1 {
	public void bubbleSort(int[] arr) {
		for(int i =0;i<arr.length-1;i++) {
			for(int idx = 0;idx<arr.length-i-1;idx++) {
				if(arr[idx]>arr[idx+1]) {
					int currentVal = arr[idx];
					arr[idx] = arr[idx+1];
					arr[idx+1] = currentVal;
				}
			}
		}
	}
}
