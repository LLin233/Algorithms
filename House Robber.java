import java.util.*;
/**
*   You are a professional robber planning to rob houses along a street.
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*
*/

public class Solution {
    public int rob(int[] nums) {
        if(nums.length < 1) {
            return 0;
        }
        int[] rst = new int[nums.length + 1];
        rst[0] = 0;
        rst[1] = nums[0];

        int i = 2;
        while(i < nums.length + 1) {
            rst[i] = Math.max(rst[i - 1], rst[i - 2] + nums[i - 1]);
            i++;
        }
        return rst[nums.length];
    }
}
