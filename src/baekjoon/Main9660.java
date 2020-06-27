package baekjoon;

import java.util.Scanner;

public class Main9660 {
    static int n;
    static int[] arr;
    static int result=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for(int i = 1; i <=n; i++){
            arr = new int[n+1];

            arr[1] = i;

            dfs(1);
        }

        System.out.println(result);
    }

    private static void dfs(int i) {
        if(i == n){
            result++;
        }else{
            for(int j = 1; j<=n; j++){
                if(isPossible(i+1)){
                    //가능
                    arr[i+1]=j;
                    dfs(i+1);
                }
            }
        }

        arr[i] = 0;
    }

    private static boolean isPossible(int target) {
        for(int i=1; i<target; i++){
            if(arr[i] == arr[target] || (Math.abs(arr[i]-arr[target]) == Math.abs(i-target))) return false;
        }

        return true;
    }
}
