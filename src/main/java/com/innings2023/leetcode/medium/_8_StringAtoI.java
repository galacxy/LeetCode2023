package com.leetcode.innings2023.medium;

public class _8_StringAtoI {
    public static int myAtoi(String s) {

        if(s == null || s.length() == 0){
            return 0;
        }

        int i = 0;
        int j = s.length()-1;
        boolean isNegative = false;
        while(i< s.length()){
            if(s.charAt(i) == '-'){
                isNegative = true;
            } else if (Character.isLetter(s.charAt(i)) || s.charAt(i) == '.'){
                return 0;
            } else if(Character.isDigit(s.charAt(i))){
                break;
            }
            i++;
        }

        

        while(j>=0 && !Character.isDigit(s.charAt(j))){
            j--;
        }

        long sum = 0;
        long div = 1;

        while(j >= i){
            char c = s.charAt(j);

            if(c == '.'){
                sum = 0;
                div = 1;
            } else {
                sum += div * (c - 48);
                div *= 10;
            }
            j--;
        }

        sum = sum * (isNegative ? -1 : 1);
        sum = Math.min(sum, Integer.MAX_VALUE);
        sum = Math.max(sum, Integer.MIN_VALUE);
  

        return (int)sum;//1099511627775
    }

    public static void main(String[] args) {
        String s = "3.14159";
        System.out.println(myAtoi(s));
    }
}
