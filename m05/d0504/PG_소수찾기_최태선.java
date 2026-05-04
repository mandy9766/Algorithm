package m05.d0504;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PG_소수찾기_최태선 {
     char[] numSet;
     Set<Integer> resultSet;
     boolean [] selected;
     int size;
     boolean[] primeNum;
     public int solution(String numbers) {
          numSet = numbers.toCharArray();
          size = numSet.length;
          selected = new boolean[size];
          resultSet = new HashSet<>();
          primeNum = new boolean[10000000];
          Arrays.fill(primeNum,true);
          primeNum[1] = false;
          primeNum[0] = false;
          for(int i=2;i<10000000;i++){
               if(primeNum[i] == true){
                    for(int j=i*2;j<10000000;j+=i){
                         primeNum[j] = false;
                    }
               }
          }
          dfs(0,"");
          return resultSet.size();
     }
     void dfs(int depth,String nowNum){
          if(depth !=0 && isPrime(Integer.parseInt(nowNum)))
               resultSet.add(Integer.parseInt(nowNum));
          if(depth == size){
               return;
          }
          for(int i=0;i<size;i++){
               if(selected[i] == false){
                    selected[i] = true;
                    dfs(depth+1, nowNum+numSet[i]);
                    selected[i] = false;
               }
          }
          
     }
     boolean isPrime(int nowNum){
          if(primeNum[nowNum] == true)
               return true;
          else
               return false;
     }
}
