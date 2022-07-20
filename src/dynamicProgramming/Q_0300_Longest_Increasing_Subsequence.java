package dynamicProgramming;
/**
 * 
 * @author hyeleekim
 * 
 * Dynamic Programming 
 * 
 * T(N^2)
 * 
 * 0. Handle edge case, nums.length == 0 or 1 
 * 1. Init int[nums.length]
 * 2. set m[0] = 1 as one element is self increasing
 * 3. Loop through i*j and set longest subsequence til i
 * 	for loop i=1 ~ i=len-1
 * 		max = 0
 * 		for loop j=0 ~ j=i-1
 * 			if(nums[i] > nums[j] && m[j] > max)
 * 				max = m[j]
 * 		m[i] = max + 1
 * 4. Once the longest length is set, return max value in array
 *
 */

public class Q_0300_Longest_Increasing_Subsequence {
	public int lengthOfLIS(int[] nums) {
		// Handle edge case 
		if(nums.length == 0 || nums.length == 1) return nums.length;
		int ans = 1;
		
		int[] d = new int[nums.length];
		d[0] = 1;
		
		for(int i=1; i<nums.length; i++) {
			int max = 0;
			for(int j=0; j<i; j++) {
				if(nums[i] > nums[j] && d[j] > max) {
					max = d[j];
				}
			}
			d[i] = max + 1;
			System.out.println(d[i]);
			if(ans < d[i])  ans = d[i];
		}
		
        return ans;
    }
}
