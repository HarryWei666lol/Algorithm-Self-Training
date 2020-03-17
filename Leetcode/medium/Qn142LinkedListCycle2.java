package medium;

public class Qn142LinkedListCycle2 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// time 100%, space 6.32%
	public ListNode detectCycle(ListNode head) {
		if(head == null || head.next == null){
			return null;
		}
		ListNode fast = head;
		ListNode slow = head;

		while(fast != null && fast.next != null){
			fast = fast.next.next;
			slow = slow.next;
			if(slow == fast){ // cycle detected
				while(fast != head){
					fast = fast.next;
					head = head.next;
				}
				return head; 
			}
		}
		return null;
	}

}
