package easy;

public class Qn53MaximumSubarray {

	// DP: Kadane's Algorithm 
	// Time 88.31%, Space 5.16%
	public int maxSubArray(int[] nums) {
		int n = nums.length;
		int maxSum = nums[0];

		for(int i = 1; i < nums.length; i++){
			if(nums[i - 1] > 0){
				nums[i] += nums[i - 1];
			}
			maxSum = Math.max(nums[i], maxSum);
		}

		return maxSum;
	}

}
