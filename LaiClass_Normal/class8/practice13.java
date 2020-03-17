package class8;

import java.util.*;

public class practice13 {

	// Permutations
	public static List<String> permutations(String set){
		List<String> res = new ArrayList<>();
		if(set == null) {
			return res;
		}
		char[] arr = set.toCharArray();
		helper(arr, 0, res);
		return res;
	}
	
	public static void helper(char[] set, int index, List<String> res) {
		if(index == set.length) {
			res.add(new String(set));
			return;
		}
		for(int i = index; i < set.length; i++) {
			swap(set, index, i);
			helper(set, index + 1, res);
			swap(set, index, i);
		}
	}
	
	public static void swap(char[] set, int index, int i) {
		char tmp = set[index];
		set[index] = set[i];
		set[i] = tmp;
	}

}
