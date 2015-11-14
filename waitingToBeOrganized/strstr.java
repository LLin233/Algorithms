import java.util.*;
/**
*   strstr (a.k.a find sub string), is a useful function in string operation. Your task is to implement this function.
*	For a given source string and a target string, you should output the first index(from 0) of target string in source string.
*	If target does not exist in source, just return -1.
*
*/

class Solution {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {
        //write your code here
        if (target == null || source == null) {
            return -1;
        }
        for (int i = 0; ; i++) {
            for(int j = 0; ; j++) {
                if (j == target.length()) {
                    return i;
                }
                if (i + j == source.length()) {
                    return -1;
                }
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
        }
    }
}

