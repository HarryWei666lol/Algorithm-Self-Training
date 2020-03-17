package hard;
import java.util.*;

public class Qn42TrappingRainWater {
	
//	Solution 1: Brute-Force Algorithm
//
//	For each element in the array, we find the maximum level of water it can trap after the rain, which is equal to the minimum of maximum height of bars on both the sides minus its own height.
//	Algorithm:
//
//	Initialize result = 0
//	Iterate the array from left to right:
//	a. Initialize maxLeft = 0 and maxRight = 0
//	b. Iterate from the current element to the beginning of array updating: maxLeft = Max(maxLeft, height[j])
//	c. Iterate from the current element to the end of array updating: maxRight = Max(maxRight, height[j])
//	d. Add Min(maxLeft, maxRight) - height[i] to the result
//	Time complexity: O(n2) - For each element of array, we iterate the left and right parts.
//	Space complexity: O(1)
	
	// Method 1
	// Time 5.09%, Space 59.59%
	// Time O(n^2), Space O(1)
	public int trap(int[] height) {
		int result = 0;
		int n = height.length;
		for (int i = 1; i < n - 1; i++){
			int maxLeft = 0, maxRight = 0;
			for(int j = i; j >= 0; j--){ //Search the left part for max bar size
				maxLeft = Math.max(maxLeft, height[j]);
			}					
			for(int j = i; j < n; j++){ //Search the right part for max bar size
				maxRight = Math.max(maxRight, height[j]);
			}					
			result += Math.min(maxLeft, maxRight) - height[i];
		}
		return result;
	}
	
//	Solution 2: Using Stack
//
//	We can use stack to keep track of the bars that are bounded by longer bars and hence, may store water. Using the stack, we can do the calculations in only one iteration.
//	We keep a stack and iterate over the array. We add the index of the bar to the stack if bar is smaller than or equal to the bar at top of stack, which means that the current bar is bounded by the previous bar in the stack. If we found a bar longer than that at the top, we are sure that the bar at the top of the stack is bounded by the current bar and a previous bar in the stack, hence, we can pop it and add resulting trapped water to the result.
//	Algorithm:
//
//	We use stack to store the indices of the bars.
//	Iterate the array:
	//	While stack is not empty and height[current] > height[stack.peek()].
		//	It means that the stack element can be popped. Pop the top element as top.
		//	Find the distance between the current element and the element at top of stack, which is to be filled. distance = current - stack.peek() - 1
		//	Find the bounded height bounded_height = Math.min(height[current], height[stack.peek()]) - height[top].
		//	Add resulting trapped water to result. result += distance * bounded_height
	//	Push current index to top of the stack
	//	Move current to the next position
//	Time complexity: O(n) - Single iteration of O(n) in which each bar can be touched at most twice due to insertion and deletion. Insertion and deletion from stack takes O(1) time.
//	Space complexity: O(n) - Stack can take up to O(n) space in case of stairs-like or flat structure.
	public int trap2(int[] height){
		Deque<Integer> stack = new ArrayDeque<>();
		int result = 0;

		for(int current = 0; current < height.length; current++){
			while(!stack.isEmpty() && height[current] > height[stack.peek()]){
				int top = stack.pop();
				
				if(!stack.isEmpty()){
					int distance = current - stack.peek() - 1;
					int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
					result += distance * bounded_height;
				}
			}	
			stack.push(current);
		}
		return result;
	}
	
//	Solution 3: Using Two Pointers
//
//	1) Here we set two pointers start and end to the left and right end of height. Then we get the minimum height (minHeight) of these pointers since the level of the water cannot be higher than it.
//	2) Then we move the two pointers towards the center. If the coming level is less than minHeight, then it will hold some water. Fill the water until we meet some "barrier" with height larger than minHeight and update start and end to repeat this process.

//	Time complexity: O(n)
//	Space complexity: O(1)
	public int trap3(int[] height){
        int left = 0;
        int right = height.length - 1;
		int water = 0;
		int minHeight = 0;

		while(left < right){
            while(left < right && height[left] <= minHeight) {
            	water += minHeight - height[left++];
            }
            	
            while(left < right && height[right] <= minHeight) {
            	water += minHeight - height[right--];
            }
            
            minHeight = Math.min(height[left], height[right]);
        }
        return water;
    }
	// Method 4 
	// Time O(n), Space O(1) --> Understandable
    // time 93.93%, Space 41.10%
    public int trap4(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        // level is currentMaxHeight
        int res = 0, level = 0, l = 0, r = height.length - 1;
        while(l < r){
            int lower = height[height[l] <= height[r] ? l++ : r--];
            level = Math.max(level, lower);
            res += level - lower;
        }
        return res;
    }
    
    // Method 5: Lower envelope of lmax and rmax for all i..n
    // Time 94.21%, Space 68.49%
    public int trap5(int[] height){
        int n = height.length;
        if(n < 3){
            return 0;
        }
        int total = 0;
        int i = 0, j = n - 1;
        int lmax = height[0];
        int rmax = height[j];
        while(i <= j){
            lmax = Math.max(lmax, height[i]);
            rmax = Math.max(rmax, height[j]);
            if(lmax <= rmax){
                total += (lmax - height[i]);
                i++;
            } else if(lmax > rmax){
                total += (rmax - height[j]);
                j--;
            }
        }
        return total;
        
    }
    

}
