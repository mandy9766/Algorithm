package d0220;

import java.io.*;
import java.util.*;

public class SWEA_2105_디저트카페_최태선 {
    static int N,T;
    static int[][] graph;
    static boolean []eat;
    static int[] di = {1,-1,-1,1};
    static int[] dj = {1,1,-1,-1};
    static int startI, startJ;
    static int maxVal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            eat = new boolean[101];
            maxVal = 0;
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    startI = i;
                    startJ = j;
                    Dfs(i,j, 0,0);
                }
            }
            if(maxVal <3){
                System.out.println("#"+t+" -1");
            }else{
                System.out.println("#"+t+" "+maxVal);
            }
        }
    }

    static void Dfs(int i,int j,int count,int dir){
        if(i == startI && j == startJ){
            if(count != 0){
                maxVal = Math.max(maxVal, count);
                return;
            }
        }
        // 직진하는경우
        int ni = i+di[dir];
        int nj = j+dj[dir];
        if(ni>=0 && ni<N && nj>=0 && nj<N && eat[graph[ni][nj]] == false ){
            eat[graph[ni][nj]] = true;
            Dfs(ni,nj,count +1, dir);
            eat[graph[ni][nj]] = false;
        }
        
        // 도는경우
        int ndir = dir+1;
        if(ndir <4){
            ni = i+di[ndir];
            nj = j+dj[ndir];
            if(ni>=0 && ni<N && nj>=0 && nj<N && eat[graph[ni][nj]] == false){
                eat[graph[ni][nj]] = true;
                Dfs(ni,nj,count +1, ndir);
                eat[graph[ni][nj]] = false;
            }
        }
    
    }
}
