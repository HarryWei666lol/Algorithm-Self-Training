package easy;

public class Qn136SingleNumber {

	// Time 100%, Space 5.19%
	// Method 1: for every bit, use bit manipulation. 0^0^0 = 0, 1^1^1 = 1, 0^0^1 = 1, 1^1^0 = 0.
	public int singleNumber(int[] nums) {
		int ans = 0;
		for(int i = 0; i < nums.length; i++){
			ans ^= nums[i];
		}
		return ans;
	}

}
