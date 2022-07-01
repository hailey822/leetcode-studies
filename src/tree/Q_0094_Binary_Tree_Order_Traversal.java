package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hyeleekim
 *
 * inorder : left - self - right
 * preorder : self - left - right
 * postorder : left - right - self
 */

public class Q_0094_Binary_Tree_Order_Traversal {
	List<Integer>  res;
	public List<Integer> inorderTraversal(TreeNode root) {
		res = new ArrayList<Integer>();
		traverse(root);
        return res;
    }
	
	private void traverse(TreeNode self) {
		if(self == null) return ;
		traverse(self.left);
		res.add(self.val);
		traverse(self.right);
	}
}
