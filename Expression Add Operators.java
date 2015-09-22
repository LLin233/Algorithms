import java.util.*;
/**
*   Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.
*	Examples: 
*	"123", 6 -> ["1+2+3", "1*2*3"] 
*	"232", 8 -> ["2*3+2", "2+3*2"]
*	"105", 5 -> ["1*0+5","10-5"]
*	"00", 0 -> ["0+0", "0-0", "0*0"]
*	"3456237490", 9191 -> []
*
*/

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<String>();
        helper(result, target, num, "", 0, 0);
        return result;
    }
    private void helper(List<String> result, int target, String num, String expression, long val, long back) {
         if (num.equals("") && val == target) {
             result.add(expression);
             return;
         }
         for(int i = 1; i <= num.length(); i++){
             String head = num.substring(0, i);
             String tail = num.substring(i, num.length());
             long currentVal = Long.parseLong(head, 10);
             if (head.length() >= 2 && head.charAt(0) == '0') {
                 return;
             }
             if (expression.equals("")) {
                 helper(result, target, tail, head, currentVal, currentVal);
             } else {
                 helper(result, target, tail, expression + "+" + head, val + currentVal, currentVal); // +
                 helper(result, target, tail, expression + "-" + head, val - currentVal, -1 * currentVal); //-
                 helper(result, target, tail, expression + "*" + head, val - back + back * currentVal, back * currentVal); //*
             }
         }
    }
}


/***
*	每一轮都要拿一位，拿两位...直到最后(1+2+3+4, 12+3+4, 123+4)，每个数都要试三种符号。

麻烦的是四则运算有优先级，如果之前是加法(2+3)，再碰到乘法的话(2+3*2)需要回退。

开一个back的变量记录需要回退的数，分三种符号来处理。

1.加法(1+2，之前的val是1, 这一轮做+2)，如果之后碰到乘法，需要回退当前的数(2)。

2.减法(1-2，之前的val是1, 这一轮做-2)，如果之后碰到乘法，需要回退当前的数的相反数(-2)。

3.乘法(1+2*3*4，之前的val是1+2*3=7, 这一轮做*4)，需要回退的数是上一轮传过来的(2*3)再*4，这一轮的val是7 - (2*3) + (2*3) * 4。

最后还要注意去掉以0开始的大于两位的数。
*/