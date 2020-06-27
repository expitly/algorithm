package baekjoon;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main2146{
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	static int n;
	static boolean[][] visited;
	static int[][] fields;
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		
		n = sc.nextInt();
		fields = new int[n][n];
		visited = new boolean[n][n];
		
		for(int i=0; i<n; i++) {
			for(int j = 0; j<n; j++) {
				fields[i][j] = sc.nextInt();
			}
		}
		
		//�� ��ȣ ���ϱ�
		int cnt = 0;
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(fields[i][j] == 1 && !visited[i][j]) {
					dfs(i, j, ++cnt);
				}
			}
		}
		
		//���� ������
		//������ŭ for ���ƾ���(BFS). �״��� Min ����.
		
		int min = Integer.MAX_VALUE;
		
		for(int z = 1; z<=cnt; z ++) {
			for(int f = 0; f<n; f++) {
				Arrays.fill(visited[f], false);				
			}
			
			int resultVal = bfs(z);
			
			min = Math.min(min, resultVal);
		}
		
		System.out.println(min);
	}

	private static int bfs(int z) {
		int resultVal = 0;
		
		Queue<Point> q = new LinkedList<Point>();
		
		for(int i = 0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(fields[i][j] == z) 
					q.offer(new Point(i, j));
			}
		}
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			
			for(int s = 0; s<qSize; s++) {
				Point p = q.poll();
				
				for(int i = 0; i< 4; i++) {
					int targetX = p.x+dx[i];
					int targetY = p.y+dy[i];
					
					if(targetX >=0 && targetX < n && targetY >=0 && targetY < n) {
						if(fields[targetX][targetY] > 0 && fields[targetX][targetY] != z) {
							return resultVal;
						}
						
						if(fields[targetX][targetY] == 0 && !visited[targetX][targetY]) {
							visited[targetX][targetY] = true;
							q.offer(new Point(targetX, targetY));
						}
					}
				}
			}
			
			resultVal++;
		}
		
		return resultVal;
	}
	
	
	public static void dfs(int x, int y, int cnt) {
		if(x < 0 || x >= n) return;
		if(y < 0 || y >= n) return;
		if(visited[x][y]) return;
		if(fields[x][y] == 0) return;
		
		fields[x][y] = cnt;
		visited[x][y] = true;
		
		for(int i = 0 ;i<4 ; i++) {
			dfs(x+dx[i], y+dy[i], cnt);
		}
	}
}
