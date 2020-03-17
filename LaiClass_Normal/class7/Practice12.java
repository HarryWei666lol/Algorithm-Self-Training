package class7;
import java.util.*;

public class Practice12 {

	// All valid subsets
	public static List<String> subset(String s){
		List<String> res = new ArrayList<>();
		if(s == null) {
			return res;
		}
		char[] charArr = s.toCharArray();
		// record the current subset
		StringBuilder sb = new StringBuilder();
		helper(charArr, sb, 0, res);
		return res;

	}

	// At each level, determine whether the character at the position 
	// "index" will be picked or not
	private static void helper(char[] charArr, StringBuilder sb, int index, List<String> result) {
		// terminate condition:
		// when we finishes determining for all the characters pick or not
		// we have a complete subset
		if(index == charArr.length) {
			result.add(sb.toString());
			return;
		}
		// 1. not picking the character at index
		helper(charArr, sb, index + 1, result);
		// 2. pick the character at index
		sb.append(charArr[index]);
		helper(charArr, sb, index + 1, result);
		// remember to remove the added character when backtracking
		// to the previous level
		sb.deleteCharAt(sb.length() - 1);
	}



	// All permutations of Parentheses

	// n stores the number of pairs of parentheses needed to add
	public static void BFS(int n, int l, int r, StringBuilder soluSoFar) {
		if(l == n && r == n) { // base case
			System.out.println(soluSoFar.toString()); // toString() is also 
			// new-ing a new String -> MUST do!!!
			return;
		}
		// Case1: add '(' on this level
		if(l < n) {
			soluSoFar.append('(');
			BFS(n, l + 1, r, soluSoFar);
			soluSoFar.deleteCharAt(soluSoFar.length() - 1);
		}
		// Case2: add ')' on this level
		if(l > r) {
			soluSoFar.append(')');
			BFS(n, l, r + 1, soluSoFar);
			soluSoFar.deleteCharAt(soluSoFar.length() - 1);
		}
	}

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		BFS(3, 0, 0, sb);

	}

	// All Permutations of a string without duplicates
	public List<String> permutation(String s){ // DFS solution with swapping
		List<String> list = new ArrayList<>();
		if(s == null) {
			return list;
		}
		char[] charArr = s.toCharArray();
		helper(charArr, 0, list);
		return list;
	}

	// Choose the character to be at the position of "index"
	// all the already chosen positions are (0, index - 1)
	// all the candidate characters can be at position "index"
	// are in the sub-array of (index, array.length - 1)
	private static void helper(char[] charArr, int index, List<String> res) {
		// Terminate Condition:
		// only when we have already chosen the characters for all the position,
		// we can have a complete permutation
		if(index == charArr.length) {
			res.add(new String(charArr)); // MUST new-ed a new string -> Deep-copy
			return;
		}

		// all the possible characters could be placed at index are
		// the characters in the subarray(index, array.length - 1)
		for(int i = 0; i < charArr.length; i++) {
			swap(charArr, index, i);
			helper(charArr, index + 1, res);
			// remember to swap back when backtracking to previous level
			swap(charArr, index, i);
		}
	}

	private static void swap(char[] arr, int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	// All Combinations of Coins
	public List<List<Integer>> combinations(int target, int[] coins){
	    // Each combination is represented as a List<Integer> curr
	    // and curr.get(i) = the number of coins of coins[i]
	    // all the combinations are stored in the res as List of List<Integer>
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> curr = new ArrayList<>();
		if(target == 0) {
			return res;
		}
		int moneyLeft = target;
		helper(coins, moneyLeft, 0, curr, res);
		return res;
	}
	
	private void helper(int[] coins, int moneyLeft, int index, List<Integer> curr, List<List<Integer>> res) {
	    // terminate condition:
	    // Note: this can also be done at index == coins.length where all the coins have been picked
	    // but a probably better one is at a previous level to reduce the number of unncessary branches
	    // in the DFS
	    // Think about it, coins.length - 1 represents the last coin we can use and actually what we can
	    // do at this level is to get moneyLeft / coins[coins.length - 1] coins if possible
		if(index == coins.length - 1) {
			if(moneyLeft % coins[index] == 0) {
				curr.add(moneyLeft /coins[index]);
				res.add(new ArrayList<>(curr));
				curr.remove(curr.size() - 1);
				// remove the just-added element for future usage 
		        // as this curr already exists in res
			}
		}
		
		// for coins[index], we can pick 0, 1, 2, .... , (moneyLeft/ coins[index]) coins
		int max = moneyLeft / coins[index];
		for(int i = 0; i <= max; i++) {
			curr.add(i);
			helper(coins, moneyLeft - i * coins[index], index + 1, curr, res);
			// remember to modify the remaining cents for the next level
			curr.remove(curr.size() - 1); // for back-tracking
		}
	}

}
