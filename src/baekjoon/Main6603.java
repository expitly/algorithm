package baekjoon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main6603 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true){
            int n = sc.nextInt();

            if(n == 0) break;

            int[] arr = new int[n];

            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }

            for(int i = 0; i<arr.length; i++){
                int[] picked = new int[6];
                picked[0] = arr[i];
                dfs(i+1, arr, picked, 1);
                picked[0] = 0;
            }

            System.out.println();
        }


    }

    private static void dfs(int nextIndex, int[] arr, int[] picked, int pickedSize) {
        if(nextIndex > arr.length) return;
        if(pickedSize == 6){
            StringBuilder sb = new StringBuilder();
            for(int i : picked){
                sb.append(i+" ");
            }

            System.out.println(sb.toString().trim());
            return;
        }

        for(int i = nextIndex; i<arr.length; i++){
            picked[pickedSize] = arr[i];
            dfs(i+1, arr, picked, pickedSize+1);
            picked[pickedSize] = 0;
        }
    }
}
