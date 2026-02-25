package d0225;

import java.io.*;
import java.util.*;

public class SWEA_1868_파핑파핑지뢰찾기_최태선 {
    static int T,N,countBomb,count,countZero;
    static char[][] board;
    static boolean[][] visited;
    static int[] di ={-1,-1,-1,0,1,1,1,0};
    static int[] dj ={-1,0,1,1,1,0,-1,-1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        for(int t=1;t<=T;t++){
            N = Integer.parseInt(br.readLine());
            board = new char[N][N];
            visited = new boolean[N][N];
            countBomb = 0;
            countZero = 0;
            count = 0;
            for(int i=0;i<N;i++){
                char[] temp = br.readLine().toCharArray();
                for(int j=0;j<N;j++){
                    board[i][j] = temp[j];
                    if(temp[j] == '*')
                        countBomb ++;
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visited[i][j] == false && check(i,j) && board[i][j] !='*'){
                        visited[i][j] = true;
                        bfs(i,j);
                        count++;
                    }
                }
            }
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(visited[i][j] == true){
                        countZero++;
                    }
                }
            }
            System.out.println("#"+t+" "+(count+(N*N-(countBomb+countZero))));
            
        }
    }
    static void bfs(int i,int j){
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{i,j});
        while(!deque.isEmpty()){
            int[] nowTile = deque.poll();
            int nowI = nowTile[0];
            int nowJ = nowTile[1];
            if(check(nowI,nowJ)){
                for(int k=0;k<8;k++){
                    int ni= nowI+di[k];
                    int nj= nowJ+dj[k];
                    if(ni>=0 && ni<N && nj>=0 && nj<N){
                        if (board[ni][nj] !='*' && visited[ni][nj] == false){
                            visited[ni][nj] = true;
                            deque.add(new int[]{ni,nj});
                        } 
                    }
                }
            }
        }
    }
    static boolean check(int i, int j){
        for(int k=0;k<8;k++){
            int ni= i+di[k];
            int nj= j+dj[k];
            if(ni>=0 && ni<N && nj>=0 && nj<N){
                if (board[ni][nj] =='*'){
                    return false;
                } 
            }
        }
        return true;
    }
}
