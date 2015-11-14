import java.util.*;
/**
*   Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.
*	For example, given
*	s = "leetcode",
*	dict = ["leet", "code"].
*	Return true because "leetcode" can be segmented as "leet code".
*
*/

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        if(s==null || s.length()==0) {
            return true;
        }
        boolean[] arrays = new boolean[s.length() + 1];
        arrays[0] = true;
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j <i; j++){
                if (arrays[j] && dict.contains(s.substring(j, i))){
                    // f(n) = f(0,i) + f(i,j) + f(j,n)
                    arrays[i] = true;
                    break;
                }
            }
        }
        return arrays[s.length()];
	}
}
