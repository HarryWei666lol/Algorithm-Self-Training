package LinkedList;

import LinkedList.ReverseLinkedList_E.ListNode;

public class MiddleNodeOfLinkedList_E {

	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	public ListNode middleNode(ListNode head) {
		// Write your solution here
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
