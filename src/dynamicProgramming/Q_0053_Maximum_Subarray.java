package dynamicProgramming;

/**
 * 
 * @author hyeleekim
 * 
 * d[i] : maximum sum till ith element
 * 
 * 1. Handle edge cases : len = 0
 * 2. Init int[] dp[nums.length]
 * 3. dp[0] = nums[0]
 * 4. Save the maximum sum til that index
 * 5. Return max value
 * 
 * e.g) 
 * [-2,1,-3,4,-1,2,1,-5,4]
 * [-2,1,-2,4, 3,5,6, 1,5]
 *
 */
public class Q_0053_Maximum_Subarray {
	 public int maxSubArray(int[] nums) {
		 // Handle edge case 
		 if(nums.length == 0) return 0;
		 if(nums.length == 1) return nums[0];
		 
		 // Init dp array
		 int[] dp = new int[nums.length];
		 dp[0] = nums[0];
		 int max = nums[0];
		 for(int i=1; i<nums.length; i++) {
			 dp[i] = Math.max(nums[i], dp[i-1] + nums[i]);
			 max = Math.max(max, dp[i]);
		 }
		 return max;
	 }
}
