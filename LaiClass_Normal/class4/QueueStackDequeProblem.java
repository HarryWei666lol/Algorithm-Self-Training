package class4;

import java.util.*;

public class QueueStackDequeProblem {


	// sort with 3 stacks(input, buffer, output) -> Does not handle duplicate
	// Note: cannot use peek(), pop() as they take the first element of the list(property of queue, not stack)

	// Time O(n^2)
	// Space O(n)
	public static Deque<Integer> sortWithThreeStacks(Deque<Integer> input) {
		if(input == null || input.size() <= 1) {
			return input;
		}

		Deque<Integer> buffer = new ArrayDeque<Integer>();
		Deque<Integer> output = new ArrayDeque<Integer>();
		int inputSize = input.size();

		while(inputSize > 0) {
			int globalMin = Integer.MAX_VALUE;
			while(!input.isEmpty()) {
				int tmp = input.pollFirst();
				if(tmp < globalMin) {
					globalMin = tmp;
				} 
				buffer.offerFirst(tmp);
			}
			output.offerFirst(globalMin);

			while(!buffer.isEmpty()) {
				if(buffer.peekFirst() > globalMin) {
					input.offer(buffer.pollFirst());
				} else {
					buffer.pollFirst();
				}	
			}

			inputSize--;
			//			System.out.println(input);
			//			System.out.println(buffer);
			//			System.out.println(output);
		}

		return output;		

	}


	// sort with 3 stacks(input, buffer, output) -> handles duplicate
	// Note: cannot use peek(), pop() as they take the first element of the list(property of queue, not stack)

	// Time O(n^2)
	// Space O(n)
	public static Deque<Integer> sortWithThreeStacksWithDup(Deque<Integer> input) {
		if(input == null || input.size() <= 1) {
			return input;
		}

		Deque<Integer> buffer = new ArrayDeque<Integer>();
		Deque<Integer> output = new ArrayDeque<Integer>();
		int inputSize = input.size();

		while(inputSize > 0) {
			int globalMin = Integer.MAX_VALUE;
			int count = 0;//
			while(!input.isEmpty()) {
				int tmp = input.pollFirst();
				if(tmp < globalMin) {
					globalMin = tmp;
					count = 1;//
				} 
				else if(tmp == globalMin){ // 
					count++;
				}
				buffer.offer(tmp);
			}

			for(int i = 0; i < count; i++) {//
				output.offerFirst(globalMin);

			}

			while(!buffer.isEmpty()) {
				if(buffer.peekFirst() > globalMin) {
					input.offerFirst(buffer.pollFirst());
				} else {
					buffer.pollFirst();
				}	
			}
			inputSize--;
			//			System.out.println(input);
			//			System.out.println(buffer);
			//			System.out.println(output);
		}

		return output;		

	}

	public static void main(String[] args) {
		LinkedList<Integer> input = new LinkedList<Integer>();
		input.offer(3);
		input.offer(3);
		input.offer(1);
		input.offer(2);
		input.offer(2);
		input.offer(4);
		//sortWithThreeStacksWithDup(input);
		sortWithTwoStacksWithDup(input);
	}


	// Sort with 2 stacks(input, buffer) -> does not handle duplicates
	// Note: cannot use peek(), pop() as they take the first element of the list(property of queue, not stack)

	// Time O(n^2)
	// Space saved 1 stack as compared to above
	public static LinkedList<Integer> sortWithTwoStacks(LinkedList<Integer> input) {
		if(input == null || input.size() <= 0) {
			return input;
		}
		LinkedList<Integer> outputPlusBuffer = new LinkedList<Integer>();
		int inputSize = input.size();
		while(inputSize != 0) {
			int globalMin = Integer.MAX_VALUE;
			while(!input.isEmpty()) {
				int tmp = input.peekLast();
				if(tmp < globalMin) {
					globalMin = tmp;
				}
				outputPlusBuffer.offer(input.pollLast());
			}

			while(!outputPlusBuffer.isEmpty() && outputPlusBuffer.peekLast() >= globalMin) {
				int tmp = outputPlusBuffer.pollLast();
				if(tmp != globalMin) {
					input.offer(tmp);
				}
			}
			outputPlusBuffer.offer(globalMin);
			inputSize--;

			System.out.println(input);
			System.out.println(outputPlusBuffer);
		}

		return outputPlusBuffer;
	}


	// Sort with 2 stacks(input, buffer) -> handles duplicates
	// Note: cannot use peek(), pop() as they take the first element of the list(property of queue, not stack)

