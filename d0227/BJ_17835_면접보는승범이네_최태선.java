package d0227;

import java.io.*;
import java.util.*;

public class BJ_17835_면접보는승범이네_최태선 {
    static int N,M,K;
    static int kArr[];
    static List<int[]>[] graph;
    static long[] dist;
    static long INF = 22222222222L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        kArr = new int[K];
        graph = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[e].add(new int[]{s,c}); // 역방향설계
        }
        dist = new long[N+1];
        Arrays.fill(dist,INF);

        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<K;i++){
            int num = Integer.parseInt(st.nextToken());
            dist[num] = 0;
            kArr[i] = num; 
        }
        dijkstra();
        long maxVal =0;
        int maxIdx = 0;
        for(int i=1;i<N+1;i++){
            if(maxVal<dist[i]){
                maxVal = dist[i];
                maxIdx = i;
            }
        }
        System.out.println(maxIdx);
        System.out.println(maxVal);
    }
    static void dijkstra(){
        PriorityQueue <long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        for(int i=0;i<K;i++){
            pq.add(new long[]{kArr[i],0});
        }
        
        while(!pq.isEmpty()){
            long[] nowNode = pq.poll();
            int nowNum = (int)nowNode[0];
            long nowDist = nowNode[1];
            if(nowDist>dist[nowNum])
                continue;
            for(int[] nextNode : graph[nowNum]){
                int nextNum = nextNode[0];
                int nextDist = nextNode[1];
                if((long)nextDist+nowDist <dist[nextNum]){
                    dist[nextNum] = (long)nextDist + nowDist;
                    pq.add(new long[]{nextNum,dist[nextNum]});
                }
            }

        }
    }
}
