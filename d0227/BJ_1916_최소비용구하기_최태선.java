package d0227;

import java.io.*;
import java.util.*;

public class BJ_1916_최소비용구하기_최태선 {
    static int N,M,A,B;
    static List<int[]>[] graph;
    static int[] dist;
    static int INF = 555555555;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }
        dist = new int[N+1];
        Arrays.fill(dist,INF);
        dist[A] = 0;
        for(int i=0;i<M;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e,k});
        }
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        dijkstra();
        System.out.println(dist[B]);

    }
    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{A,0});
        while(!pq.isEmpty()){
            int[] nowNode = pq.poll();
            int nowNum = nowNode[0];
            int nowDist = nowNode[1];
            if(nowDist > dist[nowNum])
                continue;
            for(int[] nextNode : graph[nowNum]){
                int nextNum = nextNode[0];
                int nextDist = nextNode[1];
                if(nextDist+nowDist<dist[nextNum]){
                    dist[nextNum] = nextDist + nowDist;
                    pq.add(new int[]{nextNum,dist[nextNum]});
                }

            }
        }
    }
}
