package m04.d0428;

import java.io.*;
import java.util.*;

public class PG_최소직사각형_최태선 {
     int[][] sizeArr;
     int answer;
     int INF = Integer.MAX_VALUE;
     int nowMinRow;
     int nowMinCol;
     int sizeRow,sizeCol;
     public int solution(int[][] sizes) {
          answer = INF;
          sizeArr = sizes;
          nowMinCol = Math.min(sizeArr[0][0],sizeArr[0][1]);
          nowMinRow = Math.max(sizeArr[0][0],sizeArr[0][1]);
          sizeCol = sizeArr.length;
          for(int i=1;i<sizeCol;i++){
               int nowCol = Math.min(sizeArr[i][0],sizeArr[i][1]);
               int nowRow = Math.max(sizeArr[i][0],sizeArr[i][1]);
               nowMinCol = Math.max(nowMinCol,nowCol);
               nowMinRow = Math.max(nowMinRow,nowRow);
          }
          answer = nowMinCol * nowMinRow;
          return answer;
     }
}
