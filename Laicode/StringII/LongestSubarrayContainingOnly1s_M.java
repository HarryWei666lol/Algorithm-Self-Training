package StringII;

public class LongestSubarrayContainingOnly1s_M {

	public int longestConsecutiveOnes(int[] nums, int k) {
		// Write your solution here
		int slow = 0;
		int fast = 0;

		int count = 0;
		int longest = 0;

		while(fast < nums.length){
			if(nums[fast] == 1){
				fast += 1;
				longest = Math.max(longest, fast - slow);
			} else if (count < k){
				count++;
				fast++;
				longest = Math.max(longest, fast - slow);
			} else if (nums[slow] == 0){
				slow++;
				count--;
			} else {
				slow++;
			}
		}
		return longest;
	}



}
