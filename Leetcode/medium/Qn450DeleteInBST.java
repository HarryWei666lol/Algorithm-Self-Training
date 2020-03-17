package medium;

public class Qn450DeleteInBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	// Time 100%, Space 6.90%
	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null){
			return root;
		} 
		// search
		if(key < root.val){
			root.left = deleteNode(root.left, key);
			return root;
		} else if(key > root.val){
			root.right = deleteNode(root.right, key);
			return root;
		} 

		// delete and re-order
		if(root.left == null){
			return root.right;
		} else if (root.right == null){
			return root.left;
		}
		if(root.right.left == null){
			root.right.left = root.left;
			return root.right;
		}
		TreeNode smallest = findSmallest(root.right);
		smallest.left = root.left;
		smallest.right = root.right;
		return smallest;
	}

	private TreeNode findSmallest(TreeNode curr){
		TreeNode prev = curr;
		curr = curr.left;
		while(curr.left != null){
			prev = curr;
			curr = curr.left;
		}
		prev.left = prev.left.right;
		return curr;
	}

}
