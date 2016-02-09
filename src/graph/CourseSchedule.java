package graph;

import java.util.*;

/**
 * Created by Le on 2016/2/2.
 */
public class CourseSchedule {
    /**
     * {https://leetcode.com/problems/course-schedule/}
     */

    private static int VISITED = 2;
    private static int VISITTING = 1;
    private static int NOT_VISITED = 0;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int from = prerequisites[i][1];
            int to = prerequisites[i][0];
            if (!graph.containsKey(from)) {
                HashSet<Integer> set = new HashSet<>();
                graph.put(from, set);
            }
            HashSet<Integer> set = graph.get(from);
            set.add(to);
            graph.put(from, set);
        }

        int[] visited = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (visited[i] == 0) {
                if (hasCycle(i, visited, graph)) {
                    return false;
                } else {
                    continue;
                }
            }
        }
        return true;
    }

    private boolean hasCycle(int v, int[] visited, HashMap<Integer, HashSet<Integer>> graph) {
        if (graph.containsKey(v)) {
            visited[v] = VISITTING;
            HashSet<Integer> adjacencyList = graph.get(v);
            for (int to : adjacencyList) {
                if (visited[to] == VISITTING) {
                    return true;
                }
                if (visited[to] == NOT_VISITED && hasCycle(to, visited, graph)) {
                    return true;
                }
            }
        }
        visited[v] = VISITED; //visiting finished
        return false;
    }


    public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
        List<List<Integer>> posts = new ArrayList<List<Integer>>();
        for (int i = 0; i < numCourses; i++) {
            posts.add(new ArrayList<Integer>());
        }

        int[] preNums = new int[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            posts.get(prerequisites[i][1]).add(prerequisites[i][0]);
            preNums[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (preNums[i] == 0){
                queue.offer(i);
            }
        }

        int count = numCourses;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i : posts.get(cur)) {
                if (--preNums[i] == 0) {
                    queue.offer(i);
                }
            }
            count--;
        }

        return count == 0;
    }
}
