package Strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Le on 2015/11/14.
 */
public class App {

    public static String revertString(String s) {

        //String -> O(n*n) time complexity
        //StringBuilder -> O(n)
        int lengthOfText = s.length(); //O(1)
        StringBuilder revertString = new StringBuilder();
        for (int index = lengthOfText - 1; index >= 0; index--) { //O(n)
            revertString.append(s.charAt(index));
        }
        return revertString.toString();
    }

    public static List<String> getSuffix(String s) {
        int lengthOfText = s.length();
        List<String> suffixList = new ArrayList<>();
        for (int index = 0; index < lengthOfText; index++) {
            suffixList.add(s.substring(index, lengthOfText)); //O(1), what if we use substring under StringBuilder, this operation will have O(n) time complexity
        }
        return suffixList;
    }

    //overall running time O(n)
    //some sources in addition restrict a proper prefix to be non-empty.
    public static List<String> getPrefix(String s) {
        int lengthOfText = s.length();
        List<String> prefixList = new ArrayList<>();
        for (int index = 0; index <= lengthOfText; index++) { // empty string counts
            prefixList.add(s.substring(0, index)); //O(1), what if we use substring under StringBuilder, this operation will have O(n) time complexity
        }
        return prefixList;
    }

    //O(n)
    public static String longestCommonPrefix(String str1, String str2) {
        int commonLength = Math.min(str1.length(), str2.length());
        for (int index = 0; index < commonLength; index++) {
            if (str1.charAt(index) != str2.charAt(index)) {
                return str1.substring(0, index);
            }
        }
        return str1.substring(0, commonLength);
    }

    public static String longestRepeatedSubstring(String str) {
        int lengthOfText = str.length();
        List<String> suffixList = getSuffix(str); //O(n)
        Collections.sort(suffixList); //O(nlogn)
        String longestRepeatedString = "";

        //O(n*n)
        for (int i = 0; i < lengthOfText - 1; i++) {
            String temp = longestCommonPrefix(suffixList.get(i), suffixList.get(i + 1));
            if (temp.length() > longestRepeatedString.length()) {
                longestRepeatedString = temp;
            }
        }
        return longestRepeatedString;


    }

    public static void main(String[] args) {
        System.out.println(longestRepeatedSubstring("hellohellouhellojdjehello"));
    }
}
