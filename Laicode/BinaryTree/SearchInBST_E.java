package BinaryTree;



public class SearchInBST_E {

	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}

	public TreeNode search(TreeNode root, int key) {
		// Write your solution here
		if(root == null || root.key == key){
			return root;
		} 
		if(key < root.key){
			return search(root.left, key);
		} else if(key > root.key){
			return search(root.right, key);
		}
		return root;
	}
}
