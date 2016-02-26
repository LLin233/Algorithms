package Arrays;

import java.util.*;

/**
 * Created by Le on 2015/11/21.
 */


class ArrayEazy {

    /**
     * Summary Ranges {https://leetcode.com/problems/summary-ranges/}
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int start = nums[0], end = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != end + 1) {
                end = nums[i - 1];
                if (start == end) {
                    result.add(start + "");
                } else {
                    result.add(start + "->" + end);
                }
                start = nums[i];
                end = nums[i];
            } else {
                end = nums[i];
            }
        }
        if (start == end) {
            result.add(start + "");
        } else {
            result.add(start + "->" + end);
        }

        return result;
    }

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
     * Move Zeroes {https://leetcode.com/problems/move-zeroes/}
     *
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int pointer = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pointer++] = nums[i];
            }
        }
        for (int i = pointer; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * Shortest Word Distance {https://leetcode.com/problems/shortest-word-distance/}
     */
    public int shortestDistance(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, distance = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                p1 = i;
            }
            if (word2.equals(words[i])) {
                p2 = i;
            }
            if (p1 != -1 && p2 != -1) {
                distance = Math.min(distance, Math.abs(p1 - p2));
            }
        }
        return distance;
    }


    /**
     * Contains Duplicate {https://leetcode.com/problems/contains-duplicate/}
     */

    public boolean containsDuplicate(int[] nums) {

//        if (nums == null || nums.length <= 1) {
//            return false;
//        }
//        Arrays.sort(nums);
//        for (int i = 1; i < nums.length;i++) {
//            if (nums[i] == nums[i - 1]) {
//                return true;
//            }
//        }
//        return false;

        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            if (!set.add(i)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Remove Duplicates from Sorted Array {https://leetcode.com/problems/remove-duplicates-from-sorted-array/}
     */

    public int removeDuplicates(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }

    /**
     * Plus One {https://leetcode.com/problems/plus-one/}
     *
     * @param digits
     * @return
     */

    public int[] plusOne(int[] digits) {
        int index = digits.length - 1, carry = 1, sum = 0;
        while (index >= 0 && carry != 0) {
            sum = digits[index] + carry;
            if (sum >= 10) {
                digits[index] = sum % 10;
                carry = 1;
            } else {
                digits[index] = sum;
                carry = 0;
            }
            index--;
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }

    /**
     * Rotate Array{https://leetcode.com/problems/rotate-array/}
     *
     * @param nums
     * @param k
     */

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        for (int i = start, j = end; i < j; i++, j--) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }

    /**
     * Pascal's Triangle{https://leetcode.com/problems/pascals-triangle/}
     *
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return res;
        for (int j = 0; j < numRows; j++) {
            List<Integer> row = new ArrayList<Integer>();
            row.add(1);
            for (int i = 1; i < j; i++) {//除去第一行和第二行才进这个循环
                List<Integer> prevRow = res.get(j - 1);//当前行的上一行
                int temp = prevRow.get(i - 1) + prevRow.get(i);
                row.add(temp);
            }
            if (j != 0) {
                row.add(1);//除了第一行，末尾接个1
            }
            res.add(row);
        }
        return res;
    }


}


public class ArrayProblems {

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


    /**
     * {https://leetcode.com/problems/sliding-window-maximum/}
     */

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k || k < 1) {
            return new int[]{};
        }
        LinkedList<Integer> qmax = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            while (!qmax.isEmpty() && nums[qmax.peekLast()] <= nums[i]) {
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i - k) {
                qmax.pollFirst();
            }
            if (i >= k - 1) {
                result[index++] = nums[qmax.peekFirst()];
            }
        }
        return result;
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
 * <p>
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
