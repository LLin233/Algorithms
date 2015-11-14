import java.util.*;
/**
*   Given a digit string, return all possible letter combinations that the number could represent.
*	A mapping of digit to letters (just like on the telephone buttons) is given below.
*	Input:Digit string "23"
*	Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
*
*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return result;
        }
        helper(result, "", digits, 0, digits.length());
        return result;
    }
    private void helper(List<String> result, String path, String digits, int position, int len) {
        if (position == len) {
            result.add(path);
            return;
        }
        String possibleLetters = getLetters(digits.charAt(position));
        for (char letter : possibleLetters.toCharArray()) {
            helper(result, path + letter, digits, position + 1, len);
        }
    }
    private String getLetters(char digit) {
        int index = digit - '0';
        String[] map = new String[] {
            " ",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        return map[index];
    }
}