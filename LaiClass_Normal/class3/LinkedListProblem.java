package class3;

public class LinkedListProblem {
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int v) {
			this.val = v;
		}
	}
	
	// reverse LinkedList recursively
	
	// Time O(n)
	// Space O(n)
	public static ListNode reverseRecursively(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		
		ListNode newHead = reverseRecursively(head.next);
		head.next.next = head;
		head.next = null;
		
		return newHead;
	}

	
	// LinkedList get length
	public static int length(ListNode head) {
		if(head == null) {
			return 0;
		}
		int count = 0;
		while(head != null) { // not head.next here !!!
			count++;
			head = head.next;
		}
		// after the while loop, head stops at null, not the last node
		return count;
	}
	
	// LinkedList get a node based on index
	public static ListNode get(ListNode head, int index) {
		while(index > 0 && head != null) {
			head = head.next;
			index--;
		}
		return head;
	}
	
	// append a ListNode to head
	public static ListNode appendHead(ListNode head, int val) {
		ListNode tmp = new ListNode(val);
		tmp.next = head;
		return tmp;
	}
	
	// append a ListNode to tail
	public static ListNode appendTail(ListNode head, int val) {
		ListNode tmp = new ListNode(val);
		if(head == null) {
			return tmp;
		}
		
		// find the last node in the LinkedList
		ListNode prev = head;
		while(prev.next != null) { // here prev stops at the last element, not null
			prev = prev.next;
		}
		
		prev.next = tmp;
		return head; // need to keep head to return it here
	}
	
	// remove a ListNode 
	public static ListNode remove(ListNode head, int value) {
		if(head == null) {
			return null;
		} else if (head.val == value) { // head is the value to be removed, returned value should be head.next
			return head.next;
		}
		
		ListNode cur = head;
		while(cur.next != null && cur.next.val != value) { // exit the while loop 
			// when there is no more node next to cur 并且 the ListNode's value next to cur is not equal to value
			cur = cur.next;
		}
		
		if(cur.next != null) {
			cur.next = cur.next.next;// below is how it works
			// 1 -> 2 -> 3 -> null
			//       c
			// 1 -> 2 -> null
		}
		return head;
	}
	

	

}
