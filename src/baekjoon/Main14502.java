package baekjoon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main14502 {
	static int maxZeroCnt = 0;
	static int logicCnt = 0;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {-1, 1, 0, 0};
	static int N, M;
	static int[][] arr;
	static int[][] copyArr;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i ++) {
	        for(int j = 0; j< M; j ++) {
	            if(arr[i][j] == 0) {
	                arr[i][j] = 1;
	                pick(1);
	                arr[i][j] = 0;
	            }
	        }
	    }
		
		System.out.println(maxZeroCnt);	
	}
	
    public static void pick(int picked){
    	if(picked == 3){
        	logic();
        	return;
        }

    	for(int i = 0; i < N; i ++) {
            for(int j = 0; j< M; j ++) {
                if(arr[i][j] == 0) {
                    arr[i][j] = 1;
                    pick(picked+1);
                    arr[i][j] = 0;
                }
            }
        }
    }

	private static void logic() {
		copyArr = deepCopy(arr);

		//���̷��� Ȯ��
		spreadVirus();
		
		//��ĭ ����
		int zeroCount = 0;
/*		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++){
				System.out.print(copyArr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();*/
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++){
				if(copyArr[i][j] == 0) zeroCount++;
			}
		}
		
		maxZeroCnt = Math.max(zeroCount, maxZeroCnt);
	}
	
	public static int[][] deepCopy(int[][] original) {
	    if (original == null) {
	        return null;
	    }

	    final int[][] result = new int[original.length][];
	    for (int i = 0; i < original.length; i++) {
	        result[i] = Arrays.copyOf(original[i], original[i].length);
	    }
	    return result;
	}
	
	public static void spreadVirus() {
		Queue<Node> q = new LinkedList<Node>();
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++){
				if(copyArr[i][j] == 2) {
					q.add(new Node(i, j));
				}
			}
		}
		
		while(!q.isEmpty()) {
			int x = q.peek().x;
			int y = q.peek().y;
			q.remove();
			
			for(int i = 0; i < 4; i++) {
				int targetX = x+dx[i];
				int targetY = y+dy[i];
				
				if(targetX >= N || targetX < 0) continue;
				if(targetY >= M || targetY < 0) continue;
				if(copyArr[targetX][targetY] != 0) continue;
				
				copyArr[targetX][targetY] = 2;
				
				q.add(new Node(targetX, targetY));
			}
		}
	}
}

class Node{
	int x, y;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(((Node)obj).x == x && ((Node)obj).y == y) return true;
		else return false;
	}
}
