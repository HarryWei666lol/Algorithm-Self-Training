package class1;

import java.util.Deque;
import java.util.Dictionary;
import java.util.LinkedList;
import java.util.List;

public class BinarySearch {


	// k closest element from target in a sorted array -> 中心开花

	// Time O(logn + k) on average; When k is large, ~=n, O(n)
	// Space O(k) on heap
	public int[] closestKElementsFromTarget(int arr[], int k, int target) {
		if(arr == null || arr.length == 0) {
			return arr;
		}
		if(k == 0) {
			return new int[0];
		}
		int[] res = new int[k];

		// left is the index of the largest smaller or equal element
		// right = left + 1
		// These two should be the closest to target

		int left = binarySearchClosestElement(arr, target);
		int right = left + 1;

		// this is a typical merge operation
		for(int i = 0; i < k; i++) {

			// we can advance the left pointer when:
			// 1. right pointer is already out of bound
			// 2. right pointer is not out of bound, left pointer is not out of 
			// bound, and array[left] is closer to target

			if(right >= arr.length){
				res[i] = arr[left];
				left--;
			} else if (left >= 0 && Math.abs(target - arr[left]) <= Math.abs(arr[right] - target)){
				res[i] = arr[left--];
				left--;
			} else { // when left pointer is out of bound or when arr[left] > arr[right]
				res[i] = arr[right];
				right++;
			}	
		}
		return res;
	}

	private int binarySearchClosestElement(int[] arr, int target) {
		// find from the array 
		// index of the largest element smaller or equal to target

		int left = 0;
		int right = arr.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(target <= arr[mid]) {
				right = mid;
			} else {
				left = mid;
			}
		}

		if(arr[left] <= target) {
			return left;
		}

		if(arr[right] <= target) {
			return right;
		}
		return -1;
	}


	// Smallest element larger than target

	// Time O(logn)
	// Space O(1)
	public int smallestElementLargerThanTarget(int[] arr, int target) {
		if(arr == null || arr.length == 0) {
			return -1;
		}
		int left = 0;
		int right = arr.length - 1;
		while(left < right - 1) {
			int mid = left + (right - left) / 2;
			if(target >= arr[mid]) { // in this case, you are certain that arr[mid] is smaller than
				// or equal to target and since we need it to be larger than target, can safely remove
				// the current element at index mid
				left = mid + 1;
			} else { // cannot safely remove this arr[mid] as this mid could be the right index as its element is 
				// greater than target
				left = mid;
			}
		}

		if(arr[left] > target) {
			return left;
		} else if(arr[right] > target) {
			return right;
		}
		return -1;
	}


	// K-th Smallest in two sorted arrays

	// aleft is the index to start searching in a, bleft is the index to start searching in b


	public int kthSmallestInTwoSortedArr(int[] a, int aleft, int[] b, int bleft, int k) {
		// base case
		if(aleft >= a.length) { // if provided aleft is out of bound of a 
			return b[bleft + k - 1];
		}
		if(bleft >= b.length) {// if provided bleft is out of bound of b 
			return a[aleft + k - 1];
		}
		if(k == 1) { // if k == 1, just compare the current a[aleft] and b[bleft]
			return Math.min(a[aleft], b[bleft]);
		}

		// Since index starts from left, the (k/2)th element in a or b 
		// should be left + k/2 - 1 (minus 1 here because arr starts from 0)
		int amid = aleft + k/2 - 1;
		int bmid = bleft + k/2 - 1;

		// if a.length is small than amid already, then remove element from b first
		int aval;
		if(amid >= a.length) {
			aval = Integer.MAX_VALUE;
		} else {
			aval = a[amid];
		}

		// if b.length is smaller than bmid already, then remove element from a first
		int bval;
		if(bmid >= b.length) {
			bval = Integer.MAX_VALUE;
		} else {
			bval = b[bmid];
		}

		if(aval <= bval) { // remove elements in a, as we are sure the kth element wont exist in this half of small numbers
			return kthSmallestInTwoSortedArr(a, amid + 1, b, bleft, k - k/2);// bleft is not changed 
			// reason for k - k/2 is to handle odd or even k problem. When k = 1001, 1001 - 1001/2 = 500
		} 
		else { // when bval < aval -> remove elements in b
			return kthSmallestInTwoSortedArr(a, aleft, b, bmid + 1, k - k/2); // aleft is not changed
		}	
	}
	
	
	// Search in unknown sized sorted array
	
	// Time O(? + logn)
	// Space O(1)
	public int search(Dictionary<Integer, Integer> dict, int target) {
		if(dict == null || dict.size() < 1) {
			return -1;
		}
		int left = 0;
		int right = 1;
		
	    // find the right boundary for binary search
	    // extends until we are sure that the target is within the [left, right] range
		while(dict.get(right) != null && dict.get(right) < target ) { // increase size by 2 each round
	        // 1. move left to right
	        // 2. double right index
			left = right;
			right = 2 * right;
		}
		
		return binarySearchNow(dict, left, right, target);
	}
	
	private int binarySearchNow(Dictionary<Integer, Integer> dict, int left, int right, int target) {
		// classical binary search
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(dict.get(mid) == null || dict.get(mid) > target) { // if out of bound already, must decrease search range s.t. right = mid - 1
				right = mid - 1;
			} else if (dict.get(mid) < target) {
				left = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}
}
