package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hyeleekim
 *
 * post order : leftmost child .... rightmost child, self
 
 */

public class Q_0590_Nary_Tree_Postorder_Traversal {
	List<Integer> res;
	public List<Integer> postorder(Node root) {
		res = new ArrayList<>();
		traverse(root);
        return res;
    }
	
	private void traverse(Node self) {
		// No need to traverse
		if(self == null) return; 
		if(self.children != null) {
			for(Node child : self.children) {
				traverse(child);
			}
		}
		res.add(self.val);
	}
}
