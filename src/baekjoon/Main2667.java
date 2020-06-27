package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main2667 {
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	static int n;
	static char[][] fields;
	static boolean[][] visited;
	
	static int areaCnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		
		fields = new char[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			fields[i] = sc.next().toCharArray();
		}
		
		int cnt=0;
		
		List<Integer> areaList = new ArrayList<Integer>();
		
		for(int i = 0;  i < n; i++) {
			for(int j = 0; j<n; j++) {
				if(!visited[i][j] && fields[i][j] == '1') {
					areaCnt = 0;
					
					dfs(i, j, (char)++cnt);
					areaList.add(areaCnt);
				}
			}
		}
		
		Collections.sort(areaList);
		
		System.out.println(cnt);
		
		for(Integer i : areaList) {
			System.out.println(i);
		}
		
	}
	
	public static void dfs(int x, int y, char cnt) {
		if(x < 0 || x >= n) return;
		if(y < 0 || y >= n) return;
		if(visited[x][y]) return;
		if(fields[x][y] == '0') return;
		
		visited[x][y] = true;
		fields[x][y] = cnt;
		areaCnt++;
		
		for(int i = 0; i<4; i++) {
			dfs(x+dx[i], y+dy[i], cnt);
		}
	}

}
