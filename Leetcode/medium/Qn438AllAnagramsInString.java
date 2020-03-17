package medium;
import java.util.*;

public class Qn438AllAnagramsInString {
	
	// Method 1: use Array
	// Time 88.46%, Space 6%
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> res = new ArrayList<>();
		if(s.length() == 0 || s == null){
			return res;
		}
		int[] charCounts = new int[26];
		for(char c : p.toCharArray()){
			charCounts[c - 'a']++;
		}

		int left = 0;
		int right = 0;
		int count = p.length();

		while(right < s.length()){
			if(charCounts[s.charAt(right++)-'a']-- >= 1){
				count--;
			}
			if(count == 0){
				res.add(left);
			}

			if(right - left == p.length() && charCounts[s.charAt(left++) - 'a']++ >= 0){
				count++;
			}
		}

		return res;
	}
	
	// Method 2: HashMap
	
	// Time 41.61%, Space 6%
	public List<Integer> findAnagrams2(String input, String check) {
        // Find all anagrams of String s in String l, return all starting indices
        // Assumptions: s is check, l is input are not null, s is not empty
        List<Integer> res = new ArrayList<>();
        if(input == null || input.length() == 0){
          return res;
        }
        // when s is longer than l, there is no way any of the substrings of l 
        // could be an anagram of s
        if(check.length() > input.length()){
          return res;
        }
        // This map records for each of the distinct characters in s
        // how many characters are needed
        // e.g. s = "abbc", map = {'a': 1, 'b': 2, 'c' : 1}
        // when we get an instance of 'a' in 1, we let count of 'a' decrement by 1,
        // and only when count is from 1 to 0, we have 'a' totally matched
        Map<Character, Integer> map = countMap(check);
        // Record how many distinct characters have been matched
        // only when all distinct characters are matched, A.K.A
        // match == map.size(), we find an anagram

        int match = 0;
        // we have a sliding window of size s.length(), and since the size is fixed
        // we only need to record the end index of the sliding window.
        // also, when move the sliding window by one step from left to right,
        // what we only need to change is
        // 1. remove the leftmost character at the previous sliding window
        // 2. add the rightmost character at the current sliding window

        for(int i = 0; i < input.length(); i++){
          // handle the new added character(rightmost) at the current sliding window
          char tmp = input.charAt(i);
          Integer count = map.get(tmp);
          if(count != null){
            // the number of needed count should be --
            // and only when the count is from 1 to 0, 
            // we find an additional match of distinct character
            map.put(tmp, count - 1);
            if(count == 1){
              match++;
            }
          }
          // handle the leftmost character at previous sliding window
          if(i >= check.length()){
            tmp = input.charAt(i - check.length());
            count = map.get(tmp);
            if(count != null){
              // the number of needed count should be ++
              // and only when the count is from 0 to 1, we are short for one
              // match of distinct character
              map.put(tmp, count + 1);
              if(count == 0){
                match--;
              }
            }
          }
          // for the current sliding window, if all the distinct characters are matched
          // (the count are all zero)
          if(match == map.size()){
            res.add(i - check.length() + 1);
          }
        }
        return res;
    }
    
    private Map<Character, Integer> countMap(String check){
        Map<Character, Integer> map = new HashMap<>();
        for(char c : check.toCharArray()){
          Integer count = map.get(c);
          if(count == null){
            map.put(c, 1);
          } else {
            map.put(c, count + 1);
          }
        }
        return map;
    }



}
