import java.util.*;
/**
*  Implement regular expression matching with support for '.' and '*'.
*	'.' Matches any single character.
*	'*' Matches zero or more of the preceding element.*
*	The matching should cover the entire input string (not partial).
*The function prototype should be:
*bool isMatch(const char *s, const char *p)
*Some examples:
*isMatch("aa","a") → false
*isMatch("aa","aa") → true
*isMatch("aaa","aa") → false
*isMatch("aa", "a*") → true
*isMatch("aa", ".*") → true
*isMatch("ab", ".*") → true
*isMatch("aab", "c*a*b") → true
*
*/

public class Solution {
    public boolean isMatch(String s, String p) {
        // s is normal string, and p is regex string
        if (p.length() == 0) {
            return s.length() == 0;
        } else if (p.length() < 2 || p.charAt(1) != '*') {
            // if 2nd char in p is not '*', then match character
            if (s.length() == 0) {
                return false;
            } else if (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)) {
                return false;
            } else {
                return isMatch(s.substring(1), p.substring(1));
            }
        } else {
            // if 2nd char in p is '*', then iterate all position repetitions
            char repeatLetter = p.charAt(0);
            for (int i = 0; i <= s.length(); i++) {
                // i is the number of repetition of repeatLetter, start from 0
                if (i > 0 && repeatLetter != s.charAt(i - 1)
                        && repeatLetter != '.') {
                    break;
                } else {
                    if (isMatch(s.substring(i), p.substring(2))) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
}