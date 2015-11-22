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
     *
     * O(nm) runtime, O(1) space
     */
    public int strStr(String haystack, String needle) {
        for (int i = 0; ; i++) {
            for (int j = 0; ;j++) {
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
}