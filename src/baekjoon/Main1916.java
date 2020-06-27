package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main1916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();//도시
        int m = sc.nextInt();//버스
        int[][] busTime = new int[n][n];

        long[] dist = new long[n];
        for(int i = 0; i<n; i++){
            dist[i] = Long.MAX_VALUE;

            for(int j = 0; j<n; j++){
                busTime[i][j] = -1;
            }
        }

        for(int i = 0; i<m; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int time = sc.nextInt();

            int prevBusTime = busTime[src-1][dest-1];

            if(prevBusTime == -1) busTime[src-1][dest-1] = time;
            else if(prevBusTime > -1 && time < prevBusTime){
                busTime[src-1][dest-1] = time;
            }
        }

        int targetSrc = sc.nextInt()-1;
        int targetDest = sc.nextInt()-1;

        boolean[] visited = new boolean[n];
        visited[targetSrc] = true;
        dist[targetSrc] = 0;
        //로직

        PriorityQueue<Source> q = new PriorityQueue<>();
        q.add(new Source(targetSrc, 0));

        while(!q.isEmpty()){
            Source src = q.poll();

            for(int i = 0; i<n; i++){
                if(src.src != i && busTime[src.src][i] > -1){
                    if(dist[i] > dist[src.src] + busTime[src.src][i]){
                        visited[i] = true;
                        q.add(new Source(i, dist[i]));
                        dist[i] = dist[src.src] + busTime[src.src][i];
                    }
                }
            }
        }

        System.out.println(dist[targetDest]);
    }
}

class Source implements Comparable<Source>{
    int src;
    long dist;

    public Source(int src, long dist){
        this.src = src;
        this.dist = dist;
    }

    @Override
    public int compareTo(Source o) {
        return (this.dist < o.dist) ? -1 : 1;
    }
}