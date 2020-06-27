package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main4485 {
    public static int[] dx = {0,0,1,-1};
    public static int[] dy = {1,-1,0,0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;

        while(true){
            int n = sc.nextInt();

            if(n == 0) break;

            int[][] fields = new int[n][n];
            int[][] distArr = new int[n][n];

            PriorityQueue<Target> pq = new PriorityQueue<>();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < n ; j++){
                    fields[i][j] = sc.nextInt();
                    distArr[i][j] = Integer.MAX_VALUE;
                }
            }

            distArr[0][0] = fields[0][0];
            pq.add(new Target(0,0,fields[0][0]));

            //logic
            while(!pq.isEmpty()){
                Target t = pq.poll();

                for(int i = 0 ;i < 4; i++){
                    int nextX = t.x + dx[i];
                    int nextY = t.y + dy[i];

                    if(nextX < 0 || nextX >= n) continue;
                    if(nextY < 0 || nextY >= n) continue;

                    int nextDist = t.dist + fields[nextX][nextY];

                    if(distArr[nextX][nextY] > nextDist){
                        distArr[nextX][nextY] = nextDist;
                        pq.add(new Target(nextX, nextY, distArr[nextX][nextY]));
                    }
                }
            }

            System.out.println("Problem "+ ++cnt +": "+distArr[n-1][n-1]);
        }
    }
}

class Target implements Comparable<Target>{
    int x, y, dist;

    Target(int x, int y, int dist){
        this.x = x;
        this.y = y;
        this.dist = dist;
    }


    @Override
    public int compareTo(Target o) {
        return (this.dist < o.dist) ? -1 : 1;
    }
}


