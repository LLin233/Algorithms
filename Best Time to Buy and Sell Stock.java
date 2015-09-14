import java.util.*;
/**
*   Say you have an array for which the ith element is the price of a given stock on day i.
*	If you were only permitted to complete at most one transaction 
*	(ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*
*/

public class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            max = Math.max(prices[i] - min, max);
            min = Math.min(min, prices[i]);
        }
        return Math.max(0, max);
    }
}