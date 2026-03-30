package d0330;

import java.io.*;
import java.util.*;

public class BJ_14503_로봇청소기_최태선 {
    static int N,M;
    static int[][] graph;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static int posI,posJ,dir;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        st = new StringTokenizer(br.readLine()," ");
        posI = Integer.parseInt(st.nextToken());
        posJ = Integer.parseInt(st.nextToken());
        dir = Integer.parseInt(st.nextToken());
        for(int i=0;i<N;i++){
            st= new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        count = 0;
        play();
        System.out.println(count);
    }
    static void play(){
        while (true){
            // 1. 현재 칸이 아직 청소되지 않은 경우 현재칸 청소
            if(graph[posI][posJ] == 0){
                graph[posI][posJ] = 2;
                count++;
            }
            //2. 현재 칸의 주변 4칸중 청소되지 않은 빈칸이 없는경우 
                // 바라보는 방향 유지한채로 한칸 후진할수 있으면 한칸 후진하고 1번으로 돌아감
                // 뒤쪽이 벽이라 후진할수 없다면 return;
            if(check() == false){
                int ni = posI + di[(dir+2)%4];
                int nj = posJ + dj[(dir+2)%4];
                if(graph[ni][nj] == 1)
                    return;
                else{
                    posI = ni;
                    posJ = nj;
                    continue;
                }
            }
            //3. 현재칸의 주변 4칸중 청소되지 않은 빈칸이 있는경우
                // 반시계로 90도 회전 dir = (dir+3)%4
                // 바라보는 방향 기준으로 앞쪽 칸 청소되지 않은 빈 칸인 경우 한칸 전진
                // 1번으로 돌아가기
            else{
                dir = (dir+3)%4;
                int ni = posI + di[dir];
                int nj = posJ + dj[dir];
                if(graph[ni][nj] == 0){
                    posI = ni;
                    posJ = nj;
                }
            }
        }
    }
    static boolean check(){
        int blankCount = 0;
        for(int i=0;i<4;i++){
            int ni = posI + di[i];
            int nj = posJ + dj[i];
            if(graph[ni][nj] == 0)
                blankCount ++;
        }
        if(blankCount >=1)
            return true;
        else
            return false;
    }
}
