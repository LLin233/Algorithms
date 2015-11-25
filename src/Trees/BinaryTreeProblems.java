package Trees;

/**
 * Created by Le on 2015/11/24.
 */
public class BinaryTreeProblems {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * Maximum Depth of Binary Tree
     * {https://leetcode.com/problems/maximum-depth-of-binary-tree/}
     * Given a binary tree, find its maximum depth.
     * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
     * O(n)
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;
    }

    /**
     * Balanced Binary Tree
     * {https://leetcode.com/problems/balanced-binary-tree/}
     * Given a binary tree, determine if it is height-balanced.
     * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
     * base on the definition, a binary tree is not balanced if
     * left child is not balanced
     * right child is not balanced
     * depth of the two subtrees of every node never differ by more than 1.
     *
     * @see BinaryTreeProblems#maxDepth(TreeNode)
     * <p>
     * O(n) runtime, O(n) stack space – Bottom-up recursion:
     * It seems that the above approach is recalculating max depth repeatedly for each node. We
     * could avoid the recalculation by passing the depth bottom-up. We use a sentinel value –1
     * to represent that the tree is unbalanced so we could avoid unnecessary calculations.
     * In each step, we look at the left subtree’s depth (L), and ask: “Is the left subtree
     * unbalanced?” If it is indeed unbalanced, we return –1 right away. Otherwise, L represents
     * the left subtree’s depth. We then repeat the same process for the right subtree’s depth (R).
     * We calculate the absolute difference between L and R. If the subtrees’ depth difference is
     * less than one, we could return the height of the current node, otherwise return –1 meaning
     * the current tree is unbalanced.
     */
    public boolean isBalanced(TreeNode root) {
        return maxDepthHelper(root) != -1;
    }

    private int maxDepthHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = maxDepthHelper(root.left);
        int R = maxDepthHelper(root.right);
        if (L == -1 || R == -1 || Math.abs(L - R) > 1) {
            return -1;
        }
        return Math.max(L, R) + 1;
    }

    /**
     * Same Tree
     * {https://leetcode.com/problems/same-tree/}
     * Given two binary trees, write a function to check if they are equal or not.
     * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
     * O(n)
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p != null && q != null) {
            if (p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Binary Tree Maximum Path Sum
     * {https://leetcode.com/problems/binary-tree-maximum-path-sum/}
     * Given a binary tree, find the maximum path sum.
     * For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.
     * For example:
     * Given the below binary tree,
     * 1
     * / \
     * 2   3
     * Return 6.
     *
     * O(n) space O(h)
     */
    public int maxPathSum(TreeNode root) {
        Result result = maxPathSumHelper(root);
        return result.maxPath;
    }

    private Result maxPathSumHelper(TreeNode root) {
        if (root == null) {
            return new Result(0, Integer.MIN_VALUE);
        }
        Result left = maxPathSumHelper(root.left);
        Result right = maxPathSumHelper(root.right);

        int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
        singlePath = Math.max(singlePath, 0); //cut off the path when it is less than 0
        int maxPath = Math.max(left.maxPath, right.maxPath);
        maxPath = Math.max(maxPath, left.singlePath + right.singlePath + root.val); //cross root

        return new Result(singlePath, maxPath);
    }

    class Result {
        int singlePath;
        int maxPath;

        Result(int singlePath, int maxPath) {
            this.singlePath = singlePath;
            this.maxPath = maxPath;
        }
    }


    /**
     * Lowest Common Ancestor of a Binary Tree
     * {https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/}
     * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
     * According to the definition of LCA on Wikipedia:
     * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
     * Worst case O(n)
     */

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode L = lowestCommonAncestor(root.left, p, q);
        TreeNode R = lowestCommonAncestor(root.right, p, q);
        if (L != null && R != null) {
            return root;
        }
        if(L != null) {
            return L;
        }
        if (R != null) {
            return R;
        }
        return null;
    }

    /**
     * what if the binary tree is a BST
     */
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorBST( root.right, p, q);
        } else if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        }
        return root;
    }

}
