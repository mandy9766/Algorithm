package d0226;

import java.io.*;
import java.util.*;

public class BJ_2637_장난감조립_최태선 {
    static int N,M;
    static int[] indegree;
    static List<int[]>[] graph;
    static int[] nowState;
    static boolean[] isNormal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        indegree = new int[N+1];
        nowState = new int[N+1];
        isNormal = new boolean[N+1];
        Arrays.fill(isNormal,true);
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i]= new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            indegree[Y] ++;
            graph[X].add(new int[]{Y,K});
            isNormal[X] = false;
        }
        topologicalSort();
        for(int i=1;i<N+1;i++){
            if(isNormal[i]){
                System.out.println(i+" "+nowState[i]);
            }
        }
    }
    static void topologicalSort(){
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0){
                nowState[i] = 1;
                deque.add(i);
            }
        }
        while(!deque.isEmpty()){
            int nowItem = deque.poll();
            for(int[] tempItem : graph[nowItem]){
                int nextItem = tempItem[0];
                int nextCount = tempItem[1];
                indegree[nextItem] --;
                nowState[nextItem] += nowState[nowItem]*nextCount; 
                if(indegree[nextItem] ==0){
                    deque.add(nextItem);
                }

            }
        
            
        }
    }
}
