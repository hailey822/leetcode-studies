package binarySearch;

/**
 * 
 * @author hyeleekim
 * 
 * 1. Handle edge case
 * 	nums.length == 0
 * 	first & last element 
 * 2. Init values : start = 0, end = length -2
 * 3. While (start <= end)
 * 		mid = start + (end-start)/2
 * 4. Check 3 caes 
 * 	1) mid = peak : return mid
 *  2) mid < peak (up-slope): end = mid-1  
 *  3) mid > peak (down-slope): stat =  mid + 1
 * 5. Repeat 3 & 4
 * 5. No peak found : return -1;
 */
public class Q_0162_Find_Peak_Element {
	public int findPeakElement(int[] nums) {
        // Handle edge cases 
		int n = nums.length;
		if(n == 0) return -1;
        if(n == 1) return 0;
		if(nums[0] > nums[1]) return 0;
		if(nums[n-1] > nums[n-2]) return n-1;
		// Loop
		int start = 0;
		int end = n-2;
		while(start <= end) {
			int mid = start + (end-start)/2;
			// peak 
			if( (mid == 0 || nums[mid-1] < nums[mid]) && (mid == n-1 || nums[mid] > nums[mid+1])) {
				return mid;
			}
			else if(mid == 0 || nums[mid-1] > nums[mid]) end = mid-1;
			else if(mid == n || nums[mid] < nums[mid+1])  start = mid + 1;
		}
        return 1;
    }
}
