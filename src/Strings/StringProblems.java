package Strings;

/**
 * Created by Le on 2015/11/22.
 */
public class StringProblems {
    /**
     * Valid Palindrome
     * {https://oj.leetcode.com/problems/valid-palindrome/}
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters
     * and ignoring cases.
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * <p>
     * Example Questions Candidate Might Ask:
     * Q: What about an empty string? Is it a valid palindrome?
     * A: For the purpose of this problem, we define empty string as valid palindrome.
     * <p>
     * Solution:
     * O(n) runtime, O(1) space:
     * The idea is simple, have two pointers – one at the head while the other one at the tail.
     * Move them towards each other until they meet while skipping non-alphanumeric
     * characters.
     * Consider the case where given string contains only non-alphanumeric characters. This is
     * a valid palindrome because the empty string is also a valid palindrome.
     */
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Implement strstr()
     * {https://oj.leetcode.com/problems/implement-strstr}
     * Implement strstr(). Returns the index of the first occurrence of needle in haystack, or –1
     * if needle is not part of haystack.
     * <p>
     * O(nm) runtime, O(1) space
     */
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == needle.length()) {
                    return i;
                }
                if (i + j == haystack.length()) {
                    return -1;
                }
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    break;
                }
            }
        }
    }

    /**
     * 14. One Edit Distance
     * {https://oj.leetcode.com/problems/one-edit-distance/}
     * Question:
     * Given two strings S and T, determine if they are both one edit distance apart.
     * Hint:
     * 1. If | n – m | is greater than 1, we know immediately both are not one-edit distance
     * apart.
     * 2. It might help if you consider these cases separately, m == n and m ≠ n.
     * 3. Assume that m is always ≤ n, which greatly simplifies the conditional statements.
     * If m > n, we could just simply swap S and T.
     * 4. If m == n, it becomes finding if there is exactly one modified operation. If m ≠ n,
     * you do not have to consider the delete operation. Just consider the insert operation
     * in T.
     * O(n) runtime, O(1) space – Simple one-pass
     */
    public boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) {
            return isOneEditDistance(t, s);
        }
        if (n - m > 1) {
            return false;
        }
        int i = 0, shift = n - m;
        while (i < m && s.charAt(i) == t.charAt(i)) {
            i++;
        }
        if (i == m) {
            return shift > 0;
        }
        if (shift == 0) {
            i++;
        }
        while (i < m && s.charAt(i) == t.charAt(i + shift)) {
            i++;
        }
        return i == m;
    }

    /**
     * Longest Substring Without Repeating Characters
     *{https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/}
     * Given a string, find the length of the longest substring without repeating characters.
     * For example, the longest substring without repeating letters for “abcabcbb” is “abc”, which the length is 3.
     * For “bbbbb” the longest substring is “b”, with the length of 1.
     *
     * O(n) runtime, O(1) space – Two iterations:
     */

    public int lengthOfLongestSubstring(String s) {
        boolean[] exist = new boolean[256];
        int i = 0, maxLen = 0;
        for (int j = 0; j < s.length(); j++) {
            while (exist[s.charAt(j)]) {
                exist[s.charAt(i)] = false;
                i++;
            }
            exist[s.charAt(j)] = true;
            maxLen = Math.max(j - i + 1, maxLen);
        }
        return maxLen;
    }


}