package m05.d0511;

import java.util.HashSet;
import java.util.Set;

public class PG_전화번호목록_최태선 {
     Set<String> set;
     int size;
     public boolean solution(String[] phone_book) {
          set = new HashSet<>();
          size = phone_book.length;
          for(int i=0;i<size;i++){
               set.add(phone_book[i]);
          }
          for(int i=0;i<size;i++){
               String now = phone_book[i];
               int stringSize = now.length();
               for(int j=1;j<stringSize;j++){
                    if(set.contains(now.substring(0,j)))
                         return false;
               }
          }
          return true;
     }
}
