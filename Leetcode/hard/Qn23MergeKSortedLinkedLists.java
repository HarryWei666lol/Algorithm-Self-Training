package hard;
import java.util.*;

public class Qn23MergeKSortedLinkedLists {


	//Definition for singly-linked list.
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	// Time 81.74% Space 42.08%
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists == null || lists.length == 0){
			return null;
		}

		// minHeap
		PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>(){
			@Override
			public int compare(ListNode o1, ListNode o2){
				if(o1.val < o2.val){
					return -1;
				} else if(o1.val == o2.val){
					return 0;
				} else{
					return 1;
				}
			}
		});

		ListNode dummy = new ListNode(0);
		ListNode tail = dummy;

		for(ListNode node : lists){
			if(node != null){
				queue.add(node); // the first node of each LinkedList is added to PQ
			}
		}

		while(!queue.isEmpty()){ 
			tail.next = queue.poll(); // the smallest from PQ is polled
			tail = tail.next;
			if(tail.next != null){  
				queue.add(tail.next);// the next node of this smallest node is added to the PQ -> PQ now has again k nodes
			}
		}

		return dummy.next;
	}


}
