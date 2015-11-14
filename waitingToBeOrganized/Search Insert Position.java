import java.util.*;
/**
*   Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
*   You may assume NO duplicates in the array.
*   Example
[1,3,5,6], 5 → 2

[1,3,5,6], 2 → 1

[1,3,5,6], 7 → 4

[1,3,5,6], 0 → 0
*/

public class Solution {
    /**
    * param A : an integer sorted array
    * param target :  an integer to be inserted
    * return : an integer
    */
    public int searchInsert(int[] A, int target) {
        // write your code here
        int l = 0;
        int r = A.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (A[m] == target) {
                return m;
            }
            if (A[m] < target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return l;
    }
}
