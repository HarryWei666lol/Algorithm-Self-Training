package class5;

public class Practice7 {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v) {
			this.val = v;
		}
	}
	
	
	// Time O(h); worst case O(n), average O(logn)
	// Space O(h)
	public TreeNode recursiveSearch(TreeNode root, int target) {
		if(root == null || root.val == target) {
			return root;
		}
		if(target < root.val) {
			return recursiveSearch(root.left, target); // tail recursion
		} else {
			return recursiveSearch(root.right, target); // tail recursion
		}
	}
	
	// Time O(h)
	// Space O(1)
	public TreeNode iterativeSearch(TreeNode root, int target) { // terminate condition
		TreeNode currNode  = root;
		while(currNode != null && currNode.val != target) {
			if(target < currNode.val) {
				currNode = currNode.left;
			} else {
				currNode = currNode.right;
			}
		}
		return currNode;
	}
	
	
	// Time O(h)
	// Space O(1)
	
	// Method 1
	public TreeNode iterativeInsert(TreeNode root, int target) {
		TreeNode newNode = new TreeNode(target);
		if(root == null) {
			return newNode;
		} 
		TreeNode currNode = root;
		while(currNode.val != target) {
			if(target < currNode.val) {
				if(currNode.left != null) {
					currNode = currNode.left;
				} else {
					currNode.left = newNode;
					break;
				}
			} else {
				if(currNode.right != null) {
					currNode = currNode.right;
				} else {
					currNode.right = newNode;
					break;
				}
			}
		}
		return root;
	}
	
	
	// Time O(h)
	// Space O(1)
	
	// Method 2
	public TreeNode iterativeInsert2(TreeNode root, int target) {
		TreeNode newNode = new TreeNode(target);
		if(root == null) {
			return newNode;
		}
		
		TreeNode prev = null;
		TreeNode currNode = root; // maintain access to original head
		
		while(currNode.val != target) {
			prev = root;
			if(target < root.val) {
				root = root.left;
			} else if (target > root.val){
				root = root.right;
			} else {
				return currNode;
			}
		}
		if(target < prev.val) {
			prev.left = newNode;
		} else if (target > prev.val) {
			prev.right = newNode;
		}
		return currNode;
	}
	
	
	// Time O(h)
	// Space O(h)
	
	// Method 1
	public TreeNode recursiveInsert(TreeNode root, int target) {
		if(root == null) {
			return new TreeNode(target);
		} else if (root.val == target) {
			return root;
		}
		if(target < root.val) {
			root.left = recursiveInsert(root.left, target);
		} else {
			root.right = recursiveInsert(root.right, target);
		}
		
		return root;
	}
	
	
	// Time O(h)
	// Space O(h)
	
	// Method 2
	public TreeNode recursiveInsert2(TreeNode root, int target) {
		if(root == null) {
			return new TreeNode(target);
		}
		helper(root, target);
		return root;
	}
	
	// Time O(h)
	// Space O(h) but redundant operations are removed
	private void helper(TreeNode root, int target) {
		if(root.val == target) {
			return;
		} else if (target < root.val) {
			if(root.left == null) {
				root.left = new TreeNode(target);
			} else {
				helper(root.left, target);
			}
		} else {
			if(root.right == null) {
				root.right = new TreeNode(target);
			} else {
				helper(root.right, target);
			}
		}
	}
	
	
}
