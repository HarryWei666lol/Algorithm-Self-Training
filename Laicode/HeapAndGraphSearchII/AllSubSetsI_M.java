package HeapAndGraphSearchII;
import java.util.*;

public class AllSubSetsI_M {

	public List<String> subSets(String set) {
		// Write your solution here.
		List<String> res = new ArrayList<>();
		if (set == null){
			return res;
		}
		char[] input = set.toCharArray();
		StringBuilder sb = new StringBuilder(); // record the current subset
		helper(input, sb, 0, res);
		return res;
	}

	// at each level, determine the character at the position "index" to be picked or not
	private void helper(char[] input, StringBuilder sb, int index, List<String> res){
		// terminate condition:
		// when we finishes determining for all the characters pick or not, 
		// we have a complete subset
		if(index == input.length){
			res.add(sb.toString());
			return;
		}
		sb.append(input[index]);
		helper(input, sb, index + 1, res); // pick the character at index
		sb.deleteCharAt(sb.length() - 1); // remember to remove the added character when back-tracking
		// to the previous level
		helper(input, sb, index + 1, res); // not pick the character at index
	}
}
