package d0227;

import java.io.*;
import java.util.*;

public class BJ_1504_특정한최단경로_최태선 {
    static int N,E,V1,V2;
    static List<int[]>[] graph;
    static int[] dist;
    static int INF =55555555;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        dist = new int[N+1];
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        E = Integer.parseInt(st.nextToken());
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e,k});
            graph[e].add(new int[]{s,k});
        }
        st= new StringTokenizer(br.readLine()," ");
        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());
        int result1 = dijkstra(1, V1) + dijkstra(V1, V2) + dijkstra(V2, N);
        int result2 = dijkstra(1, V2) + dijkstra(V2, V1) + dijkstra(V1, N);

        int result = Math.min(result1,result2);
        if(result>=INF)
            System.out.println(-1);
        else
            System.out.println(result);
    }
    static int dijkstra(int start,int end){
        if (start == end)
            return 0;
        Arrays.fill(dist,INF);
        dist[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{start,0});
        while(!pq.isEmpty()){
            int[] nowNode = pq.poll();
            int nowNum = nowNode[0];
            int nowDist = nowNode[1];
            if(nowDist>dist[nowNum])
                continue;
            for(int[] nextNode : graph[nowNum]){
                int nextNum = nextNode[0];
                int nextDist = nextNode[1];
                if(dist[nextNum]>nowDist+nextDist){
                    dist[nextNum] = nowDist+nextDist;
                    pq.add(new int[]{nextNum,dist[nextNum]});
                }
            }
        }
        return dist[end];
    }
}
