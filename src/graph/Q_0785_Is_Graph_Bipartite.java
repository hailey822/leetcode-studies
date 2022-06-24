package graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author hyeleekim
 * 
 * 1. Init bool[] visited, bool[] color, List<List<Integer>> adjList
 * 2. Iter through graph
 * 
 * Solve :
 * for graph(0 .. n) 
 * 		if(visited[i]) cont;
 * 		visited[i] = true;
 * 		if(! isBipartite(args ...)) rt false
 * rt true
 * 
 * isBipartite(args ...) 
 * 		itr thru adjList 
 * 		if !visited
 * 			!color
 * 			if(!isBipartite(next ... ) rt false
 * 		if color same
 * 			rt falsee
 * 		return true
 *
 */
public class Q_0785_Is_Graph_Bipartite {
	public boolean isBipartite(int[][] graph) {
		int N = graph.length;
		boolean[] visited = new boolean[N];
		boolean[] color = new boolean[N];
		List<List<Integer>> adjList = new ArrayList<>();
		for(int i=0; i<N; i++) {
			List<Integer> nodes = new ArrayList<Integer>();
			for(int v : graph[i]) {
				nodes.add(v);
			}
			adjList.add(nodes);
		}
		
		for(int i=0; i<N; i++) {
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
			} else if(color[curr] == color[next]) return false;
		}
		return true;
	}
}
