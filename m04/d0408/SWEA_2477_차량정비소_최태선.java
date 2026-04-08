package m04.d0408;

import java.io.*;
import java.util.*;

public class SWEA_2477_차량정비소_최태선 {
    static int T,N,M,K,A,B;
    static int[] a,b,t,selectedA,selectedB;
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
        PriorityQueue<int[]> pqA = new PriorityQueue<>((a,b)->{
            if(a[2]==b[2])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[2], b[2]);
        });
        int tN = 1;
        for(int i=1;i<N+1;i++){ // 먼저 창구개수만큼 넣기
            if(i>K) //만약 사람숫자보다 창구가많은데 그이상의 고객번호에 접근하려하면
                continue; 
            pqA.add(new int[]{tN,i,a[tN]+t[tN]}); // 내번호,창구번호,시간
            tN++;
        }
        while(!pqA.isEmpty()){
            int[] nowNode = pqA.poll();
            int nowId = nowNode[0];
            int nowA = nowNode[1];
            int nowTime = nowNode[2];
            selectedA[nowId] = nowA;
            
            pq.add(new int[]{nowId,nowA,nowTime});
            if(tN<=K){
                int startTime = Math.max(nowTime,t[tN]);
                pqA.add(new int[]{tN,nowA,startTime+a[nowA]});
                tN++;
            }
        }
    }
    static void setB(){
        PriorityQueue<int[]> pqB = new PriorityQueue<>((a,b)->{
            if(a[2] == b[2])
                return Integer.compare(a[1], b[1]);
            else
                return Integer.compare(a[2], b[2]);
        });
        int tN = 1;
        for(int i=1;i<M+1;i++){ // 먼저 정비소만큼 넣기
            if(i>K)
                continue;
            int[] nowNode = pq.poll();
            pqB.add(new int[]{nowNode[0],i,nowNode[2]+b[i]});// 내번호,정비번호,
            tN++;
        }
        while(!pqB.isEmpty()){
            int[] nowNode = pqB.poll();
            int nowId = nowNode[0];
            int nowB = nowNode[1];
            int nowTime = nowNode[2];
            selectedB[nowId] = nowB;
            if(tN<=K){
                int[] nextNode = pq.poll();
                int startTime = Math.max(nowTime,nextNode[2]);
                pqB.add(new int[]{nextNode[0],nowB,startTime+b[nowB]});
                tN++;
            }
        }

    }
}
