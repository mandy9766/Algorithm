package d0206;

import java.io.*;
import java.util.*;

public class SWEA_1873_상호의배틀필드_최태선 {
    static int H,W,orderCount; // 게임판의 크기
    static char[][] gameBoard;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    static char[] order;
    static int tankI,tankJ,tankD;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<T+1;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            // 게임 보드 세팅
            gameBoard = new char[H][W];
            for(int i=0;i<H;i++){
                gameBoard[i] = br.readLine().toCharArray();
            }

            // 탱크 초기위치 , 방향 세팅
            for (int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    if (gameBoard[i][j] == '^')
                    {
                        tankI = i;
                        tankJ = j;
                        tankD = 0;
                    } else if (gameBoard[i][j] == 'v')
                    {
                        tankI = i;
                        tankJ = j;
                        tankD = 1;
                    } else if (gameBoard[i][j] == '<')
                    {
                        tankI = i;
                        tankJ = j;
                        tankD = 2;
                    } else if (gameBoard[i][j] == '>')
                    {
                        tankI = i;
                        tankJ = j;
                        tankD = 3;
                    }
                }
            }

            // 오더세팅
            orderCount = Integer.parseInt(br.readLine());
            order = br.readLine().toCharArray();

            //오더 시뮬레이션
            for(int i=0;i<orderCount;i++){
                simulation(order[i]);
            }
            
            // 결과출력
            StringBuilder sb = new StringBuilder();
            sb.append("#"+t+" ");
            for(int i=0;i<H;i++){
                for(int j=0;j<W;j++){
                    sb.append(gameBoard[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }
        
    }
    public static void simulation(char orderNow){
        int ni =0;
        int nj =0;
        switch (orderNow) {
            case 'U':
                tankD = 0;
                gameBoard[tankI][tankJ] = '^';
                ni = tankI + di[tankD];
                nj = tankJ + dj[tankD];
                if (ni>=0 && ni<H && nj>=0 && nj<W && gameBoard[ni][nj] == '.'){
                    gameBoard[tankI][tankJ] = '.';
                    gameBoard[ni][nj] = '^';
                    tankI = ni;
                    tankJ = nj;
                }
                return;
            case 'D':    
                tankD = 1;
                gameBoard[tankI][tankJ] = 'v';
                ni = tankI + di[tankD];
                nj = tankJ + dj[tankD];
                if (ni>=0 && ni<H && nj>=0 && nj<W && gameBoard[ni][nj] == '.'){
                    gameBoard[tankI][tankJ] = '.';
                    gameBoard[ni][nj] = 'v';
                    tankI = ni;
                    tankJ = nj;
                }
                return;
            case 'L':    
                tankD = 2;
                gameBoard[tankI][tankJ] = '<';
                ni = tankI + di[tankD];
                nj = tankJ + dj[tankD];
                if (ni>=0 && ni<H && nj>=0 && nj<W && gameBoard[ni][nj] == '.'){
                    gameBoard[tankI][tankJ] = '.';
                    gameBoard[ni][nj] = '<';
                    tankI = ni;
                    tankJ = nj;
                }
                return;
            case 'R':   
                tankD = 3;
                gameBoard[tankI][tankJ] = '>';
                ni = tankI + di[tankD];
                nj = tankJ + dj[tankD];
                if (ni>=0 && ni<H && nj>=0 && nj<W && gameBoard[ni][nj] == '.'){
                    gameBoard[tankI][tankJ] = '.';
                    gameBoard[ni][nj] = '>';
                    tankI = ni;
                    tankJ = nj;
                } 
                return;
            case 'S': 
                int count = 0;
                while(true){
                    count ++;
                    ni = tankI + di[tankD]*count;
                    nj = tankJ + dj[tankD]*count;
                    if(ni>=H || nj>=W || ni<0 || nj<0 || gameBoard[ni][nj] == '#')
                        break;
                    else if(gameBoard[ni][nj] == '*'){
                        gameBoard[ni][nj] = '.';
                        break;
                    }
                }
                return;
            default:
                return;
        }
    }
}
