package com.leetcode.innings2023.hard;

import com.leetcode.innings2023.model.TreeNode;

public class _124_BinaryTreeMaximumPath {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        pathSum(root);
        return maxSum;
    }
    private int pathSum(TreeNode root) {
        if(root == null){
            return 0;//4035620337532002
        }

        int leftSum = pathSum(root.left);
        int rightSum = pathSum(root.right);
        int localMaxSum =  Math.max(leftSum, rightSum) + root.val;

        maxSum = Math.max(maxSum, root.val);
        maxSum = Math.max(maxSum, localMaxSum);
        maxSum = Math.max(maxSum, rightSum + leftSum + root.val);
        return Math.max(localMaxSum, root.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(9, new TreeNode(6), new TreeNode(-3));

        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(2);

        root.right.right.left = new TreeNode(2);

        root.right.right.left.left = new TreeNode(-6, new TreeNode(-6), null);
        root.right.right.left.right = new TreeNode(-6);

        System.out.println(new _124_BinaryTreeMaximumPath().maxPathSum(root));
    }
}


// mar 74
// april 100


// 2L - 1.5L
// 50k
// 4.5L - 2L - 

// 50k

// july 70k

// 80k
