package BFS;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Le on 2015/11/29.
 */
public class Vertex {
    private int data;
    private boolean isVisited;
    private List<Vertex> neighbourList;

    public Vertex(int data) {
        this.data = data;
        this.neighbourList = new ArrayList<>();
    }

    public void addNeighbour(Vertex vertex) {
        this.neighbourList.add(vertex);
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public List<Vertex> getNeighbourList() {
        return neighbourList;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return getData() + "";
    }
}
