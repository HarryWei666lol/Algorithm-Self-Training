package HashTableAndStringI;

public class RemoveAdjacentRepeatedCharacterI_E {

	public String deDup(String input) {
		if(input == null){
			return null;
		}
		char[] arr = input.toCharArray();
		int end = 0;
		for(int i = 0; i < arr.length; i++){
			// repeated characters will be ignored except
			// for the first character in the sequence
			if(i == 0 || arr[i] != arr[end - 1]){
				arr[end++] = arr[i];
			}
		}
		return new String(arr, 0, end);
	}


}
