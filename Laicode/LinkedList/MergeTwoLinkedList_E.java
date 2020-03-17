package LinkedList;

import LinkedList.Insert_E.ListNode;

public class MergeTwoLinkedList_E {
	
	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	
	public ListNode merge(ListNode one, ListNode two) {
		// Write your solution here
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while(one != null && two != null){
			if(one.value <= two.value){
				cur.next = one; 
				one = one.next;
			} else{
				cur.next = two;
				two = two.next;
			}
			cur = cur.next;
		}
		// link the remaining possible nodes
		if(one != null){
			cur.next = one;
		} else{
			cur.next = two;
		}
		return dummy.next;
	}

}
