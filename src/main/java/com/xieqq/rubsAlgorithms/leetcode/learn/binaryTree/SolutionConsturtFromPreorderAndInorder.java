package com.xieqq.rubsAlgorithms.leetcode.learn.binaryTree;

import com.xieqq.rubsAlgorithms.algs4.StdOut;

/**
 * 构种一二叉树，根据前序遍历和中序遍历后的列表。
 */
public class SolutionConsturtFromPreorderAndInorder {
    private int tag;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.tag = 0;
        return buildTree(preorder, inorder, 0, preorder.length);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int lo, int hi) {
        if (lo > hi) {
            return null;
        }

        TreeNode node = null;
        for (int i = lo; i <= hi; ++i) {
            if (inorder[i] == preorder[tag]) {
                node = new TreeNode(preorder[tag++]); //字数根节点
                node.left = buildTree(preorder, inorder, lo, i - 1);
                node.right = buildTree(preorder, inorder, i + 1, hi);
                break;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        SolutionConsturtFromPreorderAndInorder consturtFromInorderAndPostorder = new SolutionConsturtFromPreorderAndInorder();
//        int[] inorder = new int[]{9,3,15,20,7};
//        int[] postorder = new int[]{9,15,7,20,3};

        int[] preorder = new int[]{1, 2, 3};
        int[] inorder = new int[]{2, 3, 1};


        TreeNode root = consturtFromInorderAndPostorder.buildTree(preorder, inorder);
        StdOut.println(root.val);
    }

}
