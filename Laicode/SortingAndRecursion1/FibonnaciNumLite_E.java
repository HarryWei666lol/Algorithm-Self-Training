package SortingAndRecursion1;

public class FibonnaciNumLite_E {


	public int fibonacciIteratively(int K) {
		// Write your solution here
		if(K <= 0){
			return 0;
		}
		long[] array = new long[K + 1];
		array[0] = 0;
		array[1] = 1;
		for(int i = 2; i <= K; i++){
			array[i] = array[i - 2] + array[i - 1];
		}
		return (int)array[K];
	}
	public int fibonacciRecursively(int K) {
		if(K ==0){
			return 0;
		}
		if(K == 1 || K == 2){
			return 1;
		}
		return fibonacciRecursively(K-2) + fibonacciRecursively(K-1);
	}



}
