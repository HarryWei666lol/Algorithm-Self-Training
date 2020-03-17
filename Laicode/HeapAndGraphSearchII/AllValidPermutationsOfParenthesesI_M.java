package HeapAndGraphSearchII;
import java.util.*;

public class AllValidPermutationsOfParenthesesI_M {

	public List<String> validParenthesess(int n) {
		// Write your solution here
		List<String> res = new ArrayList<>();
		if(n == 0){
			return res;
		}
		StringBuilder sb = new StringBuilder();
		helper(n, 0, 0, sb, res);
		return res;
	}

	// l: how many '(' we still have
	// r: how many ')' we still have
	// 
	private void helper(int n, int l, int r, StringBuilder soluPrefix, List<String> res){
		// terminate condition: when we have n pairs of '()'' already added
		if(l == n && r == n){
			res.add(soluPrefix.toString());
			return;
		}
		if(l < n){ // whenever there is some '(' we can still use (that is, l < n)
			soluPrefix.append('(');
			helper(n, l+1, r, soluPrefix, res);
			soluPrefix.deleteCharAt(soluPrefix.length() - 1);
		}

		if(l > r){ 
			// when there is more '(' than ')' used because each ')' 
			// should be associated with a previous '('
			soluPrefix.append(')');
			helper(n, l, r+1, soluPrefix, res);
			soluPrefix.deleteCharAt(soluPrefix.length() - 1);
		}
	}

	public List<String> validParentheses(int k){
		List<String> res = new ArrayList<>();
		if(k == 0){
			return res;
		}
		char[] curr = new char[2*k]; // the final string contains 2k characters
		helper(curr, k, k, 0, res);
		return res;
	}

	// left: how many '(' we still have
	// right: how many ')' we still have
	// index: the current position in curr we want to fill in with either '(' or ')'
	private void helper(char[] curr, int left, int right, int index, List<String> res){
		// terminate condition:
		// when we do not have any parentheses left
		if(left == 0 && right == 0){
			res.add(new String(curr));
			return;
		}

		// when we can add a '(' ? 
		// whenever there is some '(' we can still use
		if(left > 0){
			curr[index] = '(';
			helper(curr, left - 1, right, index + 1, res);
			// Note: it looks like we do not do anything when back-tracking to the previous level.
			// The code is still correct because: 
			// 1. We are setting the character at index and when back-tracking, what we need is just
			//   1) remove the character at index and 
			//   2) add a different character at index
			// 2. only when we fill in all the positions in curr, we have a complete solution.
			// the code itself actually already suffices the above 2 points and it already does 
			// the correct removing operation when back-tracked to the previous level
		}

		// when we can add a ')'?
		// when there is more '(' than ')' used, because each ')' should be associated with 
		// a previous '('

		if(right > left){
			curr[index] = ')';
			helper(curr, left, right - 1, index + 1, res);
		}
	}
}
