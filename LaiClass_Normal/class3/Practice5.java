package class3;

public class Practice5 {

	public static int[] mergeSort(int[] arr) {
		if(arr == null || arr.length <= 1) {
			return arr;
		}
		int[] helper = new int[arr.length];
		mergeSort(arr, 0, arr.length - 1, helper);
		return arr;
	}
	
	private static void mergeSort(int[] arr, int left, int right, int[] helper) {
		if(left >= right) {
			return;
		}
		int mid = left + (right - left) / 2;
		mergeSort(arr, left, mid, helper);
		mergeSort(arr, mid + 1, right, helper);
		merge(arr, left, mid, right, helper);
	}
	
	private static void merge(int[] arr, int left, int mid, int right, int[] helper) {
		for(int i = left; i <= right; i++) { // !!
			helper[i] = arr[i];
		}
		int leftIndex = left;
		int rightIndex = mid + 1;
		while(leftIndex <= mid && rightIndex <= right) { // !!
			if(helper[leftIndex] <= helper[rightIndex]) {
				arr[left] = helper[leftIndex++];
			} else {
				arr[left] = helper[rightIndex++];
			}
			left++;
		}
		while(leftIndex <= mid) {
			arr[left++] = arr[leftIndex++];
		}
	}
	
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int v) {
			this.val = v;
		}
	}
	
	public static ListNode reorderList(ListNode head) {
		// find middle node
		// reverse the second half
		// merge 2 LinkedList
		if(head == null || head.next == null) {
			return head;
		}
		ListNode mid = findMiddle(head);
		ListNode one = head;// !!
		ListNode two = mid.next;
		mid.next = null;
		
		return mergeTwoLists(one, reverse(two));
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
	
	private static ListNode reverse(ListNode head) {
		ListNode prev = null;
		while(head != null) { // !!
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
	
	private static ListNode mergeTwoLists(ListNode one, ListNode two) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while(one != null && two != null) {
			cur.next = one;
			one = one.next;
			cur.next.next = two;
			two = two.next;
			cur = cur.next.next;
		}
		if(one != null) {
			cur.next = one;
		} 
		else if(two != null) {
			cur.next = two;
		}
		return dummy.next;
	}
	

}
