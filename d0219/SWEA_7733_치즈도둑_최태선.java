package Algorithm.d0219;

import java.io.*;
import java.util.*;

public class SWEA_7733_치즈도둑_최태선 {
    static int[][] graph;
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            graph = new int[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            

        }
    }
}
