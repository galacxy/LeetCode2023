package com.leetcode.innings2023.medium;

public class _5_LongestPalindromicSubstring {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() <= 1 || (s.length() == 2 && s.charAt(0) == s.charAt(1))){
            return s;
        }

        int max = 0;
        int start = 0;

        char[] str = s.toCharArray();

        for(int i=0;i<s.length();i++){
            int[] l1 = findPalindromeLength(str, i, i);
            int[] l2 = findPalindromeLength(str, i, i+1);

            if(max < l1[1]){
                max = l1[1];
                start = l1[0];
            }
            if (max < l2[1]){
                max = l2[1];
                start = l2[0];
            }
        }
        return s.substring(start, start + max);
    }

    private static int[] findPalindromeLength(char[] str, int i, int j){
        while(i>=0 && j<str.length && str[i] == str[j]){
            i--;
            j++;
        }
        return new int[]{i+1, j-i-1};
    }

    public static void main(String[] args) {
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
}
