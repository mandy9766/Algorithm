package d0212;

import java.io.*;
import java.util.*;

public class BJ_1992_쿼드트리_최태선 {
    static int[][] graph;
    static int N;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for(int i=0;i<N;i++){
            char[] temp = br.readLine().toCharArray();
            for(int j=0;j<N;j++){
                graph[i][j] = temp[j] - '0';
            }
        }
        makeTree(0, 0, N);
        System.out.println(sb);
    }
    static void makeTree(int startI,int startJ,int size){
        
        int numCheck = check(startI,startJ,size);
        if (numCheck == 1){
            sb.append(1);
        }else if(numCheck == 0){
            sb.append(0);
        }else{
            sb.append("(");
            makeTree(startI, startJ, size/2);
            makeTree(startI, startJ+size/2, size/2);
            makeTree(startI+size/2, startJ, size/2);
            makeTree(startI+size/2, startJ+size/2, size/2);
            sb.append(")");
        }

    }
    static int check(int i, int j, int size){  // 주어진 idx~ size 사이 전부 1 -> 1, 0-> 0, 아니면 -1 리턴
        int first = graph[i][j];
        for(int p=i;p<i+size;p++){
            for (int q=j;q<j+size;q++){
                if(graph[p][q] != first){
                    return -1;
                }
            }
        }
        return first;
    }
}
