package BinaryTree;

public class IsLowestCommonAncestor_M {

	public class TreeNode{
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode parent;

		public TreeNode(int key, TreeNode parent) {
			this.key = key;
			this.parent = parent;
		}
	}

	// Method 1 -> use an array so that the function getDepth can change the value
	public TreeNode lowestCommonAncestor(TreeNode one, TreeNode two) {
		if(one == null || two == null) {
			return null;
		}

		if(one == two) {
			return one;
		}

		TreeNode[] node1 = {one}; // avoids the copy by value problem if we just use a TreeNode variable
		TreeNode[] node2 = {two};

		int depthOne = getDepth(node1);
		int depthTwo = getDepth(node2);

		if(node1[0] != node2[0]) {
			// not in the same tree;
			return null;
		}

		if(depthOne >= depthTwo) {
			return getLCA(one, two, depthOne - depthTwo);
		} else {
			return getLCA(one, two, depthTwo - depthOne);
		}
	}

	private int getDepth(TreeNode[] node) {
		int count = 1;
		while(node[0].parent != null) {
			node[0] = node[0].parent;
			count++;
		}
		return count;
	}

	private TreeNode getLCA(TreeNode lowerNode, TreeNode higherNode, int depthDiff) {
		while(depthDiff > 0) {
			lowerNode = lowerNode.parent;
			depthDiff--;
		}
		while(lowerNode != higherNode) {
			lowerNode = lowerNode.parent;
			higherNode = higherNode.parent;
		}
		return lowerNode;
	}

}
