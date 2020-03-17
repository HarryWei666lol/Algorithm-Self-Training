package LinkedList;

import LinkedList.Insert_E.ListNode;

public class MergeSortLinkedList {

	class ListNode {
		public int value;
		public ListNode next;
		public ListNode(int value) {
			this.value = value;
			next = null;
		}
	}
	
	public class Solution {
		public ListNode mergeSort(ListNode head) {
			// Write your solution here
			if(head == null || head.next == null){
				return head;
			}
			// split the list into two halves
			ListNode middle = findMiddle(head);
			ListNode middleNext = middle.next;
			middle.next = null;
			// sort each half
			ListNode left = mergeSort(head);
			ListNode right = mergeSort(middleNext);
			// combine two halves
			return merge(left, right);
		}

		public ListNode findMiddle(ListNode head) {
			ListNode slow = head;
			ListNode fast = head;
			while(fast.next != null && fast.next.next != null){
				slow = slow.next;
				fast = fast.next.next;
			}
			return slow;
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
			} else {
				cur.next = two;
			}
			return dummy.next;
		}
	}

}
