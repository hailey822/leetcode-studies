package tree;

public class Q_0108_Convert_Sorted_Array_To_Binary_Search_Tree {
	public TreeNode sortedArrayToBST(int[] nums) {
		if(nums.length == 0) {
			return null;
		}
		TreeNode head = helper(nums, 0, nums.length -1);
		return head;
    }
	
	private TreeNode helper(int[] nums, int low, int high) {
		if(low > high) return null;
		int mid = (low + high) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left  = helper(nums, low, mid-1);
		node.right = helper(nums, mid+1, high);
		return node;
	}
}
