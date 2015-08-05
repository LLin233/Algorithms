import java.util.*;
/**
*   Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
*	Find two lines, which together with x-axis forms a container, such that the container contains the most water.
*	Note: You may not slant the container.
*
*/

public class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        if (right < 0) {
            return 0;
        }
        while (left < right) {
            int area = area(height, left, right);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
            if (maxArea < area) {
                maxArea = area;
            }
        }
        return maxArea;
    }
    
    private int area(int[] height, int left, int right) {
        return height[left] > height[right] ? height[right] * (right - left) : height[left] * (right - left);
    }
}
