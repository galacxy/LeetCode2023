package com.innings2023.leetcode.hard;

public class _273_IntegerToEnglish {
    private static final String[] COMMA_POWERS = {"", "Thousand", "Million", "Billion", "Trillion"};

    public String numberToWords(int num) {
        if (num == 0){
            return "Zero";
        }
        if (!get(num).isEmpty()){
            return get(num);
        }
        StringBuilder sb = null;
        int i = 0;
        while (num > 0){
            StringBuilder sb1  = processThreeDigits(num%1000);
            if (!sb1.isEmpty()) {
                sb1.append(COMMA_POWERS[i]).append(" ");
            }
            if (sb != null) {
                sb1.append(sb).append(" ");
            }
            sb = sb1;
            num /= 1000;
            i++;
        }
        return sb == null ? "" : sb.toString().trim();
    }

    private StringBuilder processThreeDigits(int num){
        StringBuilder sb = new StringBuilder();
        if(num == 0){
            return sb;
        }
        int rem = num/100;
        if(rem > 0){
            sb.append(get(rem)).append(" ").append("Hundred").append(" ");
        }
        num = num % 100;
        if(!get(num).isEmpty()){
            sb.append(get(num)).append(" ");
        } else if (num > 0){
            rem = num / 10;
            sb.append(get(rem*10)).append(" ").append(get(num%10)).append(" ");
        }
        return sb;
    }

    public static void main(String[] args) {
        int num = 1000000;
        System.out.println(new _273_IntegerToEnglish().numberToWords(num));
    }

    private static String get(int num){
        return switch (num) {
            case 1 -> "One";
            case 2 -> "Two";
            case 3 -> "Three";
            case 4 -> "Four";
            case 5 -> "Five";
            case 6 -> "Six";
            case 7 -> "Seven";
            case 8 -> "Eight";
            case 9 -> "Nine";
            case 10 -> "Ten";
            case 11 -> "Eleven";
            case 12 -> "Twelve";
            case 13 -> "Thirteen";
            case 14 -> "Fourteen";
            case 15 -> "Fifteen";
            case 16 -> "Sixteen";
            case 17 -> "Seventeen";
            case 18 -> "Eighteen";
            case 19 -> "Nineteen";
            case 20 -> "Twenty";
            case 30 -> "Thirty";
            case 40 -> "Forty";
            case 50 -> "Fifty";
            case 60 -> "Sixty";
            case 70 -> "Seventy";
            case 80 -> "Eighty";
            case 90 -> "Ninety";
            default -> "";
        };
    }
}
