import java.util.*;
/**
*  Write a function to find the longest common prefix string amongst an array of strings
*
*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }

        String target = strs[0];

        for(int i = 0; i < target.length(); i++) {
            for(int j = 1; j < strs.length; j++) {
                if(i >= strs[j].length() || strs[j].charAt(i) != target.charAt(i)) {
                    return target.substring(0, i);
                }
            }
        }

        return target;
    }
}
