package com.innings2023.leetcode.model;

public class DListNode<T> {
        public T val;
        public DListNode<T> next;
        public DListNode<T> prev;
        public DListNode() {}
        public DListNode(T val) { this.val = val; }
        public DListNode(T val, DListNode<T> next) { this.val = val; this.next = next; }
        public DListNode(T val, DListNode<T> next, DListNode<T> prev) { this.val = val; this.next = next; this.prev = prev;}
}