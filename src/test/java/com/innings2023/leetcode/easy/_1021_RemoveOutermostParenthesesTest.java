package com.leetcode.innings2023.easy;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class _1021_RemoveOutermostParenthesesTest {

    private _1021_RemoveOutermostParentheses removeOutermostParentheses = new _1021_RemoveOutermostParentheses();

    @Test
    public void removeOuterParentheses1() {
        Assert.assertEquals("()()()", removeOutermostParentheses.removeOuterParentheses("(()())(())"));
    }

    @Test
    public void removeOuterParentheses2() {
        Assert.assertEquals("()()()()(())", removeOutermostParentheses.removeOuterParentheses("(()())(())(()(()))"));
    }

    @Test
    public void removeOuterParentheses3() {
        Assert.assertEquals("(()())(()())", removeOutermostParentheses.removeOuterParentheses("((()())(()()))"));
    }

}