package com.leetcode.innings2023.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import com.leetcode.innings2023.model.TreeNode;

public class _314_VerticalOrderTraversal {
    private static class Node{
        TreeNode treeNode;
        int level;
        public Node(TreeNode treeNode, int level){
            this.level = level;
            this.treeNode = treeNode;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        if(root == null){
            return new ArrayList<>(map.values());
        }

        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(root, 0));

        while(!q.isEmpty()){
            Node node = q.poll();
            List<Integer> list = map.getOrDefault(node.level, new ArrayList<>());
            list.add(node.treeNode.val);
            map.put(node.level, list);
            if(node.treeNode.left != null){
                q.offer(new Node(node.treeNode.left, node.level-1));
            }
            if(node.treeNode.right != null){
                q.offer(new Node(node.treeNode.right, node.level+1));
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(8));
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0, null, new TreeNode(2));

        root.right.left = new TreeNode(1 ,new TreeNode(5), null);
        root.right.right = new TreeNode(7);

        System.out.println(new _314_VerticalOrderTraversal().verticalOrder(root));
        
    }
}
