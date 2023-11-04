package com.innings2023.leetcode.medium;

import com.innings2023.leetcode.model.ListNode;
import com.innings2023.leetcode.util.Utility;

public class _2_AddTwoNumvers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null){           
            return l1;
        }

        if(l2 == null){
            return l2;
        }

        ListNode head = null, node = null;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = carry + l1.val + l2.val;
            carry = sum/10;
            ListNode ptr = new ListNode(sum%10);
            if(head == null){
                head = node = ptr;
            } else {
                node.next = ptr;
                node = ptr;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int sum = carry + l1.val;
            carry = sum/10;
            ListNode ptr = new ListNode(sum%10);
            node.next = ptr;
            node = ptr;
            l1 = l1.next;
        }

        while(l2 != null){
            int sum = carry + l2.val;
            carry = sum/10;
            ListNode ptr = new ListNode(sum%10);
            node.next = ptr;
            node = ptr;
            l2 = l2.next;
        }

        if (carry > 0){
            ListNode ptr = new ListNode(carry);
            node.next = ptr;
            node = ptr;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = Utility.buildList(new int[]{2,4,3});
        ListNode l2 = Utility.buildList(new int[]{5,6,4});
        Utility.printList(addTwoNumbers(l1, l2));
    }
}
