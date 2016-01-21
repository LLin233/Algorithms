package screens;

import java.util.LinkedList;

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


    /**
     * Valid Sudoku {https://leetcode.com/problems/valid-sudoku/}
     */

    public boolean isValidSudoku(char[][] board) {
        return isValidRow(board) && isValidColumn(board) && isValidBox(board);
    }

    //检查 这个c是不是已经在flag里出现 如果重复出现返回false
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

    //横着遍历矩阵 每次检查每行充不重复
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

    //竖着遍历矩阵 每次检查每列重不重复
    private boolean isValidColumn(char[][] board) {
        for (int i = 0; i < 9; i++) {
            boolean[] flag = new boolean[10];
            for (int j = 0; j < 9; j++) {    //改成j i即可
                if (!markFlag(flag, board[j][i])) {
                    return false;
                }
            }
        }
        return true;
    }

    //遍历矩阵 检查所有小九宫格充不重复
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
        if(board == null || board.length != 9 || board[0].length != 9)
            return;
        solveSudokuHelper(board, 0, 0);
    }

    private boolean solveSudokuHelper(char[][] board, int i, int j) {
        if(j >= 9){
            return solveSudokuHelper(board,i + 1,0);
        }
        if(i == 9) {
            return true;
        }
        if(board[i][j] == '.') {
            for(int k = 1;k <= 9;k++) {
                board[i][j] = (char)(k + '0');
                if(isValid(board,i,j)) {
                    if(solveSudokuHelper(board,i,j + 1))
                        return true;
                }
                board[i][j] = '.';
            }
        }
        else {
            return solveSudokuHelper(board,i,j + 1);
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        for(int k = 0;k < 9;k++) {
            if(k != j && board[i][k] == board[i][j])
                return false;
        }
        for(int k = 0;k < 9;k++) {
            if(k != i && board[k][j] == board[i][j])
                return false;
        }
        for(int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for(int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if((row != i || col != j) && board[row][col] == board[i][j])
                    return false;
            }
        }
        return true;
    }


    /*
    *  就是给一个dictionary，设计一个函数，当用户输入一个string时，返回dict里所有以这个string开头的词。Trie搞定之，又聊了聊怎么优化，如果是客户端web输入，server端存一个大dictionary，怎么才能快速响应之类的
    */
}

