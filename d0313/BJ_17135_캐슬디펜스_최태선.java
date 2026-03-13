package d0313;

import java.io.*;
import java.util.*;

public class BJ_17135_캐슬디펜스_최태선 {
    static int N,M,D;
    static int[][] originalGraph;
    static boolean[] isSelected;
    static int[] di ={0,-1,0};
    static int[] dj ={-1,0,1};
    static int maxCount;
    static int[] nowSelected;
    static Deque<int[]> targeted;
    static Deque<int[]> deque;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        originalGraph = new int[N][M];
        isSelected = new boolean[M];
        nowSelected = new int[3];
        visited = new boolean[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                originalGraph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        deque = new ArrayDeque<>();
        maxCount = 0;
        targeted = new ArrayDeque<>();
        dfs(0,0);
        
        System.out.println(maxCount);
    }
    static void dfs(int selectCount,int nowIdx){
        if(selectCount==3){
            int k =0;
            int count =0;
            int[][] graph = new int[N][M];
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    graph[i][j] = originalGraph[i][j];
                }
            }
            for(int i=0;i<M;i++){
                if(isSelected[i] == true){
                    nowSelected[k] = i;
                    k++;
                }
            }
            for(int c=0;c<N;c++){
                for(int i=0;i<3;i++){
                    bfs(N-1,nowSelected[i],graph); //targeted에 저장 
                }
                while(!targeted.isEmpty()){
                    int[] nowMonster = targeted.poll();
                    int nowI = nowMonster[0];
                    int nowJ = nowMonster[1];
                    if(graph[nowI][nowJ] == 1){ //안죽었으면
                        graph[nowI][nowJ] = 0;
                        count ++;
                    }
                }
                setNextGraph(graph); // 그래프를 한칸씩 내리는 함수
            }
            maxCount = Math.max(maxCount, count);
            // 처리 
            return;
        }
        if(nowIdx>=M)
            return;
        //현재번호 선택
        isSelected[nowIdx] = true;
        dfs(selectCount+1,nowIdx+1);
        isSelected[nowIdx] = false;
        //선택안함
        dfs(selectCount,nowIdx+1);
    }   
    static void setNextGraph(int[][] graph){
        for(int j=0;j<M;j++){
            for(int i=N-1;i>=0;i--){
                if(i!= 0)
                    graph[i][j] = graph[i-1][j]; 
                else
                    graph[i][j] = 0;
            }
        }
        
    }
    static void bfs(int i, int j,int[][] graph){
        if(graph[i][j] == 1){
            targeted.add(new int[]{i,j});
            return;
        }
        for(int q=0;q<N;q++){
            Arrays.fill(visited[q],false);
        }
        deque.clear();
        deque.add(new int[]{i,j});
        while(!deque.isEmpty()){
            int[] temp = deque.poll();
            int nowI = temp[0];
            int nowJ = temp[1];
            if(graph[nowI][nowJ] == 1){
                targeted.add(new int[] {nowI,nowJ});
                return;
            }
            for(int k=0;k<3;k++){
                int ni = nowI + di[k];
                int nj = nowJ + dj[k];
                if(ni>=0 && ni<N && nj>=0 && nj<M && visited[ni][nj] == false && (Math.abs(i-ni)+Math.abs(j-nj)) <= D-1){
                    visited[ni][nj] = true;
                    deque.add(new int[]{ni,nj});
                }
            }
        }
        
    }
}
