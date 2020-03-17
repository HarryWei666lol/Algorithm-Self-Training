package QueueAndStack;
import java.util.*;

public class SortWith2Stacks_M {
	public static void sort(Deque<Integer> input) {
		if(input == null || input.size() <= 1) {
			return;
		}
		Deque<Integer> buffer = new ArrayDeque<Integer>();
		//then store everything in s2 in descending order
		sort(input, buffer);
	}

	private static void sort(Deque<Integer> input, Deque<Integer> buffer){
		// Method 1

		// input: unsorted elements
		// buffer:(top part) buffer, (bottom part) sorted elements

		// Step 1: sort in ascending order and store result in buffer
		while(!input.isEmpty()){
			int curMin = Integer.MAX_VALUE;
			int count = 0; //
			while(!input.isEmpty()){
				int cur = input.pollFirst();
				if(cur < curMin){
					curMin = cur;
					count = 1;//
				} else if(cur == curMin){ //
					count++;
				}
				buffer.offerFirst(cur);
			}
			while(!buffer.isEmpty() && buffer.peekFirst() >= curMin){ // take out all from buffer
				// only put in curMin later
				int tmp = buffer.pollFirst();
				if(tmp != curMin){
					input.offerFirst(tmp);
				}
			}
			while(count-- > 0){// 
				buffer.offerFirst(curMin);// returns ascending order
			}
		}
		// Instruction: from top to bottom, the integers are sorted in ascending order.
		// Step 2: move result from buffer to input, so it's in descending order
		while(!buffer.isEmpty()){
			input.offerFirst(buffer.pollFirst());
		}
	}


}
