package DSA.graph.cycleDetection.topo;

import java.util.*;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int[] adj : prerequisites) {
            adjList.get(adj[0]).add(adj[1]);
        }

        int[] indegree = new int[numCourses];
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
            for (int adj : adjList.get(curr)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    q.offer(adj);
                }
            }
            count++;
        }
        
        return count == numCourses;
    }
    public static void main(String[] args){
        int numCourses = 2;
        int[][] prerequisites = {{1,0},{0,1}};
        System.out.println(canFinish(numCourses,prerequisites));

        int numCourses1 = 2;
        int[][] prerequisites1 = {{1,0}};
        System.out.println(canFinish(numCourses1,prerequisites1));

    }

}
