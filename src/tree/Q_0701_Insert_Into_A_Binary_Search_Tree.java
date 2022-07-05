package tree;

public class Q_0701_Insert_Into_A_Binary_Search_Tree {
	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null) {
			return new TreeNode(val);
		}
		
        if(val > root.val) {
        	root.right = insertIntoBST(root.right, val);
        } else { 
        	root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
