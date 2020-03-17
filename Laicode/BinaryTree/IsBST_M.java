package BinaryTree;

public class IsBST_M {
	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	public boolean isBST(TreeNode root) {
		// Write your solution here
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	private boolean isBST(TreeNode root, int min, int max){
		if(root == null){
			return true;
		}
		if(root.key < min || root.key > max){
			return false;
		}
		return isBST(root.left, min, root.key -1) && isBST(root.right, root.key+1, max);
	}
}
