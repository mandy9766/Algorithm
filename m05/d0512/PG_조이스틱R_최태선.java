package m05.d0512;

import java.util.*;

public class PG_조이스틱R_최태선 {
     int[] arr = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1}; // 26개
     int n;
     char[] charName;
     int result;
     int move;
     public int solution(String name) {
          n = name.length();
          charName = name.toCharArray();
          result = 0;
          // 상하 처리
          for(int i=0;i<n;i++)
          {
               int idx = charName[i]-'A';
               result += arr[idx];
          }
          // 좌우 처리
          // 1. 그냥 쭉간다
          move = n-1;
          for(int i=0;i<n-1;i++){
               int next = i+1;
               while(next<n && charName[next] == 'A'){
                    next++;
               }
               // 2. 우로가다가 좌로간다
               move = Math.min(move,i*2+n-next);
               // 3. 좌로가다가 우로간다
               move = Math.min(move,2*(n-next)+i);
          }
          result = result+move;
          return result;
    }
}
