package m04.d0401;

import java.io.*;
import java.util.*;

public class BJ_1941_소문난칠공주_최태선 {
    static char[][] graph;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static boolean[][] visited;
    static boolean[][] isDone;
    static int count;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new char[5][5];
        isDone = new boolean[5][5];
        visited = new boolean[5][5];
        count = 0;
        for(int i=0;i<5;i++){
            graph[i] = br.readLine().toCharArray();
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                for(int k=0;k<5;k++){
                    Arrays.fill(visited[k], false);
                }
                visited[i][j] = true;
                if(graph[i][j] == 'S')
                    dfs(i,j,1,1); // 현재값이 선택됐다고 생각
                else
                    dfs(i,j,1,0);
                isDone[i][j] = true;
            }
        }
        System.out.println(count);
    }
    static void dfs(int i,int j,int depth, int sCount){
        if(depth == 7){
            if(sCount>=4)
            {   
                count++;
                for(int p=0;p<5;p++){
                    System.out.println(Arrays.toString(visited[p]));
                }
            }
            return;
        }
        for(int k=0;k<4;k++){
            int ni = i+di[k];
            int nj = j+dj[k];
            if(ni>=0 && ni<5 && nj>=0 && nj<5 && visited[ni][nj] == false && isDone[ni][nj] == false){
                visited[ni][nj] = true;
                if(graph[ni][nj] == 'S')
                    dfs(ni,nj,depth+1,sCount+1);
                else
                    dfs(ni,nj,depth+1,sCount);
                visited[ni][nj] = false;
            }
        }
    }
}
