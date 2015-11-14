import java.util.*;
/**
*   Given a string s, partition s such that every substring of the partition is a palindrome.
*	Return all possible palindrome partitioning of s.
*	For example, given s = "aab",
*	Return
*	  [
*	    ["aa","b"],
*		["a","a","b"]
*	  ]
*
*/

public class Solution {
     public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return result;
        }
        helper(result, new ArrayList<String>(), s, 0);
        return result;
    }
    private void helper(List<List<String>> result, List<String> path, String s, int position) {
        if (position == s.length()) {
            result.add(new ArrayList<String>(path));
            return;
        }
        for (int i = position + 1; i <= s.length(); i++) {
            String sub= s.substring(position, i);
            if(!isPlm(sub)) {
                continue;
            }
            path.add(sub);
            helper(result, path, s, i);
            path.remove(path.size() - 1);
        }
    }
    private boolean isPlm(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
	}
}