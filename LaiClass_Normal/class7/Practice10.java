package class7;

import java.util.NoSuchElementException;

public class Practice10 {

	// minHeapWithHeapify

	public class MinHeap{
		private int[] arr;
		private int size; // the number of elements in heap
		private final double RESIZE_FACTOR = 1.5;

		// 1st way to construct a MinHeap, that is fully filled
		public MinHeap(int[] arr) {
			if(arr == null || arr.length == 0) {
				throw new IllegalArgumentException("Input array cannot be null or empty");
			}
			this.arr = arr;
			this.size = arr.length;
			heapify();
		}

		// 2nd way to construct a MinHeap, that is empty
		public MinHeap(int cap) {
			if(cap <= 0) {
				throw new IllegalArgumentException("Capacity cannot be <= 0");
			}
			this.arr = new int[cap];
			size = 0;
		}

		public void offer(int ele) {
			if(size == arr.length) {
				int[] newArr = new int[(int)(arr.length * RESIZE_FACTOR)];
				for(int i = 0; i < size; i++) {
					newArr[i] = arr[i];
				}
				arr = newArr;
			}
			arr[size] = ele;
			size++;
			percolateUp(size - 1);

		}

		public int poll() {
			if(size == 0) {
				throw new NoSuchElementException("Heap is empty!");
			}

			int res = arr[0];
			arr[0] = arr[size - 1];
			size--;
			percolateDown(0);

			return res;
		}

		public int peek() {
			if(size == 0) {
				throw new NoSuchElementException("Heap is empty!");
			}
			return arr[0];
		}

		// return the original value
		public int update(int index, int ele) {
			if(index < 0 || index >= size) {
				throw new ArrayIndexOutOfBoundsException("Invalid index range");
			}
			int curr = arr[index];
			arr[index] = ele;
			if(curr > ele) {
				percolateUp(index);
			} else {
				percolateDown(index);
			}
			return curr;
		}

		public boolean isEmpty() {
			return this.size == 0;
		}

		public boolean isFull() {
			return this.size == arr.length;
		}

		public int size() {
			return this.arr.length;
		}

		public void heapify() {
			// size - 1 is the last element
			// (size - 1 - 1) / 2
			// size / 2 - 1
			for(int i = size / 2 - 1; i >= 0; i--) {
				percolateDown(i);
			}
//			
//			for(int i = 0; i <= size / 2 - 1; i++) {
//				percolateUp(i);
//			}
		}

		public void percolateUp(int index) { // this index is seen as a child index
			while(index > 0) {
				int parentIndex = (index - 1) / 2;
				if(arr[parentIndex] > arr[index]) {
					swap(arr, index, parentIndex);
				} else {
					break;
				}
				index = parentIndex;
			}
		}

		public void percolateDown(int index) { // this index is seen as a parent index

			while(index <= size / 2 - 1) { // check that index is still 
				// smaller than or equal to the largest node that is not a leaf node

				int leftChildIndex = 2 * index + 1;
				int rightChildIndex = 2 * index + 2;
				int candidate = leftChildIndex; // smallest one among leftChild and rightChild

				if(rightChildIndex <= size - 1 && arr[rightChildIndex] < arr[leftChildIndex]) {
					// update candidate if rightChild exists and it is smaller than leftChild
					candidate = rightChildIndex;
				}
				// swap if necessary
				if(arr[index] > arr[candidate]) {
					swap(arr, index, candidate);
				} else {
					break;
				}
				index = candidate;
			}
		}

		public void swap(int[] arr, int a, int b) {
			int tmp = arr[a];
			arr[a] = arr[b];
			arr[b] = tmp;
		}
	}

}
