package d0211;

import java.io.*;
import java.util.*;


public class SWEA_2805_농작물수확하기_최태선 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            int N = Integer.parseInt(br.readLine());
            int[][] graph = new int[N][N];
            for(int i=0;i<N;i++){
                char[] cArr = br.readLine().toCharArray();
                for(int j=0;j<N;j++){
                    graph[i][j] = cArr[j]-'0';
                }
            }
            int sum = 0;
            int mid = N/2;
            // 일단 중간 다더하고
            for(int j=0;j<N;j++){
                sum += graph[mid][j];
            }
            for(int depth = 1; depth<=mid;depth++){
                for(int start = depth; start<N-depth; start ++){
                    sum += graph[mid + depth][start];
                    sum += graph[mid - depth][start];
                }
            }
            System.out.println("#"+(t+1) +" "+sum);
        }
    }
}
