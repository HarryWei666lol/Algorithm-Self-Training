package StringII;
import java.util.*;

public class stringReplace_M {

	// Time O(n*m); Space O(1)
	
	// Method 1: not using String/Stringbuilder utility, using char[] to do it in-place
	public String replace(String input, String toBeReplaced, String replacement) {
		// Write your solution here
		// Assumptions: input, toBeReplaced, replacement are not null, toBeReplaced is not empty
		char[] arr = input.toCharArray();
		if(toBeReplaced.length() >= replacement.length()){
			return replaceShorter(arr, toBeReplaced, replacement);
		} 
		return replaceLonger(arr, toBeReplaced, replacement);
	}

	public String replaceShorter(char[] input, String toBeReplaced, String replacement){
		// can reuse the input char array since #characters needed is less
		// use fast and slow pointers both from left ot right direction
		int slow = 0;
		int fast = 0;
		while(fast < input.length){
			// when a match of source is found starting from fast pointer, copy replacement at slow ponter
			if(fast <= input.length - toBeReplaced.length() && equalSubString(input, fast, toBeReplaced)){
				copySubString(input, slow, replacement);
				slow += replacement.length();
				fast += toBeReplaced.length();
			} else{
				input[slow] = input[fast];
				slow++;
				fast++;
			}
		}
		return new String(input, 0, slow);
	}

	// check if SubString at fromIndex of input array is the same as source
	private boolean equalSubString(char[] input, int fromIndex, String source){
		for(int i = 0; i < source.length(); i++){
			if(input[fromIndex + i] != source.charAt(i)){
				return false;
			}
		}
		return true;
	}

	// copy String replacement to replace the subString source, starting at fromIndex of input array
	private void copySubString(char[] res, int fromIndex, String replacement){
		for(int i = 0; i < replacement.length(); i++){
			res[fromIndex + i] = replacement.charAt(i);
		}
	}

	public String replaceLonger(char[] input, String toBeReplaced, String replacement){
		// if requirement is "in-place" -> can assume given a long enough char array
		// the original input string resides on part of the char array starting from index 0
		ArrayList<Integer> matches = getAllMatches(input, toBeReplaced);
		// calculate new length needed
		char[] res = new char[input.length + matches.size() * (replacement.length() - toBeReplaced.length())];

		// fast and slow pointers both from right to left direction
		// slow: the position when traversing the new length
		// fast: the position when traversing the old length
		// lastIndex: the rightmost matching end-position's index

		int lastIndex = matches.size() - 1;
		int slow = res.length - 1;
		int fast = input.length - 1;

		while(fast >= 0){
			// only if we still have some match and slow is in the position of rightmost
			// matching end position, we should copy t
			if(lastIndex >= 0 && fast == matches.get(lastIndex)){
				copySubString(res, slow - replacement.length() + 1, replacement);
				slow -= replacement.length();
				fast -= toBeReplaced.length();
				lastIndex--;
			} else {
				res[slow] = input[fast];
				slow--;
				fast--;
			}
		}

		return new String(res);

	}

	private ArrayList<Integer> getAllMatches(char[] input, String source){
		ArrayList<Integer> matches = new ArrayList<>();
		int i = 0;
		while(i <= input.length - source.length()){
			if(equalSubString(input, i, source)){ // sliding window checking
				matches.add(i + source.length() - 1);
				i += source.length();
			} else {
				i++;
			}
		}
		return matches;
	}
	
	
	// Much higher time complexity
	// Method 2: Using Java's StringBuilder utility and String's indexOf(),
	// not using String's replace()...
	public String replacement(String input, String toBeReplaced, String replacement) {
		// Assumptions: input, toBeReplaced, replacement are not null, toBeReplaced is not empty
		StringBuilder sb = new StringBuilder();
		// we check if there exists a substring same as toBeReplaced
		// in the substring of input starting at fromIndex
		int fromIndex = 0;
		int matchIndex = input.indexOf(toBeReplaced, fromIndex);
		while(matchIndex != -1){
			sb.append(input, fromIndex, matchIndex).append(replacement);
			// Next time, we need to start from matchIndex + toBeReplaced.length()
			// to find if we have later matches
			fromIndex = matchIndex + toBeReplaced.length();
			matchIndex = input.indexOf(toBeReplaced, fromIndex);
		}
		sb.append(input, fromIndex, input.length());
		return sb.toString();
	}






}
