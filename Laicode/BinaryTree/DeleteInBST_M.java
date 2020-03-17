package BinaryTree;



public class DeleteInBST_M {

	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}

	public TreeNode deleteTree(TreeNode root, int key) {
		if(root == null){
			return null;
		}

		if(key < root.key){
			root.left = deleteTree(root.left, key);
			return root;
		} else if (key > root.key){
			root.right = deleteTree(root.right, key);
			return root;
		}

		if(root.left == null){
			return root.right;
		} else if (root.right == null){
			return root.left;
		}

		if(root.right.left == null){
			root.right.left = root.left;
			return root.right;
		}

		TreeNode smallest = deleteSmallest(root.right);
		smallest.left = root.left;
		smallest.right = root.right;
		return smallest;
	}

	private TreeNode deleteSmallest(TreeNode cur){
		TreeNode prev = cur;
		cur = cur.left;
		while(cur.left != null){
			prev = cur;
			cur = cur.left;
		}
		prev.left = prev.left.right;
		return cur;
	}


}
