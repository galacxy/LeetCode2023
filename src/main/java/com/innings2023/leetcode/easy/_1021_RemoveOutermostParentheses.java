package com.leetcode.innings2023.easy;

import java.util.Stack;

public class _1021_RemoveOutermostParentheses {
    public String removeOuterParentheses(String s) {
        if(s == null || s.isEmpty()){
            return "";
        }
        int open = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()){
            if (c == '(') {
                if(open > 0) {
                    sb.append(c);
                }
                open++;
            } else if (c == ')'){
                if(open > 1) {
                    sb.append(c);
                }
                open--;
            }
        }
        return sb.toString();
    }
}
