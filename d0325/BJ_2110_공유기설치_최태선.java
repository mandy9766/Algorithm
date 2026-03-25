package d0325;

import java.io.*;
import java.util.*;

public class BJ_2110_공유기설치_최태선 {
    static int N,C;
    static int[] housePos;
    static int maxVal;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N =Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        housePos = new int[N];
        for(int i=0;i<N;i++){
            housePos[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(housePos);
        maxVal = 0;
        int left = 1;
        int right = housePos[N-1];
        while(left<=right){
            int mid = (left+right)/2;
            // mid 값으로 가능하면 
            if(check(mid)){
                maxVal = Math.max(maxVal,mid);
                left = mid+1;
            }
            else{
                right = mid-1;
            }
        }
        System.out.println(maxVal);
    }
    static boolean check(int dist){
        int count = 1;
        int nowPos = housePos[0];
        for(int i=1;i<N;i++){
            if(housePos[i]-nowPos >=dist){
                nowPos = housePos[i];
                count++;
            }
        }
        if(count>=C)
            return true;
        else
            return false;
    }
}
