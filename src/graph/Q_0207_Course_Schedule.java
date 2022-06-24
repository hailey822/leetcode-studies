package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * 
 * @author hyeleekim
 *
 * 1. Search indegree == 0 
 * 2. Remove related edge, and update indegree
 * Repeat 1 & 2
 * After the loop, check if all the nodes are explored
 * 
 *   1 -> 2 
 *  5  \
 *    3 -> 4 -> 0  
 *    
 * [1,5] [3,5] [2,1] [4,3] [4,1] [0,4]
 */

public class Q_0207_Course_Schedule {
	
	public boolean canFinish(int numCourses, int[][] p) {
        // Set variable & initialize
        int[] indegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        // edge[1] => edge[0]
        for(int[] edge : p) {
            indegree[edge[0]] ++;
            adjList.get(edge[1]).add(edge[0]);
        }
        
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) if(indegree[i] == 0) q.offer(i);
        while(!q.isEmpty()) {
            int node = q.poll();
            visited.add(node);
            for(int dest : adjList.get(node)) {
                if(--indegree[dest] == 0) q.offer(dest);
            }
            adjList.get(node).clear();
        }
        return visited.size() == numCourses;
    }

}
