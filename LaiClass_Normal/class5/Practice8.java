package class5;

import java.util.*;

public class Practice8 {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v) {
			this.val = v;
		}
	}


	// delete in BST

	// Time O(logn)
	public TreeNode delete(TreeNode root, int target) {
		if(root == null) {
			return null;
		}

		// search and re-link
		if(target < root.val) {
			root.left = delete(root.left, target); // re-linking, that is why needs 'root.left =...'
			return root;
		} else if(target > root.val) {
			root.right = delete(root.right, target);
			return root;
		}

		// delete and re-order (always return the node that replaces the target)
		if(root.left == null) { // case 1, 2
			return root.right;
		} else if(root.right == null) { // case 3
			return root.left;
		} 

		// case 4: root has both left and right child
		if(root.right.left == null) { // 4.1
			root.right.left = root.left;
			return root.right;
		}

		TreeNode smallest = deleteSmallest(root.right);
		smallest.left = root.left;
		smallest.right = root.right;
		return smallest;
	}

	private TreeNode deleteSmallest(TreeNode cur) {
		TreeNode prev = cur;
		cur = cur.left;
		while(cur.left != null) {
			prev = cur;
			cur = cur.left;
		}

		prev.left = prev.left.right; // after removing the smallest, connect the rest
		return cur;
	}


	// Iterative Pre-Order traversal
	public List<Integer> iterativePreOrder(TreeNode root) {
		List<Integer> preOrderList = new ArrayList<>();
		if(root == null) {
			return preOrderList;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.offerFirst(root);

		while(!stack.isEmpty()) {
			TreeNode curr = stack.pollFirst();
			preOrderList.add(curr.val);

			// the left subtree should be traversed before right subtree
			// since stack is LIFO, we should push right into stack first
			// so for the next step, the top element of the stack is the left subtree
			if(curr.right != null) {
				stack.offerFirst(curr.right);
			}
			if(curr.left != null) {
				stack.offerFirst(curr.left);
			}
		}

		return preOrderList;
	}


	// Iterative In-order traversal
	public List<Integer> iterativeInOrder(TreeNode root){
		List<Integer> inOrderList = new ArrayList<>();
		if(root == null) {
			return inOrderList;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;
		
		while(curr != null || !stack.isEmpty()) {
			// always try to go left to see if there is any node that needs to be 
			// traversed before curr node, curr node is stored on stack since it
			// has not been traversed yet
			if(curr != null) {
				stack.offerFirst(curr);
				curr = curr.left;
			} else {
				// if cannot go left, meaning all nodes on left side of the top 
				// node on stack have been traversed, the next traversing node
				// should be the top node on stack
				curr = stack.pollFirst();
				inOrderList.add(curr.val);
				// the next subtree we want to traverse is curr.right
				curr = curr.right;
			}
		}
		return inOrderList;
	}


	// Iterative post-order traversal
	
	// Method 1 - check the relation between the current node and the previous node to determine which direction should go next
	public List<Integer> postOrder(TreeNode root) {
		List<Integer> postOrderList = new ArrayList<>();
		if(root == null){
			return postOrderList;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode prev = null;
		stack.offerFirst(root);

		// to record the previous node on the way of DFS so that we can determine the direction
		while(!stack.isEmpty()){
			TreeNode curr = stack.peekFirst();
			// if we are going down, either left/right direction
			if(prev == null || curr == prev.left || curr == prev.right){ // 三个都是分开的判断
				// if we can still go down, try go left first
				if(curr.left != null){
					stack.offerFirst(curr.left);
				} else if (curr.right != null){
					stack.offerFirst(curr.right);
				} else {
					// if we can not go either way, meaning curr is a leaf node
					stack.pollFirst();
					postOrderList.add(curr.val);
				}
			} else if (prev == curr.right || prev == curr.left && curr.right == null){ // 后两个condition是一起的，第一个condition是独立的
				// if we are going up from the right side or 
				// going up from the left side but we cannot go right afterwards
				stack.pollFirst();
				postOrderList.add(curr.val);
			} else {
				// otherwise, we are going up from the left side and we can go down the right side
				stack.offerFirst(curr.right);
			}
			prev = curr;
		}

		return postOrderList;
	}
	
	// Iterative post-order traversal

	// Method 2: post-order is the reverse of pre-order with traversing right subtree before traversing left subtree
	  public List<Integer> postOrder1(TreeNode root){
	    List<Integer> result = new ArrayList<Integer>();
	    if(root == null){
	      return result;
	    }

	    Deque<TreeNode> preOrder = new ArrayDeque<>();
	    preOrder.offerFirst(root);
	    while(!preOrder.isEmpty()){
	      TreeNode current = preOrder.pollFirst();
	      // conduct the result for the special pre_order traversal
	      result.add(current.val);
	      // in pre-order, the right subtree will be traversed before left subtree so pushing left child first
	      if(current.left != null){
	        preOrder.offerFirst(current.left);
	      }
	      if(current.right != null){
	        preOrder.offerFirst(current.right);
	      }
	    }
	    // reverse the pre-order traversal sequence to get the post-order result
	    Collections.reverse(result);
	    return result;
	  }

}
