import java.util.*;
/**
*   A peak element is an element that is greater than its neighbors.
*	Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
*	The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
*	You may imagine that num[-1] = num[n] = -∞.
*	For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*
*	click to show spoilers.
*	Note:
*	Your solution should be in logarithmic complexity.
*
*/
public class Solution {
  	public int findPeakElement(int[] num) {
		return helper(num, 0, num.length-1);
	    }
	private int helper(int[] num, int start, int end) {
		if (start == end) {
			return start;
		} else if (start + 1 == end) {
			return num[start] > num[end] ? start : end;
		} else {
			int mid = start + (end - start) / 2;
			if (num[mid] > num[mid - 1] && num[mid] > num[mid + 1] ) {
				return mid;
			} else if (num[mid] < num[mid - 1]){
				return helper(num, start, mid - 1);
			} else {
				return helper(num, mid + 1, end);
			}
		}
	}
}
