package m05.d0513;

import java.util.*;

public class PG_구명보트_최태선 {
     int count;
     int start;
     int end;
     int LIMIT;
     int[] peopleArr;
     public int solution(int[] people, int limit) {
          count = 0;
          start = 0;
          end = people.length-1;
          LIMIT = limit;
          peopleArr = people;

          Arrays.sort(peopleArr);
          while(start<=end){
               if(start == end){
                    count ++;
                    break;
               }
               if(peopleArr[start] + peopleArr[end] <= LIMIT){
                    start ++;
                    end --;
                    count ++;
               }
               else{
                    end --;
                    count++;
               }
          }
          return count;
     }
}
