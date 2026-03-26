package d0326;

import java.io.*;
import java.util.*;

public class BJ_12015_가장긴증가하는부분수열2_최태선R {
    static int N;
    static int[] A;
    static List<Integer> list;
    public static void main(String[] args) throws Exception{   
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        list = new ArrayList<>();
        for(int i=0;i<N;i++){
            int idx = Collections.binarySearch(list, A[i]);
            
            if(idx < 0){
                idx = -(idx+1);
            }
            if(idx == list.size())
                list.add(A[i]);
            else
            list.set(idx,A[i]);
        }
        System.out.println(list.size());   
       
        
    }
}
