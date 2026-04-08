package m04.d0408;

import java.io.*;
import java.util.*;

public class SWEA_2477_차량정비소_최태선R {
    static int T,N,M,K,A,B;
    static int[] a,b,t,selectedA,selectedB;
    static int[] timeA,timeB;
    static PriorityQueue<int[]> pq;
    static int result;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int test=1;test<=T;test++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());
            a = new int[N+1];
            b = new int[M+1];
            t = new int[K+1];
            selectedA = new int[K+1];
            selectedB = new int[K+1];
            timeA = new int[N+1];
            timeB = new int[N+1];
            result = 0;
            pq = new PriorityQueue<>((a,b)->{ // 정비소 순서 대기열 , {id,자기가 간 접수창고 번호, 정비소 도착시간}
                if(a[2]==b[2])
                    return Integer.compare(a[1], b[1]);
                else
                    return Integer.compare(a[2], b[2]);
            });
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<N+1;i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<M+1;i++){
                b[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i=1;i<K+1;i++){
                t[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(t); // 고객번호 = idx;
            setA();
            setB();
            for(int i=1;i<K+1;i++){
                if(selectedA[i] == A && selectedB[i] == B)
                    result += i;
            }
            if(result == 0)
                result = -1;
            sb.append("#").append(test).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }
    static void setA(){
        int tN =1;
        int nowTime=0;
        while (true){
            if(checkA() && tN>K)
                break;
            for(int i=1;i<N+1;i++){
                if(timeA[i] ==0 && tN<=K && nowTime>=t[tN]){ // 창구 비어있는데 넣을사람 남아있고, 도착시간보다 지금 시간이 높으면 넣기
                    timeA[i] = a[i];
                    selectedA[tN] = i;
                    pq.add(new int[]{tN,i,nowTime+a[i]}); // 지금시간
                    tN ++;
                }
            }
            for(int i=1;i<N+1;i++){
                if(timeA[i] > 0)
                    timeA[i] --;
            }
            nowTime ++;
        }
    }
    static void setB(){
        int tN =1;
        int nowTime=pq.peek()[2];
        while(true){
            if(checkB() && tN>K)
                break;
            for(int i=1;i<M+1;i++){
                if(timeB[i] == 0 && tN<=K && nowTime>=pq.peek()[2]){
                    int[] nowP = pq.poll();
                    int nowId = nowP[0];
                    timeB[i] = b[i];
                    selectedB[nowId] = i;
                    tN++;
                }
            }
            for(int i=1;i<M+1;i++){
                if(timeB[i] > 0)
                    timeB[i] --;
            }
            nowTime ++;
        }
    }
    static boolean checkA(){ // 아직 A접수대에 사람있으면 false
        for(int i=1;i<N+1;i++){
            if(timeA[i] > 0)
                return false;
        }
        return true;
    }
    static boolean checkB(){ // 아직 A접수대에 사람있으면 false
        for(int i=1;i<M+1;i++){
            if(timeB[i] > 0)
                return false;
        }
        return true;
    }
}
