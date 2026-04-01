package m04.d0401;

import java.io.*;
import java.util.*;

public class BJ_1941_소문난칠공주_최태선R {
    static char[][] graph;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static boolean[][] isSelected;
    static boolean[][] visited;
    static int count;
    static Deque<int[]> deque;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new char[5][5];
        isSelected = new boolean[5][5];
        visited = new boolean[5][5];
        count = 0;
        deque = new ArrayDeque<>();
        for(int i=0;i<5;i++){
            graph[i] = br.readLine().toCharArray();
        }
        dfs(0,0,0);
        System.out.println(count);
    }
    static void dfs(int startNum,int depth, int sCount){
        if(depth == 7){
            if(sCount>=4)
            {   
                if(bfs(startNum-1) == 7){ // 바로 이전 선택한거에서 bfs돌리기
                    count++;
                }
            }
            return;
        }
        for(int i=startNum;i<25;i++){
            isSelected[i/5][i%5] = true;
            if(graph[i/5][i%5] == 'S')
                dfs(i+1,depth+1,sCount+1);
            else
                dfs(i+1,depth+1,sCount);
            isSelected[i/5][i%5] = false;
        }
        return;
    }
    static int bfs(int startNum){
        int nowCount = 0;
        for(int i=0;i<5;i++){
            Arrays.fill(visited[i],false);
        }
        deque.clear();
        int nowI = startNum/5;
        int nowJ = startNum%5;
        visited[nowI][nowJ] = true;
        deque.add(new int[]{nowI,nowJ});
        while(!deque.isEmpty()){
            int[] nowNode = deque.poll();
            nowI = nowNode[0];
            nowJ = nowNode[1];
            nowCount ++;
            for(int k=0;k<4;k++){
                int ni = nowI +di[k];
                int nj = nowJ +dj[k];
                if(ni>=0 && ni<5 && nj>=0 && nj<5 && isSelected[ni][nj] == true && visited[ni][nj] == false)
                {
                    visited[ni][nj] = true;
                    deque.add(new int[]{ni,nj});
                }
            }
        }
        return nowCount;
    }
}
