package m04.d0422;

import java.io.*;
import java.util.*;

public class BJ_15591_MooTube_최태선 {
     static int N,Q;
     static int[] k,v;
     static List<int[]>[] graph;
     static StringBuilder sb;
     static Deque<int[]> deque;
     static int[] dist;
     static boolean[] visited;
     static int INF = Integer.MAX_VALUE;
     
     public static void main(String[] args) throws Exception{
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
          StringTokenizer st = new StringTokenizer(br.readLine()," ");
          N = Integer.parseInt(st.nextToken());
          Q = Integer.parseInt(st.nextToken());
          graph = new List[N+1];
          for(int i=1;i<N+1;i++){
               graph[i] = new ArrayList<>();
          }
          deque = new ArrayDeque<>();
          dist = new int[N+1];
          sb = new StringBuilder();
          for(int i=0;i<N-1;i++){
               st= new StringTokenizer(br.readLine()," ");
               int a = Integer.parseInt(st.nextToken());
               int b = Integer.parseInt(st.nextToken());
               int r = Integer.parseInt(st.nextToken());
               graph[a].add(new int[]{b,r});
               graph[b].add(new int[]{a,r});
          }
          for(int i=0;i<Q;i++){
               st= new StringTokenizer(br.readLine()," ");
               int k = Integer.parseInt(st.nextToken());
               int v = Integer.parseInt(st.nextToken());
               solve(k,v);
          }
          System.out.println(sb);
     }
     static void solve(int k, int v){ // 동영상 v 를 보고있는 k 이상 연관도의 영상
          deque.clear();
          Arrays.fill(dist,INF);
          for(int[] nextNode : graph[v]){
               int nextNum = nextNode[0];
               int nextVal = nextNode[1];
               if(nextVal>=k){
                    dist[nextNum] = nextVal;
                    deque.add(new int[]{nextNum,nextVal});
               }
               
          }
          deque.add(new int[]{v,Integer.MAX_VALUE});
          while(!deque.isEmpty()){
               int[] nowNode = deque.poll();
               int nowNum = nowNode[0];
               int nowVal = nowNode[1];
               for(int[] nextNode : graph[nowNum]){
                    if(nextNode[0]!= v && dist[nextNode[0]] == INF && nextNode[1]>=k){
                         int nextNum = nextNode[0];
                         int nextVal = nextNode[1];
                         dist[nextNum] = Math.min(nowVal,nextVal);
                         deque.add(new int[]{nextNum,Math.min(nowVal,nextVal)});
                    }
               }
          }
          int count=0;
          for(int i=1;i<N+1;i++){
               if(i == v)
                    continue;
               if(dist[i]>=k && dist[i] != INF)
                    count++;
          }
          sb.append(count).append("\n");
     }
}
