import java.util.*;
/**
*   Write a program to find the n-th ugly number.
*	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
*	Note that 1 is typically treated as an ugly number.
*
*/

/**JAVA**/
public class Solution {
    public int nthUglyNumber(int n) {
        List<Integer> uglyNums = new LinkedList<Integer>();
        uglyNums.add(1);
        int item2 = 0, item3 = 0, item5 = 0;
        int ugly, ugly2, ugly3, ugly5;
        while (uglyNums.size() < n) {
            ugly2 = uglyNums.get(item2) * 2;
            ugly3 = uglyNums.get(item3) * 3;
            ugly5 = uglyNums.get(item5) * 5;
            ugly = Math.min(ugly2, Math.min(ugly3, ugly5));
            if (ugly == ugly2) {
                item2++;
            } 
            if (ugly == ugly3) {
                item3++;
            } 
            if (ugly == ugly5) {
                item5++;
            }
            uglyNums.add(ugly);
        }
        return uglyNums.get(n-1);
    }
}

/**JavaScript**/

/**
 * @param {number} n
 * @return {number}
 */
var nthUglyNumber = function(n) {
    var uglyNums = [];
    var ugly, ugly2, ugly3, ugly5;
    var i2 = 0, i3 = 0; i5 = 0;
    uglyNums.push(1);
    while (uglyNums.length < n) {
        ugly2 = uglyNums[i2] * 2;
        ugly3 = uglyNums[i3] * 3;
        ugly5 = uglyNums[i5] * 5;
        ugly = Math.min(ugly2, Math.min(ugly3, ugly5));
        if (ugly == ugly2) {
            i2++;
        }
        if (ugly == ugly3) {
            i3++;
        }
        if (ugly == ugly5) {
            i5++;
        }
        uglyNums.push(ugly);
    }
    return uglyNums[uglyNums.length -1];
};