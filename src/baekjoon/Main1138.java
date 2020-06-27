package baekjoon;

import java.util.Scanner;

public class Main1138 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] arr = new int[N+1];

        for(int i = 1; i<=N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] answer = new int[N+1];

        for(int i = 1; i<=N; i++) {
            int leftCnt = arr[i];

            for(int j = leftCnt+1 ; j<=N ; j++) {
                if(answer[j] == 0) {
                    answer[j] = i;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<= N; i++) {
            sb.append(answer[i]+" ");
        }

        System.out.println(sb.toString().trim());
    }
}