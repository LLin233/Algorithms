import java.util.*;
/**
*   Binary Tree Postorder Traversal Total Accepted: 69087 Total Submissions: 211569 My Submissions Question Solution 
*	Given a binary tree, return the postorder traversal of its nodes' values.
*	For example:
*	Given binary tree {1,#,2,3},
*   1
*	\
*    2
*    /
*   3
*	return [3,2,1].
*
*	Note: Recursive solution is trivial, could you do it iteratively?
*
*/

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     List<Integer> result = new ArrayList<Integer>();
    //     if (root == null) {
    //         return result;
    //     }
    //     postorderTraversal(root, result);
    //     return result;
    // }
    // private void postorderTraversal(TreeNode root, List<Integer> result) {
    //     if (root == null) {
    //         return;
    //     }
    //     postorderTraversal(root.left, result);
    //     postorderTraversal(root.right, result);
    //     result.add(root.val);
    // }
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<Integer>();
            if (root == null) {
                return result;
            }
            Stack<TreeNode> left = new Stack<TreeNode>();
            Stack<TreeNode> right = new Stack<TreeNode>();
            TreeNode cur;
            left.push(root);
            while (!left.isEmpty()) {
                cur = left.pop();
                right.push(cur);
                if (cur.left != null) {
                    left.push(cur.left);
                }
                if (cur.right != null) {
                    left.push(cur.right);
                }
            }
            while (!right.isEmpty()) {
                result.add(right.pop().val);
            }
            return result;
    }
}