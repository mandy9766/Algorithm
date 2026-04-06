package m04.d0406;

import java.io.*;
import java.util.*;

public class BJ_2583_영역구하기_최태선 {
    static int M,N,K;
    static int[][] graph;
    static Deque<int[]> deque;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static List<Integer> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        list = new ArrayList<>();
        deque = new ArrayDeque<>();
        for(int k=0;k<K;k++){
            st = new StringTokenizer(br.readLine()," ");
            int x1 =Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int i=x1;i<x2;i++){
                for(int j=y1;j<y2;j++){
                    graph[i][j] = 1;
                }
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(graph[i][j] == 0)
                    list.add(floodFill(i, j));
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for(int count : list){
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }
    static int floodFill(int nowI,int nowJ){
        deque.clear();
        int count =1;
        graph[nowI][nowJ] = 1; 
        deque.add(new int[]{nowI,nowJ});
        while(!deque.isEmpty()){
            int[] nowNode = deque.poll();
            int i = nowNode[0];
            int j = nowNode[1];
            for(int k=0;k<4;k++){
                int ni = i+di[k];
                int nj = j+dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<M && graph[ni][nj] == 0){
                    graph[ni][nj] =1;
                    count++;
                    deque.add(new int[]{ni,nj});
                }
            }
        }
        return count;
    }
}
