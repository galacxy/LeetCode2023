package com.innings2023.leetcode.medium;

import com.innings2023.leetcode.model.DListNode;

import java.util.function.Function;

public class _1472_BrowsingHistory {
    DListNode<String> history;
    public _1472_BrowsingHistory(String homepage) {
        this.history = new DListNode<>(homepage);
    }

    public void visit(String url) {
        DListNode<String> newNode = new DListNode<>(url);
        newNode.prev = this.history;
        this.history.next = newNode;
        this.history = newNode;
    }

    public String back(int steps) {
        return traverse((node) -> node.prev, steps);
    }

    public String forward(int steps) {
        return traverse((node) -> node.next, steps);
    }

    private String traverse(Function<DListNode<String>, DListNode<String>> function, int steps){
        if (this.history == null){
            return null;
        }
        DListNode<String> current = null;
        while (this.history != null && steps-- > 0){
            current =  this.history;
            this.history = function.apply(this.history);
        }
        if (this.history == null){
            this.history = current;
        }

        return this.history.val;
    }

    public static void main(String[] args) {
        //["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
        //[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
        _1472_BrowsingHistory history = new _1472_BrowsingHistory("leetcode.com");
        history.visit("google.com");
        history.visit("facebook.com");
        history.visit("youtube.com");
        System.out.println(history.back(1));
        System.out.println(history.back(1));
        System.out.println(history.forward(1));
        history.visit("linkedin.com");
        System.out.println(history.forward(2));
        System.out.println(history.back(2));
        System.out.println(history.back(7));
    }
}
