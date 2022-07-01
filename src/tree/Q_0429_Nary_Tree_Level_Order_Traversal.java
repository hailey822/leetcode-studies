package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author hyeleekim
 *
 * 1. Init queue of Node and result List
 * 2. Add root to begin
 * 3. Initialize list for level 
 * 4. Loop through the size of queue 
 * (1) add value to level list 
 * (2) add children nodes to queue
 * 5. Add level list to result List
 * Repeat 3, 4, 5 until queue is empty 
 * 
 * Solve : 
 * while(!q.isEmpty){
 * 	List level;
 *  for(0 ... q.size){
 *  	Node = q.poll
 *   	level.add(node)
 *   	for(0 ... node.children.size) {
 *   		q.add(node.child)
 *   	}
 *    res.add(level)
 * }
 * return res
 */

public class Q_0429_Nary_Tree_Level_Order_Traversal {
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null) return res;
        
		Queue<Node> q = new LinkedList<>();
		q.offer(root);
		while(!q.isEmpty()) {
			List<Integer> level = new ArrayList<>();
			int size = q.size();
			for(int i=0; i<size; i++) {
				Node n = q.poll();
				if(n != null) level.add(n.val);
				if(n.children == null) continue;
				for(Node child : n.children) {
					if(child != null) q.add(child);
				}
			}
			res.add(level);
		}
		return res;
    }
}
