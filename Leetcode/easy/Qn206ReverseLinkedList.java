package easy;

public class Qn206ReverseLinkedList {

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	// time 100%, space 98.92% Iteratively
	//  public ListNode reverseList(ListNode head) {
	//      if(head == null || head.next == null){
	//          return head;
	//      }

	//      ListNode prev = null;
	//      ListNode curr = head;

	//      while(curr != null){
	//          ListNode next = curr.next;
	//          curr.next = prev;
	//          prev = curr;
	//          curr = next;
	//      }
	//      return prev;
	//  }
	
	// time 100%, space 98.56% Recursively
	public ListNode reverseList(ListNode head){
		if(head == null || head.next == null){
			return head;
		}
		ListNode subHead = reverseList(head.next);
		ListNode n2 = head.next;
		n2.next = head;
		head.next = null;
		return subHead;
	}

}
