import java.util.*;
/**
*  Given a list of non negative integers, arrange them such that they form the largest number.
*	For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
*	Note: The result may be very large, so you need to return a string instead of an integer.
*
*/

public class Solution {
    public String largestNumber(int[] num) {
        if (num == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int n1: num) {
            list.add(n1);
        }
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2) {
                String s1 = "" + o1 + o2;
                String s2 = "" + o2 + o1;
                return s2.compareTo(s1);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int n: list) {
            sb.append(n);
        }
        if (sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}