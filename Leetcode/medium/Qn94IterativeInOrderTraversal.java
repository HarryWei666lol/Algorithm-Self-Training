package medium;
import java.util.*;

public class Qn94IterativeInOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	// Time 100%
	// Space 100%
	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inOrderList = new ArrayList<>();
		if(root == null){
			return inOrderList;
		}

		Deque<TreeNode> stack = new ArrayDeque<>();
		TreeNode curr = root;

		while(curr != null || !stack.isEmpty()){
			if(curr != null){
				stack.offerFirst(curr);
				curr = curr.left;
			}
			else {
				curr = stack.pollFirst();
				inOrderList.add(curr.val);
				curr = curr.right;
			}
		}
		return inOrderList;
	}

}
