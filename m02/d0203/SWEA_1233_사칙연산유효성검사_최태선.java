package d0203;

import java.io.*;
import java.util.*;

public class SWEA_1233_사칙연산유효성검사_최태선 {
    public static String[][] arr;
    public static boolean isPossible;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        for (int t=0;t<10;t++){
            int N = Integer.parseInt(br.readLine());
            arr = new String[10][1000];
            isPossible = true;
            for(int i=0;i<N;i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                int nowNum = Integer.parseInt(st.nextToken());
                int iIdx = getQ(nowNum);
                int jIdx = nowNum - (int)Math.pow(2,iIdx);
                arr[iIdx][jIdx] = st.nextToken();
                if (st.hasMoreTokens()) st.nextToken();
                if (st.hasMoreTokens()) st.nextToken();
            }
            Dfs(0,0);
            if(isPossible)
                System.out.println("#"+(t+1)+" "+1);
            else
                System.out.println("#"+(t+1)+" "+0);
        }
        
    }
    public static int getQ(int x){
        int k=0;
        while(x>1){
            x/= 2;
            k++;
        }
        return k;
    }
    public static int getQ(int x,int y){
        int k=0;
        while(x>1){
            x/= 2;
            k++;
        }
        return k;
    }
    public static void Dfs(int i,int j){
        String now = arr[i][j];
        String left = arr[i+1][2*j];
        String right= arr[i+1][2*j+1];
        // val이 사칙연산인경우
        if(now.equals("+") || now.equals("-") || now.equals("*") || now.equals("/") ){
           if (left == null || right == null){
                isPossible = false;
                return;
           }
        }else{
            if(left != null || right != null){
                isPossible = false;
                return;
            }
        }
        if (left != null)
            Dfs(i+1,2*j);
        if (right!=null)
            Dfs(i+1,2*j+1);
        return;
    }
}
