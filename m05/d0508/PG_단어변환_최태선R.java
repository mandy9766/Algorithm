package m05.d0508;

import java.util.*;

public class PG_단어변환_최태선R {
     class Node{
        public String nowWord;
        public int nowCount;
        public Node(String nowWord,int nowCount){
            this.nowWord = nowWord;
            this.nowCount = nowCount;
        }
     }
     int minVal;
     int wordLen;
     boolean[] selected;
     int wordArrSize;
     String[] wordArr;
     String targetWord;
     public int solution(String begin, String target, String[] words) {
          wordLen = begin.length();
          minVal = 0;
          wordArrSize = words.length;
          selected = new boolean[wordArrSize];
          wordArr = words;
          targetWord = target;
          bfs(begin);
          return minVal;
     }
     void bfs(String startWord){
          Deque<Node> deque = new ArrayDeque<>();
          deque.add(new Node(startWord,0));
          while(!deque.isEmpty()){
               Node nowNode = deque.poll();
               String word = nowNode.nowWord;
               int count = nowNode.nowCount;
               if(word.equals(targetWord)){
                    minVal = count;
                    return;
               }
               for(int i=0;i<wordArrSize;i++){
                    if(!selected[i] && check(word,wordArr[i])){
                         selected[i] = true;
                         deque.add(new Node(wordArr[i],count+1));
                    }
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
