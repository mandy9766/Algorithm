package m04.d0407;

import java.io.*;
import java.util.*;


public class SWEA_2383_홈방범서비스_최태선 {
    static int T,N,M;
    static int[][] graph;
    static int[] dp;
    static int[] count;
    static int[] sumCount;
    static List<int[]> pos;
    static int maxVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new int[N][N];
            count = new int[41];
            sumCount = new int[41];
            pos = new ArrayList<>();
            maxVal = 0;
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if(graph[i][j] == 1)
                        pos.add(new int[]{i,j});
                }
            }
            dp = new int[41];
            dp[1] = 1;
            for(int i=2;i<41;i++){
                dp[i] = dp[i-1] +4*(i-1);
            }
            
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    Arrays.fill(count,0);
                    Arrays.fill(sumCount,0);
                    // i,j가 현재 후보
                    // i,j에서의 각 맨헤튼 거리구해서 count에 업데이트
                    for(int[] nowPos :pos){
                        int nowI = nowPos[0];
                        int nowJ = nowPos[1];
                        int dist = Math.abs(nowI-i) +Math.abs(nowJ-j);
                        count[dist] ++;
                    }
                    sumCount[0] = count[0];
                    for(int k=1;k<41;k++){
                        sumCount[k] = sumCount[k-1] +count[k]; // 멘헤튼 거리가 K면 방범은 K+1이어야 커버가능
                    }
                    for(int d=0;d<40;d++){
                        if(sumCount[d]*M >= dp[d+1])
                            maxVal = Math.max(maxVal,sumCount[d]);
                    }

                }
            }
            System.out.println("#"+t+" " + maxVal);

            
        }
    }
}
