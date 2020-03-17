package medium;

public class Qn287FindDuplicateNum {

	public int findDuplicate1(int[] nums) {
		if(nums == null || nums.length == 0){
			return 0;
		}
		int left = 0, right = nums.length - 1;
		int mid = 0;
		while(left < right){
			mid = left + (right - left) / 2;
			int count = 0;
			for(int i = 0; i < nums.length; i++){
				if(nums[i] <= mid){
					count++;
				}
			}
			if(count <= mid){
				left = mid + 1;
			} else{
				right = mid;
			}
		}
		return left;
	}

	// Time 100%, Space 5.09%
	// Floyd's Tortoise and Hare Cycle Detection
	// Time O(n), space O(1)
	public int findDuplicate(int[] nums){
		if(nums == null || nums.length == 0){
			return 0;
		}
		int tortoise = nums[0];
		int hare = nums[0];
		tortoise = nums[tortoise];
		hare = nums[nums[hare]];

		while(tortoise != hare){
			tortoise = nums[tortoise];
			hare = nums[nums[hare]];
		}

		// return tortoise -> cannot do this!!
		
		// this is indispensable
		int a_pointer = nums[0];
		int b_pointer = tortoise;

		while(a_pointer != b_pointer){
			a_pointer = nums[a_pointer];
			b_pointer = nums[b_pointer];
		}
		return a_pointer;
	}


}
