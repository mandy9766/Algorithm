package d0225;

import java.io.*;
import java.util.*;


public class SWEA_1230_암호문3_최태선 {
    static int N,M;
    static LinkedList<Integer> original;
    static Deque<Integer> deque;
    static StringBuilder sb;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int t=1;t<=10;t++){
            N = Integer.parseInt(br.readLine());
            original = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                original.addLast(Integer.parseInt(st.nextToken()));
            }
            M = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            deque = new ArrayDeque<>();
            sb = new StringBuilder();
            for(int i=0;i<M;i++){
                char order = st.nextToken().charAt(0);
                if(order == 'I'){
                    int idx = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());
                    for(int j=0;j<count;j++){
                        deque.addLast(Integer.parseInt(st.nextToken()));
                    }
                    for(int j=0;j<count;j++){
                        original.add(idx,deque.pollLast());
                    }
                    
                }else if(order =='D'){
                    int idx = Integer.parseInt(st.nextToken());
                    int count = Integer.parseInt(st.nextToken());
                    for(int j=0;j<count;j++){
                        original.remove(idx);
                    }

                }else if(order =='A'){
                    int count = Integer.parseInt(st.nextToken());
                    for(int j=0;j<count;j++){
                        original.addLast(Integer.parseInt(st.nextToken()));
                    }
                }
            }
            sb.append("#").append(t);
            for(int i=0;i<10;i++){
                sb.append(" ").append(original.get(i));
            }
            System.out.println(sb);
        }
        

    }    
}
