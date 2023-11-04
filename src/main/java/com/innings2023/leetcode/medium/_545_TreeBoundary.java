package com.innings2023.leetcode.medium;

import com.innings2023.leetcode.model.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _545_TreeBoundary {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        ans.add(root.val);
        List<Integer> list = new ArrayList<>();

        getLeftBoundary(root.left, list);
        ans.addAll(list);

        list.clear();
        getBottomBoundary(root.left, list);
        getBottomBoundary(root.right, list);
        ans.addAll(list);

        list.clear();
        getRightBoundary(root.right, list);
        Collections.reverse(list);
        ans.addAll(list);
        return ans;
    }

    private void getBottomBoundary(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }

        if(root.left == null && root.right == null){
            list.add(root.val);
        }
        getBottomBoundary(root.left, list);
        getBottomBoundary(root.right, list);
    }

    private void getRightBoundary(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        if (root.left != null || root.right != null){
            list.add(root.val);
        }
        if(root.right != null){
            getRightBoundary(root.right, list);
        } else {
            getRightBoundary(root.left, list);
        }
    }

    private void getLeftBoundary(TreeNode root, List<Integer> list) {
        if(root == null){
            return;
        }
        if (root.left != null || root.right != null){
            list.add(root.val);
        }
        if(root.left != null){
            getLeftBoundary(root.left, list);
        } else {
            getLeftBoundary(root.right, list);
        }
    }
}
