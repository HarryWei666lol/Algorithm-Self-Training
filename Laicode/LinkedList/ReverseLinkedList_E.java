package LinkedList;

public class ReverseLinkedList_E {

	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}


	// exam 1
	public ListNode reverse(ListNode head) {
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

	// recursive approach
	public ListNode reverseRecursively(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode newHead = reverseRecursively(head.next);
		head.next.next = head;
		head.next = null;
		return newHead;
	}
}


