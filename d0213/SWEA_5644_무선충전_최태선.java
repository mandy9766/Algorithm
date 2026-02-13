package d0213;

import java.io.*;
import java.util.*;

public class SWEA_5644_무선충전_최태선 {
    static int[][][] BC;
    static boolean[] isUsedBC;
    static int N;
    static int[] A;
    static int[] B;
    static PriorityQueue<int[]> pq;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(st.nextToken()); // 총 이동시간
            int C = Integer.parseInt(st.nextToken()); // BC의 개수
            A = new int[M];
            B = new int[M];
            st =  new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++){
                A[i] = Integer.parseInt(st.nextToken());
            }
            st =  new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++){
                B[i] = Integer.parseInt(st.nextToken());
            }
            pq = new PriorityQueue<>((a,b)->Integer.compare(b[3], a[3])); // 파워 최대값부터
            for(int i=0;i<M;i++){
                st = new StringTokenizer(br.readLine()," ");
                int ni = Integer.parseInt(st.nextToken());
                int nj = Integer.parseInt(st.nextToken());
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                pq.add(new int[]{ni,nj,range,power});
            }
            isUsedBC = new boolean[M];
            BC = new int[M][10][10];
            int layer = 0;
            while(!pq.isEmpty()){
                int[] temp = pq.poll();
                int i= temp[0];
                int j = temp[1];
                int range = temp[2];
                int power = temp[3];
                setGraphBfs(layer,i,j,range,power);
                layer ++;
            }
        }
        
    }
    static void setGraphBfs(int layer,int i,int j,int range, int power){
        
    }
}
