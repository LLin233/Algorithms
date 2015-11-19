package BinarySearch;

import java.util.Random;

/**
 * Created by Le on 2015/11/18.
 */
public class BinarySearchProblems {

    /**
     * First Bad Version
     * {https://leetcode.com/problems/first-bad-version/}
     * <p>
     * You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
     * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
     * You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
     *
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     * <p>
     * O(logN)
     */
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (isBadVersion(mid)) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (isBadVersion(lo)) {
            return lo;
        }
        return hi;
    }

    private boolean isBadVersion(int version) {
        return version < 10;  // assumption
    }

    /***
     * Search for a Range
     * {https://leetcode.com/problems/search-for-a-range/}
     *
     *   Given a sorted array of integers, find the starting and ending position of a given target value
         Your algorithm's runtime complexity must be in the order of O(log n).
         If the target is not found in the array, return [-1, -1].
         For example,
         Given [5, 7, 7, 8, 8, 10] and target value 8,
         return [3, 4].
     *
     *
     * @param nums input array
     * @param target integer that trying to search
     * @return an Array has 2 elements shows the index of the first target and last target
     *
     * O(logN + logN) ~ O(logN)
     *
     */
    public int[] searchRange(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int[] result = new int[2];

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                hi = mid;
            } else if (nums[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (nums[lo] == target) {
            result[0] = lo;
        } else if (nums[hi] == target) {
            result[0] = hi;
        } else {
            result[0] = result[1] = -1;
        }

        lo = 0;
        hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                lo = mid;
            } else if (nums[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        if (nums[hi] == target) {
            result[1] = hi;
        } else if (nums[lo] == target) {
            result[1] = lo;
        } else {
            result[0] = result[1] = -1;
        }
        return result;
    }


}
