package com.innings2023.leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class _210_CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans;

        if(prerequisites == null || prerequisites.length == 0){
            ans = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                ans[i] = i;
            }
            return ans;
        }

        Deque<Integer> courses = new ArrayDeque<>();
        Deque<Integer> q = new ArrayDeque<>();
        List<List<Integer>> adj = buildGraph(numCourses, prerequisites);

        int[] inDegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            inDegree[prerequisites[i][0]]++;            
        }

        int[] inDegree2 = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            inDegree2[i] = adj.get(i).size();            
        }

        for(int i=0;i<numCourses;i++){
            if(inDegree[i] == 0){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int v = q.poll();
            courses.offer(v);
            for(int i:adj.get(v)){
                if(--inDegree[i] == 0){
                    q.offer(i);
                }
            }
        }

        if (courses.size() == numCourses){
            int  k = 0;
            ans = new int[numCourses];
            while(!courses.isEmpty()){
                ans[k++] = courses.poll();
            }
        } else {
            ans = new int[0];
        }

       
        
        return ans;
    }

    public static int[] findOrderDFS(int numCourses, int[][] prerequisites) {
        int[] ans;

        if(prerequisites == null || prerequisites.length == 0){
            ans = new int[numCourses];
            for(int i=0;i<numCourses;i++){
                ans[i] = i;
            }
            return ans;
        }

        boolean[] visited = new boolean[numCourses];
        Deque<Integer> courses = new ArrayDeque<>();
        List<List<Integer>> graph = buildGraphDFS(numCourses, prerequisites);

        for(int i=0;i<numCourses;i++){
            boolean[] visiting = new boolean[numCourses];
            if(!dfs(graph, visited, visiting, courses, i)){
                return new int[0];
            }
        }

        if (courses.size() == numCourses){
            int  k = 0;
            ans = new int[numCourses];
            while(!courses.isEmpty()){
                ans[k++] = courses.poll();
            }
        } else {
            ans = new int[0];
        }
        return ans;
    }

    private static boolean dfs(List<List<Integer>> graph, boolean[] visited, boolean[] visiting, Deque<Integer> courses, int current){
        if(visited[current]){
            return true;
        }

        if(visiting[current]){
            return false;
        }
        
        visiting[current] = true;
        for(int j:graph.get(current)){
            if(!dfs(graph, visited, visiting, courses, j)){
                return false;
            }
        }
        visited[current] = true;
        courses.offer(current);
        return true;
    }

    private static List<List<Integer>> buildGraphDFS(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            graph.get(pre[0]).add(pre[1]);
        }
        return graph;
    }

    private static List<List<Integer>> buildGraph(int numCourses, int[][] prerequisites){
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre: prerequisites){
            graph.get(pre[1]).add(pre[0]);
        }
        return graph;
    }


    public static void main(String[] args) {
        int numCourses = 3;
        // int[][] prerequisites = {{1,0},{2,0},{3,1},{0,2}};
        // int[][] prerequisites = {{0,1}};
        int[][] prerequisites = {{0,1},{0,2},{1,2}};
        System.out.println(Arrays.toString(findOrderDFS(numCourses, prerequisites)));
    }
}
