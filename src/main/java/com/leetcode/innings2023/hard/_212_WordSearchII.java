package com.leetcode.innings2023.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _212_WordSearchII {

    private static class TrieNode{
        TrieNode[] children;
        public TrieNode(){
            children = new TrieNode[26];
        }
    }

    static Set<String> found = new HashSet<>();
    static Set<String> set = new HashSet<>();

    public static List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words, set);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                backtracking(board, root, i, j, new StringBuilder(), set);
            }
        }
        return new ArrayList<>(found);
    }

    private static TrieNode buildTrie(String[] words, Set<String> set) {
        TrieNode root = new TrieNode();
        for(String word: words){
            set.add(word);
            TrieNode node = root;
            for(char c: word.toCharArray()){
                if (node.children[c-'a'] == null){
                    node.children[c-'a'] = new TrieNode();
                }
                node = node.children[c-'a'];
            }
        }
        return root;
    }

    private static boolean isValid(int i, int j, char[][] board){
        return i>=0 && j>=0 && i < board.length && j < board[0].length;
    }

    private static void backtracking(char[][] board, TrieNode root, int i, int j, StringBuilder sb, Set<String> set){
        if(!isValid(i, j, board) || board[i][j] == '\0' || root.children[board[i][j] -'a'] == null){
            return;
        }
        char c = board[i][j];
        TrieNode child = root.children[c - 'a'];
        sb.append(c);
        if(set.contains(sb.toString())){
            found.add(sb.toString());
//            set.remove(sb.toString());
//            sb.setLength(0);
        }
        board[i][j] = '\0';
        backtracking(board, child, i - 1, j, sb, set);
        backtracking(board, child, i + 1, j, sb, set);
        backtracking(board, child, i, j + 1, sb, set);
        backtracking(board, child, i, j - 1, sb, set);
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        board[i][j] = c;

    }

    public static void main(String[] args) {
//        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        char[][] board = {{'o','a','b','n'},{'o','t','a','e'},{'a','h','k','r'},{'a','f','l','v'}};
        char[][] board = {{'a', 'a'}};
//        char[][] board = {{'a','b'},{'c','d'}};
//        String[] words = {"oath","pea","eat","rain"};
//        String[] words = {"oath","pea","eat","rain","hklf", "hf"};
        String[] words = {"aaa"};
        System.out.println(findWords(board, words));
    }
}
