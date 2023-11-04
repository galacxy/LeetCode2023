package com.innings2023.leetcode.hard;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _269_AlienDictionary {

    public String alienOrder(String[] words) {
        List<char[]> rules = generateRules(words);
        if(rules == null){
            return "";
        }
        return getTopologicalSorting(generateGraph(rules), words);
    }

    private String getTopologicalSorting(Map<Character, List<Character>> graph, String[] words){
        Map<Character, Integer> inDegrees = new HashMap<>();

        for(String word: words){
            for(char c: word.toCharArray()){
                inDegrees.put(c, 0);
            }
        }

        for(Character c : graph.keySet()){
            List<Character> dependents = graph.get(c);
            for(Character d: dependents){
                inDegrees.put(d, inDegrees.get(d) + 1);
            }
        }

        Deque<Character> queue = new ArrayDeque<>();

        for(Character c: inDegrees.keySet()){
            if(inDegrees.get(c) == 0){
                queue.offer(c);
            }
        }

        Deque<Character> order = new ArrayDeque<>();

        while(!queue.isEmpty()){
            char c = queue.poll();
            order.offer(c);

            if(graph.containsKey(c)){
                for(Character dependent: graph.get(c)){
                    inDegrees.put(dependent, inDegrees.get(dependent) - 1);

                    if(inDegrees.get(dependent) == 0){
                        queue.offer(dependent);
                    }
                }
            }
        }

        if(inDegrees.size() != order.size()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        while(!order.isEmpty()){
            sb.append(order.poll());
        }
        return sb.toString();

    }

    private List<char[]> generateRules(String[] words){
        List<char[]> rules = new ArrayList<>();

        for(int i=0;i<words.length-1;i++){

            if(words[i].length() > words[i+1].length() && words[i].startsWith(words[i+1])){
                return null;
            }
            int j = 0;
            
            while(j < words[i].length() && j < words[i+1].length() && words[i].charAt(j) == words[i+1].charAt(j)){
                j++;
            }

            if(j<words[i].length() && j< words[i+1].length()){
                rules.add(new char[]{words[i].charAt(j), words[i+1].charAt(j)});
            } 
        }
        return rules;
    }

    private Map<Character, List<Character>> generateGraph(List<char[]> rules){
        Map<Character, List<Character>> graph = new HashMap<>();
        for(char[] rule: rules){
            List<Character> dependents = graph.getOrDefault(rule[0], new ArrayList<>());
            dependents.add(rule[1]);
            graph.put(rule[0], dependents);
        }
        return graph;
    }


    public static void main(String[] args) {
        // String[] words = {"wrt","wrf","er","ett","rftt"};
        String[] words = {"zx","xza", "xz"};
        _269_AlienDictionary alienDictionary =  new _269_AlienDictionary();
        System.out.println(alienDictionary.alienOrder(words));
    }
}
