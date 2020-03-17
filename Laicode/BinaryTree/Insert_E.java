package BinaryTree;

public class Insert_E {
	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}

	public TreeNode insert(TreeNode root, int key) {
		// Write your solution here
		TreeNode newNode = new TreeNode(key);
		if(root == null){
			return newNode;
		} else if (root.key == key){
			return root;
		}

		if(key < root.key){
			root.left = insert(root.left, key);
		} else{
			root.right = insert(root.right, key);
		}

		return root;

	}

}
