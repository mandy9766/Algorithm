package d0203;

import java.io.*;
import java.util.*;

public class BJ_20364_부동산다툼_최태선 {
    static int x;
    static Deque<Integer> deque;
    static int firstVal;
    static int N;
    static int[] graph;
    static StringBuilder sb;
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        graph = new int[N+1];
        for(int i=0;i<Q;i++){
            x = Integer.parseInt(br.readLine());
            deque = new ArrayDeque<>() ;
            Reversed(x);
            
        }
        System.out.println(sb);
    }
    public static void Reversed(int target){
        deque.addFirst(target);
        if (target != 1){
            Reversed(target/2);
        }else{
            Check();
            sb.append(firstVal+"\n");
        }
    }
    // deque 따라가면서 다 graph값 비교해서 다 0이면 0 아니면 첫번째로 만난값 리턴
    public static void Check(){
        Iterator<Integer> it = deque.iterator();
        int next=0;
        while(it.hasNext()){
            next = it.next();
            if(graph[next] !=0){
                firstVal = next;
                return;
            }
        }
        graph[next] = 1;
        firstVal = 0;
    }
}
