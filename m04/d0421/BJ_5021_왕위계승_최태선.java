package m04.d0421;

import java.io.*;
import java.util.*;

public class BJ_5021_왕위계승_최태선 {
     static int N,M;
     static Deque<Integer> queue;
     static Map<String,Integer> personNum;
     static int[] indegree;
     static double[] val;
     static int nowNum;
     static List<Integer>[] graph;
     static double maxVal;
     static String maxName;
     static String[] candidates;
     public static void main(String[] args) throws Exception{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(br.readLine()," ");
          N = Integer.parseInt(st.nextToken());
          M = Integer.parseInt(st.nextToken());
           indegree = new int[152];
          val = new double[152];
          graph = new List[152];
          for(int i=0;i<152;i++){
               graph[i] = new ArrayList<>();
          }
          personNum = new HashMap<>();
          String nowName = br.readLine();
          personNum.put(nowName,0);
          val[0] = 1;
          nowNum = 1;
          queue = new ArrayDeque<>();
          for(int i=0;i<N;i++){
               st = new StringTokenizer(br.readLine()," ");
               String nowName1 = st.nextToken();
               check(nowName1);
               String nowName2 = st.nextToken();
               check(nowName2);
               String nowName3 = st.nextToken();
               check(nowName3);
               int num1 = personNum.get(nowName1);
               int num2 = personNum.get(nowName2);
               int num3 = personNum.get(nowName3);
               indegree[num1] += 2;
               graph[num2].add(num1);
               graph[num3].add(num1);
          }
          maxVal = -1.0;
          candidates = new String[M];
          for(int i=0;i<M;i++){
               candidates[i] = br.readLine();
          }
          for(int i=0;i<nowNum;i++){
               if(indegree[i] ==0)
               {
                    queue.add(i);
               }
          }
          while(!queue.isEmpty()){
               int nowNum = queue.poll();
               for(int nextNum : graph[nowNum]){
                    indegree[nextNum] --;
                    val[nextNum] += val[nowNum]/2;
                    if(indegree[nextNum] == 0){
                         queue.add(nextNum);
                    }
               }
          }
          for(int i=0;i<M;i++){
               if(!personNum.containsKey(candidates[i]))
                    continue;
               int nowNum = personNum.get(candidates[i]);
               if(maxVal< val[nowNum]){
                    maxVal = val[nowNum];
                    maxName = candidates[i];
               }
          }
          System.out.println(maxName);
     }
     static void check (String nowName){
          if(!personNum.containsKey(nowName))
               {
                    // 없을때만 숫자 할당하고 올리기
                    personNum.put(nowName,nowNum);
                    nowNum++;
               }
     }
}
