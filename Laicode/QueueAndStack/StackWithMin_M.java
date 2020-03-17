package QueueAndStack;
import java.util.*;

public class StackWithMin_M {

	public class Solution {
		private Deque<Integer> stack;
		private Deque<Integer> minStack;
		public Solution() {
			// write your solution here
			stack = new ArrayDeque<>();
			minStack = new ArrayDeque<>();
		}

		public int min() {
			if(minStack.isEmpty()){
				return -1;
			}
			return minStack.peekFirst();
		}

		public void push(int element) {
			stack.offerFirst(element);
			// when value <= current min value in stack, need to push the value to minStack
			if(minStack.isEmpty() || element <= minStack.peekFirst()){
				minStack.offerFirst(element);
			}
		}

		public int pop() {
			if(stack.isEmpty()){
				return -1;
			}
			Integer result = stack.pollFirst();
			// when the popped value is the same as top value of minStack, the value needs to be popped from minStack as well
			if (minStack.peekFirst().equals(result)){
				minStack.pollFirst();
			}
			return result;
		}

		public int top() {
			if(stack.isEmpty()){
				return -1;
			}
			return stack.peek();
		}
	}

}
