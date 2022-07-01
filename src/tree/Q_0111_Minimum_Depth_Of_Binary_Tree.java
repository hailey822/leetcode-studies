package tree;

public class Q_0111_Minimum_Depth_Of_Binary_Tree {
	public int minDepth(TreeNode root) {
		// Depth First Search
		if(root == null) return 0;
		if(root.left == null && root.right == null) return 1;
        if(root.left == null) return minDepth(root.right) + 1;
        if(root.right == null) return minDepth(root.left) + 1;
		return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
