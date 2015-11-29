package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Le on 2015/11/29.
 */
public class BreadthFirstSearch {
    public void bfs(Vertex root) {

        Queue<Vertex> queue = new LinkedList<>();

        root.setVisited(true);
        queue.add(root);

        while (!queue.isEmpty()) {
            Vertex currentVertex = queue.remove();
            System.out.print(currentVertex + " - ");
            for (Vertex v : currentVertex.getNeighbourList()) {
                if (!v.isVisited()) {
                    v.setVisited(true);
                    queue.add(v);
                }
            }
        }
    }
}
