package com.innings2023.leetcode.medium;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankTeamVotes {

    private static String rankTeams(String[] votes) {
        if(votes.length == 1){
            return votes[0];
        }
        Map<Character, List<Integer>> map = new HashMap<>();
        for(char c : votes[0].toCharArray()){
            List<Integer> freqList = new ArrayList<>(votes[0].length());
            for(int i=0;i<votes[0].length();i++){
                freqList.add(0);
            }
            map.put(c, freqList);
        }
        for (String vote : votes){
            for (int i = 0;i < vote.length(); i++){
                List<Integer> freqList = map.get(vote.charAt(i));
                freqList.set(i, freqList.get(i) + 1);
                map.put(vote.charAt(i), freqList);
            }
        }
        for(Map.Entry<Character, List<Integer>> entry: map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        List<Character> teams = new ArrayList<>(map.keySet());
        teams.sort(getSortingCriterion(map));
        return String.join("", teams.stream().map(String::valueOf).toList());
    }

    private static Comparator<Character> getSortingCriterion(Map<Character, List<Integer>> map) {
        return (o1, o2) -> {
            for (int i = 0; i < map.get(o1).size(); i++) {
                int compareValue = map.get(o1).get(i).compareTo(map.get(o2).get(i));
                if (compareValue != 0) {
                    return -compareValue;
                }
            }
            return o1.compareTo(o2);
        };
    }

    public static void main(String[] args) {
        String[] votes = {"BCA","CAB","CBA","ABC","ACB","BAC"};
        System.out.println(rankTeams(votes));
    }
}
