package m05.d0514;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG_여행경로_최태선 {
     Map<String,List<String>> map;
     Map<String,boolean[]> used;
     boolean isFinished;
     Deque<String> deque;
     String[] result;
     int ticketCount;
     public String[] solution(String[][] tickets) {
          map = new HashMap<>();
          used = new HashMap<>();
          isFinished = false;
          ticketCount = tickets.length;
          result = new String[ticketCount+1];
          deque = new ArrayDeque<>();
          for(int i=0;i<tickets.length;i++){
               if(map.containsKey(tickets[i][0]))
                    map.get(tickets[i][0]).add(tickets[i][1]);
               else{
                    map.put(tickets[i][0],new ArrayList<>());
                    map.get(tickets[i][0]).add(tickets[i][1]);
               }
          }
          for(Map.Entry<String ,List<String>> entry : map.entrySet()){
               String from = entry.getKey();
               List<String> list = entry.getValue();
               used.put(from,new boolean[list.size()]);
               Collections.sort(list); 
          }
          deque.add("ICN");
          dfs(0,"ICN");
          return result;
          
     }
     void dfs(int count, String nowLoc){
          if(isFinished)
               return;
          if(count == ticketCount)
          {
               isFinished = true;
               int i = 0;
               while(!deque.isEmpty())
               {
                    result[i] = deque.pollFirst();
                    i++;
               }
               return;
          }
          List<String> nextList = map.get(nowLoc);
          boolean[] nowUsed = used.get(nowLoc);
          if (nextList == null) {
               return;
          }
          for(int i=0;i<nextList.size();i++){
               if(nowUsed[i] == false){
                    nowUsed[i] = true;
                    deque.addLast(nextList.get(i));
                    dfs(count+1,nextList.get(i));
                    deque.pollLast();
                    nowUsed[i] = false;
               }
          }
     }
}
