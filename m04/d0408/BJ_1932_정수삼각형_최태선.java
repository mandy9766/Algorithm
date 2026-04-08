package m04.d0408;

import java.io.*;
import java.util.*;

public class BJ_1932_정수삼각형_최태선 {
    static int N;
    static int[][] graph; 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<=i;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=N-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                graph[i][j] = Math.max(graph[i+1][j],graph[i+1][j+1]) +graph[i][j];
            } 
        }
        System.out.println(graph[0][0]);
    }
}
