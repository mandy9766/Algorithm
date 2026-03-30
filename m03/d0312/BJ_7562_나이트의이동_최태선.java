package d0312;

import java.io.*;
import java.util.*;


public class BJ_7562_나이트의이동_최태선 {
    static int T,N;
    static int startI,startJ;
    static int goalI, goalJ;
    static int[][] graph;
    static int [] di = {-2,-1,1,2,2,1,-1,-2};
    static int [] dj = {1,2,2,1,-1,-2,-2,-1};
    static int INF = Integer.MAX_VALUE/2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            for(int i=0;i<N;i++){
                Arrays.fill(graph[i],INF);
            }
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            startI = Integer.parseInt(st.nextToken());
            startJ = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine()," ");
            goalI = Integer.parseInt(st.nextToken());
            goalJ = Integer.parseInt(st.nextToken());
            int result = bfs();
            System.out.println(result);
        }
    }
    static int bfs(){
        graph[startI][startJ] = 0;
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startI,startJ,0});
        while(!deque.isEmpty()){
            int[] nowNode = deque.poll();
            int nowI = nowNode[0];
            int nowJ = nowNode[1];
            int nowCount = nowNode[2];
            if(nowI == goalI && nowJ == goalJ)
                return nowCount;
            for(int k=0;k<8;k++){
                int ni = nowI + di[k];
                int nj = nowJ + dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<N && graph[ni][nj] > nowCount+1){
                    graph[ni][nj] = nowCount+1;
                    deque.add(new int[]{ni,nj,graph[ni][nj]});
                }
            }
        }
        return -1;
    }
}
