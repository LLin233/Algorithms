import java.util.*;
/**
*   You are given an n x n 2D matrix representing an image.

    Rotate the image by 90 degrees (clockwise).

    Follow up:
    Could you do this in-place?
*
*/

public class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int layer = 0; layer < n / 2; layer++) {
            int head = layer;
            int tail = n - 1 - layer;
            for(int i = head; i < tail; i++) {
                int len = i - head;
                int top = matrix[head][i];
                //Left -> Top
                matrix[head][i]= matrix[tail - len][head];
                //Bottom -> Left
                matrix[tail - len][head] = matrix[tail][tail - len];
                //Right -> Bottom
                matrix[tail][tail - len] = matrix[i][tail];
                //Top -> Right
                matrix[i][tail] = top;
            }
        }
    }
}
