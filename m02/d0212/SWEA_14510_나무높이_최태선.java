package d0212;

import java.io.*;
import java.util.*;


public class SWEA_14510_나무높이_최태선 {
    static int N;
    static int[] trees;
    static int day;
    static int maxHeight;
    static int idx;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){
            N = Integer.parseInt(br.readLine());
            trees = new int[N];
            maxHeight = 0;
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }
            for(int i=0;i<N;i++){
                trees[i] = maxHeight - trees[i];
            }
            
            day = 0;
            while(!isZero()){
                day ++;
                if(day%2 == 1){
                    if(exist1Check())
                    {
                        trees[idx] --;
                    }else if(exist3Check()){
                        trees[idx] --;
                    }else if(exist2by2Check()){
                        trees[idx] --;
                    }
                    
                }else{
                    if(exist2Check()){
                        trees[idx] -= 2;
                    }else if(exist3Check()){
                        trees[idx] -= 2;
                    }
                }
            }
            System.out.println("#"+(t+1)+" "+day);
        }
    }
    
    static boolean exist1Check(){ 
        for(int i=0;i<N;i++){
            if(trees[i] == 1){
                idx = i;
                return true;
            }
        }
        return false;
    }
    static boolean exist2Check(){ 
        for(int i=0;i<N;i++){
            if(trees[i] == 2){
                idx = i;
                return true;
            }
        }
        return false;
    }
    static boolean exist3Check(){ 
        for(int i=0;i<N;i++){
            if(trees[i] >= 3){
                idx = i;
                return true;
            }
        }
        return false;
    }
    static boolean isZero(){ 
        for(int i=0;i<N;i++){
            if(trees[i] != 0)
                return false;
        }
        return true;
    }
    static boolean exist2by2Check(){ 
        int cnt =0;
        for(int i=0;i<N;i++){
            if(trees[i] == 2){
                cnt ++;
                idx = i;
            }
        }
        if(cnt>=2)
            return true;
        else 
            return false;
    }
}


