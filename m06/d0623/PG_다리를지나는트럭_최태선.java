package m06.d0623;

import java.util.*;

class PG_다리를지나는트럭_최태선 {
    Deque<Integer> inLine;
    Deque<Integer> waitBus;
    int nowWeight;
    int nowTime;
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        inLine = new ArrayDeque<>();
        waitBus = new ArrayDeque<>();
        for(int i=0;i<truck_weights.length;i++){
            waitBus.addLast(truck_weights[i]);
        }
        nowWeight = 0;
        nowTime = 0;
        while(!waitBus.isEmpty()){
            nowTime ++;
            if(nowTime>bridge_length)
            {
                nowWeight -= inLine.pollFirst();
            }
            
            if(nowWeight + waitBus.peekFirst()<=weight){
                int nowBus = waitBus.pollFirst();
                inLine.addLast(nowBus);
                nowWeight += nowBus;
            }else{
                inLine.addLast(0);
            }
        }
        return nowTime+bridge_length;
        
    }
}