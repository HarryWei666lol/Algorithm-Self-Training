package class2;
import java.util.*;

public class SortingProblems {


	// Merge sort with 2 stacks(3 stacks in total)

	public void sort1(LinkedList<Integer> s1) {
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		LinkedList<Integer> s3 = new LinkedList<Integer>();
		sort(s1,s2,s3,s1.size());
	}


	private void sort(LinkedList<Integer> s1, LinkedList<Integer> s2, LinkedList<Integer> s3, int size){
		int size1 = size/2;
		int size2 = size - size/2;


		if(size<=1){
			return;
		}
		for(int i=0; i <size1; i++){ //move half of s1 to s2.
			s2.offerFirst(s1.pollFirst());
		}
		sort(s2,s3,s1,size1); //recursion mergeSort
		sort(s1,s3,s2,size2);


		int i = 0;
		int j = 0;
		while(i < size1 && j < size2){ //then move the smaller to s3. like merge sorted stacks
			if(s2.peekFirst() > s1.peekFirst()){
				s3.offerFirst(s1.pollFirst());
				j++;
			}
			else{
				s3.offerFirst(s2.pollFirst());
				i++;
			}
		}
		while(i < size1){
			s3.offerFirst(s1.pollFirst());
			j++;
		}
		while(j < size2){
			s3.offerFirst(s2.pollFirst());
			i++;
		}
		for(int index= 0; index < size; i++){ //then move s3 to s1, order is reversed too.
			s1.offerFirst(s3.pollFirst());
		}
	}



	// sort with 1 stack(2 stacks in total)

	// Time O(n^2)
	public static void sort(LinkedList<Integer> input) {
		if(input == null || input.size() <= 1) {
			return;
		}
		LinkedList<Integer> buffer = new LinkedList<Integer>();
		//then store everything in s2 in descending order
		sort(input, buffer);
	}

	private static void sort(Deque<Integer> input, Deque<Integer> buffer){
		// Method 1

		// input: unsorted elements
		// buffer:(top part) buffer, (bottom part) sorted elements

		// Step 1: sort in ascending order and store result in buffer
		while(!input.isEmpty()){
			int curMin = Integer.MAX_VALUE;
			int count = 0;
			while(!input.isEmpty()){
				int cur = input.pollFirst();
				if(cur < curMin){
					curMin = cur;
					count = 1;
				} else if(cur == curMin){
					count++;
				}
				buffer.offerFirst(cur);
			}
			while(!buffer.isEmpty() && buffer.peekFirst() >= curMin){
				int tmp = buffer.pollFirst();
				if(tmp != curMin){
					input.offerFirst(tmp);
				}
			}
			while(count-- > 0){
				buffer.offerFirst(curMin);// returns ascending order
				// buffer.offer(curMin); // returns descending order
			}
		}

		// Step 2: move result from buffer to input, so it's in descending order
		while(!buffer.isEmpty()){
			input.offerFirst(buffer.pollFirst());
		}
	}


	// Merge Sort

