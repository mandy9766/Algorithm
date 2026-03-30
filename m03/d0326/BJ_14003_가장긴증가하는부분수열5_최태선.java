package d0326;

import java.io.*;
import java.util.*;

public class BJ_14003_가장긴증가하는부분수열5_최태선 {
    static int N;
    static int[] A;
    static List<Integer> list;
    static int[] index;
    public static void main(String[] args) throws Exception{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        index = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            int idx = Collections.binarySearch(list, A[i]);
            if(idx < 0){
                idx = -(idx+1);
            }
            if(idx == list.size())
                list.add(A[i]);
            else
            list.set(idx,A[i]);
            index[i] = idx;
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        int lastIdx =0;
        for(int i=0;i<N;i++){
            if(index[i] == size-1)
                lastIdx = i;
        }
        int nowIdx = size-1;
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i=lastIdx;i>=0;i--){
            if(index[i] == nowIdx){
                deque.addFirst(A[i]);
                nowIdx --;
            }
        }
        while(!deque.isEmpty()){
            sb.append(deque.pollFirst()).append(" ");
        }
        System.out.println(list.size());
        System.out.println(sb);
    }
}
