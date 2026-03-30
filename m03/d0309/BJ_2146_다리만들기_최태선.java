package d0309;

import java.io.*;
import java.util.*;


public class BJ_2146_다리만들기_최태선 {
    static int minCount,N;
    static int[][] graph;
    static boolean[][] done;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        done = new boolean[N][N];
        visited = new boolean[N][N];
        minCount = Integer.MAX_VALUE;
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j] == 1 && done[i][j] == false)
                    bfs(i,j);
            }
        }
        System.out.println(minCount);
    }
    static void bfs(int i, int j){
        Deque<int[]> deque = new ArrayDeque<>();
        Deque<int[]> border = new ArrayDeque<>();
        for(int q=0;q<N;q++)
            Arrays.fill(visited[q],false);

        // 가장자리 border에넣고, done처리(이미 체크한섬 안하게), visited처리 (bfs처리용)
        visited[i][j] = true;
        done[i][j] = true;
        if(check(i, j))
            border.add(new int[]{i,j,0});
        deque.add(new int[]{i,j});
        while(!deque.isEmpty()){
            int[] now = deque.poll();
            int nowI = now[0];
            int nowJ = now[1];
            for(int k=0;k<4;k++){
                int ni = nowI + di[k];
                int nj = nowJ + dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<N && graph[ni][nj] == 1 && visited[ni][nj] == false){
                    visited[ni][nj] = true;
                    done[ni][nj] = true;
                    deque.add(new int[]{ni,nj});
                    if(check(ni,nj))
                        border.add(new int[]{ni,nj,0});
                }
            }
        }

        // border 에서 bfs해서 
        while(!border.isEmpty()){
            int[] now = border.poll();
            int nowI = now[0];
            int nowJ = now[1];
            int nowVal = now[2];
            if(nowVal >= minCount)
                return;
            for(int k=0;k<4;k++){
                int ni = nowI + di[k];
                int nj = nowJ + dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<N && visited[ni][nj] == false){
                    visited[ni][nj] = true;
                    if(graph[ni][nj] == 0)
                        border.add(new int[]{ni,nj,nowVal+1});
                    else{
                        minCount = nowVal;
                        return;
                    }
                }
            }
        }


    }
    
    static boolean check(int i,int j){
        for(int k=0;k<4;k++){
            int ni = i+di[k];
            int nj = j+dj[k];
            if(ni>=0 && ni<N && nj>=0 && nj<N && graph[ni][nj] == 0)
                return true;
        }
        return false;
    }
}
