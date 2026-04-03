package DSA.graph.cycleDetection.topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    class Solution {
        public int[] findOrder(int numCourses, int[][] prerequisites) {
            List<List<Integer>> adjList = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adjList.add(new ArrayList<>());
            }

            for (int[] adj : prerequisites) {
                adjList.get(adj[1]).add(adj[0]);
            }

            int[] indegree = new int[numCourses];
            int[] res = new int[numCourses];
            for (List<Integer> adjc : adjList) {
                for (int adj : adjc) {
                    indegree[adj]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < numCourses; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }
            int count = 0;
            while (!q.isEmpty()) {
                int curr = q.poll();
                res[count] = curr;
                for (int adj : adjList.get(curr)) {
                    indegree[adj]--;
                    if (indegree[adj] == 0) {
                        q.offer(adj);
                    }
                }
                count++;
            }

            return count == numCourses ? res : new int[]{};

        }
    }
}
//TC:O(V+E)
//SC:o(V)