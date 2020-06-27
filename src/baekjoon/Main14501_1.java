package baekjoon;

import java.util.Scanner;

public class Main14501_1 {
    static int N;
    static int[] T;
    static int[] P;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        T = new int[N];
        P = new int[N];
        dp = new int[N];

        for(int i = 0 ; i< N; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        int max=0;
        for(int i = 0; i <N; i++){
            max = Math.max(max, loop(i));
        }

        System.out.println(max);
    }

    public static int loop(int start){
        if(start >= N) return 0;
        if(dp[start] != 0 ) return dp[start];

        for(int i=start+T[start]; i<=N; i++){
            dp[start] = Math.max(dp[start], loop(i)+P[start]);
        }

        return dp[start];
    }
}
