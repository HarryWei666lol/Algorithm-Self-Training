package QueueAndStack;
import java.util.*;

public class QueueByTwoStacks_M {

	public class Solution {
	    // we always insert into the in stack
	    private Deque<Integer> in;
	    // we always remove from the out stack
	    private Deque<Integer> out;

	  public Solution() {
	    // Write your solution here.
	        in = new ArrayDeque<>();
	        out = new ArrayDeque<>();
	    
	  }
	  
	  public Integer poll() { // This method returns the element at the front of the container or the head of the Queue. It returns null when the Queue is empty.

	      // if out stack is empty, need to move the elements from in stack to out stack
	      move();
	    return out.isEmpty() ? null : out.pollFirst();
	  }
	  
	  public void offer(int element) {
	    // always push into the in stack
	    in.offerFirst(element);
	  }
	  
	  public Integer peek() {
	    move();
	    return out.isEmpty() ? null : out.peekFirst(); 
	  }

	  // when out stack is empty, move the elements from in stack to out stack
	  private void move(){
	      if(out.isEmpty()){
	          while(!in.isEmpty()){
	              out.offerFirst(in.pollFirst());
	          }
	      }
	  }
	  
	  public int size() {
	    return in.size() + out.size();
	  }
	  
	  public boolean isEmpty() {
	    return in.size() == 0 && out.size() == 0;
	  }
	}


}
