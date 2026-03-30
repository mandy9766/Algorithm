package d0224;

import java.io.*;
import java.util.*;
public class SWEA_2930_힙_최태선 {
    static int T,N,n1,n2;
    static PriorityQueue<Integer> pq;
    static StringBuilder sb;


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            pq = new PriorityQueue<>(Collections.reverseOrder());
            sb = new StringBuilder();
            N = Integer.parseInt(br.readLine());
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                n1 = Integer.parseInt(st.nextToken());
                if(n1 == 1){
                    n2 = Integer.parseInt(st.nextToken());
                    pq.add(n2);
                }else{
                    if(pq.isEmpty()){
                        sb.append(-1).append(" ");
                    }else{
                        sb.append(pq.poll()).append(" ");
                    }
                }
            }
            System.out.println("#"+t+" "+sb);
        }
    }
}
