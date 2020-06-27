package baekjoon;

import java.util.Scanner;

public class Main17070 {
    static int[][] fields;
    static int n;
    private static int cnt=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        fields = new int[n][n];

        for(int i =0 ;i < n; i++){
            for(int j = 0; j < n ; j++){
                fields[i][j] = sc.nextInt();
            }
        }

        //0-가로, 1-세로, 2-대각
        dfs(0, 0, 2);
        dfs(2, 1, 2);

        System.out.println(cnt);
    }

    private static void dfs(int dir, int x, int y) {
        if(x<0 || x>=n) return;
        if(y<0 || y>=n) return;
        if(fields[x][y] == 1) return;

        if(dir == 2){
            if(fields[x-1][y] ==1) return;
            if(fields[x][y-1] == 1) return;
        }

        if(x == n-1 && y == n-1) cnt++;

        switch(dir){
            case 0:
                dfs(0, x, y+1);
                dfs(2, x+1, y+1);
                break;
            case 1:
                dfs(1, x+1, y);
                dfs(2, x+1, y+1);
                break;
            case 2:
                dfs(0, x, y+1);
                dfs(1, x+1, y);
                dfs(2, x+1, y+1);
                break;
        }

    }
}
