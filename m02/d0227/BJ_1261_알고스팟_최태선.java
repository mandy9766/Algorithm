package d0227;

import java.io.*;
import java.util.*;

public class BJ_1261_알고스팟_최태선 {
    static int N ,M;
    static int[][] graph;
    static int[][] dist;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int INF = 55555;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0;i<N;i++){
            char[] cArr = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                graph[i][j] = cArr[j]-'0';
            }
        }
        dist = new int[N][M];
        for(int i=0;i<N;i++){
            Arrays.fill(dist[i],INF);
        }
        dist[0][0] = 0;
        dijkstra();
        System.out.println(dist[N-1][M-1]);
    }
    static void dijkstra(){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        while(!pq.isEmpty()){
            int[] nowNode = pq.poll();
            int nowI = nowNode[0];
            int nowJ = nowNode[1];
            int nowDist= nowNode[2];
            if(nowDist>dist[nowI][nowJ])
                continue;
            for(int k=0;k<4;k++){
                int ni= nowI + di[k];
                int nj= nowJ + dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<M){
                    if(nowDist+graph[ni][nj] < dist[ni][nj]){
                        dist[ni][nj] = nowDist+graph[ni][nj];
                        pq.add(new int[]{ni,nj,dist[ni][nj]});
                    }
                }
            }
        }

    }
}
