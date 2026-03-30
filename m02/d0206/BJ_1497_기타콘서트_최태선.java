package d0206;

import java.io.*;
import java.util.*;

public class BJ_1497_기타콘서트_최태선 {
    static int N,M;
    static long[] guitar;
    static boolean[] usedGuitar;
    static long minCount;
    static int nowMaxCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); // 기타 종류 개수
        M = Integer.parseInt(st.nextToken()); // 불러야할 곡 수 
        guitar = new long[N];
        minCount = 11;
        nowMaxCount = 0;
        // guitar 각각 순서대로 bit로 가능한 곡들 마스킹
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            st.nextToken();
            char[] arr = st.nextToken().toCharArray();
            long origin =0;
            for(int k=0;k<M;k++){
                if(arr[k] == 'Y'){
                    origin = (origin<<1) + 1;
                }else{
                    origin = (origin<<1);
                }
            }
            guitar[i] = origin; 
        }
        usedGuitar = new boolean[N];
        
        //부분 조합으로 전체 곡 가능한지 테스트하고 최소값이면 minCount 업데이트
        subSet(0, 0);
        //만약 minCount가 51이면 -1 아니면 minVal 출력
        if (nowMaxCount == 0){
            System.out.println(-1);
        }else{
            System.out.println(minCount);
        }
    }

    public static void subSet(int idx,int cnt){
        long sum = 0;
        int count =0;
        // 종료조건 : 지금까지 사용된 기타를 다 비트합연산해서 만약 가능하면 minCount랑 cnt랑 작은값 cnt는 지금까지 선택된개수
        if(idx == N){
            for(int i=0;i<N;i++){
                if(usedGuitar[i] == true){
                    sum |= guitar[i];
                }
            }
            //count = Long.bitCount(sum);
            for(int i=0;i<M;i++){
                if((sum & (1L<<i)) != 0){
                    count ++;
                }
            }
            if(nowMaxCount<count){
                nowMaxCount = count;
                minCount = cnt;
            }else if(nowMaxCount == count){
                minCount = Math.min(minCount,cnt);
            }
            return;
        }
        //현재기타 선택
        usedGuitar[idx] = true;
        subSet(idx+1, cnt+1);
        usedGuitar[idx] = false;
        //현재기타 선택안함
        subSet(idx+1, cnt);
    }
}
