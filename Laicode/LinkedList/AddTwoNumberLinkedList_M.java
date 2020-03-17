package LinkedList;

import LinkedList.Insert_E.ListNode;

public class AddTwoNumberLinkedList_M {
	
	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	
	// e.g. Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
	// Output: 7 -> 0 -> 8
	// explanation: 342 + 465 = 807
	public ListNode addTwoNumbers(ListNode a, ListNode b) {
	    // Write your solution here
	    ListNode dummy = new ListNode(0);
	    ListNode cur = dummy;
	    int val = 0;

	    while(a != null || b != null ){
	      if(a != null){
	        val += a.value;
	        a = a.next;
	      }
	      if(b != null){
	        val += b.value;
	        b = b.next;
	      }
	      cur.next = new ListNode(val % 10); // to handle when the sum is 10 or greater
	      val = val / 10; 
	      cur = cur.next;
	    }

	    return dummy.next;
	  }

}
