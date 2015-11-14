import java.util.*;
/**
*   Given preorder and inorder traversal of a tree, construct the binary tree.

    Note:
    You may assume that duplicates do not exist in the tree.
*
*/

public class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int preStart = 0;
        int preEnd = preorder.length - 1;
        int inStart = 0;
        int inEnd = inorder.length - 1;
        return buildTree(preStart, preEnd, preorder, inStart, inEnd, inorder);
    }

    private TreeNode buildTree(int preStart, int preEnd, int[] preorder, int inStart, int inEnd, int[] inorder) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        TreeNode root = new TreeNode(rootVal);
        int index = 0;
        for(int i = inStart; i < inorder.length; i++) {
            if(inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        root.left = buildTree(preStart + 1, preStart + (index - inStart), preorder, inStart, index - 1, inorder);
        root.right = buildTree(preStart + (index - inStart) + 1, preEnd, preorder, index + 1, inEnd, inorder);
        return root;
    }
}
