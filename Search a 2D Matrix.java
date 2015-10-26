import java.util.*;
/**
*   Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.
    For example,

    Consider the following matrix:

    [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
    ]
    Given target = 3, return true.
*
*/

/**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix.length < 1) {
            return false;
        }

        int row = matrix.length;
        int col = matrix[0].length;

        int low = 0;
        int high = row - 1;
        if(target < matrix[0][0]) {
            return false;
        }

        while(low <= high) {
            int mid = (high - low) / 2 + low;
            if(matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int i = high;
        low = 0;
        high = col - 1;

        while(low <= high) {
            int mid = (high - low) / 2 + low;
            if(matrix[i][mid] == target) {
                return true;
            } else if (matrix[i][mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }
}
