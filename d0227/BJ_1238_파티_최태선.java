package d0227;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class BJ_1238_파티_최태선 {
    static int N,M,X;
    static List<int[]>[] graph,revGraph;
    static int[] dist,revDist,result;
    static int INF = 15555555;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        // 그래프, rev그래프 초기화
        graph = new ArrayList[N+1];
        revGraph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }
        //dist, revDist 초기화
        dist = new int[N+1];
        revDist = new int[N+1];
        result = new int[N+1];
        Arrays.fill(dist,INF);
        Arrays.fill(revDist,INF);
        dist[X] = 0;
        revDist[X] = 0;

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine()," ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[start].add(new int[]{end,t});
            revGraph[end].add(new int[]{start,t});
        }
        dijkstra();
        dijkstraR();
        for(int i=1;i<=N;i++){
            result[i] = dist[i] + revDist[i];
        }
        int maxVal =0;
        for(int i=1;i<=N;i++){
            maxVal = Math.max(maxVal,result[i]);
        }
        System.out.println(maxVal);
    }
    
    static void dijkstraR(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{X,0});
        while(!pq.isEmpty()){
            int[] nowNode =pq.poll();
            int nowNum = nowNode[0];
            int nowDist = nowNode[1];
            if(nowDist>revDist[nowNum])
                continue;
            for(int[] nextNode : revGraph[nowNum]){
                int nextNum = nextNode[0];
                int nextDist = nextNode[1];
                if(nowDist+nextDist < revDist[nextNum]){
                    revDist[nextNum] = nowDist + nextDist;
                    pq.add(new int[]{nextNum,revDist[nextNum]});
                }
            }
        }
    }
    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        pq.add(new int[]{X,0});
        while(!pq.isEmpty()){
            int[] nowNode =pq.poll();
            int nowNum = nowNode[0];
            int nowDist = nowNode[1];
            if(nowDist>dist[nowNum])
                continue;
            for(int[] nextNode : graph[nowNum]){
                int nextNum = nextNode[0];
                int nextDist = nextNode[1];
                if(nowDist+nextDist < dist[nextNum]){
                    dist[nextNum] = nowDist + nextDist;
                    pq.add(new int[]{nextNum,dist[nextNum]});
                }
            }
        }
    }
}
