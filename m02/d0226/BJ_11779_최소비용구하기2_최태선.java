package d0226;

import java.io.*;
import java.util.*;


public class BJ_11779_최소비용구하기2_최태선 {
    static int n,m,start,end;
    static int[][] graph;
    static int[] dist;
    static int[] path;
    static int INF = 105555555;
    static StringBuilder sb;
    static int ansCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(graph[i],-1);
        }
        dist = new int[n+1];
        path = new int[n+1];

        Arrays.fill(dist,INF);
        m = Integer.parseInt(br.readLine());
        for(int i=0;i<m;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s =Integer.parseInt(st.nextToken());
            int e =Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            if(graph[s][e] == -1)
                graph[s][e] = k;
            else{
                if(graph[s][e]>k)
                    graph[s][e] = k;
            }
        }
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        dist[start] = 0;
        dijkstra();
        System.out.println(dist[end]);
        sb= new StringBuilder();
        getPath(end,1);
        System.out.println(ansCount);
        System.out.println(sb);
        
    }
    static void getPath(int num,int count){
        if(num == start){
            sb.append(start).append(" ");
            ansCount = count;
            return;
        }
        getPath(path[num], count+1);
        sb.append(num).append(" ");
    }
    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] nowNode = pq.poll();
            int nowNum = nowNode[0];
            int nowDist = nowNode[1];
            if(nowDist>dist[nowNum])
                continue;
            for(int next=1;next<n+1;next++){
                if(graph[nowNum][next] != -1 && graph[nowNum][next] + nowDist < dist[next]){
                    path[next] = nowNum;
                    dist[next] = graph[nowNum][next] + nowDist;
                    pq.add(new int[]{next,dist[next]});
                }
            }
        }
    }
    
}
