package BinarySearch;

public class closestInSortedArray_M {

	public int closest(int[] array, int target) {
		// Write your solution here
		if(array == null || array.length == 0){
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1){ // if left neighbors right -> terminate
			int mid = left + (right - left) / 2;
			if(array[mid] == target){
				return mid;
			}else if(array[mid] < target){
				left = mid;
			}else{
				right = mid;
			}
		}
		// post-processing
		if(Math.abs(array[left] - target) <= Math.abs(array[right] - target)){
			// check a[left] against target first
			return left;
		}
		else{
			return right;
		}
	}



}
