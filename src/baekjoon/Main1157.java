package baekjoon;

import java.util.Scanner;

public class Main1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next().toUpperCase();

        char[] charArr = input.toCharArray();
        int[] countArr = new int[26];

        for(int i = 0; i < charArr.length; i++){
            countArr[(int)charArr[i]-65]++;
        }

        int maxCount = 0;
        char result = '?';

        for(int i = 0; i<26; i++){
            if(countArr[i] > maxCount){
                maxCount = countArr[i];
                result = (char)(i+65);
            }else if(countArr[i] == maxCount){
                result = '?';
            }
        }

        System.out.println(result);
    }
}
