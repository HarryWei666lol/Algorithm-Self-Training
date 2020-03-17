package easy;

import java.util.BitSet;

public class Qn190ReverseBits {

	public static Integer reverseBits(Integer n){
		Integer result = 0;
		
		for(int i = 0; i < 32; i++){
			//System.out.println(Integer.toBinaryString(result) +  " Step 1");
			result <<= 1; // have 1 new place(bit) in result
			//System.out.println(Integer.toBinaryString(result) +  " Step 2");
			result += n & 1; // get what this place should be based on the rightmost bit in n
			//System.out.println(Integer.toBinaryString(result) +  " Step 3");
			n >>>= 1; // n loses its rightmost bit
			//System.out.println(Integer.toBinaryString(n) +  " value of n");
		}
        
		return result;
    }
	
	public static void main(String[] args) {
		Integer n = 43261596;
		System.out.println(Integer.toBinaryString(n) + " start");
		System.out.println(Integer.toBinaryString(reverseBits(n)) + " end");
		
	}

}
