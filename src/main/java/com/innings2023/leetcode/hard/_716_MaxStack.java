package com.innings2023.leetcode.hard;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class _716_MaxStack {
//    private static class Node{
//        int val;
//        long order;
//        public Node(int x, long order){
//            this.val = x;
//            this.order = order;
//        }
//    }
//    final PriorityQueue<Node> valPq;
//    final PriorityQueue<Node> orderPq;
//    int order;
//    public _716_MaxStack() {
//        order = 1;
//        valPq = new PriorityQueue<>(Comparator.comparingInt(node -> -node.val));
//        orderPq = new PriorityQueue<>(Comparator.comparingLong(node -> -node.order));
//    }
//
//    public void push(int x) {
//        Node node = new Node(x, this.order++);
//        valPq.offer(node);
//        orderPq.offer(node);
//    }
//
//    public int pop() {
//        Node node = orderPq.poll();
//        valPq.remove(node);
//        return node.val;
//    }
//
//    public int top() {
//        return orderPq.peek().val;
//    }
//
//    public int peekMax() {
//        return valPq.peek().val;
//    }
//
//    public int popMax() {
//        Node node = valPq.poll();
//        orderPq.remove(node);
//        return node.val;
//    }

    private final TreeSet<int[]> value;
    private final TreeSet<int[]> stack;
    private int order;

    public _716_MaxStack() {
        order = 1;
        Comparator<int[]> comp = (a, b) -> a[0] == b[0] ? b[1] - a[1] : b[0] - a[0];
        value = new TreeSet<>(comp);
        stack = new TreeSet<>(comp);
    }

    public void push(int x) {
        value.add(new int[]{x, order});
        stack.add(new int[]{order, x});
        order++;
    }

    public int pop() {
        int[] rem = stack.pollFirst();
        value.remove(new int[]{rem[1], rem[0]});
        return rem[1];
    }

    public int top() {
        return stack.first()[1];
    }

    public int peekMax() {
        return value.first()[0];
    }

    public int popMax() {
        int[] rem = value.pollFirst();
        stack.remove(new int[]{rem[1], rem[0]});
        return rem[0];
    }

    public static void main(String[] args) {
        _716_MaxStack obj = new _716_MaxStack();
         //["MaxStack","push","push","push","top","popMax","top","peekMax","pop","top"]
         // [[],[5],[1],[5],[],[],[],[],[],[]]
        //[null,null,null,null,5,5,1,5,1,5]
        obj.push(5);
        obj.push(1);
        obj.push(5);
        System.out.println(obj.top());
        System.out.println(obj.popMax());
        System.out.println(obj.top());
        System.out.println(obj.peekMax());
        System.out.println(obj.pop());
        System.out.println(obj.top());
        Comparator<int[]> comp = new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] == b[0] ? b[1] - a[1] : b[0] - a[0];
            }
        };
        System.out.println(Integer.parseInt("09"));
    }
}
