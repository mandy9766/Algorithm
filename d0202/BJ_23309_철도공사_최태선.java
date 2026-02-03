package d0202;

import java.io.*;
import java.util.*;

public class BJ_23309_철도공사_최태선  {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine()," ");
        int MaxVal = 1000001;
        // case1 배열
        int [] past = new int[MaxVal];
        int [] next = new int[MaxVal];
        int first =  Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        past[first] = second;
        next[first] = second;
        past[second] = first;
        next[second] = first;
        int head = first;
        int tail = second;
        StringBuilder sb = new StringBuilder();
        // 초기 지하철 세팅
        for(int i=0;i<N-2;i++){
            int nowStation = Integer.parseInt(st.nextToken());
            past[nowStation] = tail;
            next[nowStation] = head;
            next[tail] = nowStation;
            tail = nowStation;
            past[head] = nowStation;
        }
        for (int k=0;k<M;k++){
            st = new StringTokenizer(br.readLine()," ");
            String cmd = st.nextToken();
            if(cmd.equals("BN")){
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                sb.append(next[i] + "\n");
                int a = next[i];
                next[j] = a;
                past[j] = i;
                next[i] = j;
                past[a] = j;
             }else if(cmd.equals("BP")){
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                sb.append(past[i] + "\n");
                int a = past[i];
                next[j] = i;
                past[j] = a;
                next[a] = j;
                past[i] = j;
            }else if(cmd.equals("CN")){
                int i = Integer.parseInt(st.nextToken());
                sb.append(next[i] + "\n");
                int a = next[i];
                int aa = next[a];
                next[i] = aa;
                past[aa] = i;
            }else if(cmd.equals("CP")){
                int i = Integer.parseInt(st.nextToken());
                sb.append(past[i] + "\n");
                int a = past[i];
                int aa = past[a];
                next[aa] = i;
                past[i] = aa;
            }
        }
        System.out.println(sb);

        
    }
}
