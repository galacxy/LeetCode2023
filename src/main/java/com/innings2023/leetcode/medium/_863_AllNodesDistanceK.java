package com.innings2023.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import com.innings2023.leetcode.model.TreeNode;

public class _863_AllNodesDistanceK {
    int targetLevel = -1;
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        Deque<TreeNode> path = new ArrayDeque<>();
        findPath(root, target, path);
        target = path.pop();
        distanceKDown(target, k, ans);
        k--;
        while (!path.isEmpty() && k >= 0){
            TreeNode node = path.pop();
            if(k == 0) {
                ans.add(node.val);
                k--;
            } else if(node.left == target) {
                distanceKDown(node.right, --k, ans);
            } else {
                distanceKDown(node.left, --k, ans);
            }
            target = node;
        }


        return ans;
    }

    private void populateKDistant(TreeNode root, TreeNode target, int currentLevel, int k, List<Integer> ans){
        if(root == null || root == target || currentLevel > targetLevel){
            return;
        }

        if(currentLevel < targetLevel){
            populateKDistant(root.left, target, currentLevel+1, k, ans);
            populateKDistant(root.right, target, currentLevel+1, k, ans);
        } else {
            distanceKDown(root, targetLevel - currentLevel, ans);
        }
    }

    private void findPath(TreeNode root, TreeNode target, Deque<TreeNode> path){
        if(root == null){
            return;
        }
        path.push(root);
        if(path.peek() != target) {
            findPath(root.left, target, path);
        }
        if(path.peek() != target) {
            findPath(root.right, target, path);
        }
        if(path.peek() != target) {
            path.pop();
        }
    }

    private void findTargetLevel(TreeNode root, TreeNode target, int level){
        if(root == null){
            return;
        }

        if(root == target){
            targetLevel = level;
            return;
        }

        findTargetLevel(root.left, target, level+1);
        if(targetLevel == -1) {
            findTargetLevel(root.right, target, level+1);
        }
    }

    public void distanceKDown(TreeNode root, int k, List<Integer> ans){
        if(root == null){
            return;
        }

        if(k == 0){
            ans.add(root.val);
        } else {
            distanceKDown(root.left, k-1, ans);
            distanceKDown(root.right, k-1, ans);
        }
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2)), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
//        root.left.right.left = new TreeNode(7);
//        root.left.right.right = new TreeNode(4);
        TreeNode root = new TreeNode(0, new TreeNode(1), null);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        System.out.println(new _863_AllNodesDistanceK().distanceK(root, root.left.right, 1));
    }
}
