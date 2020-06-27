package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1238 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();

        int[][] paths = new int[n+1][n+1];
        int[][] reversePaths = new int[n+1][n+1];
        int[] dist1 = new int[n+1];
        int[] dist2 = new int[n+1];

        for(int i = 0; i<m ; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int value = sc.nextInt();

            paths[start][end]=value;
            reversePaths[end][start]=value;
        }

        for(int i = 1; i<= n; i++){
            dist1[i] = Integer.MAX_VALUE;
            dist2[i] = Integer.MAX_VALUE;
        }

        getDists(x, paths, dist1, n);
        getDists(x, reversePaths, dist2, n);

        printResult(n, dist1, dist2);
    }

    private static void getDists(int start, int[][] paths, int[] dist, int n){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.offer(start);
        paths[start][start]=0;
        dist[start] = 0;

        while(!pq.isEmpty()){
            int x = pq.poll();

            for(int i = 1; i<=n; i++){
                if(paths[x][i] > 0 && dist[i]>paths[x][i] + dist[x]){
                    dist[i] = paths[x][i]+dist[x];
                    pq.offer(i);
                }
            }
        }
    }

    private static void printResult(int n, int[] dist1, int[] dist2) {
        int result = 0;
        for(int i=1; i<=n; i++){
            result = Math.max(result, dist1[i]+dist2[i]);
        }

        System.out.println(result);
    }
}
