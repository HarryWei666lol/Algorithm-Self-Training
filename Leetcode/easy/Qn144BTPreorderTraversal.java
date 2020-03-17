package easy;
import java.util.*;
public class Qn144BTPreorderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	// time 100%, space 100%
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();

		if(root == null){
			return res;
		}

		traverse(root, res);

		return res;
	}

	public void traverse(TreeNode root, List<Integer> res){
		if(root == null){
			return;
		}
		res.add(root.val);
		traverse(root.left, res);
		traverse(root.right, res);
	}

}
