package BinarySearch;

public class firstOccurrence_M {

	public int firstOccur(int[] array, int target) {
		// Write your solution here
		if(array == null || array.length == 0){
			return -1;
		}
		int left = 0;
		int right = array.length - 1;
		while(left < right - 1){
			int mid = left + (right - left) / 2;
			if(array[mid] == target){
				right = mid; // special here, right = mid - 1 is wrong here
			} else if(array[mid] < target){
				left = mid + 1; // left = mid is also right
			} else{
				right = mid;
			}
		}
		// post-processing
		if(array[left] == target){ // check array[left] against target first
			return left;
		}
		if(array[right] == target){// then check array[right] against target
			return right;
		}
		return -1;
	}


}
