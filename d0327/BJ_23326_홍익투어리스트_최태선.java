package d0327;

import java.io.*;
import java.util.*;

public class BJ_23326_홍익투어리스트_최태선 {
    static int nowPos;
    static int N,Q;
    static int[] A;
    static TreeSet<Integer> treeSet;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        nowPos =1; 
        st =new StringTokenizer(br.readLine()," ");
        A = new int[N+1];
        treeSet = new TreeSet<>();
        for(int i=1;i<N+1;i++){
            A[i] = Integer.parseInt(st.nextToken());
            if(A[i] == 1){
                treeSet.add(i);
                treeSet.add(i+N);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<Q;i++){
            st = new StringTokenizer(br.readLine()," ");
            int order = Integer.parseInt(st.nextToken());
            if(order == 1){
                int nowI = Integer.parseInt(st.nextToken());
                if(A[nowI] == 1)
                {
                    A[nowI] = 0;
                    treeSet.remove(nowI);
                    treeSet.remove(nowI+N);
                }
                else{
                    A[nowI] =1;
                    treeSet.add(nowI);
                    treeSet.add(nowI+N);
                }
            }else if(order ==2){
                int x = Integer.parseInt(st.nextToken());
                if((nowPos+x)%N == 0){
                    nowPos = N;
                }else{
                    nowPos = (nowPos+x)%N;
                }
            }else{
                Integer minPos = treeSet.ceiling(nowPos);
                if(minPos == null)
                    sb.append(-1).append("\n");
                else{
                    int diff = minPos-nowPos;
                    sb.append(diff).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
