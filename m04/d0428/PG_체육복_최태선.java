package m04.d0428;

import java.util.*;
import java.io.*;

class PG_체육복_최태선 {
    boolean[] hasMore;
    List<Integer> realLost;
    int answer;
    public int solution(int n, int[] lost, int[] reserve) {
        answer = n;
        hasMore = new boolean[n+1];
        for(int i=0;i<reserve.length;i++){
            hasMore[reserve[i]] = true;
        }
        realLost = new ArrayList<>();
        Arrays.sort(lost);
        for(int i=0;i<lost.length;i++){
            int now = lost[i];
            if(hasMore[now] == true)
                hasMore[now] = false;
            else
                realLost.add(now);
        }
        for(int i=0;i<realLost.size();i++){
            int now = realLost.get(i);
            if(now-1 >= 1 && hasMore[now-1] == true){
                hasMore[now-1] = false;
            }
            else if(now+1 <=n && hasMore[now+1] == true){
                hasMore[now+1] = false;
            }
            else{
                answer--;
            }
        }
        
        return answer;
    }
}