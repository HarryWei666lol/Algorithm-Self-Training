package medium;

public class Qn31NextPermutation {
	
	// Time 100% Space 100%
	
	// Time O(n), Space O(1)
	public static void nextPermutation(int[] nums) {
		if(nums == null || nums.length <= 1){
			return;
		}
		int i = nums.length - 2;
		while(i >= 0 && nums[i] >= nums[i + 1]){ 
			// find 1st i that breaks descending order
			i--;
		}
		if(i >= 0){ // if not entirely descending
			int j = nums.length - 1; // start from the end
			while(nums[j] <= nums[i]){ 
				// find rightmost first larger j
				j--;
			}
			swap(nums, i, j); // switch i and j
		}
		reverse(nums, i + 1, nums.length - 1);// reverse the descending sequence
        // For this purpose: If such arrangement is not possible, 
		// it must rearrange it as the lowest possible order (ie, sorted in ascending order). 
		// -> do it even for range(i+ 1, last of array)
	}

	private static void swap(int[] nums, int left, int right){
		int tmp = nums[left];
		nums[left] = nums[right];
		nums[right] = tmp;
	}

	private static void reverse(int[] nums, int left, int right){
		while(left < right){
			swap(nums, left++, right--);
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {
				10, 8, 5, 9, 2, 1
		};
		nextPermutation(nums);
		for(int i : nums) {
			System.out.print(i + " ");
		}
	}


}
