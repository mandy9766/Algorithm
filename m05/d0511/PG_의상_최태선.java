package m05.d0511;

import java.util.HashMap;
import java.util.Map;

public class PG_의상_최태선 {
     Map<String,Integer> map;
     String[][] arr;
     int arrSize;
     int result;
     public int solution(String[][] clothes) {
          map = new HashMap<>();
          arr = clothes;
          arrSize = arr.length;
          for(int i=0;i<arrSize;i++){
               String nowCategory = clothes[i][1];
               map.put(nowCategory,map.getOrDefault(nowCategory,0)+1);
          }
          result = 1;
          for(int value : map.values()){
               result *= (value+1);
          }
          return result-1;
     }
}
