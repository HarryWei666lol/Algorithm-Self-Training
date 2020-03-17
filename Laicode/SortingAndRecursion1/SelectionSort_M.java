package SortingAndRecursion1;

public class SelectionSort_M {


	public int[] solve(int[] array) {
		// Write your solution here
		if(array == null || array.length == 0){
			return array;
		}
		for(int i = 0; i < array.length - 1; i++){
			int min = i;
			for(int j = i; j < array.length; j++){
				if(array[j] < array[min]){
					min = j;
				}
			}
			swap(array, i, min);
		}
		return array;
	}
	public void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}



}
