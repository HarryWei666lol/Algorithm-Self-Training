package BinaryTree;
import java.util.*;

public class BinaryTreeTraversal_E {


	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}


	public List<Integer> preOrder(TreeNode root) {
		// Write your solution here
		List<Integer> res = new ArrayList<Integer>();

		if(root == null){
			return res;
		}

		traversePreOrder(root, res);

		return res;
	}

	public void traversePreOrder(TreeNode root, List<Integer> res){
		if(root == null){
			return;
		}
		res.add(root.key);
		traversePreOrder(root.left, res);
		traversePreOrder(root.right, res);
	}
	public List<Integer> inOrder(TreeNode root) {
		// Write your solution here
		List<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}

		traverseInOrder(root, res);

		return res;
	}

	public void traverseInOrder(TreeNode root, List<Integer> res){
		if(root == null){
			return;
		}
		traverseInOrder(root.left, res);
		res.add(root.key);
		traverseInOrder(root.right, res);
	}

	public List<Integer> postOrder(TreeNode root) {
		// Write your solution here
		List<Integer> res = new LinkedList<Integer>();
		if(root == null){
			return res;
		}
		traversePostOrder(root, res);
		return res;
	}

	public void traversePostOrder(TreeNode root, List<Integer> res){
		if(root == null){
			return;
		}
		traversePostOrder(root.left, res);
		traversePostOrder(root.right, res);
		res.add(root.key);
	}


}
