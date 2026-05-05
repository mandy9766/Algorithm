package m05.d0506;

import java.util.PriorityQueue;

public class PG_더맵게_최태선 {
     PriorityQueue<Integer> pq;
     int count;
     int size;
     
     public int solution(int[] scoville, int K) {
          pq = new PriorityQueue<>();
          size = scoville.length;
          for(int i=0;i<size;i++){
               pq.add(scoville[i]);
          }
          count = 0;
          while(true){
               int nowVal = pq.poll();
               if(nowVal >= K){
                    return count;
               }
               if(pq.isEmpty()){
                    return -1;
               }else{
                    int nextVal = pq.poll();
                    pq.add(nowVal+nextVal*2);
                    count ++;
               }
          }
     }
}
