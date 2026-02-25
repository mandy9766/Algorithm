package d0225;

import java.io.*;
import java.util.*;

public class SWEA_5122_수열편집_최태선 {
    static int T,N,M,L,ans;
    static LinkedList<Integer> original;
    static Deque<Integer> deque;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken()); // 수열의 길이
            M = Integer.parseInt(st.nextToken()); // 추가횟수
            L = Integer.parseInt(st.nextToken()); // 출력할 인덱스
            st = new StringTokenizer(br.readLine()," ");
            original = new LinkedList<>();
            deque = new ArrayDeque<>();
            for(int i=0;i<N;i++){
                original.add(Integer.parseInt(st.nextToken()));
            }
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                String order = st.nextToken();
                if(order.equals("I")){
                    int idx = Integer.parseInt(st.nextToken());
                    while(st.hasMoreElements()){
                        deque.addLast(Integer.parseInt(st.nextToken()));
                    }
                    insert(idx);
                    
                }else if(order.equals("D")){
                    delete(Integer.parseInt(st.nextToken()));

                }else if(order.equals("C")){
                    int idx = Integer.parseInt(st.nextToken());
                    int num = Integer.parseInt(st.nextToken());
                    change(idx,num);
                }
            }
            ans = -1;
            int size= original.size();
            if(size>L)
                ans = original.get(L);
            System.out.println("#"+t+" "+ans);
        }
    }
    static void insert(int idx){
        while(!deque.isEmpty()){
            int num = deque.pollLast();
            original.add(idx,num);
        } 

    }
    static void delete(int idx){
        original.remove(idx);
    }
    static void change(int idx,int num){
        original.set(idx,num);
    }
}
