package baekjoon;

import java.util.*;

public class SuttleBus {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(s.solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        System.out.println(s.solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        System.out.println(s.solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println(s.solution(1, 1, 1, new String[]{"23:59"}));
        System.out.println(s.solution(10, 60, 45, new String[]{"23:59","23:59", "23:59", "23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59","23:59"}));//18:00
        System.out.println(s.solution(2, 10, 2, new String[]{"00:04","00:03","00:05","00:05"}));
        System.out.println(s.solution(2, 10, 2, new String[]{"09:10","09:10","09:10","09:10"}));
    }
}

class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        Map<Integer,List> bucket = new HashMap<Integer, List>();

        Integer[] timeArr = new Integer[n];

        Integer beginTime = 540;

        timeArr[0] = beginTime;
        bucket.put(beginTime, new ArrayList<Integer>());

        for(int i = 1; i<n; i++){
            timeArr[i] = timeArr[i-1]+t;
            bucket.put(timeArr[i], new ArrayList<Integer>());
        }

        Arrays.sort(timetable);

        int timeArrIdx = 0;

        for(int i = 0; i<n*m && i<timetable.length; i++){
            String s = timetable[i];
            String[] HHmm = s.split(":");
            int arrTime = Integer.parseInt(HHmm[0]) * 60 + Integer.parseInt(HHmm[1]);

            while(timeArrIdx < timeArr.length) {
                if(timeArr[timeArrIdx] >= arrTime){
                    List list = bucket.get(timeArr[timeArrIdx]);
                    if (list.size() < m) {
                        list.add(arrTime);
                        break;
                    }
                }
                timeArrIdx++;
            }
        }

        int answer = 0;
        int prevFirst = -1;

        for(int i = timeArr.length-1; i>=0; i--){
            List<Integer> list = bucket.get(timeArr[i]);

            if(list.size() < m) {
                //비어있으면 탐
                answer = timeArr[i];
                break;
            }

            int first = list.get(0);
            int last = list.get(list.size()-1);


            if(prevFirst != -1 && prevFirst != last) {
                prevFirst = first;
                answer = last;
                break;
            }else{
                prevFirst = first;
                answer = last - 1;
                break;
            }


        }

        int hour = answer / 60;
        int min = answer % 60;

        return String.format("%2d", hour).replaceAll(" ", "0")+":"+String.format("%2d", min).replaceAll(" ", "0");
    }
}