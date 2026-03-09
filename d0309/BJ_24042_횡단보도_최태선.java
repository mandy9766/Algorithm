package d0309;
import java.io.*;
import java.util.*;

public class BJ_24042_횡단보도_최태선 {
    static int N,M;
    static List<long[]>[] graph;
    static long[] dist;
    static long INF = Long.MAX_VALUE/2;
    
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        dist = new long[N+1];
        Arrays.fill(dist, INF);
        for(long i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(new long[]{b,i});
            graph[b].add(new long[]{a,i});
        }
        dijkstra();
        System.out.println(dist[N]);
    }
    static void dijkstra(){
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Long.compare(a[1],b[1]));
        dist[1] = 0;
        pq.add(new long[]{1,0});
        while(!pq.isEmpty()){
            long[] nowNode = pq.poll();
            int nowNum = (int)nowNode[0];
            long nowTime = nowNode[1];
            if(nowTime>dist[nowNum])
                continue;
            long tempTime = nowTime%M;
            for(long[] nextNode : graph[nowNum]){
                int nextNum = (int)nextNode[0];
                long nextTime = nextNode[1];
                if (nextTime< tempTime)
                    nextTime = M+nextTime;
                if(dist[nextNum] > nowTime +1 +(nextTime-tempTime)){
                    dist[nextNum] = nowTime +1 +(nextTime-tempTime);
                    pq.add(new long[]{nextNum,dist[nextNum]});
                }
            }
        }
        
    }
}
