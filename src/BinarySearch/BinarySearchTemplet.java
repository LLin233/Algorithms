package BinarySearch;

/**
 * Created by Le on 2015/11/18.
 */
public class BinarySearchTemplet {
    public static int binarySearch(int[] array, int target) {
        if (array == null || array.length == 0) {
            return -1;
        }

        int start = 0, end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] == target) {
                start = mid;
            } else if (array[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (array[start] == target) {
            return start;
        }
        if (array[end] == target) {
            return end;
        }
        return -1;
    }


    /**
     * nums[index] >= target, min(index)
     */
    public static int lowerBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = -1, hi = nums.length;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid;
            } else {
                hi = mid;
            }
        }
        return lo + 1;
    }

    /**
     * nums[index] <= target, max(index)
     */
    public static int upperBound(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int lo = -1, hi = nums.length;
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > target) {
                hi = mid;
            } else {
                lo = mid;
            }
        }
        return hi - 1;
    }
}
