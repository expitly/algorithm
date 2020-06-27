package baekjoon;

import java.util.Scanner;

public class Main1234 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long M = sc.nextLong();

        Long[] arr = new Long[(int) N];

        long maxVal = 0;
        
        for(int i = 0 ; i < N ; i++){
            long val = sc.nextLong();
            arr[i] = val;
            
            maxVal = Math.max(maxVal, val);
        }

        long max = maxVal*M;
        long min = 1;
        long center;

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