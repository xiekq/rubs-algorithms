package com.xieqq.rubsAlgorithms.leetcode.learn.binaryTree;

import com.xieqq.rubsAlgorithms.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 构种一二叉树，根据中序遍历和后序遍历后的列表。
 */
public class SolutionConsturtFromInorderAndPostorder {

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder.length == 0) {
            return null;
        }

        if (postorder.length == 1) {
            return new TreeNode(postorder[0]);
        }

        int midVal = postorder[postorder.length - 1];
        TreeNode midNode = new TreeNode(midVal);

        int midIndex = 0;
        while (inorder[midIndex] != midVal) {
            midIndex++;
        }

        if (midIndex > 0) {
            int[] inorderLeft = new int[midIndex];
            int[] postorderLeft = new int[midIndex];
            for (int i = 0; i < midIndex; i++) {
                inorderLeft[i] = inorder[i];
                postorderLeft[i] = postorder[i];
            }
            midNode.left = buildTree(inorderLeft, postorderLeft);
        }

        if (midIndex < inorder.length - 1) {
            int[] inorderRight = new int[inorder.length - 1 - midIndex];
            int[] postorderRight = new int[inorder.length - 1 - midIndex];
            for (int i = 0; i < inorderRight.length; i++) {
                inorderRight[i] = inorder[midIndex + 1];
                postorderRight[i] = postorder[midIndex];
                midIndex++;
            }
            midNode.right = buildTree(inorderRight, postorderRight);
        }
        return midNode;
    }

    public static void main(String[] args) {
        SolutionConsturtFromInorderAndPostorder consturtFromInorderAndPostorder = new SolutionConsturtFromInorderAndPostorder();
//        int[] inorder = new int[]{9,3,15,20,7};
//        int[] postorder = new int[]{9,15,7,20,3};

        int[] inorder = new int[]{1, 4, 7, 2, 6, 5, 3, 8};
        int[] postorder = new int[]{1, 7, 2, 4, 5, 8, 3, 6};


        TreeNode root = consturtFromInorderAndPostorder.buildTree(inorder, postorder);
        StdOut.println(root.val);
    }

}
