package SortingAndRecursion1;

public class QuickSort_M {

	public int[] quickSort(int[] array) {
		// Write your solution here
		if(array == null || array.length == 1){
			return array;
		}
		quickSort(array, 0, array.length - 1);
		return array;
	}
	public void quickSort(int[] array, int left, int right){
		if(left >= right){
			return;
		}
		// define a pivot and use the pivot to partition the array
		int pivotPos = partition(array, left, right);
		// pivot is already at its position, when we do the recursive call on the two partitions, pivot should not be included in any of them
		quickSort(array, left, pivotPos - 1);
		quickSort(array, pivotPos + 1, right);
	}

	private int partition(int[] array, int left, int right){
		int pivotIndex = pivotIndex(left, right);
		int pivot = array[pivotIndex];
		// swap the pivot element to the rightmost position first
		swap(array, pivotIndex, right);
		int leftBound = left;
		int rightBound = right - 1;
		while(leftBound <= rightBound){
			if(array[leftBound] < pivot){
				leftBound++;
			} else if(array[rightBound] >= pivot){
				rightBound--;
			} else { // when arr[leftIndex] > pivot or when arr[rightIndex] < pivot
				swap(array, leftBound++, rightBound--);
			}
		}
		// swap back the pivot element
		swap(array, leftBound, right);
		return leftBound;
	}

	// this is one of the ways defining the pivot
	// pick random element in the range of [left, right]
	private int pivotIndex(int left, int right){
		return left+ (int)(Math.random()*(right - left + 1));
	}

	private void swap(int[] array, int left, int right){
		int temp = array[left];
		array[left] = array[right];
		array[right] = temp;
	}



}
