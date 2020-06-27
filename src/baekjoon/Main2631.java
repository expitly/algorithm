package baekjoon;

import java.util.Scanner;

public class Main2631 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N];

        dp[0] = 1;
        int max = 0;

        for(int i=1; i<N; i++){
            dp[i] = 1;

            for(int j = 0; j<i; j++){
                if(arr[i]>arr[j] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                }
            }

            max = Math.max(dp[i], max);
        }

        System.out.println(N-max);

    }
}
