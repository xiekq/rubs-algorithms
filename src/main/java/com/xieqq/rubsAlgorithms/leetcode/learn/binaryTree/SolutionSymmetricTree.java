package com.xieqq.rubsAlgorithms.leetcode.learn.binaryTree;

public class SolutionSymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }


    public boolean isSymmetric(TreeNode lRoot, TreeNode rRoot) {
        if (lRoot == null && rRoot == null) {
            return true;
        }

        if (lRoot != null && rRoot != null && lRoot.val == rRoot.val) {
            return isSymmetric(lRoot.left, rRoot.right) && isSymmetric(lRoot.right, rRoot.left);
        }
        return false;
    }
}
