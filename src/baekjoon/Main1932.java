package baekjoon;

import java.util.Scanner;

public class Main1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        for(int i = 0; i<arr.length; i++){
            for(int j=0; j<=i; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = arr.length-2; i>=0; i--){
            for(int j=0; j<=i; j++){
                arr[i][j] += Math.max(arr[i+1][j], arr[i+1][j+1]);
            }
        }

        System.out.println(arr[0][0]);
    }
}
