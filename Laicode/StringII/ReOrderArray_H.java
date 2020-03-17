package StringII;

public class ReOrderArray_H { // or String shuffling

	public static int[] reorder(int[] array) {
		// Assumptions: array is not null
		if(array.length % 2 == 0){
			reOrder(array, 0, array.length - 1);
		} else {
			reOrder(array, 0, array.length - 2);
		}
		return array;
	}

	private static void reOrder(int[] arr, int left, int right){
		int length = right - left + 1;
		// if the subarray has 2 to 0 elements, we can just return as this should be the base case
		if(length <= 2){
			return;
		}
		// Calculate the important mid points
		// 0 1 2 3 4 5 6 7
		// lm: 2, m: 4, rm: 6
		// 0 1 2 3 4 5 6 7 8 9
		// lm: 2, m: 5, rm: 7
		
		int mid = left + length / 2;
		//System.out.println("mid is " + mid);
		int lmid = left + length / 4;
		//System.out.println("lmid is " + lmid);
		int rmid = left + length * 3 / 4;
		//System.out.println("rmid is " + rmid);
		
		reverse(arr, lmid, mid - 1);
		reverse(arr, mid, rmid - 1);
		reverse(arr, lmid, rmid - 1);
		
		// half of the left partition's size = lmid - left
		reOrder(arr, left, left + (lmid - left) * 2 - 1);
		reOrder(arr, left+(lmid - left) * 2, right);
	}

	private static void reverse(int[] arr, int left, int right){ // same as swap just with 2 index++
		while(left < right){
			int tmp = arr[left];
			arr[left] = arr[right];
			arr[right] = tmp;
			left++;
			right--;
		}
		//printArr(arr);
	}
	
	private static void printArr(int[] arr) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int[] arr = new int[] {
				0, 1, 2, 3, 4, 5, 6, 7
		};
		reorder(arr);
		printArr(arr);
	}




}
