package com.leetcode.innings2023.medium;

import java.util.LinkedList;
import java.util.Queue;

import com.leetcode.innings2023.model.TreeNode;

public class _662_MaxWidthBinaryTree {
    private static final int DUMMY = Integer.MIN_VALUE;

    private int minLevel = 0;
    private int maxLevel = 0;

    private static class Node {
        TreeNode treeNode;
        int col;
        public Node(TreeNode node, int col){
            this.col = col;
            this.treeNode = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        // q.offer(new TreeNode(DUMMY));

        int maxWidth = Integer.MIN_VALUE;

        while(!q.isEmpty()){
            // TreeNode node = q.poll();
            // if (node.val == DUMMY){
            //     maxWidth = Math.max(maxWidth, width);
            //     width = 0;
            //     if(q.size() > 0){
            //         q.offer(new TreeNode(DUMMY));
            //     }
            // } else {
            //     q.offer(node.left);
            //     q.offer(node.right);
            //     width++;
            // }
            Node node = q.peek();
            int size = q.size();
            Node current = null;
            for(int i=0;i<size;i++){
                current = q.poll();
                if(current.treeNode.left != null){
                    q.offer(new Node(current.treeNode.left, 2*current.col));
                }
                if(current.treeNode.right != null){
                    q.offer(new Node(current.treeNode.right, 2*current.col+1));
                }
            }
            maxWidth = Math.max(maxWidth, current.col - node.col + 1);
        }

        return maxWidth;
        // getRange(root, 0);
        // return maxLevel - minLevel - 1;
    }

    private void getRange(TreeNode root, int level){
        if(root == null){
            return;
        }

        minLevel = Math.min(minLevel, level);
        maxLevel = Math.max(maxLevel, level);

        if(root.left != null){
            getRange(root.left, 2*level+1);
        }
        if (root.right != null){
            getRange(root.right, 2*level+2);
        }
    }

    private int getHeight(TreeNode root){
        return root == null ? 0 : 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }

    public int widthOfBinaryTree2(TreeNode root) {
        if(root == null){
            return 0;
        }

        TreeNode[] arr = generateArray(root);
        int level = 0;
        int start = 0;
        int width = 1;
        int end = start + width - 1;
        int max = Integer.MIN_VALUE;

        while(end < arr.length){
            int i = start;
            while(arr[i] == null && i < arr.length){
                i++;
            }
            int j = end;
            while(arr[j] == null && j >= 0){
                j--;
            }
            max = Math.max(max, j-i+1);
            level++;
            start = (int)Math.pow(2,level) - 1;
            width *= 2;
            end = start + width - 1;
        }
        return max;
    }

    private TreeNode[] generateArray(TreeNode root){
        int h = getHeight(root);
        TreeNode[] arr = new TreeNode[(int)Math.pow(2, h) - 1];
        arr[0] = root;
        for(int i=0;i<arr.length/2;i++){
            if(arr[i] == null){
                continue;
            }
            if(arr[i].left != null){
                arr[2*i+1] = arr[i].left;
            }
            if(arr[i].right != null){
                arr[2*i+2] = arr[i].right;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        root.left.left = new TreeNode(5, new TreeNode(6), null);
        root.right.right = new TreeNode(9, new TreeNode(7), null);
        System.out.println(new _662_MaxWidthBinaryTree().widthOfBinaryTree(root));
    }
}
