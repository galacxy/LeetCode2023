package com.leetcode.innings2023.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _1136_ParallelCourses {
    public int minimumSemesters(int n, int[][] relations) {
        int count = 0;

        Map<Integer, List<Integer>> graph = buildGraph(n, relations);
        Map<Integer, Integer> indegree = new HashMap<>();

        for(int i=1;i<=n;i++){
            indegree.put(i, indegree.getOrDefault(i, 0));
            for(int j:graph.get(i)){
                indegree.put(j, indegree.getOrDefault(j,0) + 1);
            }
        }

        Deque<Integer> q = new ArrayDeque<>();
        Deque<Integer> courses = new ArrayDeque<>();

        for(int i=1;i<n;i++){
            if(indegree.get(i) == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int s = q.size();
            while(s-- > 0){
                int c = q.poll();
                courses.push(c);
                if(graph.containsKey(c)){
                    for(int d : graph.get(c)){
                        indegree.put(d, indegree.get(d) - 1);
                        if(indegree.get(d) == 0){
                            q.offer(d);
                        }
                    }
                }
            }
            count++;
        }

        if(n != courses.size()){
            return -1;
        } else {
            return count;
        }        
    }

    private Map<Integer, List<Integer>> buildGraph(int n, int[][] relations){
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=1;i<=n;i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] rel: relations){
            graph.get(rel[0]).add(rel[1]);
        }
        return graph;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] relations = {{1,3},{2,3}};

        System.out.println(new _1136_ParallelCourses().minimumSemesters(n, relations));
    }
}
