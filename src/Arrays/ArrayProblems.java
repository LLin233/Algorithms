package Arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Le on 2015/11/21.
 */
public class ArrayProblems {

    /**
     * Remove Element
     * {https://leetcode.com/problems/remove-element/}
     * <p>
     * Given an array and a value, remove all instances of that value in place and return the new length.
     * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     * O(n)
     */
    public int removeElement(int[] nums, int val) {
        int pointer = nums.length - 1;
        int i = 0;
        while (i <= pointer) {
            if (nums[i] == val) {
                nums[i] = nums[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }

    /**
     * Two Sum
     * {https://leetcode.com/problems/two-sum/}
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution.
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     * O(n), O(n) space
     */

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (map.containsKey(target - cur)) {
                return new int[]{map.get(target - cur) + 1, i + 1};
            }
            map.put(cur, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * Two Sum II
     * Similar to Question [1. Two Sum], except that the input array is already sorted in ascending order.
     * 2 pointers
     * O(n)
     */
    public int[] twoSumII(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int x = nums[left] + nums[right];
            if (target == x) {
                return new int[]{left + 1, right + 1};
            } else if (target < x) {
                right--;
            } else {
                left++;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}

/**
 * Two Sum III
 * Design and implement a TwoSum class. It should support the following operations: add
 * and find.
 * add(input) – Add the number input to an internal data structure.
 * find(value) – Find if there exists any pair of numbers which sum is equal to the value.
 * For example,
 * add(1); add(3); add(5); find(4)  true; find(7)  false
 *
 * add() : O(1), find(): O(n), space: O(n)
 */
class TwoSumIII {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public void add(int input) {
        int count = map.containsKey(input) ? map.get(input) : 0;
        map.put(input, count + 1);
    }

    public boolean find(int target) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey();
            int y = target - num;
            if (y == num) {
                // For duplicates, ensure there are at least two individual numbers.
                if (entry.getValue() >= 2) return true;
            } else if (map.containsKey(y)) {
                return true;
            }
        }
        return false;
    }

}