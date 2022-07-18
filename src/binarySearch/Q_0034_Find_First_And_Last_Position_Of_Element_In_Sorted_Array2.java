package binarySearch;

public class Q_0034_Find_First_And_Last_Position_Of_Element_In_Sorted_Array2 {
	
	public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        ans[0] = search(nums, target, true);
        ans[1] = search(nums, target, false);
        return ans;
    }
	
	private int search(int[] nums, int target, boolean first) {
		int lo = 0, hi = nums.length -1, ans = -1;
		while(lo <= hi) {
			int mid = lo + (hi-lo)/2;
			if(nums[mid] > target) hi = mid-1;
			else if(nums[mid] < target) lo = mid+1;
			else {
				ans = mid;
				if(first) hi = mid-1;
				else lo = mid+1;
			}
		}
		return ans;
	}
}
