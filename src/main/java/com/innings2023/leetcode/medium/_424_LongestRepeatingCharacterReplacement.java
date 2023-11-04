package com.innings2023.leetcode.medium;

public class _424_LongestRepeatingCharacterReplacement {

    public static int characterReplacement(String s, int k) {
        if (s == null){
            return 0;
        }

        if(s.length() <= 1){
            return s.length();
        }

        int i = 0;
        int max = Integer.MIN_VALUE;
        while(i < s.length()-1){
            int j = i+1, rep = k;
            while(j < s.length()){
                if(s.charAt(i) != s.charAt(j)){
                    rep--;
                }
                if(rep < 0){
                    break;
                }
                j++;
            }
            max = Math.max(max, j-i);
            i++;
        }
        return max;
    }

    public static int characterReplacement2(String s, int k) {
        int i = 0, j = 0;
        int maxFreq = 0;
        int[] freqMap = new int[26];
        int ans = 0;
        while(j < s.length()){
            int currentChar = s.charAt(j) - 'A';
            freqMap[currentChar]++;
            maxFreq = Math.max(maxFreq, freqMap[currentChar]);
            int currentLen = j - i + 1;
            if(currentLen - maxFreq > k){
                freqMap[s.charAt(i++) - 'A']--;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "ABBB";
        int k = 2;

        System.out.println(characterReplacement2(s,k));
    }
}
