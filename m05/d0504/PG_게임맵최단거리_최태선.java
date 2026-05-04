package m05.d0504;

import java.util.*;

public class PG_게임맵최단거리_최태선 {
     int[][] graph;
     int INF = 987654321;
     int minCount;
     boolean[][] visited;
     int N,M;
     int[] di = {-1,0,1,0};
     int[] dj = {0,1,0,-1};
     
     public int solution(int[][] maps) {
          graph = maps;
          minCount = INF;
          N = maps.length;
          M = maps[0].length;
          visited=  new boolean[N][M];
          bfs();
          if(minCount == INF)
               return -1;
          else
               return minCount;
          
     }
     void bfs(){
          Deque<int[]> deque;
          deque = new ArrayDeque<>();
          deque.add(new int[]{0,0,1});
          visited[0][0] = true;
          while(!deque.isEmpty()){
               int[] nowNode = deque.poll();
               int nowI = nowNode[0];
               int nowJ = nowNode[1];
               int nowCount = nowNode[2];
               if(nowI==N-1 && nowJ == M-1){
                    minCount = nowCount;
                    break;
               }
               for(int k=0;k<4;k++){
                    int ni = nowI+di[k];
                    int nj = nowJ+dj[k];
                    if(ni>=0 && ni<N&& nj>=0 && nj<M && visited[ni][nj] == false && graph[ni][nj] != 0){
                         visited[ni][nj] = true;
                         deque.add(new int[]{ni,nj,nowCount+1});
                    }
               }
               
          }
     }
}
