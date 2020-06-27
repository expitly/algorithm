package baekjoon;

import java.util.Scanner;

public class Main11066 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        while(testCase-- > 0){
            int N = sc.nextInt();
            int[] sum = new int[N+1];
            int[][] dp = new int[N+1][N+1];

            for(int i = 1; i<=N; i++){
                int val = sc.nextInt();
                sum[i] = sum[i-1]+val;
            }

            for(int i = 1; i<=N; i++){
                for(int j = 1; j<=N; j++){
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }

            System.out.println(dp(1, N, sum, dp));
        }
    }

    public static int dp(int left, int right, int[] sum, int[][] dp){
        if(dp[left][right] != Integer.MAX_VALUE) return dp[left][right];
        if(left == right){
            dp[left][right] = 0;
            return dp[left][right];
        }

        for (int mid = left; mid < right; ++mid) {
            dp[left][right] = Math.min(dp[left][right], dp(left, mid, sum, dp) + dp(mid + 1, right, sum, dp));
        }

        dp[left][right] = dp[left][right] + sum[right] - sum[left - 1];

        return dp[left][right];
    }
}
