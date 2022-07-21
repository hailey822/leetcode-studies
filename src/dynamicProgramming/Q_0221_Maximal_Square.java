package dynamicProgramming;

/**
 * @author hyeleekim
 * 
 * arr[i][j] = length of the max square with right-bottom corner (i, j)
 * 
 * 1. Handle edge case
 * 2. Init 2d array[m+1][n+1] to store max length til (i, j)
 * 3. Loop through i=1 ... m
 * 					j=1 ... n
 * 4. if mat[i][j] == 0 
 * 		arr[i+1][j+1] = 0
 * 5. else
 * 		Math.min(arr[i-1][j], arr[i-1][j-1], arr[i][j-1]) + 1
 * 6. rt arr[m-1][n-1]*arr[m-1][n-1] 	
 *
 */
public class Q_0221_Maximal_Square {
	public int maximalSquare(char[][] matrix) {
        if(matrix.length == 0) return 0;
		int m = matrix.length;
		int n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max = 0;
        for(int i=1; i<=m; i++) {
        	for(int j=1; j<=n; j++) {
        		if(matrix[i-1][j-1] == '1') {
        			dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
        			max = Math.max(dp[i][j], max);
        		}
        	}
        }
        return max * max;
    }
}
