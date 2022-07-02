package tree;

import java.util.Stack;

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
 * 1. Init stack with root, int minDiff, TreeNode prev, TreeNode curr
 * 2. Push nodes to stack
 * 3. Move on to left node
 * 4. Repeat 2, 3 until node is null
 * 5. Pop node from stack and compute difference between prev and curr
 * 6. Set curr to right node
 * 7. Repeat 2 ~ 6
 * 8. RT minDiff
 * 
 * Solve : 
 * int minDiff = Integer.MAX
 * prev = null
 * curr = root;
 * 
 * while(!stack.isEmpty() || curr != null){
 * while(curr != null) {
 * 	stack.add(curr);
 * 	curr = curr.left;
 * }
 * curr = stack.pop();
 * if(curr != null && prev != null) {
 * 	minDiff = Math.min(minDiff, curr.val - prev.val);
 * }
 * prev = curr;
 * curr = curr.right;
 * }
 * 
 * rt minDiff
 * 
 */
public class Q_0530_Minimum_Absolute_Difference_In_BST2 {
	
	public int getMinimumDifference(TreeNode root) {
		Stack<TreeNode> s = new Stack<>();
		int minDiff = Integer.MAX_VALUE;
		TreeNode prev = null;
		TreeNode curr = root;
		while(curr != null || !s.isEmpty()) {
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			if(prev != null && curr != null) {
				minDiff = Math.min(minDiff, curr.val - prev.val);
			}
			prev = curr;
			curr = curr.right;
		}
		return minDiff;
    }
}
