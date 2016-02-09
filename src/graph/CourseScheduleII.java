package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Le on 2016/2/2.
 * {https://leetcode.com/problems/course-schedule-ii/}
 */

public class CourseScheduleII {
    private static int VISITED = 2;
    private static int VISITTING = 1;
    private static int NOT_VISITED = 0;
    private int[] result;
    private int cur;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = i;
        }
        cur = numCourses - 1;
        HashMap<Integer, HashSet<Integer>> graph = new HashMap<>();
        if (prerequisites == null || prerequisites.length == 0) {
            return result;
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
                    return new int[0];
                } else {
                    continue;
                }
            }
        }

        return result;
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
        result[cur] = v;
        cur--;
        return false;
    }


    /**
     * BFS
     */
    public int[] findOrderBFS(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        int[] preCourses = new int[numCourses];
        // store the in-degree #
        for (int[] prerequisite : prerequisites) {
            preCourses[prerequisite[0]]++;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < preCourses.length; i++) {
            if (preCourses[i] == 0) {
                queue.add(i);
            }
        }
        int numOfPreCourse = 0;
        int i = 0;
        while (!queue.isEmpty()) {
            int top = queue.poll();
            res[i++] = top;
            numOfPreCourse++;
            for (int[] prerequisite : prerequisites) {
                if (prerequisite[1] == top) {
                    preCourses[prerequisite[0]]--;
                    if (preCourses[prerequisite[0]] == 0) {
                        queue.add(prerequisite[0]);
                    }
                }
            }
        }
        if (numOfPreCourse == numCourses) {
            return res;
        } else {
            return new int[0];
        }
    }
}