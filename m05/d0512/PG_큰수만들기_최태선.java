package m05.d0512;

import java.util.*;

public class PG_큰수만들기_최태선 {
     int K;
     String nowNumber;
     int size;
     int nowK;
     StringBuilder sb;
     public String solution(String number, int k) {
          K = k;
          nowK = k;
          nowNumber = number;
          size = nowNumber.length();
          sb = new StringBuilder();
          while(nowK>0){
               int maxVal = -1;
               int maxIdx = -1;
               boolean isBreaked = false;
               for(int i=0;i<nowK+1;i++){
                    if(maxVal<nowNumber.charAt(i)){
                         maxIdx = i;
                         maxVal = nowNumber.charAt(i);
                    }
                    if(maxVal == '9'){
                         sb.append(nowNumber.charAt(i));
                         nowNumber = nowNumber.substring(i+1,nowNumber.length());
                         nowK = nowK - i;
                         isBreaked = true;
                         break;
                    }
               }
               // 9가 안나온경우
               if(!isBreaked){
                    sb.append(nowNumber.charAt(maxIdx));
                    nowNumber = nowNumber.substring(maxIdx+1,nowNumber.length());
                    nowK = nowK - maxIdx;
               }
               if(sb.length() == size -K)
                    return sb.toString();
          }
          sb.append(nowNumber);
          return sb.toString();
          
     }
}
