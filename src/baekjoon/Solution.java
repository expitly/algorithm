package baekjoon;//package a.b.c;
//
//class Solution {
//    static int[] dx = {0, 0, 1, -1};
//    static int[] dy = {1, -1, 0, 0};
//    static boolean[][] visitied;
//
//    public int search(int x, int y, int[][] arr, int color){
//        if(x >= arr.length || x < 0 || y < 0 || y >= arr[0].length) return 0;
//        if(arr[x][y] == 0) return 0;
//        if(visitied[x][y]) return 0;
//        if(color != arr[x][y]) return 0;
//
//        visitied[x][y] = true;
//
//        int cnt = 1;
//        for(int i = 0; i < 4; i++){
//            cnt +=search(x+dx[i], y+dy[i], arr, color);
//        }
//
//        return cnt;
//    }
//
//    public int[] solution(int m, int n, int[][] picture) {
//        int numberOfArea = 0;
//        int maxSizeOfOneArea = 0;
//
//        visitied = new boolean[m][n];
//
//        for(int i = 0; i<picture.length; i++){
//            for(int j = 0 ; j<picture[0].length; j++){
//                if(picture[i][j] != 0 && !visitied[i][j]){
//                    numberOfArea ++;
//                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, search(i, j, picture, picture[i][j]));
//                }
//            }
//        }
//
//        int[] answer = new int[2];
//        answer[0] = numberOfArea;
//        answer[1] = maxSizeOfOneArea;
//
//        System.out.println(numberOfArea);
//        System.out.println(maxSizeOfOneArea);
//        return answer;
//    }
//}