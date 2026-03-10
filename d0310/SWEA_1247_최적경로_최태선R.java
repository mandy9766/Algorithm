package d0310;

import java.io.*;
import java.util.*;

public class SWEA_1247_최적경로_최태선R {
    static int T,N;
    static int[][] pos;
    static int[][] graph;
    static int result;
    static boolean[] isSelected;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            result = Integer.MAX_VALUE/2;
            graph = new int[N+2][N+2];
            pos = new int[N+2][2];
            isSelected = new boolean[N+2];
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N+2;i++){
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                pos[i][0] = x;
                pos[i][1] = y;
            }
            for(int i=0;i<N+2;i++){
                for(int j=i+1;j<N+2;j++){
                    int x1 = pos[i][0];
                    int y1 = pos[i][1];
                    int x2 = pos[j][0];
                    int y2 = pos[j][1];
                    int weight = Math.abs(x1-x2) + Math.abs(y1-y2);
                    graph[i][j] = weight;
                    graph[j][i] = weight;
                }
            }
            dfs(0,0,0);
            System.out.println("#"+t+" "+result);
        }
    }
    static void dfs(int depth,int nowWeight,int lastPos){
        if(result<nowWeight)
            return;
        if (depth == N){
            result = Math.min(result,nowWeight +graph[lastPos][1]);
            return;
        }
        for(int i=2;i<N+2;i++){
            if(isSelected[i] == false){
                isSelected[i] = true;
                dfs(depth+1,nowWeight +graph[lastPos][i],i);
                isSelected[i] = false;
            }
        }
    }
}
