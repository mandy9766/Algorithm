package d0220;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BJ_9470_Strahler순서_최태선 {
    static int T,K,M,P;
    static List<Integer>[] graph, revGraph;
    static int[] indegree,dp; // dp는 i까지의 Starhler 숫자
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            K = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            indegree = new int[M+1];
            dp = new int[M+1];
            Arrays.fill(dp, 1);
            graph = new ArrayList[M+1];
            revGraph = new ArrayList[M+1];
            for(int i=1;i<=M;i++){
                graph[i] = new ArrayList<>();
                revGraph[i] = new ArrayList<>();

            }
            for(int i=0;i<P;i++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                revGraph[to].add(from);
                indegree[to] ++;
            }
            topologicalSort();
            System.out.println(K+" "+dp[M]);
        }
    }
    static void topologicalSort(){
        Deque<int[]> deque = new ArrayDeque<>();
        for(int i=1;i<=M;i++){
            if(indegree[i] == 0)
                deque.add(new int[]{i,1});
        }
        while(!deque.isEmpty()){
            int[] temp = deque.poll();
            int num = temp[0];
            int count = temp[1];
            dp[num] = Math.max(dp[num],count);
            
            for(int next : graph[num]){
                indegree[next] --;
                if(indegree[next] == 0){
                    int maxVal =0;
                    for(int n : revGraph[next]){
                        maxVal = Math.max(maxVal, dp[n]);
                    }
                    int c= 0;
                    for(int n : revGraph[next]){
                        if(maxVal == dp[n])
                            c ++;
                    }
                    if (c>=2)
                        deque.add(new int[]{next,maxVal+1});
                    else
                        deque.add(new int[]{next,maxVal});
                }
            }
        }
    }
}
