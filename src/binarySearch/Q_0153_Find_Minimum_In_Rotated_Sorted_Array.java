package binarySearch;

/** 
 * 
 * @author hyeleekim
 * 
 * nums = [0,1,2,4,5,6,7] (n = 7)
 * rotated : 1 ~ n times
 * 7 times : [0,1,2,4,5,6,7]
 * 4 times : [4,5,6,7,0,1,2]
 * index   :  0 1 2 3 4 5 6
 * 
 * [3,4,5,1,2]
 *  0 1 2 3 4 
 * lo : 0 3 3
 * mi : 2 3 3
 * hi : 4 4 3 
 * 
 * 1. Init lo, hi 
 * 2. Loop while lo <= hi
 * 3. mid = lo + (hi-lo)/2
 * 4. if(lo<mid && mid <hi) -> lo is min
 * 5. 
 *
 */
public class Q_0153_Find_Minimum_In_Rotated_Sorted_Array {
	public int findMin(int[] A) {	
		// Handle edge cases 
		if (A == null || A.length == 0) return 0;
        if (A.length == 1) return A[0];
            
        // Normal cases 
		int lo = 0, hi = A.length -1, mid = -1;
		while(lo < hi) {
			mid = lo + (hi-lo) /2 ;
			// pivot is on the right
			if(A[mid] > A[hi]) {
				lo = mid + 1;
			} else {
				hi = mid;
			}
		}
        return A[lo];
    }
}
