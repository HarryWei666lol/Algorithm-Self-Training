package BinaryTree;


public class IsSymmetric_E {

	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}

	public boolean isSymmetric(TreeNode root) {
		// Write your solution here
		if(root == null){
			return true;
		}
		return isSymmetric(root.left, root.right);
	}

	private boolean isSymmetric(TreeNode one, TreeNode two){
		if(one == null && two == null){
			return true;
		} else if (one == null || two == null){
			return false;
		} else if(one.key != two.key){
			return false;
		}
		return isSymmetric(one.left, two.right) && isSymmetric(one.right, two.left);
	}

}
