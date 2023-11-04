package com.innings2023.leetcode.hard;

import com.innings2023.leetcode.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class _23_MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }

        if(lists.length == 1){
            return lists[0];
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode head = pq.poll();
        if(head.next != null){
            pq.offer(head.next);
        }
        head.next = null;
        ListNode ptr = head;
        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            if(node.next != null){
                pq.offer(node.next);
            }
            node.next = null;
            ptr.next = node;
            ptr = node;
        }

        return head;
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0){
            return null;
        }
        if(lists.length == 1){
            return lists[0];
        }

        return helper(lists, 0, lists.length-1);
    }

    private ListNode helper(ListNode[] lists, int i, int j){
        if(i >= j){
            return lists[i];
        }
        int mid = i + (j-1)/2;
        ListNode left = helper(lists, i, mid);
        ListNode right = helper(lists, mid+1, j);
        return mergeListPair(left, right);
    }

    public ListNode mergeListPair(ListNode list1, ListNode list2){
        if (list1 == null && list2 == null){
            return null;
        }

        if (list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if (list1 == list2){
            return list1;
        }

        ListNode head;

        if (list1.val < list2.val){
            head = list1;
            list1 = list1.next;
        } else {
            head = list2;
            list2 = list2.next;
        }

        ListNode ptr = head;

        while(list1 != null && list2 != null){
            if (list1.val < list2.val){
                ptr.next = list1;
                ptr = list1;
                list1 = list1.next;
            } else {
                ptr.next = list2;
                ptr = list2;
                list2 = list2.next;
            }
        }
        ptr.next = list1 != null ? list1 : list2;
        return head;
    }
}
