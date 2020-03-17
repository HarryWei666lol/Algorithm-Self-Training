package easy;
import java.util.*;

public class Qn144IterativePreOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	
	// time 100%, space 100%
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preOrderList = new ArrayList<>();
		if(root == null){
			return preOrderList;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		stack.offerFirst(root);

		while(!stack.isEmpty()){
			TreeNode curr = stack.pollFirst();
			preOrderList.add(curr.val);

			if(curr.right != null){
				stack.offerFirst(curr.right);
			} 
			if( curr.left != null) {
				stack.offerFirst(curr.left);
			}
		}

		return preOrderList;
	}

}
