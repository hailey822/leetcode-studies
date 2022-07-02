package tree;

import java.util.Stack;

/**
 * 
 * @author hyeleekim
 * 
 * In-order traversal : left - self - right
 * 
 * 1. Traverse through BST 
 * 2. Check if BST conditions are met 
 * 3. Find unmet node First and Second 
 * 4. Swap val between two
 *
 */
public class Q_0099_Recover_Binary_Search_Tree {
	
	
	public void recoverTree(TreeNode root) {
		// Handle exception
		if(root == null) return;
		TreeNode first = null;
		TreeNode second= null;
		TreeNode curr = root;
		TreeNode prev = null;
		
		Stack<TreeNode> s = new Stack<>();
        while(curr != null || !s.isEmpty()) {
        	while(curr!=null) {
        		s.add(curr);
        		curr = curr.left;
        	}
        	curr = s.pop();
        	if(prev != null && curr.val <= prev.val) {
        	    if(first == null) first = prev;
        		second =  curr;
        	}
        	prev = curr;
        	curr = curr.right;
        }
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
	
}
