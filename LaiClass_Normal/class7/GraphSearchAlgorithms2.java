package class7;


public class GraphSearchAlgorithms2 {

	// print all subsets of a set
	
	// Time = O(2^n)
	// Space = O(height) = O(n)
	public static void findSubset(char[] input, int index, StringBuilder solutionPrefix) {
		if(index == input.length) { // Base case: print solution
			System.out.println(solutionPrefix);
			return;
		}
		
		// case 1: add input[index] to the solution prefix
		solutionPrefix.append(input[index]);
		findSubset(input, index + 1, solutionPrefix);
		
		solutionPrefix.deleteCharAt(solutionPrefix.length() - 1); // breaking point
		
		// case 2: do not add input[index] to the solution prefix
		findSubset(input, index + 1, solutionPrefix);
	}
	
	// find all valid permutations using the parenthesis provided
	
	// Time O(2^(2n))
	// Space O(height) = O(2n)
	public static void allValidParenthesisPerm(int n, int l, int r, StringBuilder soluPrefix) {
		// n is total number of 'pair of ()' needed to add -> total level = 2n
		if(l == n && r == n) {
			System.out.println(soluPrefix);
			return;
		}
		
		if(l < n) { // less restrictive
			soluPrefix.append('(');
			allValidParenthesisPerm(n, l + 1, r, soluPrefix);
			soluPrefix.deleteCharAt(soluPrefix.length() - 1);
		}
		
		if(l > r) {
			soluPrefix.append(')');
			allValidParenthesisPerm(n, l, r + 1, soluPrefix);
			soluPrefix.deleteCharAt(soluPrefix.length() - 1);
		}	
	}
	
	// Print all combinations of coins that can sum up to a total value n
	
	// Time O(99^4)
	public static void coinCombination(int[] coin, int moneyLeft, int index, int[] sol) {
		if(index == 3) {
			sol[index] = moneyLeft;
			for(int c : coin) {
				System.out.print(c + " ");
			}
			return;
		}
		
		for(int i = 0; i * coin[index] <= moneyLeft; i++) {
			sol[index] = i;
			coinCombination(coin, moneyLeft - i * coin[index], index + 1, sol);
		}
	}
	
	// Given a string with no duplicate letters, how to print out all permutations of the string
	// Time O(n!)
	public static void allPermOfStringWithNoDup(char[] input, int index) {
		if(index == input.length) {
			System.out.println(input);
			return;
		}
		for(int i = index; i < input.length; i++) {
			swap(input, index, i);
			allPermOfStringWithNoDup(input, index + 1);
			swap(input, index, i);
		}
	}
	
	private static void swap(char[] input, int a, int b) {
		char tmp = input[a];
		input[a] = input[b];
		input[b] = tmp;
	}

}
