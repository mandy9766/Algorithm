package d0204;

import java.io.*;
import java.util.*;

public class SWEA_1210_Ladder1_최태선 {
    static int[][] graph;
    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int t=0;t<10;t++){
            int tNum = Integer.parseInt(br.readLine());
            graph = new int[100][100];
            int si = 0;
            int sj = 0;
            for(int i=0;i<100;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0;j<100;j++){
                    graph[i][j] = Integer.parseInt(st.nextToken());
                    if (graph[i][j] == 2){
                        si = i;
                        sj = j;
                    }
                }
            }
            
            while(si != 0){
                int leftJ = sj-1;
                int rightJ = sj +1;
                if (leftJ >=0 && graph[si][leftJ] == 1){
                    // 쭉 왼쪽으로가다가 0만나거나 그래프의 끝을 만나면 중단
                    while(true){
                        sj --;
                        if(sj-1 <0 || graph[si][sj-1] == 0 ){
                            break;
                        }
                    }
                    si--;
                }else if(rightJ<100 && graph[si][rightJ] == 1){
                    // 쭉 오른쪽으로 가다가 100 만나거나 그래프의 끝을 만나면 중단
                    while(true){
                        sj++;
                        if(sj+1 >=100 || graph[si][sj+1] == 0 ){
                            break;
                        }
                    }
                    si--;
                }
                else{
                    si--;
                }
            }
            System.out.println("#"+(tNum) +" "+sj);
        }
    }
}
