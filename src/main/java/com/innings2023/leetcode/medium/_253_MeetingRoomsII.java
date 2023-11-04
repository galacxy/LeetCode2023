package com.leetcode.innings2023.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class _253_MeetingRoomsII {
    public int minMeetingRooms(int[][] intervals) {
        if(intervals == null || intervals.length == 0){
            return 0;
        }
        int count = 1;
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] current : intervals) {
            if (!pq.isEmpty() && pq.peek()[1] <= current[0]) {
                pq.poll();
            }
            pq.offer(current);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{4,9},{4, 17}, {9,10}};
        System.out.println(new _253_MeetingRoomsII().minMeetingRooms(intervals));
    }
}
