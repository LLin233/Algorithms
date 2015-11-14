import java.util.*;
/**
*   Given an array of integers, find if the array contains any duplicates. 
*	Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
*
*/

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        HashSet set = new HashSet();
        for (int i : nums) {
            set.add(i);
        }
        if (set.size() < nums.length) {
            return true;
        }
        return false;
    }
}