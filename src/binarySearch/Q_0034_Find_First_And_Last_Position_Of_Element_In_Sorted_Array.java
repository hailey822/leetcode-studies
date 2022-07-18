package binarySearch;

public class Q_0034_Find_First_And_Last_Position_Of_Element_In_Sorted_Array {
	public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] res = new int[2];
        res[0] = -1; res[1] = -1;
    
        // Handle edge case;
        if(n == 0) return res;
        int lo = 0, hi = n-1;
        while(lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if(target == nums[mid]) {
                res[0] = findFirst(nums, mid, target);
                res[1] = findLast(nums, mid, target);
                return res;
            } else if(nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }
    
    private int findFirst(int[] nums, int mid, int target) {
        while(mid >=0 && nums[mid] == target) {
            mid--;
        }
        return mid+1;
    }
    
    private int findLast(int[] nums, int mid, int target) {
        while(mid <=nums.length-1 && nums[mid] == target) {
            mid++;
        }
        return mid-1;
    }
}
