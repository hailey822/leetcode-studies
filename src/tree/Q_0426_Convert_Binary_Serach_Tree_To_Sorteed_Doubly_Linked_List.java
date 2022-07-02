package tree;

import java.util.Stack;

/**
 * 
 * @author hyeleekim
 * 
 * predecessor of head = tail 
 * successor of tail = head
 * 
 * Divide and Conquer 
 * 1. Divide => tree into three part : left subtree, root node, right subtree
 * - left subtree : DLL
 * - root node : DLL
 * - right subtree : DLL
 * 2. Conquer => connect left subtree with root, connect it with right subtree
 *
 */
public class Q_0426_Convert_Binary_Serach_Tree_To_Sorteed_Doubly_Linked_List {
	public TreeNode treeToDoublyList(TreeNode root) {
		if(root == null) {
			return null;
		}
		TreeNode left = treeToDoublyList(root.left);
		TreeNode right = treeToDoublyList(root.right);
		root.left = root;
		root.right = root;
		return connect(connect(left, root), right);
    }
	
	private TreeNode connect(TreeNode left, TreeNode right) {
		if(left == null) return right;
		if(right == null) return left;
		TreeNode leftTail = left.left;
		TreeNode rightTail = right.left;
		
		leftTail.right = right;
		right.left = leftTail;
		left.left = rightTail;
		rightTail.right = left;
		return left;
	}
}
