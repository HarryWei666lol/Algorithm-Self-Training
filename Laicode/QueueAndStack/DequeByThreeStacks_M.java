package QueueAndStack;
import java.util.*;

public class DequeByThreeStacks_M {

	public class Solution {
		private Deque<Integer> left;
		private Deque<Integer> right;
		private Deque<Integer> buffer;
		public Solution() {
			// Write your solution here.
			this.left = new ArrayDeque<>();
			this.right = new ArrayDeque<>();
			this.buffer = new ArrayDeque<>();
		}

		public void offerFirst(int element) {
			left.offerFirst(element);
		}

		public void offerLast(int element) {
			right.offerFirst(element);
		}

		public Integer pollFirst() {
			move(right, left);
			if(left.isEmpty()){
				return null;
			}
			return left.pollFirst();

		}

		public Integer pollLast() {
			move(left, right);
			if(right.isEmpty()){
				return null;
			}
			return right.pollFirst();
		}

		public Integer peekFirst() {
			move(right, left);
			if(left.isEmpty()){
				return null;
			}
			return left.peekFirst();
		}

		public Integer peekLast() {
			move(left, right);
			if(right.isEmpty()){
				return null;
			}
			return right.peekFirst();
		}

		public int size() {
			return left.size() + right.size();
		}

		public boolean isEmpty() {
			return left.isEmpty() && right.isEmpty();
		}

		// when destination stack is empty, move half of the elements from
		// the src stack to dest stack
		public void move(Deque<Integer> src, Deque<Integer> dest){
			if(!dest.isEmpty()){
				return;
			}
			int halfSize = src.size() / 2;

			for(int i = 0; i < halfSize; i++){
				buffer.offerFirst(src.pollFirst());
			}

			while(!src.isEmpty()){
				dest.offerFirst(src.pollFirst());
			}

			while(!buffer.isEmpty()){
				src.offerFirst(buffer.pollFirst());
			}
		}
	}

}
