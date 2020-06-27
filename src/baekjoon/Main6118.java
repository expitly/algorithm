package baekjoon;

import java.io.*;
import java.util.*;

public class Main6118 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line[] = in.readLine().split(" ");

        int n = Integer.parseInt(line[0]);
        int m = Integer.parseInt(line[1]);

        Map<Integer, List> map = new HashMap<>();

        int x,y;
        List<Integer> list;

        for(int i = 0; i < m; i++){
            line = in.readLine().split(" ");

            x = Integer.parseInt(line[0]);
            y = Integer.parseInt(line[1]);

            list = map.get(x);
            if(list == null){
                list = new ArrayList();

                map.put(x,list);
            }
            list.add(y);

            list = map.get(y);
            if(list == null){
                list = new ArrayList();

                map.put(y,list);
            }
            list.add(x);
        }

        int[] dist = new int[n+1];

        for(int i=1; i<=n; i++){
            dist[i] = Integer.MAX_VALUE;
        }

        dist[1] = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 < o2 ? -1 : 1;
            }
        });
        pq.add(1);

        while(!pq.isEmpty()){
            Integer target = pq.poll();

            list = map.get(target);

            for(Integer i : list){
                if(dist[i] > dist[target]+1){
                    dist[i] = dist[target]+1;
                    pq.add(i);
                }
            }
        }

        int maxIdx = 1;
        int maxCnt = 1;

        for(int i=1; i<=n; i++){
            if(dist[i] > dist[maxIdx]){
                maxIdx = i;
                maxCnt = 1;
            }else if(dist[i] == dist[maxIdx]){
                maxCnt++;
            }
        }

        System.out.println(maxIdx + " " + dist[maxIdx] + " " + maxCnt);
    }
}
