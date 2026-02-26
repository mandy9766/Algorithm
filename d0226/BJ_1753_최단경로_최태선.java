package d0226;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class BJ_1753_최단경로_최태선 {
    static int INF = 5000000;
    static int V,E,start;
    static int[] dist;
    static List<int[]>[] graph;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());
        graph = new ArrayList[V+1];
        for(int i=0;i<=V;i++){
            graph[i] = new ArrayList<>();
        }
        dist = new int[V+1];
        Arrays.fill(dist,INF);
        dist[start] = 0;

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e,k}); // s에서 e로가는값 k
        }
        dijkstra();
        for(int i=1;i<=V;i++){
            if(dist[i] == INF)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }

    }
    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] next = pq.poll();
            int nowNum = next[0];
            int nowDist = next[1];
            if(nowDist>dist[nowNum])
                continue;
            for(int[] temp : graph[nowNum]){
                int nextNum = temp[0];
                int nextDist = temp[1];
                if(dist[nextNum]>dist[nowNum]+nextDist){
                    dist[nextNum] = dist[nowNum]+nextDist;
                    pq.add(new int[]{nextNum,dist[nextNum]});
                }
            }
        }

    }
    
}
