package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Le on 2016/2/17.
 */
public class Subsets {
    /**
     * {https://leetcode.com/problems/subsets/}
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        subsetsHelper(result, new ArrayList<Integer>(), nums, 0);
        return result;

    }

    private void subsetsHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        result.add(new ArrayList<Integer>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
    /**
     * {https://leetcode.com/problems/subsets-ii/}
     */

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        subsetsWithDupHelper(result, new ArrayList<Integer>(), nums, 0);
        return result;

    }

    private void subsetsWithDupHelper(List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        result.add(new ArrayList<Integer>(list));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            subsetsWithDupHelper(result, list, nums, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
