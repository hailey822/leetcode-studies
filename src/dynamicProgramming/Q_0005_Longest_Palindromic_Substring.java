package dynamicProgramming;

/**
 * 
 * @author hyeleekim
 * 
 * Palindrome : symmetrical word
 * Single char : palindromic on it's own
 * 
 * 1. Handle edge case : null || len < 2 -> return s
 * 2. Init 2d array of boolean
 * 		bool[][] dp = new int[len][len]
 * 		dp[start][end] marks if substring from start to end is palindromic
 * 3. for i==j, dp[i][j] == true
 * 4. Init start = 0, len = 1;
 * 5. Double for loop 
 * 		for(end = 1 ~ n)
 * 			for(start = end-1 ~ 0)
 * 				if s[start] == s[end]
 * 					if( (end-1 == start) || dp[start+1][end-1] == true)
 * 						dp[start][end] == true
 * 						if((end-start+1) > len)
 * 							update len and start
 * 5. Return s.substring(start, start+len)

 *
 */
public class Q_0005_Longest_Palindromic_Substring {
	public String longestPalindrome(String s) {
		int len = s.length();
		// Handle edge case 
		if(s == null || len < 2) return s;
		
		// Init vals
		int maxStart = 0, maxLen = 1;
		boolean[][] dp = new boolean[len][len];
		for(int i=0; i<len; i++) dp[i][i] = true;
		
		// Loop through string
		for(int end = 1; end<len; end++) {
			for(int start=end-1; start >= 0; start--) {
				if(s.charAt(start) == s.charAt(end)) {
					if((start+1 == end) || dp[start+1][end-1]) {
						dp[start][end] = true;
						if((end-start+1) > maxLen) {
							maxLen = (end-start+1);
							maxStart = start;
						}
					}
				}
			}
		}
		
		return s.substring(maxStart, maxStart + maxLen);
    }
}
