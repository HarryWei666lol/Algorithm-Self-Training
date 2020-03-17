package medium;
import java.util.*;

public class Qn49GroupAnagram {

    // Time 87.05%, Space 36.26%
    // Time Complexity: O(NKlogK), where NN is the length of strs, 
	// and K is the maximum length of a string in strs. 
	// The outer loop has complexity O(N) as we iterate through 
	// each string. Then, we sort each string in O(KlogK) time.


    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs == null || strs.length == 0){
            return new ArrayList<List<String>>();
        }
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr); // Arrays.sort() can only sort any typed array
            String tmp = String.valueOf(arr);
            if(!map.containsKey(tmp)){
                map.put(tmp, new ArrayList<String>());
            }
            map.get(tmp).add(s);
        }
        return new ArrayList<List<String>>(map.values());
    }

}
