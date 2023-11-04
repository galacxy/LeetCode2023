package com.leetcode.innings2023.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1297_MaximumNumberOfOccurrences {
    /*
    Given a string s, return the maximum number of occurrences of any substring under the following rules:
        The number of unique characters in the substring must be less than or equal to maxLetters.
        The substring size must be between minSize and maxSize inclusive.
     */
    public static int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        if (s==null || s.length() < minSize){
            return 0;
        }

        int start = 0;
        int end = 0;
        int[] freqMap = new int[26];
        Map<String, Integer> map = new HashMap<>();
        Arrays.sort(null, start, end, null);

        while(end - start + 1 <= minSize ){
            freqMap[s.charAt(end++) - 'a']++;
        }

        if (getUniq(freqMap) <= maxLetters) {
            String subString = s.substring(start, end);
            System.out.println(subString + " "  + start + " " + (end-1));
            map.put(subString, map.getOrDefault(subString, 0) + 1);
        }

        while(end < s.length()) {
            while (end < s.length() && end - start + 1 <= maxSize) {
                freqMap[s.charAt(end++) - 'a']++;
                if (getUniq(freqMap) <= maxLetters) {
                    String subString = s.substring(start, end);
                    System.out.println(subString + " "  + start + " " + (end-1));
                    map.put(subString, map.getOrDefault(subString, 0) + 1);
                }
            }
            if(start < s.length()) {
                freqMap[s.charAt(start++) - 'a']--;
            }
            while (end >= 0 && end < s.length() && end - start > minSize){
                freqMap[s.charAt(--end) - 'a']--;
            }
        }
        return map.values().stream().mapToInt(a -> a).max().orElse(0);
    }

    private static long getUniq(int[] freqMap){
        return Arrays.stream(freqMap).filter(i -> i > 0).count();
    }

    public static void main(String[] args) {
//        String s = "abcde";
        String s = "aabcabcab";
        int maxLetters = 2, minSize = 2, maxSize = 3;
        System.out.println(maxFreq(s, maxLetters, minSize, maxSize));
    }
}
