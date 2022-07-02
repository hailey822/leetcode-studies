package tree;

/**
 * 
 * @author hyeleekim
 * 
 * 1
 *   \ 
 *   3
 *  /
 * 2
 * 
 * min 2 nodes 
 * 
 * Tree Traversal : 
 * preOrder : self - left - right
 * postOrder : left - right - self
 * inOrder : left - self - right
 * 
 * Recursive : BST In-order traversal => ascending sorting
 * 
 */
public class Q_0530_Minimum_Absolute_Difference_In_BST {
	boolean init;
	int minDiff;
	int prev;
	
	public int getMinimumDifference(TreeNode root) {
		init = false;
		minDiff = Integer.MAX_VALUE;
		inorder(root);
        return minDiff;
    }
	
	private void inorder(TreeNode node) {
		// Handle exception 
		// Inorder
		if(node == null) return;
		inorder(node.left);
		// Handle self
		if(!init) {
			init = true;
		} else {
			minDiff = Math.min(node.val - prev, minDiff);
		}
		prev = node.val;
		inorder(node.right);
	}
}
