package baekjoon;

import java.util.Scanner;

public class Main9095 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        int maxVal = 0;
        for(int i = 0; i < N; i++){
            int val = sc.nextInt();
            arr[i] = val;

            maxVal = Math.max(maxVal, val);
        }

        int[] dp = new int[maxVal+1];

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=4;

        for(int i = 4 ; i<=maxVal; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }

        for(int i = 0; i < N; i++){
            System.out.println(dp[arr[i]]);
        }
    }
}
