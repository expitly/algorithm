package baekjoon;

import java.util.Scanner;

public class Main9251 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] word1 = sc.next().toCharArray();
        char[] word2 = sc.next().toCharArray();

        int[][] arr = new int[word1.length+1][word2.length+1];

        for(int i=1; i<arr.length; i++){
            for(int j=1; j<arr[0].length; j++){
                if(word1[i-1] == word2[j-1]){
                    arr[i][j] = arr[i-1][j-1]+1;
                }else{
                    arr[i][j] = Math.max(arr[i-1][j], arr[i][j-1]);
                }
            }
        }

        System.out.println(arr[arr.length-1][arr[0].length-1]);
    }
}
