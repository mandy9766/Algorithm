package d0212;

import java.io.*;
import java.util.*;

public class SWEA_1861_정사각형방_최태선 {
    static int N;
    static int[][] A;
    static int nowMinVal,nowMaxVal;
    static int ansLen,ansNum;
    static boolean[][] visited;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            A = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<N;j++){
                    A[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            ansLen = 0;
            ansNum = 0;
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    nowMaxVal = nowMinVal = A[i][j];
                    Dfs(i,j);
                    int tempLength = nowMaxVal - nowMinVal +1;
                    if(tempLength > ansLen){
                        ansLen = tempLength;
                        ansNum = nowMinVal;
                    }else if(tempLength == ansLen){
                        ansNum = Math.min(ansNum,nowMinVal);
                    }
                    
                }
            }
            System.out.println("#"+(t+1) +" " +ansNum + " "+ansLen);
        }
    }
    static void Dfs(int i,int j){
        if(visited[i][j] == true){
            return;
        }
        visited[i][j] = true;
        for(int k=0;k<4;k++){
            int ni = i +di[k];
            int nj = j +dj[k];
            if(ni>=0 && ni<N && nj>=0 && nj<N && visited[ni][nj]==false){
                if(A[ni][nj] == A[i][j]+1){
                    nowMaxVal = A[ni][nj];
                    Dfs(ni,nj);
                }else if(A[ni][nj] == A[i][j]-1){
                    nowMinVal = A[ni][nj];
                    Dfs(ni,nj);
                }
            }

        }
    }
}
