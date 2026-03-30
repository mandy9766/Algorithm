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
            for(int i=0;i<C;i++){
                st = new StringTokenizer(br.readLine()," ");
                int x = Integer.parseInt(st.nextToken())-1;
                int y = Integer.parseInt(st.nextToken())-1;
                int range = Integer.parseInt(st.nextToken());
                int power = Integer.parseInt(st.nextToken());
                pq.add(new int[]{y,x,range,power});
            }
            int aI = 0;
            int aJ = 0;
            int bI = 9;
            int bJ = 9;
            totalPower =0;
            isUsedBC = new boolean[C];
            BC = new int[C][10][10];
            int layer = 0;
            while(!pq.isEmpty()){
                int[] temp = pq.poll();
                int i= temp[0];
                int j = temp[1];
                int range = temp[2];
                int power = temp[3];
                setGraph(layer,i,j,range,power);
                layer ++;
            }
            for (int time = 0; time <= M; time++) {
                // time==0 은 이동 전 충전, time>0 부터 이동
                if (time > 0) {
                    aI += di[A[time - 1]];
                    aJ += dj[A[time - 1]];
                    bI += di[B[time - 1]];
                    bJ += dj[B[time - 1]];
                }
                int best = 0;
                // A가 i BC, B가 j BC를 선택한다고 가정하고 전부 비교
                for (int i = 0; i < C; i++) {
                    for (int j = 0; j < C; j++) {
                        int aGain = BC[i][aI][aJ];
                        int bGain = BC[j][bI][bJ];
                        int sum;
                        if (i == j) {
                            // 같은 BC를 동시에 쓰면 둘이 나눠가지므로 합은 그 BC 파워(=aGain=bGain)
                            sum = Math.max(aGain, bGain);
                        } else {
                            sum = aGain + bGain;
                        }
                        if (sum > best) best = sum;
                    }
                }
                totalPower += best;
                }
            System.out.println("#"+(t+1)+" "+totalPower);
        }
    }
    static void setGraph(int layer, int i, int j, int range, int power) {
        for (int r = 0; r < 10; r++) {
            for (int c = 0; c < 10; c++) {
                if (Math.abs(r - i) + Math.abs(c - j) <= range) {
                    BC[layer][r][c] = power;
                }
            }
        }
    }
}

      
