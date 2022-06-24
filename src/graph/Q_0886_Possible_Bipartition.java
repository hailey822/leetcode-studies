package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hyeleekim
 *
 *
 * 1. Init bool[] visited, bool[] color, L<L<I>> adjList
 * 2. Loop through graph
 * 
 * Solve : 
 * 
 * for(Graph 0..n)
 * 		if(visited[i]) continue;
 * 		visited[i] = true;
 * 		if(!isBipartite(args ..)) rt false;
 * 
 * rt true
 * 
 * 
 * isBipartite(args ...)
 * 		iter thru adjList
 * 		i) not visited
 * 			!color
 * 			if(!isBipartite(...)) rt false
 * 		ii) color same
 * 			rt false
 * 	rt true;
 * 
 */
public class Q_0886_Possible_Bipartition {
	
	public boolean possibleBipartition(int n, int[][] dislikes) {
		boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] d : dislikes) {
            int a = d[0] -1;
            int b = d[1] -1;
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        
        for(int i=0; i<n; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            if(!isBipartite(i, visited, color, adjList)) return false;
        }
        return true;
    }
	
	 private boolean isBipartite(int curr, boolean[] visited, boolean[] color, List<List<Integer>> adjList) {
	        for(int next : adjList.get(curr)) {
	            if(!visited[next]) {
	                visited[next] = true;
	                color[next] = !color[curr];
	                if(!isBipartite(next, visited, color, adjList)) return false;
	            }
	            else if(color[next] == color[curr]) return false;
	        }
	        return true;
	    }

}
