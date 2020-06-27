package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main2661 {
    static int n;
    static String result;
    static char[] strArr;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        strArr = new char[n];
        strArr[0] = '1';

        dfs(1);
    }

    public static void dfs(int cnt){
        if(cnt == n){
            result = new String(strArr);
            System.out.println(result);
            return;
        }

        for(int i =1; i<=3; i++){
            strArr[cnt] = (char)(i+48);
            if(result == null && isValid(cnt+1)){
                dfs(cnt+1);
            }
            strArr[cnt] = 0;
        }
    }

    private static boolean isValid(int cnt) {
        int packageCnt = 1;
        int right= cnt-1;
        int left = right-packageCnt;

        while(left >= 0){
            if (isMatched(packageCnt, right, left)) return false;

            packageCnt++;
            right = (cnt-1)-packageCnt+1;
            left = right - packageCnt;
        }

        return true;

    }

    private static boolean isMatched(int packageCnt, int right, int left) {
        for(int i = 0; i < packageCnt; i++){
            if(strArr[left+i] != strArr[right+i]){
                return false;
            }
        }
        return true;
    }
}
