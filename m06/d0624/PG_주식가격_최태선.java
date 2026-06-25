package m06.d0624;

import java.util.*;

public class PG_주식가격_최태선 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=0;i<prices.length;i++){
            while(!deque.isEmpty() && prices[deque.peekLast()] > prices[i]){
                int nowIdx = deque.pollLast();
                answer[nowIdx] = i-nowIdx;
            }
            deque.addLast(i);
        }
        while(!deque.isEmpty()){
            int nowIdx = deque.pollLast();
            answer[nowIdx] = (prices.length-1) - nowIdx; 
        }
        return answer;
    }
}
