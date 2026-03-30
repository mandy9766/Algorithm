package d0309;

import java.io.*;
import java.util.*;

public class SWEA_1868_파핑파핑지뢰찾기_최태선 {
    static int T,N;
    static char[][] board;
    static int[] di = {-1,-1,-1,0,1,1,1,0};
    static int[] dj = {-1,0,1,1,1,0,-1,-1};
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            count = 0;
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            for(int i=0;i<N;i++){
                char[] temp = br.readLine().toCharArray();
                for(int j=0;j<N;j++){
                    board[i][j] = temp[j];
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(board[i][j] == '.'&& check(i,j)){
                        bfs(i,j);
                        count ++;
                    }
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(board[i][j] == '.')
                        count ++;
                }
            }
            System.out.println("#"+t+" "+(count));
        }
        
    }
    static boolean check(int i, int j){
        if (board[i][j] == '*')
            return false;
        for(int k=0;k<8;k++){
            int ni = i +di[k];
            int nj = j +dj[k];
            if(ni>=0 && ni<N && nj >= 0 && nj<N && board[ni][nj] == '*')
                return false;
        }
        return true;
    }
    static void bfs(int i, int j){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i,j});
        board[i][j] = '0';

        while(!deque.isEmpty()){
            int[] now = deque.poll();
            int nowI = now[0];
            int nowJ = now[1];
            if(check(nowI,nowJ))
            {
                for(int k=0;k<8;k++){
                    int ni = nowI + di[k];
                    int nj = nowJ + dj[k];
                    if (ni>=0 && ni<N && nj >= 0 && nj<N && board[ni][nj] == '.' ){
                        board[ni][nj] = '0';
                        deque.add(new int[]{ni,nj});
                    }
                }
            }

        }
    }
}
