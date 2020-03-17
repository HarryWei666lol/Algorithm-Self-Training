package StringII;

public class rightShiftByNChar_E {

	// Time O(n)
	  public String rightShift(String input, int n) {
	    // Write your solution here
	    if(input == null || input.length() <= 1){
	      return input;
	    }
	    char[] arr = input.toCharArray();
	    int len = arr.length;
	    n %= arr.length;
	    reverse(arr, len - n, len - 1);
	    reverse(arr, 0, len - n - 1);
	    reverse(arr, 0, len - 1);
	    return new String(arr);
	  }

	  private void reverse(char[] arr, int left, int right){
	    while(left < right){ // left < right or left <= right
	      char tmp = arr[left];
	      arr[left] = arr[right];
	      arr[right] = tmp;
	      left++;
	      right--;
	    }
	  }

}
