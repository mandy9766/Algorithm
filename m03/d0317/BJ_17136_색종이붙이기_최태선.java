import java.io.*;
import java.util.*;

public class BJ_17136_색종이붙이기_최태선 {
    static int[][] graph;
    static int minVal;
    static int[] nowCount;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        graph = new int[10][10];
        for(int i=0;i<10;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<10;j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        minVal = Integer.MAX_VALUE;
        nowCount = new int[6]; // 색종이 카운트
        dfs(0,0,0);
        if(minVal != Integer.MAX_VALUE)
            System.out.println(minVal);
        else
            System.out.println(-1);
    }
    static void dfs(int i,int j,int c){
        if( c> minVal)
            return;
        if(i==10){
            if(check()){
                minVal = Math.min(minVal,c);
            }
            return;
        }
        // 그냥 넘기는 경우 (0이라서)
        if(graph[i][j] == 0){
            if(j == 9){
                    dfs(i+1,0,c);
            }else{
                dfs(i,j+1,c);
            }
        }
        else{
            // 현재 위치에 색종이를 붙이는 경우
            for(int nowSize = 1; nowSize<6;nowSize++){
                if(nowCount[nowSize]>= 5)
                    continue;
                boolean isPossible = true;
                for(int p = i;p<i+nowSize;p++){
                    for(int q = j;q<j+nowSize;q++){
                        if(p>=10 || q >= 10 || graph[p][q] != 1){
                            isPossible = false;
                            break;
                        }
                    }
                    if(!isPossible)
                        break;
                }
                if(isPossible) { // nowSize가 남아있고, 붙일수있으면
                    nowCount[nowSize] ++;
                    setGraph(i, j, 0, nowSize);
                    if(j + nowSize == 10){
                        dfs(i+1,0,c+1);
                    }else{
                        dfs(i,j+nowSize,c+1);
                    }
                    setGraph(i, j, 1, nowSize);
                    nowCount[nowSize] --;
                }
            }
        }
    }  
    static boolean check(){
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                if (graph[i][j] != 0)
                    return false;
            }
        }
        return true;
    }
    static void setGraph(int p,int q,int setNum,int nowSize){
        for(int i=p;i<p+nowSize;i++){
            for(int j=q;j<q+nowSize; j++){
                graph[i][j] = setNum;
            }
        }
    }
}
