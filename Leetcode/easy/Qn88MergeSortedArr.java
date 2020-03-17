package easy;

public class Qn88MergeSortedArr {
	// Time 100%, Space 100%
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end  = m + n - 1;
        m--;
        n--;
        
        while(m >= 0 && n >= 0){
            if(nums1[m] >= nums2[n]){
                nums1[end--] = nums1[m--];
            } else{
                nums1[end--] = nums2[n--];
            } 
        }
        
        while(n >= 0){ // handles the case where nums1 = [4,5,6,0,0,0] and nums2 = [1,2,3]
            nums1[end--] = nums2[n--];
        }
    }

}
