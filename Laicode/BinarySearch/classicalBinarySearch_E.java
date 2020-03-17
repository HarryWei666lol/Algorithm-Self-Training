package BinarySearch;

public class classicalBinarySearch_E {

	public int binarySearch(int[] array, int target) {
		// Write your solution here
		if(array == null || array.length == 0){
			return -1;
		}
		int left = 0;
		int right = array.length -1;
		while(left <= right){
			int mid = left + (right - left) /2;
			if(array[mid] == target){
				return mid;
			}else if(array[mid] < target){
				left = mid + 1;// if code is left = mid -> dead loop, it is wrong cos mid has already been checked
			}else{
				right = mid - 1;
			}
		}
		return -1;
	}


}
