import java.util.*;
/**
*	Given a non-negative number represented as an array of digits, plus one to the number.
*	The digits are stored such that the most significant digit is at the head of the list.
*
*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int index = digits.length - 1, carry = 1, sum = 0;
        while (index >= 0 && carry != 0) {
            sum = digits[index] + carry;
            if (sum >= 10) {
                digits[index] = sum % 10;
                carry = 1;
            } else {
                digits[index] = sum;
                carry = 0;
            }
            index--;
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        }
        return digits;
    }
}