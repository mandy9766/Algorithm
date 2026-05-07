package m05.d0507;

public class PG_입국심사_최태선 {
     long answer;
     int N;
     int[] timeArr;
     long maxTime;
     int timeSize;
     public long solution(int n, int[] times) {
          answer = Long.MAX_VALUE;
          N = n;
          timeArr = times;
          maxTime = 0;
          timeSize = timeArr.length;
          for(int i=0;i<timeSize;i++){
               maxTime = Math.max(maxTime,timeArr[i]);
          }
          long end = (maxTime *timeSize) * (N/timeSize+1);
          long start = 1;
          while(start<=end){
               long mid = (end+start)/2;
               if(check(mid)){ // mid 시간안에 수용가능하면
                    answer = Math.min(answer,mid);
                    end = mid-1;
               }
               else{
                    start = mid+1;
               }
          }
          return answer;
     }
     public boolean check(long time){
          long count=0;
          for(int i=0;i<timeSize;i++){
               count += (long)time/timeArr[i];
          }
          if(count >= N){
               return true;
          }
          else{
               return false;
          }
     }
}
