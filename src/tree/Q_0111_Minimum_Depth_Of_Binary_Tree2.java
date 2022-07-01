package tree;

import java.util.LinkedList;
import java.util.Queue;

public class Q_0111_Minimum_Depth_Of_Binary_Tree2 {
	public int minDepth(TreeNode root) {
		// Breadth First Search 
		if(root == null) return 0;
		
		int depth = 1;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i=0; i<size; i++) {
				TreeNode node = q.poll();
				if(node.left == null && node.right == null) {
					return depth;
				}
				if(node.left != null) q.offer(node.left);
				if(node.right != null) q.offer(node.right);
			} 
			depth ++;
		}
		return depth;
    }
}
