package baekjoon;

import java.util.Scanner;

public class Main1149 {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] rgbArr = new int[n][3];
		
		for(int i = 0; i < n ; i++){
			rgbArr[i][0] = sc.nextInt();
			rgbArr[i][1] = sc.nextInt();
			rgbArr[i][2] = sc.nextInt();
		}
		
		
		for(int i = 0; i < n ; i++){
			System.out.println(rgbArr[i][0]+" "+rgbArr[i][1]+" "+rgbArr[i][2]);
		}
	}
	
	public static void method(){
		
		
	}
	
	public class Node{
		int sum = 0;
		int left = 0;
		int right = 0;
		
		public Node(int val){
			this.sum += val;
		}
	}
}
