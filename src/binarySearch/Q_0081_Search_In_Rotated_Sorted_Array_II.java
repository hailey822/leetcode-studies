package binarySearch;

/**
 * 
 * @author hyeleekim
 * 
 * og : [0,1,2,4,5,6,7]
 * 
 * target: 3
 * index 0,1,2,3,4,5,6
 * re : [4,5,6,7,0,1,2]
 * lo : 0 4 6 7
 * hi : 6 6 6
 * mi : 3 5 6
 */
public class Q_0081_Search_In_Rotated_Sorted_Array_II {
	public boolean search(int[] nums, int target) {
		// Handle edge case 
		if(nums == null || nums.length == 0) return false;
		
		int lo = 0, hi = nums.length -1, mid= 01;
		while(lo <= hi) {
			mid = lo + (hi-lo)/2;
			// Found the target
			if(nums[mid] == target) return true;
			// left part is sorted
			if(nums[lo] < nums[mid]) {
				if(nums[lo] <= target && target<= nums[mid]) {
					// target in sorted part
					hi = mid-1;
				} else {
					// target in rotated part
					lo = mid+1;
				}
			} else if( nums[mid] < nums[lo]){ // right part is rotated
				if(nums[mid] < target  && target<= nums[hi]) {
					// target in sorted part
					lo = mid+1;
				} else {
					// target in rotated part
					hi = mid-1;
				}
			} else {
				lo++;
			}
		}
        return false;
    }
}
