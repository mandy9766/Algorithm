package m06.d0622;

import java.util.*;

class PG_올바른괄호_최태선 {
    boolean solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(arr[i] == '('){
                deque.addLast(arr[i]);
            }else if(arr[i] == ')'){
                if(deque.isEmpty()){
                    return false;
                }else{
                    deque.pollLast();
                }
            }
        }
        if(deque.isEmpty())
            return true;
        else
            return false;
    }
}