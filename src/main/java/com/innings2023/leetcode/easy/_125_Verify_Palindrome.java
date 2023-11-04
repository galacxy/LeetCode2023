package com.innings2023.leetcode.easy;

public class _125_Verify_Palindrome {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length()-1;

        while(i < j){
            while(i<j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i<j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(i<j && s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;

//        s = s.toLowerCase().replaceAll("[^0-9a-z]", "");
//        boolean isEven = s.length()%2 == 0;
//        int mid = s.length()/2;
//        return isEven?
//                isEqual(s, mid-1, mid):
//                isEqual(s, mid, mid);

    }

    private static boolean isEqual(String s, int i, int j){
        while(i>=0 && j < s.length()){
            System.out.println(s.charAt(i) + " " + s.charAt(j));
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i--;
            j++;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }
}
