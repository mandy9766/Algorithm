package m04.d0430;

import java.util.*;

public class PG_N으로표현_최태선 {
     List<Set<Integer>> list;
     public int solution(int N, int number) {
          list = new ArrayList<>();
          for(int i=0;i<=8;i++){
               list.add(new HashSet<>());
          }
          int tempN = 0;
          for(int i=1;i<=8;i++){
               tempN = tempN*10 + N;
               list.get(i).add(tempN);
          }
          int answer = 0;
          for(int i=1;i<=8;i++){
               for(int j=1;j<i;j++){
                    for(int op1 : list.get(j)){
                         for(int op2 : list.get(i-j)){
                         list.get(i).add(op1-op2);
                         list.get(i).add(op1+op2);
                         list.get(i).add(op1*op2);
                         if(op2 !=0)
                              list.get(i).add(op1/op2);
                         }
                    }
                    
               }
               if(list.get(i).contains(number))
                    return i;
          }
          
          return -1;
     }
}
