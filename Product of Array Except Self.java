import java.util.*;
/**
* Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

* Solve it without division and in O(n).

* For example, given [1,2,3,4], return [24,12,8,6].

* Follow up:
* Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*
*/

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int[] A = new int[nums.length];
        // A[0] = nums[0];
        
        // for (int i = 1; i < nums.length; i++) {
        //     A[i] = nums[i] * A[i - 1]; 
        // }
        
        // int[] B = new int[nums.length];
        // B[nums.length - 1] = nums[nums.length - 1];
        
        // for (int i = nums.length - 2; i > 0; i--) {
        //      B[i] = nums[i] * B[i + 1]; 
        // }
        
        // for (int i = 0; i < nums.length;i++) {
        //   if (i == 0) {
        //       nums[i] = B[i + 1];
        //   } else if (i == nums.length - 1) {
        //       nums[i] = A[i - 1];
        //   } else {
        //       nums[i] = A[i - 1] * B [i + 1];
        //   }
        // }
        // return nums;
        
        /**
        * follow-up
        */
        int[] res = new int[nums.length];  
        res[res.length-1] = 1;  
        for(int i=nums.length-2; i>=0; i--) {  
            res[i] = res[i+1] * nums[i+1];  
        }  
          
        int left = 1;  
        for(int i=0; i<nums.length; i++) {  
            res[i] *= left;  
            left *= nums[i];  
        }  
        return res;  
    }
}
