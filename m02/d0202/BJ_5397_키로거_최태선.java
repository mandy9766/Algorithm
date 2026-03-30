package d0202;

import java.io.*;
import java.util.*;

public class BJ_5397_키로거_최태선 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for (int t=0;t<T;t++){
            Deque<Character> dequeLeft = new ArrayDeque<>();
            Deque<Character> dequeRight = new ArrayDeque<>();
            char[] keys = br.readLine().toCharArray();
            int size = keys.length;
            // <를하면 왼쪽에 값이있으면 오른쪽으로 넘기고 없으면 그냥 있기
            // >하면 오른쪽에 값이 있으면 왼쪽으로 넘기고 없으면 그냥 있기
            // 값을 추가할때는 왼쪽덱의 맨끝에 넣기
            // 값을 뺄때는 왼쪽덱의 맨끝에서 빼기
            
            for(int i=0;i<size;i++){
                if(keys[i] == '<'){
                    if(dequeLeft.size() != 0){
                        dequeRight.addFirst(dequeLeft.pollLast());
                    }
                }else if(keys[i] =='>'){
                    if(dequeRight.size() != 0){
                        dequeLeft.addLast(dequeRight.pollFirst());
                    }
                }else if(keys[i] == '-'){
                    dequeLeft.pollLast();
                }else{
                    dequeLeft.addLast(keys[i]);
                }
            }
            StringBuilder sb = new StringBuilder();
            Iterator<Character> it  = dequeLeft.iterator();
            while (it.hasNext()){
                sb.append(it.next());
            }
            it = dequeRight.iterator();
            while(it.hasNext()){
                sb.append(it.next());
            }
            System.out.println(sb);
        }
        
    }
}
