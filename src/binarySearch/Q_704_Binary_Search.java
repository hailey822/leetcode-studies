package binarySearch;

/**
 * 
 * @author hyeleekim
 * 
 * 1. If nums.length == 0, return -1
 * 2. Init start = 0, end = length-1
 * 3. while start< end
 * 4. mid = start + (end-start)/2
 * 5. if nums[mid] == target, return mid;
 * 6. if nums[mid] < target, start = mid + 1
 * 7. else, end = mid-1;
 * 8. return -1
 *
 */
public class Q_704_Binary_Search {
	public int search(int[] nums, int target) {
		// Handle edge case
		if(nums.length == 0) return -1;
		// Init
		int start = 0;
		int end = nums.length-1;
		while(start <= end) {
			int mid = start + (end-start)/2;
			if(nums[mid] == target) return mid;
			else if(nums[mid] > target) end = mid-1;
			else start = mid+1;
		}
		return -1;
	}
}
