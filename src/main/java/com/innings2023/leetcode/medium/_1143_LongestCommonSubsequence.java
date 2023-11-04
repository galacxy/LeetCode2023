package com.innings2023.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class _1143_LongestCommonSubsequence {
    StringBuilder sb = new StringBuilder();
    public int longestCommonSubsequence(String text1, String text2) {
        if(text1 == null || text2 == null || text1.isEmpty() || text2.isEmpty()){
            return 0;
        }
        if(text1.equals(text2)){
            return text1.length();
        }
        if(text1.length() < text2.length()){
            String temp = text2;
            text2 =  text1;
            text1 = temp;
        }
        int m = text1.length(), n = text2.length();

        int[] previous = new int[m+1];
        int[] current = new int[m+1];
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(text1.charAt(j) == text2.charAt(i)){
                    current[j] = 1 + previous[j+1];
                } else {
                    current[j] = Math.max(current[j+1], previous[j]);
                }
            }
            int[] temp = previous;
            previous = current;
            current = temp;
        }
        return previous[0];
    }

    private static class Student{
        private final int id;
        private final String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        @Override
        public String toString() {
            return id + ":" + name;
        }

        @Override
        public int hashCode() {
            return name.length();
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if (!(obj instanceof Student)){
                return false;
            }
            Student obj2 = (Student) obj;
            return id == obj2.id && name.equals(obj2.name);
        }
    }

    public static void main(String[] args) {
//        _1143_LongestCommonSubsequence lcs = new _1143_LongestCommonSubsequence();
//        System.out.println(lcs.longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr"));
//        System.out.println(lcs.sb);

        Student s1 = new Student(1, "Ravi");
        Student s2 = new Student(1, "Kavi");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
        Map<Student, String> map = new HashMap<>();
        map.put(s1, s1.toString());
        map.put(s2, s2.toString());
        System.out.println(map.size());
        System.out.println(s1.hashCode() + " " + s2.hashCode());
        System.out.println(map.get(s1));
    }
}
