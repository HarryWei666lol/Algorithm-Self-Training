package BinaryTree;
import java.util.*;

public class BinaryTreeTraversal_H {
	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}

	public List<Integer> preOrder(TreeNode root) {
		List<Integer> preOrderList = new ArrayList<>();
		if(root == null) {
			return preOrderList;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.offerFirst(root);

		while(!stack.isEmpty()) {
			TreeNode curr = stack.pollFirst();
			preOrderList.add(curr.key);

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

	public List<Integer> inOrder(TreeNode root) {
		// Write your solution here
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
				inOrderList.add(curr.key);
				// the next subtree we want to traverse is curr.right
				curr = curr.right;
			}
		}
		return inOrderList;
	}

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
			if(prev == null || curr == prev.left || curr == prev.right){
				// if we can still go down, try go left first
				if(curr.left != null){
					stack.offerFirst(curr.left);
				} else if (curr.right != null){
					stack.offerFirst(curr.right);
				} else {
					// if we can not go either way, meaning curr is a leaf node
					postOrderList.add(curr.key);
					stack.pollFirst();
				}
			} else if (prev == curr.right || prev == curr.left && curr.right == null){ // 后两个condition是一起的，第一个condition是独立的
				// if we are going up from the right side or 
				// going up from the left side but we cannot go right afterwards
				stack.pollFirst();
				postOrderList.add(curr.key);
			} else {
				// otherwise, we are going up from the left side and we can down the right side
				stack.offerFirst(curr.right);
			}
			prev = curr;
		}

		return postOrderList;
	}

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
			result.add(current.key);
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
