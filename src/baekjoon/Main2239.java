package baekjoon;

import java.util.Scanner;

public class Main2239 {
    static char[][] fields = new char[9][9];
    static boolean isFinished = false;
    static int curX, curY;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ;i < 9 ; i++) {
            fields[i] = sc.nextLine().toCharArray();
        }

        dfs();
    }

    private static void dfs() {
        if(isFinished) return;

        if(!check()){
            int x = curX;
            int y = curY;
            for(int k = 1; k<=9; k++){
                if(isValid(x, y, k)){
                    fields[x][y] = (char) (k+48);
                    dfs();
                    fields[x][y] = '0';
                }
            }
        }else{
            isFinished = true;

            for(int i = 0 ;i < 9 ; i++) {

                for (int j = 0; j < 9; j++) {
                    System.out.print(fields[i][j]);
                }

                System.out.println();
            }
        }
    }

    private static boolean check() {
        for(int i = 0 ;i < 9 ; i++) {
            for (int j = 0; j < 9; j++) {
                if(fields[i][j] == '0'){
                    curX = i;
                    curY = j;
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(int x, int y, int k) {
        char val = (char)(k+48);

        for(int i = 0; i<9; i++){
            if(fields[x][i] == val) return false;
        }

        for(int i = 0; i<9; i++){
            if(fields[i][y] == val) return false;
        }

        int targetX = x/3*3;
        int targetY = y/3*3;

        for(int i = targetX; i<targetX+3; i++){
            for(int j = targetY; j<targetY+3; j++){
                if(fields[i][j] == val) return false;
            }
        }

        return true;
    }
}
