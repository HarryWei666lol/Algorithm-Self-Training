package easy;

public class Qn172FactorialTrailingZeroes {

	// Trailing zero is formed by multiplying 2's multiple and 5's multiple. 
	// By nature, # of 2's multiple (2, 4, 6, ... 2-steps-jump) are lot more than 
	// # of 5's (5, 10, 15..5-steps-jump). So # of 5's multiple should decide the 
	// trailing zeros which is n/5. But note that numbers like 25, 125.. are special 
	// as they have more than one 5's in them and each 5 can contribute to one trailing zero 
	// with some 2's multiple. Again, do not worry about running out of 2's multiples for 25 or 125 etc 
	// as they are far more abundantly available.

	// Time 100%, Space 7.69%
	// O(1) Time Complexity
	public int trailingZeroes(int n) {
		int count = 0;
		while(n >= 5){
			count = count + n / 5;
			n = n / 5;
		}
		return count;
	}


}
