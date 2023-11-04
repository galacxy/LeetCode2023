package com.innings2023.codingninjas;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryString {

    public static int countStrings(int n){
        if(n<=1){
            return n;
        }

        int zero = 0;
        int one = 0;
        int prevZero = 1, prevOne = 1;
        for(int i=2;i<=n;i++){
            zero = prevOne + prevZero;
            one = prevZero;
            prevZero = zero;
            prevOne = one;
        }

        return one + zero;
    }

    public static List< String > generateString(int N) {
        List<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.offer("0");
        q.offer("1");
        while(!q.isEmpty()){
            String s = q.poll();
            if(s.length() == N){
                ans.add(s);
            } else if(s.length() < N) {
                if (s.charAt(s.length() - 1) == '0') {
                    q.offer(s + "0");
                    q.offer(s + "1");
                } else {
                    q.offer(s + "0");
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(countStrings(2));
        System.out.println(generateString(3));
    }

}
