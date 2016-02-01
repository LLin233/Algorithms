package screens;

import java.util.*;

/**
 * Created by Le on 2016/1/19.
 */
public class tb {

    public LinkNode Reserve(LinkNode node) {
        LinkNode prev = null;
        LinkNode next = null;

        while (node != null) {
            next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }

    /**
     * Evaluate Reverse Polish Notation {https://leetcode.com/problems/evaluate-reverse-polish-notation/}
     * 错误检查, 每次pop操作检查栈空情况，如果栈空，则说明出错。还有就是最后检查一下栈的size，如果不是1也说明运算数多了，返回错误
     */

    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (tokens[i].equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (tokens[i].equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (tokens[i].equals("/")) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                if (num1 != 0) {
                    stack.push(num2 / num1);
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                stack.push(Integer.parseInt(tokens[i]));
            }
        }
        return stack.pop();
    }



    public boolean isValidSudoku(char[][] board) {
        return isValidRow(board) && isValidColumn(board) && isValidBox(board);
    }

    private boolean markFlag(boolean[] flag, char c) {
        if (c == '.') {
            return true;
        }
        int index = c - '0';
        if (flag[index]) {  //如果之前已经出现过这个数了
            return false;
        } else {
            flag[index] = true;
            return true;
        }
    }

    private boolean isValidRow(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] flag = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (!markFlag(flag, board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isValidColumn(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] flag = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (!markFlag(flag, board[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidBox(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean[] flag = new boolean[10];
                for (int m = 0; m < 3; m++) {
                    for (int n = 0; n < 3; n++) {
                        if (!markFlag(flag, board[i * 3 + m][j * 3 + n])) {
                            return false;
                        }
                    }

                }
            }
        }
        return true;
    }

    /**
     * Sudoku Solver {https://leetcode.com/problems/sudoku-solver/}
     */

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return;
        solveSudokuHelper(board, 0, 0);
    }

    private boolean solveSudokuHelper(char[][] board, int i, int j) {
        if (j >= 9) {
            return solveSudokuHelper(board, i + 1, 0);
        }
        if (i == 9) {
            return true;
        }
        if (board[i][j] == '.') {
            for (int k = 1; k <= 9; k++) {
                board[i][j] = (char) (k + '0');
                if (isValid(board, i, j)) {
                    if (solveSudokuHelper(board, i, j + 1))
                        return true;
                }
                board[i][j] = '.';
            }
        } else {
            return solveSudokuHelper(board, i, j + 1);
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == board[i][j])
                return false;
        }
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j])
                return false;
        }
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if ((row != i || col != j) && board[row][col] == board[i][j])
                    return false;
            }
        }
        return true;
    }


    /**
     * Topographical Sort
     *
     * 第一轮：设计函数，判断输入的一组edges能不能构成一个合法的tree，例如
         输入：A->B, A->C，合法
         输入：A->B, A->C, B->C 不合法
         输入：A->B, A->C, B->D, C->D 不合法
     只有一个V(root)入度(indegree) 为0, 其余V的入度为1, 否则不合法
     */

    public boolean isTopologicalSortAValidTree(ArrayList<DirectedGraphNode> graph){
        if (directedCycle(graph)) { //must be DAG
            return false;
        }

        int rootCount = 0;
        HashMap<DirectedGraphNode, Integer> map = new HashMap<>();
        for (DirectedGraphNode node : graph) {
            for (DirectedGraphNode neighbor : node.neighbors) {
                if (map.containsKey(neighbor)) {
                    return false;
                } else {
                    map.put(neighbor, 1);
                }
            }
        }

        for (DirectedGraphNode node : graph) {
            if (!map.containsKey(node)) {
                rootCount++;
            }
        }
        return rootCount == 1;

    }
    private boolean directedCycle(ArrayList<DirectedGraphNode> graph) {
        return true;
    }



    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        buildString(root, builder);
        return builder.toString();
    }
    private void buildString(TreeNode node, StringBuilder builder) {
        if (node == null) {
            builder.append("null,");
        } else {
            builder.append(node.val + ",");
            buildString(node.left, builder);
            buildString(node.right, builder);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(",")));
        TreeNode resultTree = buildTree(nodes);
        return resultTree;
    }
    private TreeNode buildTree(List<String> nodes) {
        String val = nodes.remove(0);
        if ("null".equals(val)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(val));
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }


    /*
    *  就是给一个dictionary，设计一个函数，当用户输入一个string时，返回dict里所有以这个string开头的词。Trie搞定之，又聊了聊怎么优化，如果是客户端web输入，server端存一个大dictionary，怎么才能快速响应之类的
    */

}


class DirectedGraphNode{
    int V;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        V = x;
        neighbors = new ArrayList<>();
    }
}


class MedianFinder {

    Integer sum = 0;
    PriorityQueue<Integer> maxheap = new PriorityQueue<Integer>();
    PriorityQueue<Integer> minheap = new PriorityQueue<Integer>(Collections.reverseOrder());

    // Adds a number into the data structure. O(logn)
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.offer(minheap.poll());
        }

        sum += num;
    }

    // Returns the median of current data stream (O(1))
    public double findMedian() {
        return maxheap.size() == minheap.size() ? (double) (maxheap.peek() + minheap.peek()) / 2.0 : maxheap.peek();
    }

    public int getSize(){
        return maxheap.size() + minheap.size();
    }
    public double getMean() {
        return sum / getSize();
    }

}

