package d0213;

import java.io.*;
import java.util.*;

public class SWEA_1249_보급로_최태선 {
    static int[][] graph;
    static PriorityQueue<int[]> pq;
    static int[][] dist;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int N ;
    public static void main(String[] args) throws Exception{
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){
            N =Integer.parseInt(br.readLine());
            graph = new int[N][N];
            for(int i=0;i<N;i++){
                char[] cArr = br.readLine().toCharArray();
                for(int j=0;j<N;j++){
                    graph[i][j] = cArr[j]-'0';
                }
            }
            // 00 -> N-1,N-1 최소로
            dist = new int[N][N];
            for(int i=0;i<N;i++){
                Arrays.fill(dist[i],3000); 
            }
            dijkstra(0, 0);
            System.out.println("#"+(t+1)+" "+dist[N-1][N-1]);
        }
    }
    static void dijkstra(int p,int q){
        pq = new PriorityQueue<>((a,b)->Integer.compare(a[2], b[2]));
        pq.add(new int[]{p,q,graph[p][q]});
        dist[p][q] = graph[p][q];
        while(!pq.isEmpty()){
            int[] temp = pq.poll();
            int i = temp[0];
            int j = temp[1];
            int nowDist = temp[2];
            if(nowDist > dist[i][j])
                continue;
            for(int k=0;k<4;k++){
                int ni = i+di[k];
                int nj = j+dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<N){
                    int tempDist = dist[i][j] + graph[ni][nj];
                    if(tempDist < dist[ni][nj]){
                        dist[ni][nj] = tempDist;
                        pq.add(new int[]{ni,nj,tempDist});
                    }
                }
            }
        }
    }
}
