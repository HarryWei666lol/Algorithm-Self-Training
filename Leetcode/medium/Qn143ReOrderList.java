package medium;

public class Qn143ReOrderList {


	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	public void reorderList(ListNode head) {
		if(head == null || head.next == null){
			return;
		}

		ListNode l1 = head; // will be the head of first list

		ListNode prev = null, slow = head, fast = head;

		// cut the list to 2 halves
		// prev will be tail of 1st half
		// slow will be head of 2nd half
		while(fast != null && fast.next != null){
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		prev.next = null;

		// reverse 2nd half
		ListNode l2 = reverse(slow);

		// merge the two halves
		merge(l1, l2);
	}

	private ListNode reverse(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while(curr != null){
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

	private void merge(ListNode l1, ListNode l2){
		while(l1 != null){
			ListNode n1 = l1.next;
			ListNode n2 = l2.next;

			l1.next = l2;
			if(n1 == null){
				break;
			}
			l2.next = n1;

			l1 = n1;
			l2 = n2;
		}
	}


}
