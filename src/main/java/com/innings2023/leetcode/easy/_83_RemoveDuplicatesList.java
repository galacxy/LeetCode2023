package com.innings2023.leetcode.easy;

import com.innings2023.leetcode.model.ListNode;

public class _83_RemoveDuplicatesList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ptr = head, prev = null;

        while(ptr != null){
            while(prev != null && prev.val == ptr.val){
                prev.next = ptr.next;
            }
            prev = ptr;
            ptr = ptr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        
    }
}
