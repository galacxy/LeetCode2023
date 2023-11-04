package com.innings2023.leetcode.medium;

public class _211_WordDictionary {
    private static class TrieNode{
        TrieNode[] children;
        boolean isLeaf;
        public TrieNode(){
            this.children = new TrieNode[26];
            this.isLeaf = false;
        }
    }
    TrieNode root;

    public _211_WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if (node.children[c-'a'] == null){
                node.children[c-'a'] = new TrieNode();
            }
            node = node.children[c-'a'];
        }
        node.isLeaf = true;
    }

    public boolean search(String word) {
        return search(word, 0, root);
    }

    private boolean search(String word, int i, TrieNode node){
        if (node == null){
            return false;
        }

        if(i == word.length()){
            return node.isLeaf;
        }

        boolean result = false;
        if (word.charAt(i) == '.'){
            for(TrieNode child: node.children){
                result = search(word, i+1, child);
                if (result){
                    break;
                }
            }
        } else {
            result = search(word, i+1, node.children[word.charAt(i) - 'a']);
        }
        return result;
    }

    public static void main(String[] args) {
        _211_WordDictionary dictionary = new _211_WordDictionary();
//        [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("add");
        System.out.println(dictionary.search("a"));
        System.out.println(dictionary.search(".at"));
        System.out.println(dictionary.search("bat"));
        System.out.println(dictionary.search(".at"));
        System.out.println(dictionary.search("an."));
        System.out.println(dictionary.search("a.d."));
        System.out.println(dictionary.search("b."));
        System.out.println(dictionary.search("a.d"));
        System.out.println(dictionary.search("."));
    }
}
