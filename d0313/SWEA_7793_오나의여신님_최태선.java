package d0313;

import java.io.*;
import java.util.*;

public class SWEA_7793_오나의여신님_최태선 {
    static int T,N,M;
    static char[][] graph;
    static boolean[][] visitedSu;
    static int goalI,goalJ;
    static Deque<int[]> suDeque;
    static Deque<int[]> akDeque;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new char[N][M];
            visitedSu = new boolean[N][M];
            suDeque = new ArrayDeque<>();
            akDeque = new ArrayDeque<>();
            for(int i=0;i<N;i++){
                char[] temp = br.readLine().toCharArray();
                for(int j=0;j<M;j++){
                    graph[i][j] = temp[j];
                    if(temp[j] == 'D'){
                        goalI = i;
                        goalJ = j;
                    }else if (temp[j] == 'S'){
                        suDeque.add(new int[]{i,j});
                        visitedSu[i][j] = true;
                        graph[i][j] = '.';
                    }else if (temp[j] == '*'){ // graph에 *로 업데이트해가며 visited 배열없이 처리
                        akDeque.add(new int[]{i,j});
                    }
                }
            }
            int result = bfs();
            if(result == -1)
                System.out.println("#"+t+" GAME OVER");
            else
                System.out.println("#"+t+" "+result);
        }
    }
    static int bfs(){
        int count = 0;
        while(true){
            count ++;
            int size = akDeque.size();
            for(int i=0;i<size;i++){
                int[] nowNode = akDeque.poll();
                int nowI = nowNode[0];
                int nowJ = nowNode[1];
                for(int k=0;k<4;k++){
                    int ni = nowI + di[k];
                    int nj = nowJ + dj[k];
                    if(ni>=0 && ni<N && nj>=0 && nj<M && graph[ni][nj] == '.'){
                        graph[ni][nj] = '*';
                        akDeque.add(new int[]{ni,nj});
                    }
                }
            }
            size = suDeque.size();
            for(int i=0;i<size;i++){
                int[] nowNode = suDeque.poll();
                int nowI = nowNode[0];
                int nowJ = nowNode[1];
                for(int k=0;k<4;k++){
                    int ni = nowI + di[k];
                    int nj = nowJ + dj[k];
                    if(ni>=0 && ni<N && nj>=0 && nj<M && visitedSu[ni][nj] == false){
                        if(graph[ni][nj] == '.'){
                            visitedSu[ni][nj] = true;
                            suDeque.add(new int[]{ni,nj});
                        // 도착하는경우
                        }else if(graph[ni][nj] == 'D'){
                            return count;
                        }
                    }
                }
            }
            // 갈수있는곳이 없다.
            if(suDeque.size() == 0)
                return -1;
        }
    }
}
