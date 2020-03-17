package easy;
import java.util.*;
public class Qn349IntersectionOf2Arr {
	// Time 96.84%, Space 89.19%
	public int[] intersection(int[] nums1, int[] nums2) {
		int n = nums1.length;
		int m = nums2.length;
		if(n==0 || m == 0) {
			return new int[0];
		}

		Set<Integer> set = new HashSet<Integer>();
		Set<Integer> result = new HashSet<Integer>();
		for(int i = 0 ; i < n;i++) {
			set.add(nums1[i]);
		}
		for(int i = 0 ; i < m;i++) {
			if(set.contains(nums2[i])) {
				result.add(nums2[i]);
			}
		}
		int []intersection = new int[result.size()];
		Iterator<Integer> it = result.iterator();
		int j = 0;

		while(it.hasNext()) {
			intersection[j] = (int) it.next();
			j++;
		}
		return intersection;
	}


}
