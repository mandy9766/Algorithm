package d0220;

import java.io.*;
import java.util.*;

import org.omg.CORBA.ORBPackage.InvalidName;

public class BJ_1005_ACM크래프트_최태선 {
    static int N,K,W;
    static int[] D;
    static List<Integer>[] graph;
    static int[] inDegree;
    static int[] dp;
    static int[] time;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            graph = new ArrayList[N+1];
            for(int i=1;i<=N;i++){
                graph[i] = new ArrayList<>();
            }
            D = new int[N+1];
            inDegree = new int[N+1];
            dp = new int[N+1];
            time = new int[N+1];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<=N;i++){
                time[i] = Integer.parseInt(st.nextToken());
                dp[i] = time[i];
            }
            for(int i=0;i<K;i++){
                st = new StringTokenizer(br.readLine()," ");
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[from].add(to);
                inDegree[to] ++;
            }
            W = Integer.parseInt(br.readLine());
            topologicalSort();
            System.out.println(dp[W]);
        }
    }
    static void topologicalSort(){
        Deque <Integer> deque = new ArrayDeque<>();
        for(int i=1;i<=N;i++){
            if(inDegree[i] == 0){
                deque.add(i);
            }
        }
        while(!deque.isEmpty()){
            int now = deque.poll();
            for(int next : graph[now]){
                dp[next] = Math.max(dp[next],dp[now]+time[next]);
                inDegree[next] --;
                if(inDegree[next] == 0)
                    deque.add(next);
            }
        }
    }
}
