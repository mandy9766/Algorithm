package d0225;

import java.io.*;
import java.util.*;

public class BJ_14658_하늘에서별똥별이빗발친다_최태선 {
    static int N,M,L,K;
    static int[][] pos;
    static int maxCount;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        maxCount=0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        pos = new int[K][2];
        for(int k=0;k<K;k++){
            st = new StringTokenizer(br.readLine()," ");
            pos[k][0] = Integer.parseInt(st.nextToken()); // x
            pos[k][1] = Integer.parseInt(st.nextToken()); // y
        }
        for(int i=0;i<K;i++){
            for(int j=0;j<K;j++){
                int x1 = pos[i][0];
                int y2 = pos[j][1];
                check(x1,y2);
            }
        }

        System.out.println(K-maxCount);
        
    }
    static void check(int x1, int y2){// 범위안에 최대로 들어오는 별똥별 값 리턴
        int count =0;
        for(int k=0;k<K;k++){
            int x = pos[k][0];
            int y = pos[k][1];
            if(x>=x1 && x<=x1+L && y>=y2 && y<=y2+L){
                count ++;
            }
        }
        maxCount = Math.max(maxCount, count);
    }
}
