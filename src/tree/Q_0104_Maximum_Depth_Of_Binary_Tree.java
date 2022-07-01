package tree;

public class Q_0104_Maximum_Depth_Of_Binary_Tree {
	public int maxDepth(TreeNode root) {
		if(root == null) return 0;
		return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
