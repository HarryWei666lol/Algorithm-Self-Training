package HashTableAndStringI;
import java.util.*;

public class TopKFrequentWords_M {


	// Assumptions: combo is not null, and k >= 1
	public String[] topKFrequent(String[] combo, int k) {
		// Write your solution here
		if(combo.length == 0){
			return new String[0];
		}
		
		// Step 1: O(n) on average, O(n^2) worst case
		
		// get all the distinct strings as keys and their frequencies as values
		// NOTE: the freqMap has at least size 1
		Map<String, Integer> freqMap = getFreqMap(combo);

		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, 
				new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2){
				// compare the frequencies, directly call the compareTo method since 
				// the frequencies are represented by Integer
				return e1.getValue().compareTo(e2.getValue());
			}
		});

		// Step 2:O(k + (n-k)logk)
		for(Map.Entry<String, Integer> entry : freqMap.entrySet()){
			if(minHeap.size() < k){
				minHeap.offer(entry);
			} else if (entry.getValue() > minHeap.peek().getValue()){
				minHeap.poll();
				minHeap.offer(entry); // automatic balancing
			}
		}
		// Since the returned array requires the strings sorted by their frequencies,
		// use a separate helper method to do this operation
		return freqArray(minHeap);
	}

	private Map<String, Integer> getFreqMap(String[] combo){
		Map<String, Integer> freqMap = new HashMap<>();
		// NOTE: when possible, choose the most efficient way for HashMap operations
		for(String s : combo){
			Integer freq = freqMap.get(s);
			if(freq == null){
				freqMap.put(s, 1);
			} else {
				freqMap.put(s, freq + 1);
			}
		}
		return freqMap;
	}

	private String[] freqArray(PriorityQueue<Map.Entry<String, Integer>> minHeap){
		String[] res = new String[minHeap.size()];
		for(int i = minHeap.size() - 1; i >= 0; i--){
			res[i] = minHeap.poll().getKey();
		}
		return res;
	}




}
