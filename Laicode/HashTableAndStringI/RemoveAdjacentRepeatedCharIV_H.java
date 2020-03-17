package HashTableAndStringI;
import java.util.*;

public class RemoveAdjacentRepeatedCharIV_H {
	// Method 1
	public String deDupI(String input) {
		// Write your solution here
		if(input.length() == 0) {
			return input;
		}
		char[] arr = input.toCharArray();

		Deque<Character> stack = new ArrayDeque<>();
		int f = 0;
		while(f < arr.length) {
			char c = arr[f];
			if(stack.size() > 0 && c == stack.peekFirst()) {
				while(f < arr.length && c == arr[f]) {
					f++;
				}
				stack.pollFirst();
			} else {
				stack.offerFirst(arr[f]);
				f++;
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char s : stack) {
			sb.append(s);
		}

		return sb.reverse().toString();
	}

	public String deDupII(String input) {
		// Write your solution here
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
	
	// Method 2:
	// Wanted and advanced but hard method
	public String deDepIII(String input){
		if(input == null || input.length() <= 1){
			return input;
		}
		char[] array = input.toCharArray();
		// instead of using an extra stack explicitly, we can actually reuse the left side of 
		// the original char[] as the "stack"
		// slow: is where the top of the stack is.
		int slow = 0;
		for(int fast = 1; fast < array.length; fast++){
			// if stack is empty(when end == -1) or there is no duplicate chars,
			// we are able to push the character into the stack
			if(slow == -1 || array[fast] != array[slow]){
				array[++slow] = array[fast];
			} else {
				// otherwise, we need to pop the top element by slow--;
				// and ignore all the consecutive duplicate chars
				slow--;
				while(fast + 1 < array.length && array[fast] == array[fast + 1]){
					fast++;
				}
			}
		}
		return new String(array, 0, slow + 1);
	}



}