	// Time O(n^2)
	// Space saved 1 stack as compared to above
	public static LinkedList<Integer> sortWithTwoStacksWithDup(LinkedList<Integer> input) {
		if(input == null || input.size() <= 0) {
			return input;
		}
		LinkedList<Integer> outputPlusBuffer = new LinkedList<Integer>();
		int inputSize = input.size();
		while(inputSize != 0) {
			int globalMin = Integer.MAX_VALUE;
			int count = 0; //
			while(!input.isEmpty()) {
				int tmp = input.peekLast();
				if(tmp < globalMin) {
					globalMin = tmp;
					count = 1;
				} else if (tmp == globalMin) {//
					count++;
				}
				outputPlusBuffer.offer(input.pollLast());
			}

			while(!outputPlusBuffer.isEmpty() && outputPlusBuffer.peekLast() >= globalMin) {
				int tmp = outputPlusBuffer.pollLast();
				if(tmp != globalMin) {
					input.offer(tmp);
				}
			}
			for(int i = 0; i < count; i++) { // 
				outputPlusBuffer.offer(globalMin);
			}

			inputSize--;

			System.out.println(input);
			System.out.println(outputPlusBuffer);
		}

		return outputPlusBuffer;
	}


	// Implement queue with 2 stacks
	// must use offerFirst() as we are implementing a queue

	// enqueue is O(1) time
	// dequeue is O(n) worst time, O(1) amortized time
	public static class QueueBy2Stacks{
		private LinkedList<Integer> enqueue;
		private LinkedList<Integer> dequeue;

		public QueueBy2Stacks() {
			enqueue = new LinkedList<Integer>();
			dequeue = new LinkedList<Integer>();
		}

		public int size() {
			return enqueue.size() + dequeue.size();
		}

		public boolean isEmpty() {
			return enqueue.size() == 0 && dequeue.size() == 0; 
		}

		public void offer(int val) {
			enqueue.offerFirst(val);
		}

		public Integer poll() {
			move();
			return dequeue.isEmpty() ? null : dequeue.pollFirst();
		}

		public Integer peek() {
			move();
			return dequeue.isEmpty() ? null : dequeue.peekFirst();
		}

		private void move() {
			if(dequeue.isEmpty()) {
				while(!enqueue.isEmpty()) {
					dequeue.offerFirst(enqueue.pollFirst());
				}
			}
		}
	}


	// Implement Stack with 2 queues
	public static class stackBy2Queues{
		private Queue<Integer> q1;
		private Queue<Integer> q2;

		public stackBy2Queues() {
			q1 = new ArrayDeque<Integer>();
			q2 = new ArrayDeque<Integer>();
		}

		public void push(int x) {
			q1.offer(x);
		}

		// removes the element on top of the stack and returns that element
		public Integer pop() {
			Integer prev = q1.poll();
			Integer cur = q1.poll();

			// as long as the next one is not null, remove 1st element 
			// from q1 and add as 1st element to q2
			while(cur != null){
				q2.offer(prev);
				prev = cur;
				cur = q1.poll();
			}

			// swap the 2 queues q1 and q2
			Queue<Integer> tmp = q1;
			q1 = q2;
			q2 = tmp;

			// return the last element of stack -> 1st element of current q1
			return prev;
		}

		// Get the top element
		public Integer top() {
			Integer res = pop();
			if(res != null){
				q1.offer(res); // top shouldn't remove element, we need to add it back 
			}
			return res;
		}

		public boolean isEmpty() {
			return top() == null;
		}
	}

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

	// Stack by 1 queue
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


	// minStack
	public static class minStack{
		// stack: 7, 2, 5, 3, 8, 2
		//  minStack:  7, 2, 2
		// only push to minStack when the pushed val is smaller than or equal to 
		// minStack's top-most value
		// space-optimized
		private Deque<Integer> stack;
		private Deque<Integer> min;

		public minStack() {
			this.stack = new ArrayDeque<Integer>();
			this.min = new ArrayDeque<Integer>();
		}

		public Integer min() {
			if(min.isEmpty()) { // corner case
				return null;
			}
			return min.peek();
		}

		public void push(int val) {
			stack.push(val);
			if(min.isEmpty() || val <= min.peek()) {
				min.push(val);
			}
		}

		public Integer pop() {
			if(stack.isEmpty()) {
				return null;
			}
			int tmp = stack.poll();
			if(tmp == min.peekLast()) {
				min.poll();
			}
			return tmp;
		}


		public Integer top() {
			if(stack.isEmpty()) {
				return null;
			}
			return stack.peek();

		}

		public boolean isEmpty() {
			return stack.isEmpty();
		}
	}


	// Deque by 3 stacks
	public static class DequeBy3Stacks {
		private Deque<Integer> left;
		private Deque<Integer> right;
		private Deque<Integer> buffer;
		public DequeBy3Stacks() {
			// Write your solution here.
			this.left = new ArrayDeque<Integer>();
			this.right = new ArrayDeque<Integer>();
			this.buffer = new ArrayDeque<Integer>();
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
