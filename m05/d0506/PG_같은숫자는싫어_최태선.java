package m05.d0506;

import java.util.ArrayDeque;
import java.util.Deque;

public class PG_같은숫자는싫어_최태선 {
     int[] answer;
     int size;
     Deque<Integer> deque;
     int dequeSize;
     public int[] solution(int []arr) {
          size = arr.length;
          deque = new ArrayDeque<>();
          deque.addLast(arr[0]);
          for(int i=1;i<size;i++){
               if(deque.peekLast() != arr[i]){
                    deque.addLast(arr[i]);
               }
          }
          dequeSize = deque.size();
          answer = new int[dequeSize];
          for(int i=0;i<dequeSize;i++){
               answer[i] = deque.pollFirst();
          }
          return answer;
     }
}
