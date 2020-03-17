package class8;

import java.util.Arrays;

public class practice14 {

	public static class MyHashMap<K, V>{
		
		// Node is a static class of MyHashMap, since it is:
		// very closely bonded to MyHashMap class
		// we probably need to access this class outside from MyHashMap class
		
		public static class Node<K, V>{
			final K key;
			V value;
			Node<K, V> next;
			Node(K key, V value){
				this.key = key;
				this.value = value;
			}
			
			public K getKey() {
				return this.key;
			}
			
			public V getValue() {
				return this.value;
			}
			
			public void setValue(V val) {
				this.value = val;
			}
		}
		
		// static final variables are global constants
		public static final int DEFAULT_CAPACITY = 16; // #buckets
		public static final float DEFAULT_LOAD_FACTOR = 0.75f;
		
		private Node<K, V>[] arr;
		private int size; // how many key-value pairs are actually stored in the HashMap
		private float loadFactor; // determine when to rehash
		
		public MyHashMap() {
			this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);	
		}
		
		@SuppressWarnings("unchecked")
		public MyHashMap(int cap, float loadFactor) {
			if(cap <= 0) {
				throw new IllegalArgumentException("cap cannot be <= 0");
			}
			this.arr = (Node<K, V>[])(new Node[cap]);
			this.size = 0;
			this.loadFactor = loadFactor;
		}
		
		public int size() {
			return this.size;
		}
		
		public boolean isEmpty() {
			return this.size == 0;
		}
		
		public void clear() {
			Arrays.fill(this.arr, null);
			size = 0;
		}
		
		// non-negative
		private int hash(K key) {
			// 1. null key
			if(key == null) {
				return 0;
			}
			return key.hashCode() & 0X7fffffff; // guarantees non-negative 
		}
		
		private int getIndex(K key) {
			return hash(key) % this.arr.length;
		}
		
		private boolean equalsValue(V v1, V v2) {
			if(v1 == null && v2 == null) {
				return true;
			}
			if(v1 == null || v2 == null) {
				return false;
			}
			return v1.equals(v2);
		}
		
		// O(n), traverse the whole array, and traverse each of the LinkedList
		public boolean containsValue(V value) {
			if(isEmpty()) {
				return false;
			}
			for(Node<K, V> node : arr) {
				while(node != null) {
					// check if the value equals() value, node.getValue() all possible to be null
					if(equalsValue(node.value, value)) {
						return true;
					}
					node = node.next;
				}
			}
			return false;
		}
		
		private boolean equalsKey(K k1, K k2) {
			if(k1 == null && k2 == null) {
				return true;
			}
			if(k1 == null || k2 == null) {
				return false;
			}
			return k1.equals(k2);
		}
		
		
		public boolean containsKey(K key) {
			// get the index of the key
			int index = getIndex(key);
			Node<K, V> node = arr[index];
			while(node != null) {
				// check if the key equals() key, node.key() all possible to be null
				if(equalsKey(node.key, key)) {
					return true;
				}
				node = node.next;
			}
			return false;
		}
		
		// if key does not exists in the HashMap, return null
		public V get(K key) {
			int index = getIndex(key);
			Node<K, V> node = arr[index];
			while(node != null) {
				if(equalsKey(node.key, key)) {
					return node.value;
				}
				node = node.next;
			}
			return null;
		}
		
		// insert/update
		// if the key already exists, return the old corresponding value
		// if the key does not exist, return null
		public V put(K key, V value) {
			int index = getIndex(key);
			Node<K, V> head = arr[index]; // don't lose the control of head node
			Node<K, V> node = head;
			
			// update operation
			while(node != null) {
				// check if key equals() key
				// node.key() all possible to be null
				if(equalsKey(node.key, key)) {
					V res = node.value;
					node.value = value;
					return res; // old node's value
				}
			}
			
			// append the new node before head and update new head
			// insert operation
			Node<K, V> newNode = new Node<K, V>(key, value);
			newNode.next = head;
			arr[index] = newNode;// new Head is here
			
			size++;
			if(needRehashing()) {
				rehashing();
			}
			return null;
			
		}
		
		private boolean needRehashing() {
			// float loadFactor
			float ratio = (size + 0.0f) / arr.length;
			return ratio >= loadFactor;
		}
		
		private void rehashing() {
			// new double sized array
			// for each node in the old array
			// do the put() operation to the new larger array
		}
		
		// if the key exists, remove the <key, value> from the HashMap
		// return the value
		// if the key does not exist, return null
		public V remove(K key) {
			// ??? this may be slightly incorrect
			// get index
			// delete operation on LinkedList
			// size--
			int index = getIndex(key);
			Node<K, V> currNode = arr[index];
			Node<K, V> dummy = new Node<K, V>(currNode.key, currNode.value);
			dummy.next = currNode;
			Node<K, V> prev = dummy;
			while(currNode != null) {
				if(equalsKey(currNode.key, key)) {
					prev.next = currNode.next;
					size--;
					return currNode.value;
				} else {
					prev = currNode;
				}
				currNode = currNode.next;
			}
			return null;
			
		}
		
	}

}
