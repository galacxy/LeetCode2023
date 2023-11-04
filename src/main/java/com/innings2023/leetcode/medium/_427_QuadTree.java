package com.innings2023.leetcode.medium;

public class _427_QuadTree {

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

    public Node construct(int[][] grid) {
        if (grid == null || grid.length == 0){
            return null;
        }
        int n = grid.length;
        return constructTree(grid, 0, 0, n);
    }


    public Node constructTree(int[][] grid, int m, int n, int len){
        Node root;
        if (len == 1){
            root = new Node(grid[m][n] == 1,    true);
            return root;
        }

        Node topLeft = constructTree(grid, m, n, len/2);
        Node topRight = constructTree(grid, m, n+len/2, len/2);
        Node bottomLeft = constructTree(grid, m+len/2, n, len/2);
        Node bottomRight = constructTree(grid, m+len/2, n+len/2,len/2);
        if (topLeft != null && topRight != null && bottomRight != null && bottomLeft != null &
            topLeft.val == topRight.val && topRight.val == bottomRight.val && bottomRight.val == bottomLeft.val) {
            root = new Node(topLeft.val, true);
        } else {
//            int val = topLeft != null ? topLeft.val : topRight != null ? topRight.val
            root = new Node(topLeft.val, false, topLeft, topRight, bottomLeft, bottomRight);
        }
        return root;
    }

    public static void main(String[] args) {
//        int[][] grid = {{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,1,1,1,1},{1,1,1,1,1,1,1,1},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0},{1,1,1,1,0,0,0,0}};
        int[][] grid = {{1,1,0,0},{0,0,1,1},{1,1,0,0},{0,0,1,1}};
//        int[][] grid = {{0,1},{1, 0}};
        Node root = new _427_QuadTree().construct(grid);
        new _427_QuadTree().print(root);
    }

    private void print(Node root){
        if (root == null){
            System.out.print("[" + null + "]");
            return;
        }
        System.out.print("[" + (root.isLeaf?1:0) + "," + " " + (root.val?1:0) + "]");
        if (!root.isLeaf){
            print(root.topLeft);
            print(root.topRight);
            print(root.bottomLeft);
            print(root.bottomRight);
        }
    }
}
