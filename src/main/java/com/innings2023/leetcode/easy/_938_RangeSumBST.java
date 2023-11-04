package com.innings2023.leetcode.easy;

import com.innings2023.leetcode.model.TreeNode;

public class _938_RangeSumBST {
    private int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        traverse(root, low, high);
        return sum;
    }

    private void traverse(TreeNode root, int low, int high){
        if(root == null){
            return;
        }

        if(root.val >= low){
            traverse(root.left, low, high);
        }
        sum += root.val >= low && root.val <= high ? root.val :0;

        if(root.val <= high){
            traverse(root.right, low, high);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10, new TreeNode(5), new TreeNode(15));
        root.left.left =  new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        System.out.println(new _938_RangeSumBST().rangeSumBST(root, 7, 15));
    }
}
