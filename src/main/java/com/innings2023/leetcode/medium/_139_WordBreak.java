package com.leetcode.innings2023.medium;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _139_WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        if(s.isEmpty()){
            return true;
        }
        boolean matched = false;
        for(String word: wordDict){
            if (s.equals(word)){
                return true;
            }
            if (s.startsWith(word)) {
                matched = matched || wordBreak(s.substring(word.length()), wordDict);;
            }
        }
        return matched;
    }

    private static boolean isSegmentationPossible(TrieNode root){
        if(root == null){
            return false;
        }

        return root.isLeaf() || root.children.values().stream().anyMatch(_139_WordBreak::isSegmentationPossible);
    }

    private static class TrieNode{
        String prefix;
        Map<String, TrieNode> children;

        public TrieNode(String prefix,  Map<String, TrieNode> children){
            this.prefix = prefix;
            this.children = children;
        }

        public boolean isLeaf(){
            return this.children == null || this.children.isEmpty();
        }
    }

    private static TrieNode buildTrie(String prefix, String sentence, List<String> wordDict){
        if (sentence.isEmpty()){
            return new TrieNode(prefix, Collections.emptyMap());
        }

        Map<String, TrieNode> children = new HashMap<>();
        for(String word: wordDict){
            if(sentence.startsWith(word)){
                TrieNode child = buildTrie(word, sentence.substring(word.length()), wordDict);
                if(child != null) {
                    children.put(word, child);
                }
            }
        }
        return children.isEmpty() ? null : new TrieNode(prefix, children);
    }

    public static void main(String[] args) {
        String s = "acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb";
        List<String> wordDict = Arrays.asList("abbcbda","cbdaaa","b","dadaaad","dccbbbc","dccadd","ccbdbc","bbca","bacbcdd","a","bacb","cbc","adc","c","cbdbcad","cdbab","db","abbcdbd","bcb","bbdab","aa","bcadb","bacbcb","ca","dbdabdb","ccd","acbb","bdc","acbccd","d","cccdcda","dcbd","cbccacd","ac","cca","aaddc","dccac","ccdc","bbbbcda","ba","adbcadb","dca","abd","bdbb","ddadbad","badb","ab","aaaaa","acba","abbb");
//        System.out.println(wordBreak(s, wordDict));
        long start = System.nanoTime();
//        boolean b = isSegmentationPossible(buildTrie("", s, wordDict));
        boolean b = wordBreak(s, wordDict);
        System.out.println((System.nanoTime() - start)/1000 + " us");
        System.out.println(b);
    }
}
