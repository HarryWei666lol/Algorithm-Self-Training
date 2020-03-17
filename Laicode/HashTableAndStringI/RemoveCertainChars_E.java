package HashTableAndStringI;
import java.util.*;

public class RemoveCertainChars_E {

	public String remove(String input, String t) {

		// convert immutable String to char[] to solve the problem in-place
		char[] arr = input.toCharArray();

		// Get a set of all distinct characters in t so that lookup operation will be efficient
		Set<Character> set = buildSet(t);
		// slow: [0, slow) contains the valid result
		// fast: [fast, arr.length) is the area to explore
		int slow = 0;
		for(int fast = 0; fast < arr.length; fast++){
			// the exploring character can only be put into valid area if it is not in the set
			if(!set.contains(arr[fast])){
				arr[slow++] = arr[fast];
			}
		}
		// convert the char[] subarray back to String object
		return new String(arr, 0, slow);
	}

	private Set<Character> buildSet(String t){
		Set<Character> set = new HashSet<Character>();
		for(int i = 0; i < t.length(); i++){
			set.add(t.charAt(i));
		}
		return set;
	}



}
