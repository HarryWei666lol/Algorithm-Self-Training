package HashTableAndStringI;

public class RemoveSpaces_E {


	public String removeSpaces(String input) {
		// Write your solution here
		// exam 1
		if(input.isEmpty()){
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0;
		for(int i = 0; i < array.length; i++){
			// ignore the current space character under these two cases:
			// 1. We ignore all the space characters followed by another space character,
			// only the first one will be reamined
			// 2. We ignore also the space character if it is the first character of the input string
			if(array[i] == ' ' &&(i == 0 || array[i - 1] == ' ')){
				continue;
			}
			array[slow++] = array[i];
		}
		// Post-processing: it is possible we still have one trailing space character at the end
		if(slow > 0 && array[slow - 1] == ' '){
			return new String(array, 0, slow - 1);
		}
		return new String(array, 0, slow);
	}



}
