package easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Qn169MajorityElement {

	// Method 1
	// Time 19.46%, Space 5.15%
		     public int majorityElement(int[] nums) {
		         int count = nums.length / 2;
		         Map<Integer, Integer> map = new HashMap<>();
		         for(int n : nums){
		             if(map.containsKey(n)){
		                 map.put(n, map.get(n) + 1);
		             } else {
		                 map.put(n, 1);
		             }
		             if(map.get(n) > count){
		                 count = n;
		                 break;
		             }
		         }
		         return count;
		     }

	// Method 2
	//Time 99.87%, Space 70.59%
	public int majorityElement2(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length/2];
	}

	// Method 3 - Moore Voting Algorithm
	// Time 99.87%, Space 68.38%
	public int majorityElement3(int[] nums){
		int count = 0;
		int ret = 0;
		for(int num: nums){
			if(count == 0){
				ret = num;
			}
			if(num != ret){
				count--;
			} else{
				count++;
			}
		}
		return ret;
	}




}
