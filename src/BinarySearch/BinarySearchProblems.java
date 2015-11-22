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
     * <p>
     * Given a sorted array of integers, find the starting and ending position of a given target value
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     *
     * @param nums   a sorted array
     * @param target a target value
     * @return An array contains the starting and ending position of a given target value
     * <p>
     * O(logN + logN) ~ O(logN)
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

    /**
     * Search Insert Position
     * {https://leetcode.com/problems/search-insert-position/}
     * <p>
     * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
     * You may assume no duplicates in the array.
     * Here are few examples.
     * [1,3,5,6], 5 → 2
     * [1,3,5,6], 2 → 1
     * [1,3,5,6], 7 → 4
     * [1,3,5,6], 0 → 0
     *
     * @param nums   a sorted array
     * @param target a target value
     * @return an Integer as the index where it would be if it were inserted in order
     * <p>
     * O(logN)
     */
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }

        if (nums[lo] >= target) {
            return lo; //replace
        } else if (nums[hi] >= target) {
            return hi;
        } else {
            return hi + 1;
        }
    }

    /**
     * Search a 2D Matrix
     * {https://leetcode.com/problems/search-a-2d-matrix/}
     * <p>
     * Write an efficient algorithm that searches for a value in an m x n matrix.
     * For example,
     * Consider the following matrix:
     * [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * Given target = 3, return true.
     *
     * @param matrix an m x n matrix, Integers in each row are sorted from left to right. The first integer of each row is greater than the last integer of the previous row.
     * @param target
     * @return boolean is target in the matrix
     * <p>
     * O(logN)  image we flat the matrix into a sorted array
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix[0] == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int colum = matrix[0].length;
        int lo = 0, hi = row * colum - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            int midNum = matrix[mid / colum][mid % colum];
            if (midNum == target) {
                return true;
            } else if (midNum > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        if (matrix[lo / colum][lo % colum] == target) {
            return true;
        } else if (matrix[hi / colum][hi % colum] == target) {
            return true;
        }
        return false;
    }

    /**
     * Search a 2D Matrix II
     * {https://leetcode.com/problems/search-a-2d-matrix-ii/}
     * <p>
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * <p>
     * Integers in each row are sorted in ascending from left to right.
     * Integers in each column are sorted in ascending from top to bottom.
     * For example,
     * <p>
     * Consider the following matrix:
     * <p>
     * [
     * [1,   4,  7, 11, 15],
     * [2,   5,  8, 12, 19],
     * [3,   6,  9, 16, 22],
     * [10, 13, 14, 17, 24],
     * [18, 21, 23, 26, 30]
     * ]
     * Given target = 5, return true.
     * <p>
     * Given target = 20, return false.
     *
     * @param matrix: A list of lists of integers
     * @param target: A number you want to search in the matrix
     * @return boolean: A boolean indicate if target is in the given matrix
     * O(n + m), O(1) space
     */
    public boolean searchMatrixII(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0, col = matrix[0].length - 1;
        while (row >= 0 && col >= 0 && row < matrix.length && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    /**
     * Find Peak Element
     * {https://leetcode.com/problems/find-peak-element/}
     * A peak element is an element that is greater than its neighbors.
     * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
     * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
     * You may imagine that num[-1] = num[n] = -∞.
     * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
     *
     * @param nums
     * @return index of peak element
     * O(logN)
     */
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < nums[mid + 1]) {
                lo = mid;
            } else if (nums[mid] < nums[mid - 1]) {
                hi = mid;
            } else {
                return mid;
            }
        }
        return nums[lo] > nums[hi] ? lo : hi;
    }

    /**
     * Find Minimum in Rotated Sorted Array
     * {https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/}
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element.
     * You may assume no duplicate exists in the array.
     *
     * @param nums
     * @return minimum element
     * O(logN)
     */
    public int findMin(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            //just compare to the end of the half side, if mid element is less then it, this indicates mid -> hi is a ascending array
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return nums[lo] < nums[hi] ? nums[lo] : nums[hi];
    }

    /**
     * Find Minimum in Rotated Sorted Array II
     * {https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/}
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * Find the minimum element.
     * The array may contain duplicates.
     *
     * @param nums
     * @return minimum element
     * O(logN), worst case O(n)
     */
    public int findMinII(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            //just compare to the end of the half side, if mid element is less then it, this indicates mid -> hi is a ascending array
            if (nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[mid] > nums[hi]) {
                lo = mid;
            } else {
                hi--; // nums[mid] == nums[hi], worst case most of elements are duplicate, we have to cut them all. O(n)
            }
        }
        return nums[lo] < nums[hi] ? nums[lo] : nums[hi];
    }

    /**
     * Search in Rotated Sorted Array
     * {https://leetcode.com/problems/search-in-rotated-sorted-array/}
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * You may assume no duplicate exists in the array.
     *
     * @param nums
     * @param target
     * @return int
     *
     *  O(logn)
     */

    public int searchRotatedSortedArray(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > nums[lo]) {
                if (nums[lo] <= target && nums[mid] >= target) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else {
                if (nums[mid] <= target && nums[hi] >= target) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            }
        }
        if (nums[hi] == target) {
            return hi;
        }
        if (nums[lo] == target) {
            return lo;
        }
        return -1;
    }

    /**
     * Search in Rotated Sorted Array II
     * {https://leetcode.com/problems/search-in-rotated-sorted-array-ii/}
     * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
     * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
     * You are given a target value to search. If found in the array return its index, otherwise return -1.
     * duplicates are allowed
     *
     * @param nums
     * @param target
     * @return boolean
     *
     *  O(logN), worst case O(n)
     */
    public boolean searchRotatedSortedArrayII(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] > nums[lo]) {
                if (nums[lo] <= target && nums[mid] >= target) {
                    hi = mid;
                } else {
                    lo = mid;
                }
            } else if (nums[mid] < nums[lo]) {
                if (nums[mid] <= target && nums[hi] >= target) {
                    lo = mid;
                } else {
                    hi = mid;
                }
            } else {
                lo++;
            }
        }
        return nums[hi] == target || nums[lo] == target;
    }

    /**
     * Median of Two Sorted Arrays
     * {https://leetcode.com/problems/median-of-two-sorted-arrays/ }
     * There are two sorted arrays nums1 and nums2 of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if (len % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, len / 2) + findKth(nums1, 0, nums2, 0, len / 2 + 1)) / 2.0;
        } else {
            return findKth(nums1, 0, nums2, 0, len / 2 + 1);
        }
    }
    private int findKth(int[] A, int indexA, int[] B, int indexB, int k) {
        if (indexA > A.length - 1) {
            return B[indexB + k - 1];
        }
        if (indexB > B.length - 1) {
            return A[indexA + k - 1];
        }
        // avoid infilite loop if k == 1
        if (k == 1) {
            return Math.min(A[indexA], B[indexB]);
        }
        int keyA = Integer.MAX_VALUE, keyB = Integer.MAX_VALUE;

        if (indexA + k / 2 - 1 < A.length){
            keyA = A[indexA + k / 2 - 1];
        }
        if (indexB + k / 2 - 1 < B.length) {
            keyB = B[indexB + k / 2 - 1];
        }
        if (keyA > keyB) {
            return findKth(A, indexA, B, indexB + k / 2, k - k / 2);
        } else {
            return findKth(A, indexA + k / 2, B, indexB, k - k / 2);
        }
    }
}
