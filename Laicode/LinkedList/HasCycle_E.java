package LinkedList;

import LinkedList.ReverseLinkedList_E.ListNode;

public class HasCycle_E {

	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	
	public boolean hasCycle(ListNode head) {
		// write your solution here
		if(head == null || head.next == null){
			return false;
		}
		ListNode slow = head;
		ListNode fast = head;
		while (fast != null && fast.next != null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast){
				return true;
			}
		}
		return false;
	}

}
