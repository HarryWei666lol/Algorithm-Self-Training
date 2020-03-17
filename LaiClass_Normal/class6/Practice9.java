package class6;
import java.util.*;

public class Practice9 {
	// k smallest in unsorted array
	// Method 1
	// Time O(nlogn + klogn)
	// Space O(n + k)
	public static int[] smallestKElementsNHeap(int[] arr, int k) {
		Queue<Integer> minHeap = new PriorityQueue<Integer>();
		for(int i = 0; i < arr.length; i++) {
			minHeap.offer(arr[i]);
		}

		int[] result = new int[k];
		for(int i = 0; i < k; i++) {
			result[i] = minHeap.poll();
		}
		return result;
	}


	// k smallest in unsorted array
	// Method 2
	// Time
	// Space

	public static class MyComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer i1, Integer i2) {
			if(i1.equals(i2)) {
				return 0;
			}
			return i1 < i2 ? 1 : -1;
		}
	}

	public static int[] smallestkElements(int[] arr, int k) {
		if(k == 0) {
			return new int[0];
		}

		Queue<Integer> maxHeap = new PriorityQueue<Integer>(k, new MyComparator());
		for(int i = 0; i < k; i++) {
			maxHeap.offer(arr[i]);
		}

		for(int i = k; i < arr.length; i++) {
			if(arr[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.offer(arr[i]);
			}
		}

		return toArray(maxHeap);
	}

	private static int[] toArray(Queue<Integer> queue) {
		int[] res = new int[queue.size()];
		for(int i = res.length - 1; i >= 0; i--) {
			res[i] = queue.poll();
		}
		return res;
	}

	public static void main(String[] args) {
		int k = 10;
		// Anonymous class implementation
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if(o1.equals(o2)) {
					return 0;
				}
				return o1 > o2 ? -1 : 1;
			}
		});
	}


}
