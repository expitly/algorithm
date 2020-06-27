package baekjoon;

import java.util.Scanner;

public class Main3184 {
    static int[] dx = {0 ,0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static int wolfCnt = 0, sheepCnt = 0;
    static int totalWolfCnt = 0, totalSheepCnt = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        char arr[][] = new char[x][y];
        boolean[][] visited = new boolean[x][y];

        for(int i = 0; i<x; i++){
            arr[i] = sc.next().toCharArray();
        }

        for(int i = 0; i<x ; i++){
            for(int j = 0; j < y; j ++){
                if(!visited[i][j] && arr[i][j] != '#'){
                    wolfCnt = 0;
                    sheepCnt = 0;
                    loop(i, j, arr, visited);

                    if(sheepCnt > wolfCnt) totalSheepCnt+=sheepCnt;
                    else totalWolfCnt += wolfCnt;
                }
            }
        }

        System.out.println(totalSheepCnt + " " + totalWolfCnt);
    }

    public static void loop(int x, int y, char[][] arr,  boolean[][] visited){
        if(x < 0 || y < 0 || x >= arr.length || y >= arr[0].length) return;
        if(visited[x][y]) return;
        if(arr[x][y] == '#') return;

        visited[x][y] = true;
        if(arr[x][y] == 'v') wolfCnt++;
        else if(arr[x][y] == 'o') sheepCnt++;

        for(int i = 0; i<4; i++){
            loop(x+dx[i], y+dy[i], arr, visited);
        }
    }
}
