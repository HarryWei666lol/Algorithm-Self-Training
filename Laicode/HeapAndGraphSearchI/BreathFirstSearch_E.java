package HeapAndGraphSearchI;
import java.util.*;

public class BreathFirstSearch_E {
	public class TreeNode {
		public int key;
		public TreeNode left;
		public TreeNode right;
		public TreeNode(int key) {
			this.key = key;
		}
	}
	
	public List<List<Integer>> layerByLayer(TreeNode root) { // BFS
	    List<List<Integer>> list = new ArrayList<List<Integer>>();
	    if(root == null){
	      return list;
	    }
	    Queue<TreeNode> queue = new LinkedList<TreeNode>();
	    queue.offer(root);
	    while(!queue.isEmpty()){
	      // the list storing all the nodes on the current level
	      List<Integer> curLayer = new ArrayList<Integer>();
	      // the size of current level
	      int size = queue.size();
	      // traverse all the nodes on the current level and prepare for the next level
	      for(int i = 0; i < size; i++){
	        TreeNode cur = queue.poll();
	        curLayer.add(cur.key);
	        if(cur.left != null){
	          queue.offer(cur.left);
	        }
	        if(cur.right != null){
	          queue.offer(cur.right);
	        }
	      }
	      list.add(curLayer);
	    }
	    return list;
	  }
}
