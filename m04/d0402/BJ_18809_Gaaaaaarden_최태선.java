package m04.d0402;

import java.io.*;
import java.util.*;

public class BJ_18809_Gaaaaaarden_최태선 {
    static int N,M,G,R;
    static int[][] graph;
    static int[][] pos;
    static int[][] redPositon;
    static int[][] greenPositon;
    static int posCount;
    static int maxVal;
    static Deque<int[]> greenDeque;
    static Deque<int[]> redDeque;
    static Deque<int[]> tempDeque;
    static int[][] bfsGraph;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        bfsGraph = new int[N][M];
        pos = new int[10][2];
        redPositon = new int[R][2];
        greenPositon = new int[G][2];
        posCount = 0;
        maxVal = 0;
        greenDeque = new ArrayDeque<>();
        redDeque = new ArrayDeque<>();
        tempDeque = new ArrayDeque<>();
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 2){
                    pos[posCount][0] = i;
                    pos[posCount][1] = j;
                    posCount++;
                }
            }
        }
        dfs(0,0,0);
        System.out.println(maxVal);

    }
    static void dfs(int depth,int rCount,int gCount){
        if(rCount == R && gCount == G){
            //처리
            int count = bfs();
            maxVal = Math.max(maxVal,count);
            return;
        }
        if(depth >=posCount)
            return;
        int nowI = pos[depth][0];
        int nowJ = pos[depth][1];
        if(gCount<G)
        {  
            greenPositon[gCount][0] = nowI;
            greenPositon[gCount][1] = nowJ;
            graph[nowI][nowJ] = 3; // 3은 그린! 
            dfs(depth+1,rCount,gCount+1);
            graph[nowI][nowJ] = 2;
        }
        if(rCount<R){
            redPositon[rCount][0] = nowI;
            redPositon[rCount][1] = nowJ;
            graph[nowI][nowJ] = 4; // 4는 레드! 
            dfs(depth+1,rCount+1,gCount);
            graph[nowI][nowJ] = 2;
        }
        dfs(depth+1,rCount,gCount); // 안뿌리고 넘기기
    }
    static int bfs(){
        int count =0;
        for(int i=0;i<N;i++){
            bfsGraph[i] = graph[i].clone();
        }
        tempDeque.clear();
        greenDeque.clear();
        redDeque.clear();
        for(int i=0;i<R;i++){
            bfsGraph[redPositon[i][0]][redPositon[i][1]] = 4;
            redDeque.add(new int[]{redPositon[i][0],redPositon[i][1]});
        }
        for(int i=0;i<G;i++){
            bfsGraph[greenPositon[i][0]][greenPositon[i][1]] = 3;
            greenDeque.add(new int[]{greenPositon[i][0],greenPositon[i][1]});
        }
        while(!greenDeque.isEmpty() && !redDeque.isEmpty()){
            int greenSize = greenDeque.size();
            int redSize = redDeque.size();
            for(int i=0;i<greenSize;i++){
                int[] nowNode = greenDeque.poll(); 
                int nowI = nowNode[0];
                int nowJ = nowNode[1];
                for(int k=0;k<4;k++){
                    int ni = nowI + di[k];
                    int nj = nowJ + dj[k];
                    if(ni>=0 && ni<N && nj>=0 && nj<M && (bfsGraph[ni][nj] == 1 ||bfsGraph[ni][nj] == 2)){
                        bfsGraph[ni][nj] = 7;
                        tempDeque.add(new int[]{ni,nj});
                    }
                }
            }
            for(int i=0;i<redSize;i++){
                int[] nowNode = redDeque.poll(); 
                int nowI = nowNode[0];
                int nowJ = nowNode[1];
                for(int k=0;k<4;k++){
                    int ni = nowI + di[k];
                    int nj = nowJ + dj[k];
                    if(ni>=0 && ni<N && nj>=0 && nj<M ){
                        if(bfsGraph[ni][nj] == 1 ||bfsGraph[ni][nj] == 2)
                        {
                            bfsGraph[ni][nj] = 4;
                            redDeque.add(new int[]{ni,nj});
                        }
                        if(bfsGraph[ni][nj] == 7)
                        {
                            bfsGraph[ni][nj] = 5;
                            count ++;
                        }
                    }
                }
            }
            while(!tempDeque.isEmpty()){
                 int[] nowNode = tempDeque.poll(); 
                int nowI = nowNode[0];
                int nowJ = nowNode[1];
                if(bfsGraph[nowI][nowJ] == 7){
                    bfsGraph[nowI][nowJ] = 3;
                    greenDeque.add(new int[]{nowI,nowJ});
                }
            }
        }

        return count;
    }
}
