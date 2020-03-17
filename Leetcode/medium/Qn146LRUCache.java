package medium;
import java.util.*;

public class Qn146LRUCache {
	// Time 40.23%
	// Space 84.05%

	class LRUCache {

		class Node { // doubly-linked node
			int val;
			int key;
			Node prev;
			Node next;
			public Node(int key, int val){
				this.key = key;
				this.val = val;
			}
		}


		public void join(Node n1, Node n2){
			n1.next = n2;
			n2.prev = n1;
		}

		public void remove(Node curr){
			curr.prev.next = curr.next;
			curr.next.prev = curr.prev;
		}

		public void moveToHead(Node curr){ 
			// when a node is accessed, it will be moved to 
			// head's next, it is no longer the least recently used node
			// another node will be pushed down the usage ranking

			Node next = head.next;
			join(head, curr);
			join(curr, next);

		}

		Map<Integer, Node> map = new HashMap<>();
		Node head = new Node(-1, -1);
		Node tail = new Node(-1, -1);
		int capacity;

		public LRUCache(int capacity) {
			join(head, tail);
			this.capacity = capacity;
		}

		public int get(int key) {
			if(!map.containsKey(key)){
				return -1;
			}
			Node toGetNode = map.get(key);
			// to update the usage ranking
			remove(toGetNode);
			moveToHead(toGetNode);

			return toGetNode.val;

		}

		public void put(int key, int value) {
			if(map.containsKey(key)){
				Node node = map.get(key);
				node.val = value;

				remove(node);
				moveToHead(node);
			} else {
				if(map.size() == capacity){ // map.size() can check the capacity at any instance
					if(tail.prev != head){
						map.remove(tail.prev.key);
						remove(tail.prev);
					}
				}
				Node toAddNode = new Node(key, value);
				moveToHead(toAddNode);
				map.put(key, toAddNode);
			}
		}
	}
}
