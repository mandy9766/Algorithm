package d0323;

import java.io.*;
import java.util.*;

public class BJ_14500_테트로미노_최태선 {
    static int maxVal;
    static int N,M;
    static int[][] graph;
    public static void main(String[] args) throws Exception {
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
        }
        maxVal = 0;
        for(int i=0;i<N;i++){
            for (int j=0;j<M;j++){
                check1(i, j);
                check2(i, j);
                check3(i, j);
                check4(i, j);
                check5(i, j);
            }
        }
        System.out.println(maxVal);
    }
    static void check1(int i,int j){
        if(j+3<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i][j+2]+graph[i][j+3]);
        if(i+3<N)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i+2][j]+graph[i+3][j]);
    }
    static void check2(int i,int j){
        if(i+1<N &&j+1<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i][j+1]+graph[i+1][j+1]);
    }
    static void check3(int i,int j){
        if(i+1<N && j+2<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i+1][j+1]+graph[i][j+2]);
        if(i+2<N && j+1<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i+1][j+1]+graph[i+2][j]);
        if(i-1>=0 && j+2<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i][j+2]+graph[i-1][j+1]);
        if(i+2<N && j-1>=0)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i+2][j]+graph[i+1][j-1]);
    }
    static void check4(int i,int j){
        if(i+2<N && j+1<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i+1][j+1]+graph[i+2][j+1]);
        if(i+2<N && j-1>=0)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i+1][j-1]+graph[i+2][j-1]);
        if(i-1>=0 && j+2<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i-1][j+1]+graph[i-1][j+2]);
        if(i+1<N && j+2<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i+1][j+1]+graph[i+1][j+2]);
    }
    static void check5(int i,int j){
        if(i+2<N && j+1<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i+1][j+1]+graph[i+2][j+1]);
        if(i+2<N && j+1<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i+1][j]+graph[i+2][j]);
        if(i+2<N && j+1<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i+2][j]+graph[i+2][j+1]);
        if(i+2<N && j-1>=0)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i+2][j]+graph[i+2][j-1]);
        if(i+1<N && j+2<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i][j+1]+graph[i][j+2]);
        if(i+1<N && j+2<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i][j+2]+graph[i+1][j+2]);
        if(i-1>=0 && j+2<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i][j+1]+graph[i][j+2]+graph[i-1][j+2]);
        if(i+1<N && j+2<M)
            maxVal = Math.max(maxVal,graph[i][j]+graph[i+1][j]+graph[i+1][j+1]+graph[i+1][j+2]);
    }
}
