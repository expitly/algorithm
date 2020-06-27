package baekjoon;

import java.util.HashSet;
import java.util.Scanner;

public class Main10815_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		int[] arr = new int[N];
		
		for(int i =0; i<N; i++) {
			set.add(sc.nextInt());
		}
		
		int M = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		for(int i =0; i<M; i++) {
			int target = sc.nextInt();
			
			if(set.contains(target)) sb.append("1");
			else sb.append("0");
			
			sb.append(" ");
		}
		
		System.out.println(sb.toString().trim());
	}

}
