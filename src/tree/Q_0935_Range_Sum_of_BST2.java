package tree;

import java.util.Stack;

/**
 * 
 * @author hyeleekim
 * 
 * Recursive
 * 1. Init global int sum = 0
 * 3. Check if root falls under range
 * 4. root val is smaller than low, only search right tree
 * 5. root val is larger than high, only search left tree
 * 6. return sum
 */
public class Q_0935_Range_Sum_of_BST2 {
	public int rangeSumBST(TreeNode root, int low, int high) {
		if(root == null) return 0;
		if(root.val < low) return rangeSumBST(root.right, low, high);
		if(root.val > high) return rangeSumBST(root.left, low, high);
		return rangeSumBST(root.right, low, high)+ root.val + rangeSumBST(root.left, low, high);
	}
}
