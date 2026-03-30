package d0212;
import java.io.*;
import java.util.*;

public class BJ_1600_말이되고픈원숭이_최태선 {
    static int K,W,H;
    static int[][][] dp; // k , i , j
    static int[][] graph;
    static Deque<int[]> deque;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static int[] hi = {-1,-2,-2,-1,1,2,2,1};
    static int[] hj = {-2,-1,1,2,2,1,-1,-2};
    static int answer;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        graph = new int[H][W];
        for(int i=0;i<H;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<W;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[K+1][H][W];
        for(int k=0;k<=K;k++){
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    dp[k][i][j] = -1;
                }
            }
        }
        deque = new ArrayDeque<>();
        deque.add(new int[]{0,0,0});
        dp[0][0][0] = 0;
        while(!deque.isEmpty()){
            int[] temp = deque.poll();
            int k = temp[0];
            int i = temp[1];
            int j = temp[2];
            int count = dp[k][i][j];

            
            // 말을 쓰는경우 8가지
            if(k<K){
                for (int p=0;p<8;p++){
                    int ni = i+hi[p];
                    int nj = j+hj[p];
                    if (ni < 0 || ni >= H || nj < 0 || nj >= W) continue;
                    if (graph[ni][nj] == 1) continue;
                    if(dp[k+1][ni][nj] == -1){
                        dp[k+1][ni][nj] = count+1;
                        deque.add(new int[]{k+1,ni,nj});
                    }
                }
            }
            // 원숭이모드 4가지
            for (int p=0;p<4;p++){
                int ni = i+di[p];
                int nj = j+dj[p];
                if (ni < 0 || ni >= H || nj < 0 || nj >= W) continue;
                if (graph[ni][nj] == 1) continue;
                if (dp[k][ni][nj] == -1) {
                    dp[k][ni][nj] = count + 1;
                    deque.add(new int[]{k, ni, nj});
                }
            }

        }
        System.out.println(-1);

    }    
}
