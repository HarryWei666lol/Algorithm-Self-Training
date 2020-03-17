package LinkedList;

import LinkedList.HasCycle_E.ListNode;

public class Insert_E {
	
	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}

	public ListNode insert(ListNode head, int value) {
		// Write your solution here
		ListNode newNode = new ListNode(value);
		// 1. determine if the inserted node is before head
		if(head == null || head.value >= value){
			newNode.next = head;
			return newNode;
		}
		// 2. insert the new node to the right position
		// using the curr node to traverse the linked list
		// because we need to preserve 'head'
		// the insert position of the new node should be between prev and prev.next
		ListNode curr = head;
		while(curr.next != null && curr.next.value < value){
			curr = curr.next;
		}
		newNode.next = curr.next;
		curr.next = newNode;
		return head;
	}
}
