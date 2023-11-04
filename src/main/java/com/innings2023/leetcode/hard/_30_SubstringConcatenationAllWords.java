package com.innings2023.leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _30_SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();

        if(s == null || s.isEmpty() || words == null || words.length == 0 || words[0].isEmpty()){
            return ans;
        }

        int subLen = words.length * words[0].length(), i = 0;
        int wordLen = words[0].length();

        Map<String, Integer> comparing = new HashMap<>(words.length);
        Map<String, Integer> compared = new HashMap<>(words.length);
        for(String word: words){
            addToMap(word, comparing);
        }
        
        while(i+wordLen <= s.length()){
            String sub = s.substring(i, i+wordLen);
            int len = 0;
            while(comparing.containsKey(sub)){
//                len += matched.length();
//                removeFromMap(matched, comparing);
//                addToMap(matched, compared);
//                final int lenStr = len;
//                matched = comparing.keySet().stream().filter(word -> sub.substring(lenStr).startsWith(word)).findFirst().orElse(null);
            }
            if(comparing.isEmpty()){
                ans.add(i);
            }
            for(String word: compared.keySet()){
                comparing.put(word, comparing.getOrDefault(word, 0) + compared.get(word));
            }
            compared.clear();
            i++ ;
        }

        return ans;
    }

    private void addToMap(String key, Map<String, Integer> map){
        map.put(key, map.getOrDefault(key, 0)+1);
    }

    private void removeFromMap(String key, Map<String, Integer> map){
        if(map.get(key) == 1){
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }

    public static void main(String[] args) {
        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] words = {"fooo","barr","wing","ding","wing"};

        System.out.println(new _30_SubstringConcatenationAllWords().findSubstring(s, words));
    }


}
