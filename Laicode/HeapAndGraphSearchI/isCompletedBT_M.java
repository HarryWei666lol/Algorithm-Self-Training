package HeapAndGraphSearchI;
import java.util.*;

public class isCompletedBT_M {
	
	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	
	public boolean isCompleted(TreeNode root) {
		// Write your solution here
		if(root == null){
			return true;
		}
		Queue<TreeNode> queue = new ArrayDeque<TreeNode>();
		// if the flag is set true, there should not be any child nodes afterwards
		boolean flag = false;
		queue.offer(root);
		while(!queue.isEmpty()){
			TreeNode cur = queue.poll();
			// if any of the child is not present, set the flag to true
			if(cur.left == null){
				flag = true;
			} else if(flag){ // flag and flag==true are same & cur.left != null 
				// if flag is set but we still see cur has a left child,
				// the binary tree is not a completed one
				return false;
			} else{ // when flag == false
				//if flag is not set and left child is present
				queue.offer(cur.left);
			}
			// same logic applied to the right child
			if(cur.right == null){
				flag = true;
			} else if(flag){
				return false;
			} else{
				queue.offer(cur.right);
			}
		}
		return true;
	}
}
