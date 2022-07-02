package tree;

import java.util.Stack;

/**
 * 
 * @author hyeleekim
 * 
 * Iterative 
 * 1. Init Stack, sum = 0
 * 2. Do BFS with condition 
 *
 */
public class Q_0935_Range_Sum_of_BST {
	public int rangeSumBST(TreeNode root, int low, int high) {
		int sum = 0;
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while(!s.isEmpty()) {
			TreeNode node = s.pop();
			if(node != null) {
				if(node.val >= low && node.val <= high) {
					sum += node.val;
				}
				if(low < node.val) s.push(node.left);
				if(node.val < high) s.push(node.right);
			}
		}
		return sum;
	}
}
