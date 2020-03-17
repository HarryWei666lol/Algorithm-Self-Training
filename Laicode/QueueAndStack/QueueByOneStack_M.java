package QueueAndStack;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueByOneStack_M {

	public static class stackBy1Queue{
		private Queue<Integer> q; // FIFO

		public stackBy1Queue() {
			this.q = new ArrayDeque<Integer>();
		}

		public void push(int val) { // imagine the benzene circle

			// stack 		 [1 2 3 4 5]
			// stack.push(6) [1 2 3 4 5 6]
			// implemented by
			// queue 		 [1 2 3 4 5 6]

			int size = q.size();

			// queue [1 2 3 4 5 6]
			q.add(val);// add to the tail 

			for(int i = 0; i < size; i++) {
				int x = q.poll();
				q.offer(x);
			}
			// queue [2 3 4 5 6 1]
			// queue [3 4 5 6 1 2]
			// queue [4 5 6 1 2 3]
			// queue [5 6 1 2 3 4]
			// queue [6 1 2 3 4 5]

		}

		public int pop() {

			// stack.pop(6)  [1 2 3 4 5]
			// implemented by 
			// queue [6 1 2 3 4 5]
			// becomes 
			// queue [1 2 3 4 5]

			if(q.isEmpty()) {
				return -1;
			} 
			int x = q.poll(); // removes the innermost element in stack or top element in queue
			return x;
		}

		public int top() { // find the top(innermost) element 
			if(q.isEmpty()) {
				return -1;
			}
			return q.peek();
		}

		public boolean isEmpty() {
			return q.isEmpty();
		}
	}

}
