package d0319;

import java.io.*;
import java.util.*;

public class BJ_17406_배열돌리기4_최태선 {
    static int N,M,K;
    static int[][] A;
    static int[] di = {0,1,0,-1};
    static int[] dj = {1,0,-1,0};
    static int[][] rotateList;
    static int minVal;
    static List<Integer> order;
    static boolean[] isSelected;
    static int[][] originalA;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = new int[N+1][M+1];
        rotateList = new int[K][3];
        minVal = Integer.MAX_VALUE;
        order = new ArrayList<>();
        isSelected = new boolean[K];
        originalA = new int[N+1][M+1];
        for(int i=1;i<N+1;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=1;j<M+1;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
                originalA[i][j] = A[i][j];
            }
        }
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine()," ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            rotateList[i][0] = r;
            rotateList[i][1] = c;
            rotateList[i][2] = s;
        }
        dfs(0);
        
        System.out.println(minVal);
    }
    static void dfs(int depth){
        if(depth == K){
            for(int nowOrder : order){
                int r = rotateList[nowOrder][0];
                int c = rotateList[nowOrder][1];
                int s = rotateList[nowOrder][2];
                rotate(r,c,s);
            }
            getMinVal();
            // 그래프원복
            for(int i=0;i<N+1;i++){
                for(int j=0;j<M+1;j++){
                    A[i][j] = originalA[i][j];
                }
            }
            return;
        }
        for(int i=0;i<K;i++){
            if(isSelected[i] == false){
                isSelected[i] = true;
                order.add(i);
                dfs(depth+1);
                order.remove(order.size()-1);
                isSelected[i] = false;
            }
        }

    }
    static void getMinVal(){
        for(int i=1;i<N+1;i++){
            int val =0;
            for(int j=1;j<M+1;j++){
                val += A[i][j];
            }
            minVal = Math.min(minVal,val);
        }
    }
    static void rotate(int r,int c,int s){
        for(int size = s;size>0;size--){
            rotateLogic(r-size,c-size,size);
        }
    }
    static void rotateLogic(int startI,int startJ,int size){
        int past = A[startI][startJ];
        int temp = -1;
        int ni = startI;
        int nj = startJ;
        for(int k=0;k<4;k++){
            for(int i=0;i<size*2;i++){
                ni += di[k];
                nj += dj[k];
                temp = A[ni][nj];
                A[ni][nj] = past;
                past = temp;
            }
        }
    }
}
