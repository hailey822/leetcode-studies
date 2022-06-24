package graph;

/**
 * 
 * @author hyeleekim
 * 
 * 1. Init boolean[] visited, counter = 0
 * 2. Dfs each city and mark visited 
 * 3. If not visited, it's new province => counter ++
 * 
 * Solve : 
 * for(cities 0 ... N) {
 * 	if !visited 
 * 		dfs(args...)
 * 		counter++
 * }
 * 
 * dfs(args) {
 * 		iterate through isConnected
 * 		if(!visited) visited = true;
 * }
 *
 */

public class Q_0547_Number_Of_Provinces {

    public int findCircleNum(int[][] isConnected) {
        int N = isConnected.length;
        boolean[] visited = new boolean[N];
        int counter = 0;
        for(int i=0; i<N; i++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(i, isConnected, visited);
                counter++;
            }
        }
        return counter;
    }
    
    private void dfs(int curr, int[][] isConnected, boolean[] visited) {
        for(int i=0; i<isConnected.length; i++) {
            if(isConnected[curr][i] == 1) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(i, isConnected, visited);
                }
            }
        }
    }
}
