package m04.d0411;

import java.io.*;
import java.util.*;

public class SWEA_1263_사람네트워크2_최태선 {
    static int T,N;
    static int[][] graph;
    static int[][] dist;
    static int INF = Integer.MAX_VALUE/2;
    static int minVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            graph = new int[N][N];
            dist = new int[N][N];
            minVal = Integer.MAX_VALUE;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(graph[i][j] == 1)
                        dist[i][j] = 1;
                    else if(i == j){
                        dist[i][j] = 0;
                    }else{
                        dist[i][j] = INF;
                    }
                }
            }
            for(int k=0;k<N;k++){
                for(int i=0;i<N;i++){
                    for(int j=0;j<N;j++){
                        if(dist[i][j] > dist[i][k] + dist[k][j] ){
                            dist[i][j] = dist[i][k] + dist[k][j];
                        }
                    }
                }
            }
            for(int i=0;i<N;i++){
                int temp = 0;
                for(int j=0;j<N;j++){
                    temp +=dist[i][j];
                }
                minVal = Math.min(minVal,temp);
            }
            System.out.println("#"+t+" " +minVal);
        }
    }
}
