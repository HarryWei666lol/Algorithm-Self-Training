package easy;

public class Qn189RotateArr {
	// time 100%, space 100%
	public void rotate(int[] nums, int k) {
		int n = nums.length;
		k %= n; // the problem is equivalent if k only differs by a multiple of n
		if (k == 0) {
			return; // no need to rotate
		
		}

		reverse(nums, 0, n - 1); // O(n)
		reverse(nums, 0, k - 1); // O(n)
		reverse(nums, k, n - 1); // O(n)
	}

	// reverse nums[] in index range [i, j]
	// time complexity O(j - i)
	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int tmp = nums[i];
			nums[i++] = nums[j]; // post increment i
			nums[j--] = tmp; // post decrement j
		}
	}

}
