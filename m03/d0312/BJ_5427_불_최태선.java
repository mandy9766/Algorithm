package d0312;

import java.io.*;
import java.util.*;

public class BJ_5427_불_최태선 {
    static int T,W,H;
    static char[][] graph;
    static boolean[][] visitedFire;
    static boolean[][] visitedSang;
    static Deque<int[]> fireDeque;
    static Deque<int[]> sangDeque;
    static int[] di ={-1,0,1,0};
    static int[] dj ={0,1,0,-1};
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            graph = new char[H][W];
            visitedFire = new boolean[H][W];
            visitedSang = new boolean[H][W];

            sangDeque = new ArrayDeque<>();
            fireDeque = new ArrayDeque<>();

            for(int i=0;i<H;i++){
                char[] temp = br.readLine().toCharArray();
                for(int j=0;j<W;j++){
                    graph[i][j] = temp[j];
                    if(graph[i][j] == '@'){
                        visitedSang[i][j] = true;
                        graph[i][j] = '.';
                        sangDeque.add(new int[]{i,j});
                    }else if (graph[i][j] == '*'){
                        visitedFire[i][j] = true;
                        fireDeque.add(new int[]{i,j});
                    }
                }
            }
            int result = bfs();
            if(result == -1)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(result);
        }
    }
    static int bfs(){
        int count = 0;
        while(true){
            count ++;
            //불먼저 업데이트
            Deque<int[]> tempFireDeque = new ArrayDeque<>();
            while(!fireDeque.isEmpty()){
                int[] nowNode = fireDeque.poll();
                int nowI = nowNode[0];
                int nowJ = nowNode[1];
                for(int k=0;k<4;k++){
                    int ni = nowI+ di[k];
                    int nj = nowJ+ dj[k];
                    if(ni>=0 && ni<H && nj>=0 && nj<W && visitedFire[ni][nj] == false && graph[ni][nj]!= '#'){
                        visitedFire[ni][nj] = true;
                        graph[ni][nj] = '*';
                        tempFireDeque.add(new int[]{ni,nj});
                    }
                }
            }
            fireDeque = tempFireDeque;
            // 상근이업데이트
            Deque<int[]> tempSangDeque = new ArrayDeque<>();
            while(!sangDeque.isEmpty()){
                int[] nowNode = sangDeque.poll();
                int nowI = nowNode[0];
                int nowJ = nowNode[1];
                for(int k=0;k<4;k++){
                    int ni = nowI+ di[k];
                    int nj = nowJ+ dj[k];
                    // 나감
                    if(ni<0 || ni>=H || nj<0 || nj>=W )
                        return count;
                    if(ni>=0 && ni<H && nj>=0 && nj<W && visitedSang[ni][nj] == false && graph[ni][nj] == '.' ){
                        visitedSang[ni][nj] = true;
                        tempSangDeque.add(new int[]{ni,nj});
                    }
                }
            }
            // 갈방향이 없는경우 실패
            if(tempSangDeque.isEmpty())
                return -1;
            sangDeque = tempSangDeque;
            
        }
    }
}
