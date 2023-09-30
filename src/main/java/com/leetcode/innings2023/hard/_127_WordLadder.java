package com.leetcode.innings2023.hard;

import java.util.Arrays;
import java.util.List;

public class _127_WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord == null || endWord == null || beginWord.isEmpty() || endWord.isEmpty() || beginWord.equals(endWord)){
            return 0;
        }

        int minCount = Integer.MAX_VALUE;

        for(int i=0;i<wordList.size();i++){
            int count = -1;
            if(isTransformable(beginWord, wordList.get(i))){
                count = 1 + getTransformations(beginWord, new boolean[wordList.size()], i, wordList, endWord);
            }
            minCount = Math.min(minCount, count);
        }
        return minCount;
    }

    private static int getTransformations(String beginWord, boolean[] visited, int k, List<String> wordList, String endWord) {
        if(visited[k]){
            return 0;
        }
        //visited[k] = true;
        int count = -1;
        for(int i=0;i<wordList.size();i++){
            if(i == k){
                continue;
            }
            if(endWord.equals(wordList.get(i))){
                return 0;
            }
            if (isTransformable(beginWord, wordList.get(i))){
                count = 1 + getTransformations(wordList.get(i), visited, i, wordList, endWord);
            }
        }
        return count;
    }

    private static boolean isTransformable(String s1, String s2){
        if(s1.length() != s2.length()) {
            return false;
        }

        int diff = 0;
        for(int i=0;i<s1.length();i++) {
            if(s1.charAt(i) != s2.charAt(i)){
                diff++;
            }
            if(diff > 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String  beginWord = "hit", endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}
