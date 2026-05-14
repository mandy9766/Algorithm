package m05.d0514;

import java.util.ArrayDeque;
import java.util.Deque;

public class PG_아이템줍기_최태선 {
     int[][] graph;
     int cX,cY,iX,iY;
     int[] dX = {-1,0,1,0};
     int[] dY = {0,1,0,-1};
     
     public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
          graph = new int[101][101];
          cX = characterX * 2;
          cY = characterY * 2;
          iX = itemX * 2;
          iY = itemY * 2;
          for(int i=0;i<rectangle.length;i++){
               int x1 = rectangle[i][0] *2;
               int y1 = rectangle[i][1] *2;
               int x2 = rectangle[i][2] *2;
               int y2 = rectangle[i][3] *2;
               for(int k=x1;k<=x2;k++){
                    if(graph[k][y1] != 2)
                         graph[k][y1] = 1;
                    if(graph[k][y2] != 2)
                         graph[k][y2] = 1;
               }
               for(int k=y1;k<=y2;k++){
                    if(graph[x1][k] != 2)
                         graph[x1][k] = 1;
                    if(graph[x2][k] != 2)
                         graph[x2][k] = 1;
               }
               for(int p=x1+1;p<x2;p++){
                    for(int q=y1+1;q<y2;q++){
                         graph[p][q] = 2;
                    }
               }
          }
          return bfs()/2;
     }
     int bfs(){
          Deque<int[]> deque = new ArrayDeque<>();
          deque.add(new int[]{cX,cY,0});
          graph[cX][cY] = 3;
          while(!deque.isEmpty()){
               int[] nowNode = deque.poll();
               int nowX = nowNode[0];
               int nowY = nowNode[1];
               int nowCount = nowNode[2];
               if(nowX == iX && nowY == iY)
                    return nowCount;
               for(int k=0;k<4;k++){
                    int nX = nowX + dX[k];
                    int nY = nowY + dY[k];
                    if(nX>=0 && nX<= 100 && nY>=0 && nY<=100 && graph[nX][nY] == 1){
                         graph[nX][nY] = 3;
                         deque.add(new int[]{nX,nY,nowCount+1});
                    }
               }
          }
          return -1;
     }
}
