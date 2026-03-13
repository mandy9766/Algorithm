package d0313;

import java.io.*;
import java.util.*;

public class BJ_17070_파이프옮기기1_최태선 {
    static int N;
    static int[][] graph;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0;
        dfs(new int[]{0,1,0}); // i1,j1,i2,j2,dir
        System.out.println(count);
    }
    static void dfs(int[] nowState){
        int i = nowState[0];
        int j = nowState[1];
        int dir = nowState[2];
        if(i == N-1 && j == N-1){
            count ++;
            return;
        }

        
        if(dir == 0 ){ // 가로인경우
            // 가로로 밀기
            if(j+1 <N && graph[i][j+1] == 0)
                dfs(new int[]{i,j+1,0});
            // 가로로밀고 대각선회전
            if(j+1<N && i+1<N && graph[i][j+1] == 0 && graph[i+1][j+1] == 0 && graph[i+1][j] == 0)
                dfs(new int[]{i+1,j+1,2});
        }else if(dir == 1) //세로인경우
        {
            //세로로 밀기
            if(i+1 <N && graph[i+1][j] == 0)
                dfs(new int[]{i+1,j,1});
            //세로로 밀고 대각선 회전
            if(j+1<N && i+1<N && graph[i][j+1] == 0 && graph[i+1][j+1] == 0 && graph[i+1][j] == 0)
                dfs(new int[]{i+1,j+1,2});
        }else{ // 대각인경우
            // 대각선으로 밀기
            if(j+1<N && i+1<N && graph[i][j+1] == 0 && graph[i+1][j+1] == 0 && graph[i+1][j] == 0)
                dfs(new int[]{i+1,j+1,2});
            //대각으로 밀고 가로방향으로 회전
            if(j+1 <N && graph[i][j+1] == 0)
                dfs(new int[]{i,j+1,0});
            //대각으로 밀고 세로방향으로 회전
            if(i+1 <N && graph[i+1][j] == 0)
                dfs(new int[]{i+1,j,1});
        }

    }
}
