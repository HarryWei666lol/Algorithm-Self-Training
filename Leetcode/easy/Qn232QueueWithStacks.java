package easy;
import java.util.*;

public class Qn232QueueWithStacks {

	class MyQueue {
	    
	    Deque<Integer> in;
	    Deque<Integer> out;
	    /** Initialize your data structure here. */
	    public MyQueue() {
	        in = new LinkedList<Integer>();
	        out = new LinkedList<Integer>();
	    }
	    
	    /** Push element x to the back of queue. */
	    public void push(int x) {
	        in.push(x);
	        
	    }
	    
	    /** Removes the element from in front of queue and returns that element. */
	    public int pop() {
	        shuffleIfNecessary();
	        if(out.isEmpty()){
	            return 0;
	        }
	        return out.pop();
	        
	    }
	    
	    /** Get the front element. */
	    public int peek() {
	        shuffleIfNecessary();
	        if(out.isEmpty()){
	            return 0;
	        }
	        return out.peek();
	    }
	    
	    /** Returns whether the queue is empty. */
	    public boolean empty() {
	        return in.isEmpty() && out.isEmpty();
	    }
	    
	    public void shuffleIfNecessary(){
	        if(out.isEmpty()){
	            while(!in.isEmpty()){
	                out.push(in.pop());
	            }
	        }
	    }
	}

}
