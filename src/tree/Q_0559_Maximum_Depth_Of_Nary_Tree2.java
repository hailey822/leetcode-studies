package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * @author hyeleekim
 * 
 * 1. Handle Edge cases
 * 2. Init queue and add root 
 * 3. Loop through nodes in queue
 * 4. 	Add child node of each node 
 * 5. Incremenent Depth
 * 6. Repeat 3,4,5
 * Return depth
 * 
 * Solve : 
 * while(!q.isEmpty){
 * 		node = q.poll
 * 		for(Node child : node.children) {
 * 			q.add(child)
 * 		}
 * 		depth ++
 * }
 * rt depth
 */

public class Q_0559_Maximum_Depth_Of_Nary_Tree2 {
	
	public int maxDepth(Node root) {
		// Breadth First Search
        if(root == null) return 0;
        if(root.children == null) return 1;
        int depth = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
        	int size = q.size();
        	for(int i=0; i<size; i++) {
	        	Node n = q.poll();
	        	if(n.children == null) continue;
	        	for(Node child : n.children) {
	        		q.offer(child);
	        	}
        	}
        	depth++;
        }
        return depth;
    }
}
