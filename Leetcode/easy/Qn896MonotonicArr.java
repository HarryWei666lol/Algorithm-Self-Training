package easy;

public class Qn896MonotonicArr {
	// time 100%, space 100%
	public boolean isMonotonic(int[] A) {
        int len = A.length; // length of array is A.length while length of string is A.length()
        if(len < 2) {
            return true;
        }
        
        if(A[0] <= A[len-1]) { // monotone increasing
            for(int i = 0; i < A.length - 1; i++)  {
                if(A[i] > A[i+1]) { // check there is any anomalous decrease
                    return false;
                }
            }
            return true;
        }
        else { // monotone decreasing
            for(int i = 0; i < A.length - 1; i++)  {
                if(A[i] < A[i+1]) { // check if there is any anomalous increase
                    return false;
                }
            }
            return true;
        }
    }

}
