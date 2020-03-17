package BinaryTree;

import BinaryTree.BinaryTreeTraversal_E.TreeNode;

public class IsBalanced_M {
	
	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}

	public boolean isBalanced(TreeNode root) {
		// Write your solution here
		if(root == null){
			return true;
		}
		boolean left = isBalanced(root.left);
		boolean right = isBalanced(root.right);
		if(!left || !right){
			return false;
		}
		// judge if the height diff of current node is satisfied
		int leftHeight = findHeight(root.left);
		int rightHeight = findHeight(root.right);
		if(Math.abs(leftHeight - rightHeight) > 1){
			return false;
		}
		return true;
	}

	public int findHeight(TreeNode root) {
		// Write your solution here
		if(root == null){
			return 0;
		}
		int leftHeight= findHeight(root.left);
		int rightHeight= findHeight(root.right);
		return Math.max(leftHeight, rightHeight) + 1;
	}
}
