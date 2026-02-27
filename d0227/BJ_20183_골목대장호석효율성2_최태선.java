package d0227;

import java.io.*;
import java.util.*;


public class BJ_20183_골목대장호석효율성2_최태선 {
    static int N,M,A,B;
    static long C;
    static List<int[]>[] graph;
    static long[] dist;
    static long INF = Long.MAX_VALUE/2;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Long.parseLong(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1;i<N+1;i++){
            graph[i] = new ArrayList<>();
        }
        dist = new long[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph[s].add(new int[]{e,k});
            graph[e].add(new int[]{s,k});
        }
        long start = 1;
        long end = C;
        long mid = 0;
        long minVal = Long.MAX_VALUE;
        while(start<=end){
            mid = (start+end)/2;
            dijkstra(mid);
            if(dist[B] == INF){
                start = mid+1;
            }else{
                minVal = Math.min(minVal, mid);  
                end = mid-1;
            }
        }
        if(minVal != Long.MAX_VALUE)   
            System.out.println(minVal);
        else  
            System.out.println(-1);
        
    }
    static void dijkstra(long mid){
        Arrays.fill(dist,INF);
        dist[A] = 0;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)->Long.compare(a[1],b[1]));
        pq.add(new long[] {A,0}); 
        while(!pq.isEmpty()){
            long[] nowNode = pq.poll();
            int nowNum = (int)nowNode[0];
            long nowDist = nowNode[1];
            if(nowDist>dist[nowNum])
                continue;
            for(int[] nextNode : graph[nowNum]){
                int nextNum = nextNode[0];
                int nextDist = nextNode[1];
                if(nextDist+nowDist > C)  
                    continue;
                if(nextDist>mid){ //최대 수금액이 더 크면 못감 mid는 이분탐색으로 찾아놓은 값
                    continue;
                }
                if(nowDist + nextDist < dist[nextNum]){
                    dist[nextNum] = nowDist + nextDist;
                    pq.add(new long[]{nextNum,dist[nextNum]});
                }
            }
        }
    }

}
