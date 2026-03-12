package d0312;
import java.io.*;
import java.util.*;

public class BJ_7569_토마토_최태선 {
    static int M,N,H; // 가로(j) 세로(i) 높이(k)
    static int[][][] graph;
    static int[] di = {-1,0,1,0,0,0};
    static int[] dj = {0,1,0,-1,0,0};
    static int[] dk = {0,0,0,0,-1,1};
    static Deque<int[]> deque;
    static int minDay;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        graph = new int[N][M][H];
        deque = new ArrayDeque<>();
        for(int k=0;k<H;k++){
            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<M;j++){
                    graph[i][j][k] = Integer.parseInt(st.nextToken());
                    if(graph[i][j][k] == 1){
                        deque.add(new int[]{i,j,k,0});
                    }
                }
            }
        }
        int count =0;
        bfs();
        for(int k=0;k<H;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(graph[i][j][k] == 0){
                        count ++;
                    }
                }
            }
        }
        if(count == 0)
            System.out.println(minDay);
        else
            System.out.println(-1);

    }    
    static void bfs(){
        while(!deque.isEmpty()){
            int[] nowTomato = deque.poll();
            int nowI = nowTomato[0];
            int nowJ = nowTomato[1];
            int nowK = nowTomato[2];
            int nowDay = nowTomato[3];
            minDay = nowDay;
            for(int p=0;p<6;p++){
                int ni = nowI + di[p];
                int nj = nowJ + dj[p];
                int nk = nowK + dk[p];
                if(ni>=0 && ni<N && nj>=0 && nj<M && nk>=0 && nk<H && graph[ni][nj][nk] == 0){
                    graph[ni][nj][nk] = 1;
                    deque.add(new int[]{ni,nj,nk,nowDay+1});
                }
            }
        }
    }
}
