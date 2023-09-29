package com.leetcode.innings2023.medium;

public class _79_WordSearch {

    public static boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(traverse(board, word, i, j, visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isValid(int i, int j, char[][] board){
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length;
    }


    private static boolean traverse(char[][] board, String word, int i, int j, boolean[][] visited) {
        if(!isValid(i,j, board) || board[i][j] != word.charAt(0) || visited[i][j]){
            return false;
        }
        if(word.length() == 1){
            return true;
        }
        visited[i][j] = true;
        boolean left = traverse(board, word.substring(1), i, j - 1, visited);
        boolean up = left || traverse(board, word.substring(1), i - 1, j, visited);
        boolean down = up || traverse(board, word.substring(1), i + 1, j, visited);
        boolean right = down || traverse(board, word.substring(1), i, j + 1, visited);
        visited[i][j] = false;
        return right;
    }

    public static void main(String[] args) {
        char[][]board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
//        char[][]board = {{'a','b'},{'c','d'}};
        String word = "ABCB";
        System.out.println(exist(board, word));
    }

}
