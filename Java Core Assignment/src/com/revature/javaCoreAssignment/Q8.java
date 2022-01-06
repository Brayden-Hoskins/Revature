package com.revature.javaCoreAssignment;
import java.util.ArrayList;
public class Q8 {
	public boolean isPalindrome(String s) {
		// For every letter in the first half of the word
		for (int i = 0; i < s.length() / 2; ++i) {
			// Check if the letter has a sibling letter in the other half of the word
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				// If it does not, the word is not a palindrome
				return false;
		}
		
		// Because it never failed the above check, thus ending the method and returning false,
		// it must be a palindrome
		return true;
	}
	
	public void Palindrome() {
		
		ArrayList<String> palindromeCandidates = new ArrayList<String>();
		palindromeCandidates.add("karan");
		palindromeCandidates.add("madam");
		palindromeCandidates.add("tom");
		palindromeCandidates.add("civic");
		palindromeCandidates.add("radar");
		palindromeCandidates.add("jimmy");
		palindromeCandidates.add("kayak");
		palindromeCandidates.add("john");
		palindromeCandidates.add("refer");
		palindromeCandidates.add("billy");
		palindromeCandidates.add("did");
		
		// The below formulation is called for-each loop. The String s is the placeholder for the String of the "current iteration"
		ArrayList<String> palindromes = new ArrayList<String>();
		for (String s : palindromeCandidates) {
			if (isPalindrome(s))
				palindromes.add(s);
		}
		
		for (String s : palindromeCandidates)
			System.out.println(s + " ");
		
		for (String s : palindromes)
			System.out.println(s + " ");
	}
}

