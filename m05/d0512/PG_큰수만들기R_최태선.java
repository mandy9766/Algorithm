package m05.d0512;

import java.util.*;

public class PG_큰수만들기R_최태선 {
     
class Solution {
    int K;
    String nowNumber;
    StringBuilder sb;
    public String solution(String number, int k) {
        nowNumber = number;
        K = k;
        sb = new StringBuilder();
        for(int i=0;i<nowNumber.length();i++){
            while (K>0 && sb.length()>0 && sb.charAt(sb.length()-1) < nowNumber.charAt(i)){
                sb.deleteCharAt(sb.length()-1);
                K--;
            }
            sb.append(nowNumber.charAt(i));
        }
        if(K == 0)
            return sb.toString();
        else{
            while(K >0){
                sb.deleteCharAt(sb.length()-1);
                K--;
            }
            return sb.toString();
        }
    }
}
}
