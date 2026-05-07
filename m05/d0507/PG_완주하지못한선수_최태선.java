package m05.d0507;

import java.util.HashMap;
import java.util.Map;

public class PG_완주하지못한선수_최태선 {
     Map <String,Integer> parti;
     public String solution(String[] participant, String[] completion) {
          parti = new HashMap<>();
          for(String p : participant){
               if(!parti.containsKey(p))
                    parti.put(p,1);
               else{
                    parti.put(p,parti.get(p)+1);
               }
          }
          for(String p : completion){
                    parti.put(p,parti.get(p)-1);
          }
          for(String p : participant){
               if(parti.get(p) == 1)
                    return p;
          }
          return "";
     }
}
