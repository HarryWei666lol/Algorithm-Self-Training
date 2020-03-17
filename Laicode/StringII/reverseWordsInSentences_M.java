package StringII;

public class reverseWordsInSentences_M {

	// Time O(n)
	public String reverseWords(String input) {
		// Write your solution here
		// Assumptions:
		//    The words are separated by one space character, no leading or trailing spaces
		if(input == null || input.length() <= 1){
			return input;
		}
		// convert to char array and solve it in-place
		char[] arr = input.toCharArray();
		// reverse the whole char array
		reverse(arr, 0, arr.length - 1);
		int start = 0;
		// reverse each of the words
		for(int i = 0; i < arr.length; i++){
			// start index of a word
			if(arr[i] != ' ' && (i == 0 || arr[i - 1] == ' ')){
				start = i;
			}
			// end index of a word
			if(arr[i] != ' ' && (i == arr.length - 1 || arr[i + 1] == ' ')){
				reverse(arr, start, i);
			}
		}
		return new String(arr);
	}

	private void reverse(char[] arr, int left, int right){
		while(left < right){
			char tmp = arr[left];
			arr[left++] = arr[right];
			arr[right--] = tmp;
			// left++;
			// right--;
		}
	}

}
