package easy;

public class Qn1170CompareStringsByFreqOfSmallestChar {

	// 1) queries = [“cbd”], words = [“zaaaz"]
	// 2) queries = [“bbb”, “cc”], words = [“a”, “aa”, “aaa”, “aaaa”]
	public int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] buckets = new int[12];
		for(String w: words){
			int[] memo = new int[26];
			char smallestChar = 'z';
			for(char currChar : w.toCharArray()){
				int tmp = currChar - 'a';
				memo[tmp]++;
				if (currChar < smallestChar){
					smallestChar = currChar;
				}
			}
			// 1) memo: [3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2]

			// 2) memo: [1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2]
			//    memo: [2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2]
			//    memo: [3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2]
			//    memo: [4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,2]
			int indexMemo = smallestChar - 'a';
			int indexBucket = memo[indexMemo];
			buckets[indexBucket]++;
		}
		// 1) buckets: [0,0,0,1,0,0,0,0,0,0,0,0]

		// 2) buckets: [0,1,1,1,1,0,0,0,0,0,0,0]

		for(int i = 10; i >= 0; i--){
			buckets[i] = buckets[i] + buckets[i+1];
		}
		// 1) buckets: [1,1,1,1,0,0,0,0,0,0,0,0]
		//                  y1  

		// 2) buckets: [4,4,3,2,1,0,0,0,0,0,0,0]
		//                   y2 y1

		int n = queries.length;
		int[] res = new int[n];
		for(int i = 0; i < n; i++){
			int[] memo = new int[26];
			char smallestChar = 'z';
			for(char currChar : queries[i].toCharArray()){
				int tmp = currChar - 'a';
				memo[tmp]++;
				if(currChar < smallestChar){
					smallestChar = currChar;
				}
			}
			// 1) memo: [0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]

			// 2) memo: [0,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
			//    memo: [0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]
			int indexMemo = smallestChar - 'a';
			int indexBucket = memo[indexMemo];
			res[i] = buckets[indexBucket + 1];
			// 1) res: [1]
			// 2) res: [1,2]
		}

		return res;
	}
}


