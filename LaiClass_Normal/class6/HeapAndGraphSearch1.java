package class6;
import java.util.*;

public class HeapAndGraphSearch1 {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int v) {
			this.val = v;
		}
	}
	
	// Time O(n)
	// Space O(n)
	
	public void BFS(TreeNode root) {
		if(root == null) {
			return;
		}
		Deque<TreeNode> queue = new ArrayDeque<>();
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				TreeNode curr = queue.remove();
				if(curr.left != null) {
					queue.offer(curr.left);
				}
				if(curr.right != null) {
					queue.offer(curr.right);
				}
				System.out.print(curr.val + " ");
			}
			System.out.println(); // for a newline
		}
	}
}
