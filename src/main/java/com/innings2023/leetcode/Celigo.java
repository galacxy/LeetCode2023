package com.innings2023.leetcode;

import java.util.*;

public class Celigo {


    //Return all node values on a given depth in a binary tree
    // Given is target tdepth, root


    private static class Node {
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }
    public List<Integer> getDepthKNodes(Node root, int depth){
        List<Integer> list = new ArrayList<>();
        //    1
        //  2  3
        // 4    6
        // depth = 1
//        traverseTree(root, depth, list);

        Queue<Node> q = new LinkedList<>(); // 1 null
        q.offer(root);
        q.offer(null);
        while(!q.isEmpty()){
            Node temp = q.poll();
            if (temp == null){
                depth--;
                if(q.size() > 1){
                    q.offer(null); // marks the level completion
                }
            } else {
                if(depth == 0){
                    list.add(temp.val);
                } else {
                    if(temp.left != null){
                        q.offer(temp.left);
                    }
                    if(temp.right != null){
                        q.offer(temp.right);
                    }
                }
            }
        }

        return list;
    }

    private void traverseTree(Node root, int depth, List<Integer> list) {
        if(root == null || depth < 0){
            return;
        }
        if(depth == 0){
            list.add(root.val);
        } else {
            traverseTree(root.left, depth - 1, list);
            traverseTree(root.right, depth - 1, list);
        }
    }


}
