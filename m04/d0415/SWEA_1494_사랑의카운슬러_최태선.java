package m04.d0415;

import java.io.*;
import java.util.*;

public class SWEA_1494_사랑의카운슬러_최태선 {
    static int T,N;
    static boolean[] selected;
    static int[][] pos;
    static long minVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            selected = new boolean[N];
            pos = new int[N][2];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                pos[i][0] = Integer.parseInt(st.nextToken());
                pos[i][1] = Integer.parseInt(st.nextToken());
            }
            minVal = Long.MAX_VALUE;
            dfs(0,0);
            System.out.println("#"+t+" "+ minVal);
        }
    }
    static void dfs(int depth,int startNum){
        if(depth == N/2){
            // 처리
            long Bx=0;
            long By=0;
            long Ax=0;
            long Ay=0;
            for(int i=0;i<N;i++){
                if(selected[i] == true){
                    Bx += pos[i][0];
                    By += pos[i][1];
                }
                else{
                    Ax += pos[i][0];
                    Ay += pos[i][1];
                }
            }
            minVal = Math.min(minVal,(Bx-Ax)*(Bx-Ax) + (By-Ay)*(By-Ay));
            return;
        }
        for(int i=startNum;i<N;i++){
            selected[i] = true;
            dfs(depth+1,i+1);
            selected[i] = false;
        }
    }
}
