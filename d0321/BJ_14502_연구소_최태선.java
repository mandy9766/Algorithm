package d0321;

import java.util.*;
import java.io.*;

public class BJ_14502_연구소_최태선 {
    static int N,M;
    static int[][] graph;
    static int[][] originalGraph;
    static int maxVal;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static List<int[]> startPos;
    static int[][] nowSelected;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        startPos = new ArrayList<>();
        graph = new int[N][M];
        originalGraph = new int[N][M];
        nowSelected = new int[3][2];
        maxVal = 0;
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                originalGraph[i][j] =graph[i][j];
                if(graph[i][j] == 2)
                    startPos.add(new int[]{i,j});
            }
        }
        dfs(0,0);
        System.out.println(maxVal);
    }
    static void dfs(int detph,int nowStart){
        if(detph == 3){
            for(int i=0;i<3;i++){
                int p = nowSelected[i][0];
                int q = nowSelected[i][1];
                graph[p][q] = 1;
            }
            bfs();
            for(int i=0;i<N;i++){
                graph[i] = originalGraph[i].clone();
            }
            return;
        }
        for(int i=nowStart;i<N*M;i++){
            int nowI = i/M;
            int nowJ = i%M;
            if(originalGraph[nowI][nowJ] == 0){
                nowSelected[detph][0] = nowI;
                nowSelected[detph][1] = nowJ;
                dfs(detph+1, i+1);
            }
        }
    }
    // 현재 그래프 상황에서 바이러스 퍼트리고 카운트 세서 maxVal까지 업데이트하는 함수
    static void bfs(){
        Deque<int[]> deque = new ArrayDeque<>();
        for(int[] node : startPos){
            deque.add(node);            
        }
        while(!deque.isEmpty()){
            int[] node = deque.poll();
            int nowI = node[0];
            int nowJ = node[1];
            for(int k=0;k<4;k++){
                int ni = nowI+di[k];
                int nj = nowJ +dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<M && graph[ni][nj] ==0){
                    graph[ni][nj] = 2;
                    deque.add(new int[]{ni,nj});
                }
            }
        }
        int count = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(graph[i][j] == 0)
                    count ++;
            }
        }
        maxVal = Math.max(maxVal, count);
        return;
    }
}
