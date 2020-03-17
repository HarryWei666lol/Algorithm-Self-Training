package StringII;
import java.util.*;

public class LongestSubStringWithOnlyUniqueChar_M {


	public int longest(String input) {
		// Assumptions: the input string is not null
		// the distinct set contains all distinct characters
		// in the sliding window of (slow, fast)
		
		Set<Character> distinct = new HashSet<>();
		int slow = 0;
		int fast = 0;
		int longest = 0;
		
		while(fast < input.length()){
			
			if(distinct.contains(input.charAt(fast))){
				
				// if there is duplicate character, move slow pointer
				
				distinct.remove(input.charAt(slow));
				slow++;
			} else {
				
				// if there is no duplicate character, slide fast pointer and we have
				// a sliding window of (slow, fast) containing all distinct characters
				
				distinct.add(input.charAt(fast));
				fast++;
				longest = Math.max(longest, fast - slow);
			}
		}
		return longest;
	}


}
