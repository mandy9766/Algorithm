package m05.d0513;

import java.util.*;

public class PG_아이템줍기_최태선 {
     int[][] graph;
     int dir = -1;
     int[] di = {-1,0,1,0};// 상우하좌
     int[] dj = {0,1,0,-1};
     int cX,cY,iX,iY;
     int maxCount;
     int itemCount;
     public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
          graph = new int[51][51];
          cX = characterX;
          cY = characterY;
          iX = itemX;
          iY = itemY;
          maxCount = 0;
          for(int i=0;i<rectangle.length;i++){
               int x1 = rectangle[i][0];
               int y1 = rectangle[i][1];
               int x2 = rectangle[i][2];
               int y2 = rectangle[i][3];
               // 가로변
               for(int k=x1;k<=x2;k++){
                    graph[k][y1] = 1;
                    graph[k][y2] = 1;
               }
               //세로변
               for(int k=y1;k<=y2;k++){
                    graph[x1][k] = 1;
                    graph[x2][k] = 1;
               }
          }
          for(int k=0;k<4;k++){
               int ni = characterX + di[k];
               int nj = characterY + dj[k];
               if(ni>=0 && ni<=50 && nj>=0 && nj<=50 && graph[ni][nj] == 1){
                    check(ni,nj,k,1); // 시작방향으로 체크 , 가장 큰 값이 가장 바깥을 도는 dir값
               }
          }
          int ni = characterX + di[dir];
          int nj = characterY + dj[dir];
          check(ni,nj,dir,2);
          return Math.min(itemCount,maxCount-itemCount);
          
     }
     void check(int nowI,int nowJ,int nowDir,int v){
          int count =1;
          int i= nowI;
          int j= nowJ;
          int d = nowDir;
          while(true){
               if(v == 1 && i == cX && j == cY)
                    break;
               if(v == 2 && i == iX && j == iY)
                    break;
               // 먼저 오른쪽이 있으면 오른쪽으로 돈다
               int ni = i+di[(d+3)%4];
               int nj = j+dj[(d+3)%4];
               if(ni>=0 && ni<=50 && nj>=0 && nj<=50 && graph[ni][nj] == 1)
               {
                    i = ni;
                    j = nj;
                    count ++;
                    d = (d+3)%4;
                    continue;
               }
               ni = i+di[d];
               nj = j+dj[d];
               if(ni>=0 && ni<=50 && nj>=0 && nj<=50 && graph[ni][nj] == 1)
               {
                    i = ni;
                    j = nj;
                    count ++;
                    continue;
               }
               ni = i+di[(d+1)%4];
               nj = j+dj[(d+1)%4];
               if(ni>=0 && ni<=50 && nj>=0 && nj<=50 && graph[ni][nj] == 1)
               {
                    i = ni;
                    j = nj;
                    count ++;
                    d = (d+1)%4;
                    continue;
               }
          }
          if(v == 1 && maxCount < count){
               maxCount = count;
               dir = nowDir;
          }
          if(v == 2){
               itemCount = count;
          }
          return;
     }
}