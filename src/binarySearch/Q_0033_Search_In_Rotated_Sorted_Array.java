package binarySearch;

/**
 * 
 * @author hyeleekim
 * 
 * 1. Find the pivot : O(logN)
 *		1) lo = 0, hi = n-1;
 *		2) while(lo<=hi) 
 *		3) 	increasing order
 * 2. Binary search the array with pivot considered : O(logN)
 *
 *
 * e.g) [2,4,5,6,7,0,1]
 *       0 1 2 3 4 5 6
 *                 ^
 * n = 7
 * lo : 0 4 4 5 
 * hi : 6 6 5 5
 * mi : 3 5 4 5
 */

public class Q_0033_Search_In_Rotated_Sorted_Array {
	public int search(int[] A, int target) {
		if(A.length == 0) return -1;
		int n = A.length;
		// 1. Find pivot
		int lo = 0, hi = n-1;
		while(lo < hi) {
			int mi = lo + (hi - lo)/2;
			if(A[mi] > A[hi]) lo = mi + 1;
			else hi = mi;
		}
		// 2. Binary search the target
		int pivot = lo;
		lo = 0;
		hi = n-1;
		while(lo <= hi) {
			int temp = lo + (hi-lo)/2;
			int mid = (temp+ pivot)%n;
			if(A[mid] == target) return mid;
			if(A[mid] < target ) lo = temp + 1;
			else hi = temp -1;
		}
		return -1;
		
	}
}
