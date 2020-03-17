package class8;

import java.util.*;

public class HashSetAndStrings {
	
	// Zuma String Question
	
	// Remove particular character e.g. 'u' in 'student', in-place Qn1.1
	// Time O(n), Space O(1)
	public static void removeChar(StringBuilder input) {
		if(input.length() <= 0) {
			return;
		}
		int i = 0;
		for(int j = 0; j < input.length(); j++) {
			if(input.charAt(j) != 'u' || input.charAt(j) != 'n') {
				input.setCharAt(i, input.charAt(j));
				i++;
			}
		}
		input.delete(i, input.length());
	}
	
	
	// Char Removal -> Unnecessary Spaces Qn 1.2
	// Time O(n); Space O(1)
	public static String removeSpaces(String input) {
		if(input.isEmpty()) {
			return input;
		}
		char[] arr = input.toCharArray();
		int slow = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == ' ' && (i == 0 || arr[i - 1] == ' ')) {
				continue; // don't copy for 0th index or preceding index is also space
			}
			arr[slow] = arr[i];
			slow++;
		}
		
		// post-processing: it is possible we still have one trailing
		// space character at the end
		if(slow > 0 && arr[slow - 1] == ' ') {
			return new String(arr, 0, slow - 1); // max is exclusive of the index 'slow - 1' 
		} 
		
		return new String(arr, 0, slow);// max is exclusive of the index 'slow'
		
	}
	
	public static void main(String args[]) {
		//System.out.println(removeSpaces("  abc de  d  "));
		System.out.println(zumaRemoveDup("bawxxxwwaabc"));
	}
	
	// Char De-duplication(Remove duplicated and adjacent letters) Qn2.1
	public static String charDedup1() {
		return new String("");
	}
	
	
	
	// Char De-duplication(Zuma Version) Qn2.2 
	// Time O(n), Space O(n)
	public static String zumaRemoveDup(String input) {
		if(input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();
		
		Deque<Character> stack = new ArrayDeque<>();
		int f = 0;
		while(f < arr.length) {
			char c = arr[f];
			if(stack.size() > 0 && c == stack.peekLast()) {
				while(f < arr.length && c == arr[f]) {
					f++;
				}
				stack.pollLast();
			} else {
				stack.offerLast(arr[f]);
				f++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char s : stack) {
			sb.append(s);
		}
		
		return sb.toString();
	}

}
