import java.util.*;
/**
*   Given two numbers represented as strings, return multiplication of the numbers as a string.
*   Note: The numbers can be arbitrarily large and are non-negative.
*
*/

public class Solution {
    public String multiply(String num1, String num2) {
        String n1 = new StringBuilder(num1).reverse().toString();
        String n2 = new StringBuilder(num2).reverse().toString();

        int[] val = new int[n1.length() + n2.length()];
        for(int i = 0; i < n1.length(); i++) {
            for(int j = 0; j < n2.length(); j++) {
                val[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }

        StringBuilder rst = new StringBuilder();
        int value, carry;
        for(int i = 0; i < val.length; i++) {
            value = val[i] % 10;
            carry = val[i] / 10;
            rst.insert(0, value);
            if(i + 1 < val.length) {
                val[i + 1] += carry;
            }
        }
        while(rst.charAt(0) == '0' && rst.length() > 1) {
            rst.deleteCharAt(0);
        }
        return rst.toString();
    }
}
