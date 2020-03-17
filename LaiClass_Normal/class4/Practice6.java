package class4;

public class Practice6 {
	
	public static class ListNode{
		int val;
		ListNode next;
		public ListNode(int v) {
			this.val = v;
		}
	}

	// Implement Stack by LinkedList
	public static class stackByLinkedList{
		private ListNode head;
		public stackByLinkedList() {
			this.head = null;
		}
		
		public Integer pop() {
			if(head == null) {
				return null;
			}
			ListNode prev = head;
			head = head.next;
			prev.next = null;
			return prev.val;
		}
		
		public Integer peek() {
			if(head == null) {
				return null;
			}
			return head.val;
		}
		
		public void push(int val) {
			ListNode toPush = new ListNode(val);
			toPush.next = head;
			head = toPush;
		}
	}
	
	
	// Implement Queue by LinkedList
	public static class queueByLinkedList{
		private ListNode head;
		private ListNode tail;
		public queueByLinkedList() {
			this.head = this.tail = null;
		}
		
		public Integer poll() {
			if(head == null) {
				return null;
			}
			ListNode node = head;
			head = head.next;
			if(head == null) { // !!!
				tail = null;
			}
			node.next = null;
			return node.val;
		}
		
		public Integer peek() {
			if(head == null) {
				return null;
			}
			return head.val;
		}
		
		public void offer(int val) {
			if(head == null) {
				head = new ListNode(val);
				tail = head;
			} else {
				ListNode toPush = new ListNode(val);
				tail.next = toPush;
				tail = tail.next;
			}
			
		}
	}
	
	
	// Implement queue by array
	public static class BoundedQueueByArr{
		int head;
		int tail;
		int size;
		Integer[] arr;
		public BoundedQueueByArr(int cap) {
			this.arr = new Integer[cap];
			this.head = this.tail = 0;
			this.size = 0;
		}
		
		public boolean offer(Integer ele) {
			// 1.
			if(size == arr.length) {
				return false;
			}
			
			// 2.
			arr[tail] = ele;
			tail = tail + 1 == arr.length ? 0 : tail + 1;
			size++;
			return true;
		}
		
		public Integer peek() {
			if(size == 0) {
				return null;
			}
			return arr[head];
		}
		
		public Integer poll() {
			if(size == 0) {
				return null;
			}
			Integer res = arr[head];
			head = head + 1 == arr.length ? 0 : head + 1;
			size--;
			return res;
		}
		
		public int size() {
			return size;
		}
		public boolean isEmpty() {
			return size == 0;
		}
		public boolean isFull() {
			return size == arr.length;
		}
	}
	
	
	// Implement bounded stack by array
	public static class BoundedStackByArr{
		int[] arr;
		int head;
		
		public BoundedStackByArr(int cap) {
			this.arr = new int[cap];
			head = -1;
		}
		
		public boolean push(int ele) {
			if(head == arr.length - 1) {
				return false;
			}
			arr[++head] = ele; // first head++; then arr[head] = ele;
			return true;
		}
		
		public Integer pop() {
			return head == -1 ? null : arr[head--];
		}
		
		public Integer top() {
			return head == -1 ? null : arr[head];
		}
	}
}
