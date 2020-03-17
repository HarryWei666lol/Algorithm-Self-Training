package HashTableAndStringI;
import java.util.*;

public class MissingNumber1_M {

	// method 1 - use HashSet
	public int missing1(int[] array) {
		int n = array.length + 1;
		HashSet<Integer> set = new HashSet<>();
		for(int a : array){
			set.add(a);
		}
		for(int i = 1; i < n; i++){
			if(!set.contains(i)){
				return i;
			}
		}
		return n;
	}

	// method 2 - use sum
	public int missing2(int[] array){
		int n = array.length + 1;
		long targetSum = (n + 0L) * (n + 1) / 2;
		long actualSum = 0L;
		for(int a : array){
			actualSum += a;
		}
		return (int) (targetSum - actualSum);
	}

	// method 3 - bit operations - O(n)
	public int missing3(int[] array){
		int n = array.length + 1;
		int xor = 0;
		// xor 1 to n
		for(int i = 1; i <= n; i++){
			xor ^= i;
		}
		// after this operation, all the numbers from 1 to n
		// are pair xor'ed except for the missing number
		// since x^x = 0, the remaining number is the result
		for(int a : array){
			xor ^= a;
		}
		return xor;
	}




}
