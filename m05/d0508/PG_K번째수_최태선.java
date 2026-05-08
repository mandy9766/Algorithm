package m05.d0508;

import java.util.*;

public class PG_K번째수_최태선 {
     int[][] comd;
     int[] arr;
     int[] temp;
     int[] result;
     public int[] solution(int[] array, int[][] commands) {
          arr = array;
          comd = commands;
          int size = comd.length;
          result = new int[size];
          for(int i=0;i<size;i++){
               int start = comd[i][0]-1;
               int end = comd[i][1]-1;
               int k = comd[i][2]-1;
               int tempSize = end-start+1;
               temp = new int[tempSize];
               int idx = 0;
               for(int j=start;j<end+1;j++){
                    temp[idx] = array[j];
                    idx++;
               }
               Arrays.sort(temp);
               result[i] = temp[k];
          }
          return result;
     }
}
