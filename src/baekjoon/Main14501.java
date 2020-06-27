package baekjoon;

import java.util.Scanner;

public class Main14501 {
    static int[] D = new int[16];
    static int[] T = new int[16];
    static int[] P = new int[16];
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1 ; i<= n; i++){
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        System.out.println(dp(1));
    }

    static int dp(int day){
        if(day == n+1) return 0;
        if(day > n+1) return -10000000;
        if(D[day] > 0) return D[day];

        return D[day] = Math.max(dp(day+1), dp(day+T[day])+P[day]);
    }
}
