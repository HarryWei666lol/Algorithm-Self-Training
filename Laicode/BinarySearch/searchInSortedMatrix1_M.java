package BinarySearch;

public class searchInSortedMatrix1_M {


	public int[] search(int[][] matrix, int target) {
		// Write your solution here
		if(matrix.length == 0 || matrix[0].length == 0){
			return new int[]{-1,-1};
		}

		int rows = matrix.length;
		int cols = matrix[0].length;
		int left = 0;
		int right = rows * cols - 1;

		// convert the 2D array to 1D array with rows * cols elements
		while(left <= right){
			int mid = left + (right - left)/2;
			// convert the position in 1D array back to row and col in 2d array
			int row = mid / cols; // helper function to map n-dimensional coordinate to 1D coordinate(vice versa)
			int col = mid % cols; 
			if (matrix[row][col] == target){
				return new int[]{row, col};
			} else if(matrix[row][col] < target){
				left = mid + 1;
			} else{
				right = mid - 1;
			}
		}
		return new int[] {-1, -1};
	}



}
