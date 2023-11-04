package com.innings2023.leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _207_CourseSchedule {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites.length <= 1){
            return true;
        }

    
        List<Integer>[] adj = buildGraph(numCourses, prerequisites);
        Set<Integer> path = new HashSet<>(numCourses);
        for(int i=0;i<numCourses;i++){
            if(isCyclcePresent(i, adj, new boolean[numCourses], path)){
                return false;
            }
        }

        return true;
    }

    private static List<Integer>[] buildGraph(int numCourses, int[][] prerequisites){
        List<Integer>[] adj = new List[numCourses];

        for(int i=0;i<numCourses;i++){
            adj[i] = new ArrayList<>();
        }

        for(int[] pre: prerequisites){
            adj[pre[1]].add(pre[0]);
        }
        return adj;
    }

    private static boolean isCyclcePresent(int i, List<Integer>[] adj, boolean[] visited, Set<Integer> path) {
        if(path.contains(i)){
            return true;
        }
        if(visited[i]){
            return false;
        }

        path.add(i);
        visited[i] = true;

        for(int neighbour:adj[i]){
            if(isCyclcePresent(neighbour, adj, visited, path)){
                return true;
            }
        }

        path.remove(i);

        return false;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{1,0},{0,1}};

        System.out.println(canFinish(numCourses, prerequisites));
    }


}
