package hard;
import java.util.*;

public class Qn145IterativePostOrderTraversal {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	
	// Time 100%
	// Space 100%
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postOrderList = new ArrayList<>();
		if(root == null){
			return postOrderList;
		}
		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode prev = null;
		stack.offerFirst(root);

		while(!stack.isEmpty()){
			TreeNode curr = stack.peekFirst();
			if(prev == null || curr == prev.left || curr == prev.right){
				if(curr.left != null){
					stack.offerFirst(curr.left);
				} else if (curr.right != null){
					stack.offerFirst(curr.right);
				} else {
					stack.pollFirst();
					postOrderList.add(curr.val);
				}
			} else if(prev == curr.right || prev == curr.left && curr.right == null){
				stack.pollFirst();
				postOrderList.add(curr.val);
			} else {
				stack.offerFirst(curr.right);
			}

			prev = curr;
		}

		return postOrderList;
	}

}
