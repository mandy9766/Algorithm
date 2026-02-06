package d0205;

import java.io.*;
import java.util.*;
public class BJ_18428_감시피하기_최태선 {
    static String[][] graph;
    static int N ;
    static boolean[][] used;

    static int[][] nowPosition;
    static boolean isPossible;
    static int teacherSize;
    static int[][] teacherPosition;
    static int[] di = {-1,1,0,0};
    static int[] dj = {0,0,-1,1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new String[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                graph[i][j] = st.nextToken();
            }
        }
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j].equals("T")){
                    teacherSize++;
                }
            }
        }
        teacherPosition = new int[teacherSize][2];
        int teacherCount =0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(graph[i][j].equals("T")){
                    teacherPosition[teacherCount][0] = i;
                    teacherPosition[teacherCount][1] = j;
                    teacherCount++;
                }
            }
        }
        used = new boolean[N][N];
        nowPosition = new int[3][2]; // 행은 자리, 열은 각각 i,j
        isPossible = false;
        comb(0);
        if(isPossible)
            System.out.println("YES");
        else
            System.out.println("NO");

    }

    // 세 i,j값을 생성해서 check
    public static void comb(int count){
        if(isPossible == true){
            return;
        }
        if(count == 3){
            check();      
            return;
        }
        for(int i=0;i<N;i++){
            for (int j=0;j<N;j++){
                if(used[i][j] == true || graph[i][j].equals("T") || graph[i][j].equals("S"))
                    continue;
                used[i][j] = true;
                nowPosition[count][0] = i;
                nowPosition[count][1] = j;
                comb(count+1);
                used[i][j] = false;
            }
        }
        
    }
    // nowPosition값 기준으로 가능한지 체크하는 함수
    public static void check(){
        //그래프 세팅
        for(int k=0;k<3;k++){
            int i = nowPosition[k][0];
            int j = nowPosition[k][1];
            graph[i][j] = "O";
        }   
        checkGraph();
        //그래프 원복
        for(int k=0;k<3;k++){
            int i = nowPosition[k][0];
            int j = nowPosition[k][1];
            graph[i][j] = "X";
        }
    }
    // 현 그래프상황에서 감시 피할수있는지 체크하는 함수
    public static void checkGraph(){
        for(int k=0;k<teacherSize;k++){
            int tI = teacherPosition[k][0];
            int tJ = teacherPosition[k][1];
            for(int d=0;d<4;d++){
                int nowDirI = di[d];
                int nowDirJ = dj[d];
                int num = 1;
                while(tI+nowDirI*num>=0 && tI+nowDirI*num<N && tJ+nowDirJ*num>=0 && tJ+nowDirJ*num<N){
                    int nowI = tI+nowDirI*num;
                    int nowJ = tJ+nowDirJ*num;
                    if(graph[nowI][nowJ].equals("S"))
                        return;
                    if(graph[nowI][nowJ].equals("O"))
                        break;
                    num++;
                }
            }
        }
        isPossible =true;
        return;
    }
    
}
