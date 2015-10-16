import java.util.*;
/**
**   Implement atoi to convert a string to an integer.
*Requirements for atoi:
*The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
*Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
*The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
*If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
*If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*
*/

public class Solution {
    public int myAtoi(String str) {
        if(str == null || str.length() == 0) {
            return 0;
        }

        boolean neg = false;
        double result = 0;
        int i = 0;
        str = str.trim();

        if(str.charAt(i) == '-' || str.charAt(i) == '+') {
            if(str.charAt(i++) == '-') {
                neg = true;
            }
        }

        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i++) - '0');
        }

        if(neg) {
            result = -result;
        }

        if(result >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if(result <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return (int) result;
        }
    }
}