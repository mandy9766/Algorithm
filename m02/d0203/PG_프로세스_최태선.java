package d0203;

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        int size = priorities.length;
        for(int i=0;i<size;i++){
            deque.addLast(new int[]{i,priorities[i]});
        }
        while(true){
            int[] arraySet = deque.pollFirst();
            int nowPriority = arraySet[1];
            int nowLocation = arraySet[0];
            Iterator <int[]> it = deque.iterator();
            boolean isPriority=true;
            while(it.hasNext()){
                int next = it.next()[1];
                if (next>nowPriority){
                    isPriority = false;
                    break;
                }
            }
            if (isPriority){
                answer++;
                if(nowLocation == location){
                    break;
                }
            }else{
                deque.addLast(new int[]{nowLocation,nowPriority});
            }
        }

        return answer;
    }
}