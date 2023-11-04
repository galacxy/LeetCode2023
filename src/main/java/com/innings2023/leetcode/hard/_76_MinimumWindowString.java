package com.leetcode.innings2023.hard;

import java.util.HashMap;
import java.util.Map;

public class _76_MinimumWindowString {
    public String minWindow(String s, String t) {
        String ans = "";
        if(s == null || t == null || s.isEmpty() || t.isEmpty() || t.length() > s.length()){
            return ans;
        }
        if(s.equals(t)){
            return s;
        }
        int minLength = Integer.MAX_VALUE;
        Map<Character, Integer> map = getFreqMap(t);
        int i=0, j = 0;
        int counter = map.size();
        while(j < s.length()){
            char c = s.charAt(j);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0){
                    counter--;
                }
            }
            while(counter == 0){
                if(minLength > (j-i+1)) {
                    minLength = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
                c = s.charAt(i);
                if(map.containsKey(c)){
                    map.put(c, map.get(c) + 1);
                    if(map.get(c) > 0){
                        counter++;
                    }
                }
                i++;
            }
            j++;
        }
        return ans;
    }

    private Map<Character, Integer> getFreqMap(String t) {
        Map<Character, Integer> o = new HashMap<>();
        for(int i=0;i<t.length();i++){
            o.put(t.charAt(i), o.getOrDefault(t.charAt(i), 0) + 1);
        }
        return o;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC", t = "ABC";
        System.out.println(new _76_MinimumWindowString().minWindow(s, t));
    }
}
