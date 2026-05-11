package m05.d0511;

public class PG_카펫_최태선 {
     int B;
     int Y;
     public int[] solution(int brown, int yellow) {
          B = brown;
          Y = yellow;
          // 가로세로 전부 3이상이어야하고 2500을 넘을수없음
          for(int i=3;i<2500;i++){
               for(int j=3;j<=i;j++){
                    if(check1(i,j) && check2(i,j))
                         return new int[]{i,j};
                    
               }
          }
          return new int[]{};
     }
     boolean check1(int n, int m){
          if(2*(n+m-2) == B)
               return true;
          return false;
     }
     boolean check2(int n, int m){
          if((n-2)*(m-2) == Y)
               return true;
          return false;
     }
}
