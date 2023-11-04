package com.leetcode.innings2023.medium;

import java.util.LinkedHashMap;
import java.util.Map;

import com.leetcode.innings2023.model.ListNode;
import com.leetcode.innings2023.util.Utility;


public class _82_RemoveDuplicatesII {

    
    private static class Node{
        public ListNode ptr;
        public int count;
        public Node(int count, ListNode ptr){
            this.ptr = ptr;
            this.count = count;
        }
    }


    public static ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        Map<Integer, Node> map = new LinkedHashMap<>();
        ListNode ptr = head;

        while(ptr != null){
            Node node = map.get(ptr.val);
            if (node == null){
                node = new Node(1, ptr);
            } else {
                node.count++;
            }
            map.put(ptr.val, node);
            ptr = ptr.next;
        }

        ListNode newHead = null;

        for(Integer val: map.keySet()){
            Node node = map.get(val);

            if(node.count == 1){
                if(newHead == null){
                    newHead = ptr = node.ptr;
                } else {
                    ptr.next = node.ptr;
                    ptr = ptr.next;
                }
            }
            
            
        }

        if(ptr != null){
            ptr.next = null;
        }

        return newHead;

    }

    public static ListNode deleteDuplicates2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode prev = new ListNode(Integer.MIN_VALUE, head);
        ListNode ptr = head, next = null, dummy = prev;;
        boolean flag = false;
        while(ptr != null){
            next = ptr.next;
            flag = false;
            while(next != null && ptr.val == next.val){
                next = next.next;
                flag = true;
            }
            if(flag){
                prev.next = next;
                ptr = next;
            } else{
                prev = ptr;
                ptr = ptr.next;
            }   
         }
        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode head = Utility.buildList(new int[]{1,1,2,3,5,6});
        Utility.printList(deleteDuplicates2(head));
    }
}


