package medium;

import java.util.Random;

public class Qn384ShuffleAnArr {
	
	/**
	 * Your Solution object will be instantiated and called as such:
	 * shuffleArr obj = new shuffleArr(nums);
	 * int[] param_1 = obj.reset();
	 * int[] param_2 = obj.shuffle();
	 */
	
	// Solution 1
	// Time 86.51%, Space 100%
	class shuffleArr {
	    private int[] nums;
	    private Random rand;
	    
	    public shuffleArr(int[] nums) {
	        this.nums = nums;
	        this.rand = new Random();
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        return this.nums;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        if(nums == null){
	            return null;
	        }
	        int[] a = nums.clone();
	        for(int j = 1; j < a.length; j++){
	            int i = rand.nextInt(j + 1);
	            swap(a, i, j);
	        }
	        return a;
	    }
	    
	    public void swap(int[] arr, int left, int right){
	        int tmp = arr[left];
	        arr[left] = arr[right];
	        arr[right] = tmp;
	    }
	}
	
	// Solution 2 - Fisher-Yates shuffle or AKA Knuth shuffle - O(n)
	// Time 60.07%, Space 100%
	class Solution {
	    private int[] array;
	    private int[] original;
	    
	    Random rand = new Random();
	    
	    public Solution(int[] nums) {
	        this.array = nums;
	        this.original = nums.clone();
	    }
	    
	    /** Resets the array to its original configuration and return it. */
	    public int[] reset() {
	        array = original;
	        
	        // This is to make sure the changes in "array" does not change the "original" as when we write array = original, 
	        // we make both array and original to an array of integers present in the same memory location.
	        // hence original = original.clone(); will make original point to new array integers which is a clone of values pointed by original previously.
	        // Think of this as a deep copy.
	        
	        original = original.clone();
	        return original;
	    }
	    
	    /** Returns a random shuffling of the array. */
	    public int[] shuffle() {
	        for(int i = 0; i < array.length; i++){
	            swap(i, randRange(i, array.length));
	        }
	        return array;
	    }
	    
	    private int randRange(int min, int max){
	        return min + rand.nextInt(max - min);
	    }
	    
	    public void swap(int left, int right){
	        int tmp = array[left];
		    array[left] = array[right];
		    array[right] = tmp;
	    }
	}
}
