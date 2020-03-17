package SortingAndRecursion1;

public class MergeSort_M {
	public int[] mergeSort(int[] array){
		if(array == null){
			return array;
		}
		int[] helper = new int[array.length];
		mergeSort(array, 0, array.length - 1, helper);
		return array;
	}

	private void mergeSort(int[] array, int left, int right, int[] helper){
		if(left >= right){
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(array, left, mid, helper);
		mergeSort(array, mid + 1, right, helper);
		merge(array, left, mid, right, helper);
	}

	private void merge(int[] array, int left, int mid, int right, int[] helper){
		for (int i = left; i <= right; i++){
			helper[i] = array[i];
		}

		int leftIndex = left;
		int rightIndex = mid + 1;

		while(leftIndex <= mid && rightIndex <= right){
			if(helper[leftIndex] <= helper[rightIndex]){
				array[left] = helper[leftIndex];
				leftIndex++;
			}else{
				array[left] = helper[rightIndex];
				rightIndex++;
			}
			left++;
		}

		while(leftIndex <= mid){
			array[left++] = helper[leftIndex++];
		}

	}


}
