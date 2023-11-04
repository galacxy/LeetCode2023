package com.innings2023.leetcode.easy;

import org.junit.Test;

import static org.junit.Assert.*;

public class _1021_RemoveOutermostParenthesesTest {

    private _1021_RemoveOutermostParentheses removeOutermostParentheses = new _1021_RemoveOutermostParentheses();

    @Test
    public void removeOuterParentheses1() {
        assertEquals("()()()", removeOutermostParentheses.removeOuterParentheses("(()())(())"));
    }

    @Test
    public void removeOuterParentheses2() {
        assertEquals("()()()()(())", removeOutermostParentheses.removeOuterParentheses("(()())(())(()(()))"));
    }

    @Test
    public void removeOuterParentheses3() {
        assertEquals("(()())(()())", removeOutermostParentheses.removeOuterParentheses("((()())(()()))"));
    }

}