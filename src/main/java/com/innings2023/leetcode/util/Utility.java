package com.leetcode.innings2023.util;

import com.leetcode.innings2023.model.ListNode;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;



@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Utility {

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode buildList(int[] nums){
        ListNode head = new ListNode(nums[0]);
        ListNode ptr = head;
        for(int i=1;i < nums.length ;i++){
            ptr.next = new ListNode(nums[i]);
            ptr = ptr.next;
        }
        return head;
    }
    
}
