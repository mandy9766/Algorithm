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
    static Deque<int[]> deque;
    static int[] di={0,-1,0,1,0}; // 정지상우하좌
    static int[] dj={0,0,1,0,-1};
    static int totalPower;

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
            int aI = 0;
            int aJ = 0;
            int bI = 9;
            int bJ = 9;
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
            for(int i=0;i<M;i++){
                Arrays.fill(isUsedBC, false);
                aI = aI + di[A[i]];
                aJ = aJ + dj[A[i]];
                bI = bI + di[B[i]];
                bJ = bJ + dj[B[i]];
                boolean aDone= false;
                boolean bDone= false;
                for(int m=0;m<C;m++){
                    if(aDone == false){
                        if(BC[m][aI][aI] != 0){
                            totalPower += BC[m][aI][aI];
                            aDone = true;
                        }
                    }else if(bDone == false){
                        if(BC[m][bI][bI] != 0){
                            totalPower += BC[m][bI][bI];
                            bDone = true;
                        }
                    }
                }
            }
            System.out.println("#"+(t+1)+" "+totalPower);
        }
        
    }
    static void setGraphBfs(int layer,int i,int j,int range, int power){
        deque = new ArrayDeque<>();
        deque.add(new int[]{i,j,0});
        while(!deque.isEmpty()){
            int [] temp = deque.poll();
            int nowI = temp[0];
            int nowJ = temp[1];
            int count = temp[2];
            BC[layer][nowI][nowJ] = power;
            if(count +1 <= range){
                for(int k=1;k<5;k++){
                    int ni = i+di[k];
                    int nj = j+dj[k];
                    if(ni>=0 && ni<10 && nj>=0 && nj<10){
                        deque.add(new int[]{ni,nj,count+1});
                    }
                }
            }
        }
        
    }
}