	// Time O(nlogn)
	// Space O(n)
	public static int[] sort(int[] arr) {
		if(arr == null || arr.length == 1) {
			return arr;
		}
		int[] helper = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, helper);
		return arr;
	}

	private static void mergeSort(int[] arr, int left, int right, int[] helper) {
		if(left <= right) {
			return;
		}

		int mid = left + (right - left) / 2;
		mergeSort(arr, left, mid, helper);
		mergeSort(arr, mid + 1, right, helper);
		merge(arr, left, mid, right, helper);
	}

	private static void merge(int[] arr, int left, int mid, int right, int[] helper) {
		for(int i = left; i < right; i++) {
			helper[i] = arr[i];
		}
		int leftIndex = left;
		int rightIndex = mid + 1;
		while (leftIndex <= mid && rightIndex <= right) {
			if(helper[leftIndex] < helper[rightIndex]) {
				arr[left] = helper[leftIndex];
				leftIndex++;
			} else {
				arr[left] = helper[rightIndex];
				rightIndex++;
			}
			left++;
		}

		while(leftIndex <= mid) {
			arr[left] = helper[leftIndex];
			leftIndex++;
			left++;
		}	
	}


	// MergeSort in LinkedList

	// Time O(nlogn)
	// Space O(logn)
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int v) {
			this.val = v;
			next = null;
		}
	}

	public static ListNode mergeSortInLinkedList(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMiddle(head);
		ListNode midNext = mid.next;
		mid.next = null;

		ListNode left = mergeSortInLinkedList(head);
		ListNode right = mergeSortInLinkedList(midNext);

		return mergeHelper(left, right);
	}

	private static ListNode findMiddle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private static ListNode mergeHelper(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while(left != null && right != null) {
			if(left.val <= right.val) {
				cur.next = left;
				left = left.next;
			} else {
				cur.next = right;
				right = right.next;
			}
			cur = cur.next;
		}
		// just need to perform one time as connecting one node with another, will connect all the rest

		if(left != null) { 
			cur.next = left;
		} else {
			cur.next = right;
		}
		return dummy.next;
	}


	// convert string “A1B2C3D4” to string “ABCD1234”

	// Time O(nlogn)
	// Space O(n + logn) -> O(n)   
	// same as classical merge sort
	public static String convert(String str) {
		if(str == null || str.length() == 1) {
			return str;
		}
		char[] arr = str.toCharArray();
		char [] helper = new char[arr.length];
		mergeSortStr(arr, 0, arr.length - 1, helper);
		return new String(arr);
	}

	private static void mergeSortStr(char[] arr, int left, int right, char[] helper) {
		if (right <= left) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSortStr(arr, left, mid, helper);
		mergeSortStr(arr, mid + 1, right, helper);
		merging(arr, left, mid, right, helper);
	}

	private static void merging(char[] arr, int left, int mid,
			int right, char[] helper) {
		for (int i = left; i <= right; i++) {
			helper[i] = arr[i];
		}

		int leftIndex = left;
		int rightIndex = mid + 1;

		while (leftIndex <= mid && rightIndex <= right) {
			if (helper[leftIndex] >= 'A' && helper[leftIndex] <= 'Z'
					&& helper[rightIndex] >= 'A' && helper[rightIndex] <= 'Z'
					|| helper[leftIndex] >= '0' && helper[leftIndex] <= '9'
					&& helper[rightIndex] >= '0' && helper[rightIndex] <= '9') {
				// leftIndex,rightIndex属于同一类，比如都是字母 'A' - 'Z' 或者都是数字 '0' - '9'
				if (helper[leftIndex] <= helper[rightIndex]) {
					arr[left++] = helper[leftIndex++];
				} else {
					arr[left++] = helper[rightIndex++];
				}
			} else { // leftIndex, rightIndex一个是字母，另一个是数字
				if (helper[leftIndex] >= 'A' && helper[leftIndex] <= 'Z') {
					arr[left++] = helper[leftIndex++];
				} else {
					arr[left++] = helper[rightIndex++];
				}
			}
		}

		while (leftIndex <= mid) {
			arr[left++] = helper[leftIndex++];
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(4);
		list.add(2);
		list.add(3);
		list.add(1);
		sort(list);
		while(!list.isEmpty()) {
			System.out.print(list.pollFirst() + " ");
		}
		String str = "A1B2C3D4";
		System.out.print(convert(str));
	}


	// convert a string “ABCD1234” to ”A1B2C3D4”

	// Time O(nlogn)
	// Space O(logn)
	public String reverseConvert(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		char[] arr = str.toCharArray();
		convert(arr, 0, arr.length - 1);
		return new String(arr);
	}

	private void convert(char[] arr, int left, int right) {
		if (left + 1 > right) {
			return;
		}
		int length = right - left + 1;
		int mid = left + length/2;

		int leftmid = left + length/4;
		int rightmid = left + length * 3/4;

		reverse(arr, leftmid, mid - 1);
		reverse(arr, mid, rightmid - 1);
		reverse(arr, leftmid, rightmid - 1);

		convert(arr, left, left + (leftmid - left) * 2 - 1);
		convert(arr, left + (leftmid - left) * 2, right);
	}

	private void reverse(char[] arr, int left, int right) {
		while (left < right) {
			swap(arr, left++, right--);
		}
	}

	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}


	// Classical Quick Sort

	// Time O(n^2)         On average: O(nlogn)
	// Space O(n)                      O(logn)
	public static int[] quickSort(int[] arr) {
		if(arr == null || arr.length == 1) {
			return arr;
		}
		quickSort(arr, 0, arr.length - 1);
		return arr;
	}

	private static void quickSort(int[] arr, int left, int right) {
		if(left >= right) { // !!
			return;
		}

		// define a pivot and use the pivot to partition the array
		int pivotPos = partition(arr, left, right);

		// pivot is already at its position, when we do the recursive call on the two partitions, 
		// pivot should not be included in any of them
		quickSort(arr, left, pivotPos - 1);
		quickSort(arr, pivotPos + 1, right);
	}

	private static int partition(int[] arr, int left, int right) {
		int pivotIndex = calculatePivot(left, right);
		int pivot = arr[pivotIndex];

		swap(arr, pivotIndex, right); // swap the pivot element to the right-most position first

		int i = left; // leftBound
		int j = right - 1; // rightBound
		while(i < j) { // !!
			if(arr[i] < pivot) {
				i++;
			} else if(arr[j] > pivot) {
				j--;
			} else { // when arr[leftIndex] > pivot or when arr[rightIndex] < pivot
				swap(arr, i, j);
				i++;
				j--;
			}
		}
		swap(arr, i, pivotIndex); // swap back the pivot element
		return i;
	}


	// pick random element in the range of [left, right]
	private static int calculatePivot(int left, int right) {
		int pivotIndex = left + (int)(Math.random() * (right - left + 1));
		return pivotIndex;
	}

	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}


	// Move 0s to the right end

	// Time O(n)
	// Space O(1)
	public static int[] moveZeros(int[] arr) {
		if (arr == null || arr.length == 1) {
			return arr;
		}
		int left = 0;
		int right = arr.length - 1;

		while(left <= right) {
			if(arr[left] != 0) {
				left++;
			} else if (arr[right] == 0) {
				right--;
			} else {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return arr;
	}


	// Rainbow Sort

	// Time O(n)
	// Space O(1)
	public static int[] rainbowSort(int arr[]) {
		if(arr == null || arr.length == 1) {
			return arr;
		}
		int i = 0;
		int j = 0;
		int k = arr.length - 1;

		// three bounds:
		// 1. the left side of i is -1(exclusive of i)
		// 2. the right side of k is 1(exclusive of k)
		// 3. the part between i and k is 0 (exclusive of j)
		// 4. between j and k is to be discovered (inclusive of both j and k)

		while(j <= k) {
			if(arr[j] == -1) {
				swap(arr, i, j);
				i++;
				j++;
			} else if(arr[j] == 0) {
				j++;
			} else { // when arr[j] == 1
				swap(arr, j, k);
				k--;
			}
		}
		return arr;
	}

}
