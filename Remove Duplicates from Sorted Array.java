import java.util.*;
/**
*   Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
*	Do not allocate extra space for another array, you must do this in place with constant memory.
*	For example,
*	Given input array nums = [1,1,2],
*	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
*
*/

public class Solution {
    public int removeDuplicates(int[] A) {
        if (A == null && A.length == 0) {
            return 0;
        }
        int left = 0, right = 0;
        while (right < A.length) {
            A[left++] = A[right++];
            while (right < A.length && A[right] == A[right - 1]) {
                right++;
            }
        }
        return left;
    }
}