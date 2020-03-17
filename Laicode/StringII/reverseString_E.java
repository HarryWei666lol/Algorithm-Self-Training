package StringII;

public class reverseString_E {

	// Method 1
	  // Time O(n); Space O(n)
	  // public String reverse(String input) {
	  //   // Write your solution here
	  //   if(input == null || input.length() <= 1){
	  //     return input;
	  //   }
	  //   char[] arr = input.toCharArray();
	  //   for(int left = 0, right = arr.length - 1; left < right; left++, right--){
	  //     // as long as left < right, we will swap
	  //     swap(arr, left, right);
	  //   }
	  //   return new String(arr);
	  // }

	  private void swap(char[] arr, int left, int right){
	    char tmp = arr[left];
	    arr[left] = arr[right];
	    arr[right] = tmp;
	  }

	  // Method 2
	  // Time O(n); Space O(n)
	  public String reverse(String input) {
	    if(input == null || input.length() <= 1){
	      return input;
	    }
	    char[] arr = input.toCharArray();
	    reverseHelper(arr, 0, arr.length - 1);
	    return new String(arr);
	  }

	  private void reverseHelper(char[] arr, int left, int right){
	    if(left >= right){
	      return;
	    }
	    swap(arr, left, right);
	    reverseHelper(arr, left + 1, right - 1);
	  }

}
