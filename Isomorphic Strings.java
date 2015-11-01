import java.util.*;
/**
*   Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

For example,
Given "egg", "add", return true.

Given "foo", "bar", return false.

Given "paper", "title", return true.

Note:
You may assume both s and t have the same length.
*
*/

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> tran = new HashMap<Character, Character>();
        Set<Character> orgn = new HashSet<Character>();

        for(int i = 0; i < s.length(); i++) {
            if(tran.containsKey(s.charAt(i))) {
                if(tran.get(s.charAt(i)) != t.charAt(i)) {
                    return false;
                }
            } else {
                if(orgn.contains(t.charAt(i))) {
                    return false;
                } else {
                    tran.put(s.charAt(i), t.charAt(i));
                    orgn.add(t.charAt(i));
                }
            }
        }
        return true;
    }
}
