package easy;

public class Qn235LCA_Of_BST {


	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}


	// Time 95.31%, Space 5.10%
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if(p.val < root.val &&  q.val < root.val){
			return lowestCommonAncestor(root.left, p, q);
		} else if(p.val > root.val && q.val > root.val){
			return lowestCommonAncestor(root.right, p, q);
		} else{
			return root;
		}
	}


}
