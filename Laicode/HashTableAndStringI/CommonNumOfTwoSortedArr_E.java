package HashTableAndStringI;
import java.util.*;

public class CommonNumOfTwoSortedArr_E {

	// Time O(m+n); Space O(1)
	public List<Integer> common(int[] a, int[] b) {
		// Write your solution here
		List<Integer> common = new ArrayList<Integer>();
		int i = 0, j = 0;
		while(i < a.length && j < b.length){
			if(a[i] == b[j]){
				common.add(a[i]);
				i++;
				j++;
			} else if (a[i] < b[j]){
				i++;
			} else {
				j++;
			}
		}
		return common;
	}

	// TIme O(n) on average; O(n^2) worst case; Space O(n)
	public List<Integer> commonII(int[] a, int[] b){
		List<Integer> common = new ArrayList<Integer>();

		// Time O(n) on average; O(n^2) worst case
		HashMap<Integer, Integer> countA = new HashMap<Integer, Integer>();
		for(int num : a){
			Integer ct = countA.get(num);
			if(ct != null){
				countA.put(num, ct + 1);
			} else {
				countA.put(num, 1);
			}
		}

		// Time O(n) on average; O(n^2) worst case
		HashMap<Integer, Integer> countB = new HashMap<Integer, Integer>();
		for(int num : b){
			Integer ct = countB.get(num);
			if(ct != null){
				countB.put(num, ct + 1);
			} else {
				countB.put(num, 1);
			}
		}

		// Time O(m) on average; O(m*n) worst case
		for(Map.Entry<Integer, Integer> entry : countA.entrySet()){
			Integer ctInB = countB.get(entry.getKey());
			if(ctInB != null){
				int appear = Math.min(entry.getValue(), ctInB);
				for(int i = 0; i < appear; i++){
					common.add(entry.getKey());
				}
			}
		}
		return common;
	}



}
