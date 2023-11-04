package com.innings2023.leetcode.easy;

import com.innings2023.leetcode.model.ListNode;

import java.util.Stack;

public class _234_PalindromeLL {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        Stack<Integer> s = new Stack<>();
        ListNode slow = head, fast = head;
        while(fast.next != null){
            s.push(slow.val);
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
            } else {
                s.pop();
            }
        }
        while (slow!=null){
            slow = slow.next;
            if(s.pop() != slow.val){
                return false;
            }
        }
        return true;
    }

}
