package d0220;

import java.io.*;
import java.util.*;

public class BJ_2056_작업_최태선 {
    static int N;
    static int[] indegree,timeTable,dp;
    static List<Integer>[] graph;
    static int maxVal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        indegree = new int[N+1];
        timeTable = new int[N+1];
        dp = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int time = Integer.parseInt(st.nextToken());
            timeTable[i] = time;
            dp[i] = time;
            int count = Integer.parseInt(st.nextToken());
            for(int j=0;j<count;j++){
                int from = Integer.parseInt(st.nextToken());
                graph[from].add(i);
                indegree[i] ++;
            }
        }
        topologicalSort();
        maxVal = 0;
        for(int i=1;i<=N;i++){
            maxVal = Math.max(maxVal, dp[i]);
        }
        System.out.println(maxVal);
    }
    static void topologicalSort(){
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(indegree[i] == 0)
                deque.add(i);
        }
        while(!deque.isEmpty()){
            int num = deque.poll();
            for(int next : graph[num]){
                dp[next] = Math.max(dp[next],timeTable[next]+ dp[num]);
                indegree[next] --;
                if(indegree[next]== 0){
                    deque.add(next);
                }
            }
        }

    }
    
}
