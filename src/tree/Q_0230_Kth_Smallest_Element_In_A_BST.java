package tree;

import java.util.Stack;

/**
 * 
 * @author hyeleekim
 * in-order traversal of BST : left - self - right ==> ascending sorted
 * 
 * 1. Init counter, Stack<Node>, Curr
 * 2. Do DFS while incrementing counter
 * 3. If counter is met, return node val
 * 
 * Solve
 * 
 * int counter = 0;
 * Stack s;
 * s.ps
 * 
 */

public class Q_0230_Kth_Smallest_Element_In_A_BST {
	public int kthSmallest(TreeNode curr, int k) {
		int counter = 0;
		Stack<TreeNode> s = new Stack<>();
		while(curr != null || !s.isEmpty()) {
			while(curr != null) {
				s.push(curr);
				curr = curr.left;
			}
			curr = s.pop();
			if(++counter == k) break;
			curr = curr.right;
		}
		
        return curr.val;
    }
}
