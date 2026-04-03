package m04.d0403;

import java.io.*;
import java.util.*;

public class BJ_1799_비숍_최태선 {
    static int N;
    static int[][] graph;
    static int maxVal;
    static int [] di = {-1,-1,1,1};
    static int [] dj = {-1,1,1,-1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }   

        maxVal = 0;
        dfs(0,0);
        System.out.println(maxVal);

    }
    static void dfs(int nowIdx,int nowCount){
        if(nowIdx == N*N){
            maxVal = Math.max(maxVal, nowCount);
            return;
        }
        int nowI = nowIdx/N;
        int nowJ = nowIdx%N;
        //현재 i 값 넣을수 있으면 넣기
        if(graph[nowI][nowJ] == 1){
            //넣는처리 3으로 덮어쓰기, 지나간자리 원복용으로 저장하고 몇개인지 세기
            int[][] beforeGraph = new int[N][N];
            for(int i=0;i<N;i++){
                beforeGraph[i] = graph[i].clone();
            }
            setGraph(nowI, nowJ);
            dfs(nowIdx+1,nowCount+1);
            //원복
             for(int i=0;i<N;i++){
                graph[i] = beforeGraph[i].clone();
            }
        }
        // 안넣고 그냥 넘기기
        dfs(nowIdx+1,nowCount);
    }
    static void setGraph(int i,int j){
        graph[i][j] = 3;
        for(int p=1;p<10;p++) // p는 앞으로간 칸
        {
            for(int k=0;k<4;k++){
                int ni = i+p*di[k];
                int nj = j+p*dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<N)
                    graph[ni][nj] = 3;
            }
        }
    }
}
   
