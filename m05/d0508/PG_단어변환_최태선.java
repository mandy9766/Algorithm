package m05.d0508;

import java.util.*;

public class PG_단어변환_최태선 {
     int minVal;
     int INF=Integer.MAX_VALUE;
     int wordLen;
     boolean[] selected;
     int wordArrSize;
     String[] wordArr;
     String targetWord;
     public int solution(String begin, String target, String[] words) {
          wordLen = begin.length();
          minVal = INF;
          wordArrSize = words.length;
          selected = new boolean[wordArrSize];
          wordArr = words;
          targetWord = target;
          dfs(begin,0);
          if(minVal == INF)
               return 0;
          else
               return minVal;
          
     }
     void dfs(String nowWord,int nowCount){
          // 만약 현재값이 같으면
          if(nowWord.equals(targetWord)){
               minVal = Math.min(minVal,nowCount);
               return;
          }
          for(int i=0;i<wordArrSize;i++){
               if(selected[i] == true)
                    continue;
               //만약 한단어만 바꿔서 그 word가 될 수 있는 상황이면
               if(check(nowWord,wordArr[i])){
                    selected[i] = true;
                    dfs(wordArr[i],nowCount+1);
                    selected[i] = false;
               }
          }
          
     }
     boolean check(String nowWord, String selectedWord){
          int count = 0;
          for(int i=0;i<wordLen;i++){
               if(nowWord.charAt(i) != selectedWord.charAt(i))
                    count ++;
          }
          if(count == 1)
               return true;
          else
               return false;
     }
}
