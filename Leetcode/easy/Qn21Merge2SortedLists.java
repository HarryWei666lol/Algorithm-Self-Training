package easy;

public class Qn21Merge2SortedLists {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}
	
	// time 100%, space 8.08%
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummyHead = new ListNode(0);
		ListNode c = dummyHead, c1 = l1, c2 = l2;
		while(c1 != null && c2 != null){
			if(c1.val < c2.val){
				c.next = c1;
				c1 = c1.next;
			} else{
				c.next = c2;
				c2 = c2.next;
			}
			c = c.next;     
		}
		if(c1 != null){
			c.next = c1;
		} else if(c2 != null){
			c.next = c2;
		}

		return dummyHead.next;
	}

}
