package com.xieqq.rubsAlgorithms.leetcode.learn.binaryTree;

public class SolutionSymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (null == root) {
            return true;
        }
        return checkSymmetric(root.left, root.right);
    }


    public boolean checkSymmetric(TreeNode lRoot, TreeNode rRoot) {
        if ((lRoot == null && rRoot != null) || (lRoot != null && rRoot == null)) {
            return false;
        }
        if (lRoot == null && rRoot == null) {
            return true;
        } else if (lRoot != null && rRoot != null) {
            return (lRoot.val == rRoot.val) && checkSymmetric(lRoot.left, rRoot.right) && checkSymmetric(lRoot.right, rRoot.left);

        } else {
            return false;
        }
    }

}
