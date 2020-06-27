package baekjoon;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main2014 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int t = sc.nextInt();
		
		int input[] = new int[100001];
		
		for(int i=1; i<=n; i++){
			int in = sc.nextInt();
			input[i] = in;
		}
		
		for(int i=0; i<t; i++){
			int maxIndex = 0;
			for(int k=1; k<=n; k++){
				if(input[k] > input[maxIndex])
					maxIndex = k;
			}
		
			input[maxIndex] = input[maxIndex]-1;
		}
		
		for(int i=1; i<=n; i++){
			System.out.print(input[i]+" ");
		}
	}
}
