/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        flatten(root, null);
    }
    private static TreeNode flatten(TreeNode root, TreeNode tail) {
        if (root == null) return tail;

        root.right = flatten(root.left, flatten(root.right, tail));
        root.left = null;
        return root;
    }
}