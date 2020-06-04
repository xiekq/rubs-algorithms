package com.xieqq.rubsAlgorithms.leetcode.learn.binaryTree;

/**
 * 求解树的深度
 */
public class SolutionMaxDepth {
    public int maxDepth(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int maxDepth = Math.max(leftDepth, rightDepth) + 1;
        return maxDepth;
    }
}
