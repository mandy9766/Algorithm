package d0327;

import java.io.*;
import java.util.*;

public class BJ_2461_대표선수_최태선 {
    static int N,M;
    static int[][] graph; // 반, 크기
    static int minVal;

    static PriorityQueue<int[]> pq;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(graph[i]);
        }
        minVal =Integer.MAX_VALUE;
        pq = new PriorityQueue<>((a,b)-> Integer.compare(a[2], b[2]));
        int nowMin = Integer.MAX_VALUE;
        int nowMax = 0;
        
        for(int i=0;i<N;i++){
            nowMin = Math.min(nowMin,graph[i][0]);
            nowMax = Math.max(nowMax,graph[i][0]);
            pq.add(new int[]{i,0,graph[i][0]});
        }
        minVal = Math.min(minVal,nowMax-nowMin);
        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int i=node[0];
            int j=node[1];
            int val = node[2];
            j++;
            if(j>=M)
                break;
            nowMin = Math.min(pq.peek()[2],graph[i][j]);
            nowMax = Math.max(nowMax,graph[i][j]);
            minVal = Math.min(minVal,nowMax-nowMin);
            pq.add(new int[]{i,j,graph[i][j]});
        }
        System.out.println(minVal);
    }
}
