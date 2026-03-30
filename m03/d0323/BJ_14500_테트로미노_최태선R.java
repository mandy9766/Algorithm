package d0323;

import java.io.*;
import java.util.*;

public class BJ_14500_테트로미노_최태선R {
    static int maxVal;
    static int N,M;
    static int[][] graph;
    static boolean[][] visited;
    static int[] di ={-1,0,1,0};
    static int[] dj ={0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxVal = 0;
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                visited[i][j] = true;
                dfs(i,j,graph[i][j],1);
                visited[i][j] = false;
                check(i, j);
            }
        }
        System.out.println(maxVal);
    }
    static void dfs(int i,int j, int sum,int depth){
        if(depth ==4)
        {
            maxVal = Math.max(maxVal,sum);
            return;
        }
        for(int k=0;k<4;k++){
            int ni = i+di[k];
            int nj = j+dj[k];
            if(ni>=0 && ni<N && nj>=0 && nj<M && visited[ni][nj] == false){
                visited[ni][nj] = true;
                dfs(ni,nj,sum+graph[ni][nj],depth+1);
                visited[ni][nj] = false;
            }
        }
    }
    static void check(int i,int j){
        if(i+1<N && j+2<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i+1][j+1]+graph[i][j+2]);
        if(i+2<N && j+1<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i+1][j+1]+graph[i+2][j]);
        if(i-1>=0 && j+2<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i][j+2]+graph[i-1][j+1]);
        if(i+2<N && j-1>=0)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i+2][j]+graph[i+1][j-1]);
    }
}
