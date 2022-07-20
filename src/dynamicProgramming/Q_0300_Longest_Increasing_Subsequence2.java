package dynamicProgramming;

import java.util.Arrays;

/**
 * 
 * @author hyeleekim
 * 
 * Dynamic Programming 
 * 
 * T(NlogN)
 * 
 * Collestions.binarySearch
 * 	- exists => idx
 * 	- not => insertionPoint
 * 		abs(idx+1) => iP
 * 
 * Strictyl Increasing array 
 * 1) Add at new position
 * 2) Override
 * 
 * return array size
 *
 */

public class Q_0300_Longest_Increasing_Subsequence2 {
	public int lengthOfLIS(int[] nums) {
		// Handle edge case 
		if(nums.length == 0 || nums.length == 1) return nums.length;
		
		int[] dp = new int[nums.length];
		int len = 0;
		for(int x : nums) {
			int index = Arrays.binarySearch(dp, 0, len, x);
			if(index < 0) index = -(index + 1);
			dp[index] = x;
			if(index == len) len++;
		}
		return len;
    }
}
