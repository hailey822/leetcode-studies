package dynamicProgramming;
/**
 * 
 * @author hyeleekim
 * 
 * d[nums.length][2]
 * d[i][0] = max (+) product 'til ith number 
 * d[i][1] = min (-) product 'til ith number
 *  
 * e.g) 
 * [-2,3,-4]
 * [-2,-6, -12]
 * [-2, 3,  24]
 * 
 * [2,3,-2,4]
 * max [2,6,-2,  4]
 * min [2,3,-6,-24]
 */
public class Q_0152_Maximum_Product_Subarray {
	public int maxProduct(int[] nums) {
		// Handle edge case 
		if(nums.length == 0) return 0;
		
		int max = nums[0];
		int min = nums[0];
		int result = nums[0];
		for(int i=1; i<nums.length; i++) {
			int c = nums[i];
			int temp = max;
			max = Math.max(c, Math.max(max*c, min*c));
			min = Math.min(c, Math.min(temp*c, min*c));
			if(max>result) result = max;
		}
		return result;
    }
}
