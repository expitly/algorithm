package baekjoon;

import java.util.*;
import java.io.*;

public class Main3020 {
	static int[] higher, lower;
	static int N, H, len;
	
	public static void main(String[] args) throws Exception {
		int inVal, cntLow, cntHigh, ans, cnt = 1;
		int[] block;
		
		//System.setIn(new FileInputStream("E:\\workspace\\software_test\\src\\sample_data.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		len = N/2;
		lower = new int[len+1];
		higher = new int[len+1];
		block = new int[H];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			inVal = Integer.parseInt(st.nextToken());
			if (i%2 == 0) higher[i/2] = inVal;
			else lower[i/2] = inVal;
		}
		Arrays.sort(lower);
		Arrays.sort(higher);
		//System.out.println(Arrays.toString(lower));
		//System.out.println(Arrays.toString(higher));
		
		for (int i = 1; i <= H; i++) {
			cntLow = countLow(i);
			cntHigh = countHigh(H-i+1);
			ans = (len - cntLow + 1) + (len - cntHigh + 1);
			block[i-1] = ans;
			//System.out.println("#"+i+" "+cntLow+" "+cntHigh+" => "+(len - cntLow + 1)+" "+(len - cntHigh + 1)+" ==> "+ans);
		}
		
		Arrays.sort(block);
		for (int i = 1; i < H; i++) {
			if (block[i] == block[0]) cnt++;
			else break;
		}
		System.out.println(block[0]+ " "+ cnt);
	}
	
	static int countLow(int height) {
		int start = 1, end = len, mid, ans = 0; 
		while (end >= start) {
			mid = (start + end) / 2;
			if (height <= lower[mid]) end = mid - 1;
			else start = mid + 1;
		}
		ans = start;
		return ans;
	}
	
	static int countHigh(int height) {
		int start = 1, end = len, mid, ans = 0;  
		while (end >= start) {
			mid = (start + end) / 2;
			if (height <= higher[mid]) end = mid - 1;
			else start = mid + 1;
		}
		ans = start;
		return ans;
	}
}