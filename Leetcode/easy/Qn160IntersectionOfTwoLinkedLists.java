package easy;

public class Qn160IntersectionOfTwoLinkedLists {


	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	// Time 95.82%, Space 5.71%
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null){
			return null;
		}

		// step 1. count the two lists
		int c1 = count(headA);
		int c2 = count(headB);

		// step 2. move the longer one |n1 - n2| steps
		int n = Math.abs(c1 - c2);

		// step 3. move together and find the meeting point
		while(n > 0){
			if(c1 > c2){
				headA = headA.next;
			} else{
				headB = headB.next;
			}
			n--;
		}

		while(headA != headB){
			headA = headA.next;
			headB = headB.next;
		}

		return headA;

	}

	private int count(ListNode l){
		int count = 0;
		while(l.next != null){
			count++;
			l = l.next;
		}
		return count;
	}


}
