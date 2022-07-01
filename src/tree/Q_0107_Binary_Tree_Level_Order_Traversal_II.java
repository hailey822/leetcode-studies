package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 
 * @author hyeleekim
 * 
 * 1. Init q with root, and List 
 * 2. Poll all the nodes at queue and add to same level list
 * 3. Add all the child nodes of polled nodes 
 * Repeat 2, 3 until q is empty
 * 
 * Solve : 
 * while(!q.isEmpty()) {
 * 	List level;
 * 	for(0 ... q.size) {
 * 		node = q.poll;
 *		level.add(node)l
 *		q.add(node.left)
 *		q.add(node.right)
 * 	}
 * 	res.add(0, level)
 * }
 *  rt res
 */
public class Q_0107_Binary_Tree_Level_Order_Traversal_II {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        // Handle edge case : no node
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);
            }
            res.add(0, level);
        }
        return res;
    }
}
