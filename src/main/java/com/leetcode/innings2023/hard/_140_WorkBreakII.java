package com.leetcode.innings2023.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public class _140_WorkBreakII {
    /*

Problem Description::

		Given a String "word" and an array of Strings "words", add spaces in "word" to construct a sentence
		where each word is a valid word from "words". Return all such possible sentences in any order.

		Note: The same word in the "words" may be reused multiple times in the segmentation.

	Example 1::
		Input: word = "batsandcows", words = {"bat", "bats", "and", "sand", "cows", "cow"}
		Output: {"bat sand cows", "bats and cows"}

	Example 2::
		Input: word = "basand", words = {"bat", "bats", "and", "sand", "cows", "cow"}
		Output: {}

	Constraints::
		1 <= word.length <= 20
		1 <= words.length <= 1000
		1 <= words[i].length <= 10
		Word and words[i] consist of lowercase English letters.
		All the strings of words array are unique.


*/

    public static String[] findProperSentences(String word, String[] words){
        Set<String> answer = new HashSet<>();
        for(int i=0;i< words.length;i++){
            answer.add(getWord(word, words, i));
        }
        return new ArrayList<>(answer).toArray(new String[answer.size()]);
    }

    private static String getWord(String word, String[] words, int i){
        if(i >= words.length || word.isEmpty()){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        while(i<words.length){
            int idx = word.indexOf(words[i]);
            if(idx == 0){
                sb.append(words[i]).append(" ");
                String rem = getWord(word.substring(words[i].length()), words, 0);
                if (rem == null){
                    return sb.toString();
                }
                sb.append(rem);
            }
            i++;
        }
        return sb.toString();
    }

    private static class Node{
        String prefix;
        String word;
        List<Node> children;

        public boolean isLeaf(){
            return isNull(this.children) || this.children.isEmpty();
        }
    }

    private static Node buildTree(String prefix, String word, String[] words){
        Node root = new Node();
        root.prefix = prefix;
        root.word = word;
        if(!word.isEmpty()) {
            root.children = new ArrayList<>();
            for (String w : words) {
                if (word.indexOf(w) == 0 && word.length() > w.length()) {
                    Node child = buildTree(w, word.substring(w.length()), words);
                    root.children.add(child);
                }
            }
        }
        return root;
    }

    private static class TrieNode{
        String prefix;
        Map<String, TrieNode> children;
        public TrieNode(String prefix, Map<String, TrieNode> children){
            this.children = children;
            this.prefix = prefix;
        }

        public boolean isLeaf(){
            return isNull(this.children) || this.children.isEmpty();
        }
    }

    private static TrieNode buildTrie(String prefix, String sentence, List<String> dictionary){
        if(sentence.isEmpty()){
            return new TrieNode(prefix, Collections.emptyMap());
        }
        Map<String, TrieNode> children = new HashMap<>();
        for(String word:dictionary){
            if (sentence.startsWith(word)){
                TrieNode child = buildTrie(word, sentence.substring(word.length()), dictionary);
                if (child != null) {
                    children.put(word, child);
                }
            }
        }
        return children.isEmpty() ? null : new TrieNode(prefix, children);
    }

    private static void traverseTrie(TrieNode root, Stack<String> sentence, List<String> result){
        if (isNull(root)){
            return;
        }
        sentence.push(root.prefix);
        if (root.isLeaf()){
            result.add(String.join(" ", sentence).trim());
        }
        root.children.values().forEach(child -> traverseTrie(child, sentence, result));
        sentence.pop();
    }


    public static void main(String[] args) {
        String word = "catsandog";
        String[] words = {"cats","dog","sand","and","cat"};
        List<String> result = new ArrayList<>();
        traverseTrie(buildTrie("", word, Arrays.asList(words)), new Stack<>(), result);
        System.out.println(result);
    }
}
