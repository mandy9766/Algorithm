package m04.d0403;

import java.io.*;
import java.util.*;

public class BJ_1799_비숍_최태선R {
    static int N;
    static int[][] graph;
    static int maxVal[];
    static int [] di = {-1,-1,1,1};
    static int [] dj = {-1,1,1,-1};
    static boolean[] up; // 합이 일정
    static boolean[] down; // 차가 일정
    
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
        up = new boolean[2*N-1]; //우상향
        down = new boolean[2*N-1]; // 우하향
        maxVal = new int[2];
        maxVal[0] = 0;
        maxVal[1] = 0;
        dfs(0,0,0,0);
        dfs(0,1,0,1);
        System.out.println(maxVal[0]+maxVal[1]);

    }
    static void dfs(int i, int j,int nowCount , int color){
        if(j >= N){
            i++;
            if(j%2 == 0){
                j = 1;
            }else{
                j = 0;
            }
        }
        
        if(i >= N){
            maxVal[color] = Math.max(maxVal[color], nowCount);
            return;
        }
        //현재 i 값 넣을수 있으면 넣기
        if(graph[i][j] == 1 && (up[i+j] == false && down[i-j + N-1] == false )){
            up[i+j] = true;
            down[i-j+N-1] = true;
            dfs(i,j+2,nowCount+1,color);
            //원복
            up[i+j] = false;
            down[i-j+N-1] = false;
        }
        // 안넣고 그냥 넘기기
        dfs(i,j+2,nowCount,color);
    }
    
}
   
