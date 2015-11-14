import java.util.*;
/**
*	Write a method anagram(s,t) to decide if two strings are anagrams or not.
*	Have you met this question in a real interview? Yes
*	Example
*	Given s="abcd", t="dcab", return true.
*	Challenge
*	O(n) time, O(1) extra space
*/

public class Solution {
    /**
     * @param s: The first string
     * @param b: The second string
     * @return true or false
     */
    public boolean anagram(String s, String t) {
        // write your code here
        if (s.length() != t.length()) {
            return false;
        }
        int[] flags = new int[256];

        for (char c : s.toCharArray()) {
            flags[c] += 1; 
        }
        for (char c : t.toCharArray()) {
            flags[c] -= 1;
            if (flags[c] < 0) {
                return false;
            }
        }
        return true;
    }
};
