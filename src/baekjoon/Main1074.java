package baekjoon;

public class Main1074 {
	static int R=7, C=7, cnt=0;
	
	public static void main(String[] args) {
		recursive(8,0,0);
	}
	
	public static void recursive(int N, int r, int c) {
		if(N == 1) {
			if(R == r && C == c) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			if(R == r+1 && C == c) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			if(R == r && C == c+1) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			if(R == r+1 && C == c+1) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			return;
		}
		
		recursive(N/2, r, c);
		recursive(N/2, r, c+N);
		recursive(N/2, r+N, c);
		recursive(N/2, r+N, c+N);
	}
}
