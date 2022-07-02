package tree;
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

public class Q_0098_Validate_Binary_Search_Tree2 {
	
	public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
	
	private boolean validate(TreeNode node, Integer leftBound, Integer rightBound) {
		if(node == null) return true;
		if(leftBound != null && node.val <= leftBound) {
			return false;
		}
		if(rightBound != null && node.val >= leftBound) {
			return false;
		}
		return validate(node.left, leftBound, node.val) && validate(node.right, node.val, rightBound);
	}
}
