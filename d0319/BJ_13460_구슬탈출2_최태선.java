package d0319;

import java.io.*;
import java.util.*;

public class BJ_13460_구슬탈출2_최태선 {
    static class Pos{
        int i;
        int j;
        Pos(int i,int j){
            this.i = i;
            this.j = j;
        }
    }
    static int N,M;
    static char[][] graph;
    static int minVal;
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,1,0,-1};
    static Pos Red,Blue;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new char[N][M];
        minVal = Integer.MAX_VALUE;

        for(int i=0;i<N;i++){
            char[] temp = br.readLine().toCharArray();
            for(int j=0;j<M;j++){
                graph[i][j] = temp[j];
                if(graph[i][j] == 'R'){
                    Red = new Pos(i,j);
                }
                else if (graph[i][j] == 'B'){
                    Blue = new Pos(i,j);
                }
            }
        }
        // 처리
        dfs(1);
        if(minVal == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(minVal);
    }
    static void dfs(int depth){
        if(depth >= minVal)
            return;
        // 최대 10번까지만
        if(depth == 11){
            return;
        }
        char[][] tempGraph = new char[N][M];
        Pos tempRed = new Pos(Red.i,Red.j);
        Pos tempBlue = new Pos(Blue.i,Blue.j);
        for(int i=1;i<N-1;i++){
            for(int j=1;j<M-1;j++){
                tempGraph[i][j] = graph[i][j];
            }
        }
        for(int k=0;k<4;k++){
            // 각 방향으로 하는 메서드 진행 (만약 이때 성공했으면 minVal = min(minval,depth+1)로 처리후 뒤는 하지않음)
            boolean isFinished = playGame(depth,k);
            
            if(isFinished == false)
                dfs(depth+1);
            // 그래프 이전으로 원복
            for(int i=1;i<N-1;i++){
                for(int j=1;j<M-1;j++){
                    graph[i][j] = tempGraph[i][j];
                }
            }
            // 레드공 블루공 위치도 원복
            Red.i = tempRed.i;
            Red.j = tempRed.j;
            Blue.i = tempBlue.i;
            Blue.j = tempBlue.j;
        }
    }
    static boolean playGame(int depth, int k){
        char redRaiserResult;
        char blueRaiserResult;
        int Rni = Red.i +di[k];
        int Rnj = Red.j +dj[k];
        while(true){
            if(graph[Rni][Rnj] != '.'){
                redRaiserResult = graph[Rni][Rnj];
                break;
            }
            else{
                Rni = Rni +di[k];
                Rnj = Rnj +dj[k];
            }
        }
        int Bni = Blue.i +di[k];
        int Bnj = Blue.j +dj[k];
        while(true){

            if(graph[Bni][Bnj] != '.'){
                blueRaiserResult = graph[Bni][Bnj];
                break;
            }
            else{
                Bni = Bni +di[k];
                Bnj = Bnj +dj[k];
            }
        }
        if(redRaiserResult == 'O'){
            if(blueRaiserResult != 'R'){
                minVal = Math.min(minVal,depth);
                return true;
            }
            else{
                return true;
            }
        }
        if(blueRaiserResult == 'O'){
            return true;
        }
        // 둘다 들어가진 않은경우
        // 만약 둘중하나가 앞에있는경우
        if (redRaiserResult == 'B' || blueRaiserResult == 'R'){
            // A가 B뒤에있으므로 B가 한칸뒤, A가 두칸뒤
            if (redRaiserResult == 'B'){
                int resultBi = Bni -di[k];
                int resultBj = Bnj -dj[k];
                graph[Blue.i][Blue.j] = '.';
                graph[resultBi][resultBj] = 'B';
                Blue.i = resultBi;
                Blue.j = resultBj;

                int resultRi = Bni - 2*di[k];
                int resultRj = Bnj - 2*dj[k];
                graph[Red.i][Red.j] = '.';
                graph[resultRi][resultRj] = 'R';
                Red.i = resultRi;
                Red.j = resultRj;
            }else{ // A가 B 앞에있으므로 A가 한칸뒤, B가 두칸뒤
                int resultRi = Rni -di[k];
                int resultRj = Rnj -dj[k];
                graph[Red.i][Red.j] = '.';
                graph[resultRi][resultRj] = 'R';
                Red.i = resultRi;
                Red.j = resultRj;

                int resultBi = Rni -2*di[k];
                int resultBj = Rnj -2*dj[k];
                graph[Blue.i][Blue.j] = '.';
                graph[resultBi][resultBj] = 'B';
                Blue.i = resultBi;
                Blue.j = resultBj;
            }
            return false;
        }
        // 둘다 #에 막힌경우
        else{
            int resultRi = Rni -di[k];
            int resultRj = Rnj -dj[k];
            graph[Red.i][Red.j] = '.';
            graph[resultRi][resultRj] = 'R';
            Red.i = resultRi;
            Red.j = resultRj;

            int resultBi = Bni -di[k];
            int resultBj = Bnj -dj[k];
            graph[Blue.i][Blue.j] = '.';
            graph[resultBi][resultBj] = 'B';
            Blue.i = resultBi;
            Blue.j = resultBj;
        }
        return false;
    }
}