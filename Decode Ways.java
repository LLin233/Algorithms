import java.util.*;
/**
*   A message containing letters from A-Z is being encoded to numbers using the following mapping:

    'A' -> 1
    'B' -> 2
    ...
    'Z' -> 26
    Given an encoded message containing digits, determine the total number of ways to decode it.
    For example,
    Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).
    The number of ways decoding "12" is 2.
*
*/

public class Solution {
    public int numDecodings(String s) {
        if(s.length() < 1) {
            return 0;
        }
        if(s.charAt(0) == '0') {
            return 0;
        }

        int[] sum = new int[s.length() + 1];
        sum[0] = 1;
        sum[1] = 1;

        for(int i = 2; i <= s.length(); i++) {
            if(s.charAt(i - 1) != '0') {
                sum[i] = sum[i - 1];
            }
            if(s.charAt(i - 2) != '0') {
                int val = Integer.parseInt(s.substring(i - 2, i));
                if(val > 0 && val <= 26) {
                    sum[i] += sum[i - 2];
                }
            }
        }
        return sum[s.length()];
    }
}
