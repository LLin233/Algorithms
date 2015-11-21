package Arrays;

/**
 * Created by Le on 2015/11/21.
 */
public class ArrayProblems {

    /**
     * Remove Element
     * {https://leetcode.com/problems/remove-element/}
     *
     *  Given an array and a value, remove all instances of that value in place and return the new length.
     *  The order of elements can be changed. It doesn't matter what you leave beyond the new length.
     *  O(n)
     */
    public int removeElement(int[] nums, int val) {
        int pointer = nums.length - 1;
        int i = 0;
        while (i <= pointer) {
            if(nums[i] == val){
                nums[i] = nums[pointer];
                pointer--;
            } else {
                i++;
            }
        }
        return pointer + 1;
    }

}
