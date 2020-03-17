package medium;
import java.math.BigInteger;
import java.util.*;

public class Qn445AddTwoNumbers2 {

	// Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}


	// 3 stack method
	// Time 73.17%, Space 73.53% 
	public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
		Deque<ListNode> s1 = new ArrayDeque<>();
		Deque<ListNode> s2 = new ArrayDeque<>();
		Deque<ListNode> s3 = new ArrayDeque<>();

		while(l1 != null){
			s1.offerFirst(l1);
			l1 = l1.next;
		}

		while(l2 != null){
			s2.offerFirst(l2);
			l2 = l2.next;
		}

		int carry = 0;
		while(!s1.isEmpty() || !s2.isEmpty()){
			int val1 = s1.isEmpty() ? 0 : s1.pollFirst().val;
			int val2 = s2.isEmpty() ? 0 : s2.pollFirst().val;

			int val = carry + val1 + val2;
			ListNode node = new ListNode(val % 10);
			carry = val / 10;
			s3.offerFirst(node);
		}
		if(carry == 1){
			s3.offerFirst(new ListNode(1));
		}

		ListNode dummy = new ListNode(0);
		ListNode head = dummy;
		while(!s3.isEmpty()){
			head.next = s3.pollFirst();
			head = head.next;
		}
		return dummy.next;
	}



	// Time 7.70%, Space 73.53%

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		StringBuilder l1Sb = new StringBuilder();
		StringBuilder l2Sb = new StringBuilder();
		ListNode result = new ListNode(0);
		ListNode dummy = result;
		int sum = 0;
		while (l1!=null){
			l1Sb.append(Integer.toString(l1.val));
			l1=l1.next;
		}
		while (l2!=null){
			l2Sb.append(Integer.toString(l2.val));
			l2=l2.next;
		}     
		BigInteger bi = new BigInteger(l1Sb.toString());
		BigInteger n = new BigInteger(l2Sb.toString()).add(bi);
		String s = n.toString();
		for (int i=0; i<=s.length()-1;i++){
			ListNode ln = new ListNode(s.charAt(i)-48);
			dummy.next = ln;
			dummy = ln;
		}
		return result.next;
	}

}
