import java.util.*;
/**
*   Given a pattern and a string str, find if str follows the same pattern.
*	Examples:
*	pattern = "abba", str = "dog cat cat dog" should return true.
*	pattern = "abba", str = "dog cat cat fish" should return false.
*	pattern = "aaaa", str = "dog cat cat dog" should return false.
*	pattern = "abba", str = "dog dog dog dog" should return false.
*	Notes:
*	patterncontains only lowercase alphabetical letters, and str contains words separated by a single space. Each word in str contains only lowercase alphabetical letters.
*	Both pattern and str do not have leading or trailing spaces.
*	Each letter in pattern must map to a word with length that is at least 1.
 */
public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map index = new HashMap();
        for (int i = 0; i < words.length; ++i) {
            if (!Objects.equals(index.put(pattern.charAt(i), i), index.put(words[i], i))) {
                return false;
            }
        }
        return true;
    }
}