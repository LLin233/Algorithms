import java.util.*;
/**
*  Given a set of distinct integers, nums, return all possible subsets.
*Note:
*Elements in a subset must be in non-descending order.
*The solution set must not contain duplicate subsets.
*For example,
*If nums = [1,2,3], a solution is:
*
*[
*  [3],
*  [1],
*  [2],
*  [1,2,3],
*  [1,3],
*  [2,3],
*  [1,2],
*  []
*]
*
*
*/

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (S == null || S.length == 0) {
            return result;
        }
        Arrays.sort(S);
        helper(result, new ArrayList<Integer>(), S, 0);
        return result;
    }
    private void helper(List<List<Integer>> answer, List<Integer> path, int[] S, int position) {
        answer.add(new ArrayList<Integer>(path));
        for (int i = position; i < S.length; i++) {
            path.add(S[i]);
            helper(answer, path, S, i + 1);
            path.remove(path.size() - 1);
            }
        }
    }
