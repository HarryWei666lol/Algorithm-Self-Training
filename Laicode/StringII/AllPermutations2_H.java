package StringII;
import java.util.*;

public class AllPermutations2_H {

	public class Solution {
		public List<String> permutations(String input) {
			// Write your solution here
			List<String> res = new ArrayList<>();
			if(input == null){
				return res;
			}
			char[] arr = input.toCharArray();
			helper(res, 0, arr);
			return res;
		}

		// index: at the level of index, we are to determine for the current permutation, 
		// which element is positioned at the index
		public void helper(List<String> res, int index, char[] arr){
			if(index == arr.length){
				// base case: when we have determined for all the indices of the
				// current permutation which element to choose
				res.add(new String(arr));
				return;
			}

			// Notice: the rule is just for the current level, if a certain element is picked,
			// we cannot pick any of its duplicates
			// so that we use a set to record all the distinct elements
			Set<Character> used = new HashSet<Character>();
			for(int i = index; i < arr.length; i++){
				// user.add(arr[i]) will return false if the value of arr[i]
				// is already in the Set
				if(used.add(arr[i])){
					swap(arr, i, index);
					// go for the next level, index + 1
					helper(res, index + 1, arr);
					// don't forget to do the clear operation when backtracking
					swap(arr, i, index);
				}
			}
		}

		private void swap(char[] arr, int left, int right){
			char tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
		}
	}


}
