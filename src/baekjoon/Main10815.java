package baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main10815 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i =0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<M; i++) {
			int target = sc.nextInt();
			
			boolean isContain = false;
			
			int left = 0;
			int right = N-1;
			
			while(left <= right) {
				int m = (left + right)/2;
				
				if(arr[m] == target) {
					isContain = true;
					break;
				}
				if(arr[m] > target) right -=1;
				else left +=1;
			}
			
			if(isContain) sb.append("1");
			else sb.append("0");
			
			sb.append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

}
