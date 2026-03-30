package d0312;

import java.io.*;
import java.util.*;

public class SWEA_2819_격자판의숫자이어붙이기_최태선 {
    static int T;
    static int[][] graph;
    static StringBuilder sb;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static Set<String> stringSet;
    public static void main(String[] args) throws Exception{
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            graph = new int[4][4];
            for(int i=0;i<4;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<4;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            stringSet = new HashSet<>();
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    sb= new StringBuilder();
                    sb.append(graph[i][j]);
                    dfs(i,j,1);
                }
            }
            System.out.println("#"+t+" "+ stringSet.size());

        }
    }
    static void dfs(int i,int j,int depth){
        if(depth == 7){
            stringSet.add(sb. toString());
            return;
        }
        
        for(int k=0;k<4;k++){
            int ni = i+di[k];
            int nj = j+dj[k];
            if(ni >=0 && ni<4 && nj>=0 && nj < 4)
            {
                sb.append(graph[ni][nj]);
                dfs(ni,nj,depth+1);
                sb.setLength(sb.length()-1);
            }
        }
        
    }
}
