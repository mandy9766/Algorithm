package d0210;

import java.io.*;
import java.util.*;


public class SWEA_1952_수영장_최태선 {
    static int[] plan,table;    
    static int minVal;
    public static void main(String[] args) throws Exception {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        plan = new int[3];
        table = new int[12];
        for(int t=0;t<T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            plan[0] = Integer.parseInt(st.nextToken()); // 1일짜리
            plan[1] = Integer.parseInt(st.nextToken()); //1개월짜리
            plan[2] = Integer.parseInt(st.nextToken()); // 3개월치
            minVal = Integer.parseInt(st.nextToken()); // 1년치로 미니멈값 잡고
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<12;i++)
                table[i] = Integer.parseInt(st.nextToken());  
            Dfs(0,0); 
            System.out.println("#"+(t+1) +" " +minVal);       
        }
    
    }
    static void Dfs(int day, int sum){
        if (sum >= minVal) return;
        if(day >= 12){ // 12월까지 다 돈경우 ( 12월 인덱스 11)
            minVal = Math.min(minVal, sum);
            return;
        }
        if (table[day] == 0){
            Dfs(day+1,sum);
        }
        else{
            Dfs(day+3,sum+plan[2]);
            Dfs(day+1,sum+plan[1]);
            Dfs(day+1,sum+plan[0]*table[day]);
        }
    }
}
