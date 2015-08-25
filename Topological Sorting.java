import java.util.*;
/**
*	Given an directed graph, a topological order of the graph nodes is defined as follow:
*	For each directed edge A -> B in graph, A must before B in the order list.
*	The first node in the order can be any node in the graph with no nodes direct to it.
*	Find any topological order for the given graph.
*	http://www.lintcode.com/en/problem/topological-sorting/
*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    private Map status;
    private ArrayList<DirectedGraphNode> res;
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        status = new HashMap();
        res = new ArrayList<DirectedGraphNode>();
        if (graph.size()==0) {
            return res;
        }
        for (DirectedGraphNode node: graph) {
            status.put(node,0);
        }

        while (hasUnVisited(status,graph)){ //ensure all nodes are visited
            for (DirectedGraphNode node : graph) {
                if (status.get(node)==0) {
                    dfs(graph,node);
                }
            }
        }
        return res;
    }

    private boolean hasUnVisited(Map status, ArrayList<DirectedGraphNode> graph){
        for (DirectedGraphNode node : graph) {
            if (status.get(node) == 0) {
                return true;
            }
        }
        return false;
    }

    private void dfs(ArrayList<DirectedGraphNode> graph,DirectedGraphNode node){
        if (status.get(node) == 1){
            System.out.println("It is not a DAG");
        } 
        if (status.get(node) == 2) {
            return;
        }
        status.put(node,1); //assume it is not a DAG which will consider as error
        for (DirectedGraphNode next : node.neighbors) {
            dfs(graph,next);
        }
        status.put(node,2);
        res.add(0,node); // stack style
    }
}
