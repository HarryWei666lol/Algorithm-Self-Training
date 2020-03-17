package LinkedList;

public class CheckIfPalindrome_M {

	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	public boolean isPalindrome(ListNode head) {
		// Write your solution here
		if(head == null || head.next == null){
			return true;
		}
		ListNode middle = findMiddle(head);
		ListNode right = reverseLinkedList(middle.next);
		while(right != null){
			if (head.value != right.value){
				return false;
			}
			head = head.next;
			right = right.next;
		}
		return true;
	}

	public ListNode reverseLinkedList(ListNode head) {
		// Write your solution here
		ListNode prev = null;
		while(head != null){
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public ListNode findMiddle(ListNode head){
		if(head == null){
			return null;
		}
		ListNode slow = head;
		ListNode fast = head;
		while(fast.next != null && fast.next.next != null){
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}



}
