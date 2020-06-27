package baekjoon;

import java.util.Scanner;

public class Main3079 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];

        for(int i = 0 ; i < N ; i++){
            int val = sc.nextInt();
            arr[i] = val;
        }

        long max = Long.MAX_VALUE;
        long min = 1;
        long center;
        long result=0;

        while(min <= max){
            long total = 0;
            center = (min + max) / 2;

            for(int i = 0; i < N; i++){
                total += ( center/arr[i] );
            }

            if( total >= M ){
                max = center-1;
//                result = center;
            }else{
                min = center+1;
            }
        }

        System.out.println(min);
    }
}