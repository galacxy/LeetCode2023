package com.innings2023.leetcode.medium;

import java.util.Stack;

public class _1249_MinRemoveValidParentheses {
    public String minRemoveToMakeValid(String s) {
        if(s == null || s.isEmpty()){
            return s;
        }

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '('){
               stack.push(i);
            } else if (c == ')'){
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--) {
            if(stack.isEmpty() || stack.peek() < i){
                sb.append(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new _1249_MinRemoveValidParentheses().minRemoveToMakeValid("))(("));
    }
}
