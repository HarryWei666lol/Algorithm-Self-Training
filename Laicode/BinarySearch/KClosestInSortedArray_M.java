package BinarySearch;

public class KClosestInSortedArray_M {


	public int[] kClosest(int[] arr, int target, int k) {
		if(arr == null || arr.length == 0){
			return arr;
		}
		// left is the index of the largest smaller or equal element
		// right = left + 1
		// These two should be the closest to target
		int left = binarySearchClosestElement(arr, target);
		int right = left + 1;
		int[] res = new int[k];
		// this is a typical merge operation
		for(int i = 0; i < k; i++){
			// we can advance the left pointer when:
			// 1. right pointer is already out of bound of original arr
			// 2. right pointer is not out of bound, left pointer is not out of 
			// bound of original arr, and array[left] is closer to target
			if(right >= arr.length){
				res[i] = arr[left--];
			} else if (left >= 0 && Math.abs(target - arr[left]) <= Math.abs(arr[right] - target)){
				res[i] = arr[left--];
			} else{
				res[i] = arr[right++];
			}
		}
		return res;
	}
	private int binarySearchClosestElement(int[] arr, int target){
		// find the largest smaller or equal element's index in the array
		int left = 0;
		int right = arr.length - 1;
		while(left < right - 1){
			int mid = left + (right - left) / 2;
			if(arr[mid] <= target){
				left = mid;
			} else{
				right = mid; 
			}
		}
		if(Math.abs(target - arr[left]) <= Math.abs(target - arr[right])){
			return left;
		} else if (Math.abs(target - arr[left]) > Math.abs(target - arr[right])) {
			return right;
		} 
		return -1;
		// if(arr[right] <= target){
		//     return right;
		// }
		// if(arr[left] <= target){
		//     return left;
		// }
	}




}
