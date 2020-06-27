package baekjoon;

import java.util.Scanner;

public class Main1780 {
    static int[][] arr;
    static int[] cntArr = new int[3];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        loop(0,0, n);

        System.out.println(cntArr[0]);
        System.out.println(cntArr[1]);
        System.out.println(cntArr[2]);
    }

    public static void loop(int x, int y, int cnt){

        int target = arr[x][y];

        for(int i = x; i < x+cnt; i++){
            for(int j = y; j < y+cnt; j++){
                if(target != arr[i][j]){
                    for(int w = 0; w < 3; w++) {
                        for (int h = 0; h < 3; h++) {
                            loop(x+w*cnt/3, y+h*cnt/3, cnt/3);
                        }
                    }
                    return;
                }
            }
        }

        cntArr[target+1] +=1;
    }
}
