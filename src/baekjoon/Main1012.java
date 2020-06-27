package baekjoon;

import java.util.Scanner;

public class Main1012 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	static int[][] fields;
	static boolean[][] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCaseCnt = sc.nextInt();
		
		while(testCaseCnt-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int s = sc.nextInt();
			
			fields = new int[x][y];
			visited = new boolean[x][y];
			
			
			for(int i = 0; i<s; i++) {
				fields[sc.nextInt()][sc.nextInt()] = 1;
			}
			
			int cnt = 0;
			for(int i = 0; i<x; i++) {
				for(int j = 0; j<y; j++) {
					if(!visited[i][j] && fields[i][j] == 1) {
						dfs(i, j);
						cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	public static void dfs(int x, int y) {
		if(x < 0 || x >= fields.length) return;
		if(y < 0 || y >= fields[0].length) return;
		if(visited[x][y]) return;
		if(fields[x][y] == 0) return;
		
		visited[x][y] = true;
		
		for(int i = 0; i<4; i++) {
			dfs(x+dx[i], y+dy[i]);
		}
	}
}
