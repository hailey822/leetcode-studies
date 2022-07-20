package dynamicProgramming;
/**
 * 
 * @author hyeleekim
 * 
 * sub problem => whole problem
 * 
 * Input : t1(N), t2(M)
 * 1. Init 2d array length of N+1 * M+1
 * 2. Loop from row 1 and col1 
 * 3. If charater match, a[i][j] = a[i-1][j-1]
 * 4. If no match, a[i][j] = Math.max(a[i-1][j], a[i][j-1])
 * 5. Return value of a[N][M]
 *
 * TC : O(N*M)
 */
public class Q_1143_Longest_Common_Subsequence {
	 public int longestCommonSubsequence(String text1, String text2) {
		 // Init 2d array length of N+1 * M+1
		 int[][] ans = new int[text1.length()+1][text2.length()+1];
		 
		 // Loop
		 for(int r=1; r<=text1.length(); r++) {
			 for(int c=1; c<=text2.length(); c++) {
				 if(text1.charAt(r-1) == text2.charAt(c-1)) {
					 ans[r][c] = ans[r-1][c-1] + 1;
				 } else {
					 ans[r][c] = Math.max(ans[r][c-1], ans[r-1][c]);
				 }
			 }
		 }
		 
		 // Return value of a[N][M]
		 return ans[text1.length()][text2.length()];
	 }
}
