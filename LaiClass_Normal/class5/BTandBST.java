package class5;

public class BTandBST {

	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v) {
			this.val = v;
		}
	}
	
	public void preOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		System.out.print(root.val);
		preOrder(root.left);
		preOrder(root.right);
	}
	
	public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.val);
		inOrder(root.right);
	}
	
	public void postOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val);
	}
	
	
	// Time O(n)
	// Space O(n)
	public int getHeight(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
	}
	
	
	// Time O(nlogn)
	// Space O(height)
	public boolean isBalanced(TreeNode root) {
		if(root == null) {
			return true;
		}
		int leftHeight = getHeight(root.left);
		int rightHeight = getHeight(root.right);
		if(Math.abs(rightHeight - leftHeight) > 1) {
			return false;
		} 
		return isBalanced(root.left) && isBalanced(root.right);
	}
	
	
	// Time O(n)
	// Space O(height)
	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		} else if(left == null || right == null) {
			return false;
		} else if(left.val != right.val) {
			return false;
		}
		return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
	}
	
	
	// Time O(n^2)
	// Space O(height)
	public boolean isTwistedIdentical(TreeNode left, TreeNode right) {
		if(left == null && right == null) {
			return true;
		} else if(left == null || right == null) {
			return false;
		} else if(left.val != right.val) {
			return false;
		}
		
		return isTwistedIdentical(left.left, right.left) && isTwistedIdentical(left.right, right.right) ||
				isTwistedIdentical(left.left, right.right) && isTwistedIdentical(left.right, right.left);
	}
	
	
	// Time O(n)
	// Space O(height)
	public boolean isBST(TreeNode root, int min, int max) {
		if(root == null) {
			return true;
		}
		if(root.val <= min || root.val >= max) {
			return false;
		}
		
		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
	}
	
	
	// Equivalent to inOrder traversal 
	// Time O(n) worst case or O(height + # of nodes in range [lower, upper]) -> better solution
	// O(height)
	public void printInRange(TreeNode root, int lowerBound, int upperBound) {
		if(root == null) {
			return;
		}
		
		if(root.val > lowerBound) {
			printInRange(root.left, lowerBound, upperBound);
		}
		
		if(root.val >= lowerBound || root.val <= upperBound) {
			System.out.print(root.val);
		}
		
		if(root.val < upperBound) {
			printInRange(root.right, lowerBound, upperBound);
		}
	}
	
	

}
