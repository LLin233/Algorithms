import java.util.*;
/**
*   Find the contiguous subarray within an array (containing at least one number) which has the largest product.
*	For example, given the array [2,3,-2,4],
*	the contiguous subarray [2,3] has the largest product = 6.
*
*/

public class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int max_global = nums[0];
        int max_local = nums[0];
        int min_local = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = max_local;
            max_local = Math.max(Math.max(max_local * nums[i], nums[i]), nums[i] * min_local);
            min_local =  Math.min(Math.min(temp * nums[i], nums[i]), nums[i] * min_local);
            max_global = Math.max(max_local, max_global);
        }
        return max_global;
    }
}