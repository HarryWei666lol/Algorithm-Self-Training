package QueueAndStack;

import java.util.*;
import java.util.Deque;

public class StackByTwoQueues_M {

	public static class StackBy2Queue{
		private Queue<Integer> q1;
		private Queue<Integer> q2;
		private int size;
		
		public StackBy2Queue(int size) {
			q1 = new ArrayDeque<>();
			q2 = new ArrayDeque<>();
			this.size = 0;
		}
		
		public void pop() {
			if(q1.isEmpty()) {
				return;
			}
			// Leave one element in q1 and push others in q2
			while(q1.size() != 1) {
				q2.offer(q1.poll());
			}
			
			// Pop the only left element from q1
			q1.poll();
			size--;
			
			// Swap the names of 2 queues
			Queue<Integer> tmp = q1;
			q1 = q2;
			q2 = tmp;
		}
		
		public void offer(int x) {
			q1.offer(x);
			size++;
		}
		
		public int top() {
			if(q1.isEmpty()) {
				return -1;
			}
			while(q1.size() != 1) {
				q2.offer(q1.poll());
			}
			
			// last pushed element
			int tmp = q1.peek();
			// to empty the auxiliary queue after last operation and push the last element to q2
			q2.offer(q1.poll());
			
			// swap the 2 queues
			Queue<Integer> temp = q1;
			q1 = q2;
			q2 = temp;
			
			return tmp;
			
		}
		public int size() {
			return this.size;
		}
		
		public boolean isEmpty() {
			return top() == -1;
		}
	}

}
