package com.innings2023.leetcode.medium;

import com.innings2023.leetcode.model.Node;

import java.util.*;

public class _133_CloneGraph {
    private  Map<Integer, List<Node>> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        buildGraph(node, new HashSet<>());

        Node copy = null;
        Map<Integer, Node> cloneMap = new HashMap<>();
        for(Integer i: map.keySet()){
            Node clone = cloneMap.get(i);
            if(clone == null){
                clone = new Node(i, new ArrayList<>());
                cloneMap.put(i, clone);
            }
            if(copy == null){
                copy = clone;
            }
            for(Node n: map.get(i)) {
                Node neighbour = cloneMap.get(n.val);
                if(neighbour == null){
                    neighbour = new Node(n.val, new ArrayList<>());
                    cloneMap.put(n.val, neighbour);
                }
                clone.neighbors.add(neighbour);
            }
        }
        return copy;
    }

    private void buildGraph(Node node, Set<Integer> visited){
        if(visited.contains(node.val)){
            return;
        }

        visited.add(node.val);
        map.put(node.val, node.neighbors);
        for(Node n: node.neighbors){
            buildGraph(n, visited);
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node4.neighbors = Arrays.asList(node, node3);
        System.out.println(new _133_CloneGraph().cloneGraph(node));
    }
}
