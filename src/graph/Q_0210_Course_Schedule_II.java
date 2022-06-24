package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * @author hyeleekim
 *
 * 0. Build indegree array & adjacentList
 * 1. Find node where indegree == 0
 * 2. Update Indegree & Remove related edge
 * Repeat 1,2 until all the courses are visited
 * Check if all the nodes are visited after loop
 * 
 */

public class Q_0210_Course_Schedule_II {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        int indegree[] = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<numCourses; i++) {
            adjList.add(new ArrayList<Integer>());
        }
        
        // edge[1] => edge[0]
        for(int[] edge : prerequisites) {
            indegree[edge[0]] ++;
            adjList.get(edge[1]).add(edge[0]);
        }
        

        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<numCourses; i++) {
            if(indegree[i] == 0) q.offer(i);
        }
        
        int[] res = new int[numCourses];
        int index = 0;
        while(!q.isEmpty()) {
            int node = q.poll();
            for(int dest : adjList.get(node)) {
                if(--indegree[dest] == 0) q.offer(dest);
            }
            adjList.get(node).clear();
            res[index++] = node;
        }
        return index == numCourses ? res : new int[0];
    }
}
