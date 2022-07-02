package tree;

import java.util.Stack;

/**
 * 
 * @author hyeleekim
 * 
 * A valid BST is defined as follows:
 * 	- The left subtree of a node contains only nodes with keys less than the node's key.
 *  - The right subtree of a node contains only nodes with keys greater than the node's key.
 *  - Both the left and right subtrees must also be binary search trees.
 *  
 *  InOrder : left - self - right
 */

public class Q_0098_Validate_Binary_Search_Tree {
	
	public boolean isValidBST(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		TreeNode prev = null;
		TreeNode curr = root;
		while(curr != null || !s.isEmpty()) {
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop(); 
			if(prev != null && curr != null) {
				if(curr.val <= prev.val) return false;
			}
			prev = curr;
			curr = curr.right;
		}
        return true;
    }
}
