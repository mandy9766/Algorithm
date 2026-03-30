package d0318;

import java.io.*;
import java.util.*;

public class BJ_13144_ListOfUniqueNumbers_최태선 {
    static int N;
    static int[] arr;
    static long count;
    static Set<Integer> nowSet;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        nowSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        count = 0;
        int s = 0;
        int e = 0;
        while (true){
            int nowE = arr[e];
            if(!nowSet.contains(nowE))
            {
                nowSet.add(nowE);
                e++;
            }else{ // 현재e값이 중복됨
                count += e-s;
                nowSet.remove(arr[s]);
                s++;
            }
            if(e >= N){
                long n = e-s;
                count += n*(n+1)/2;
                break;
            }
            
        }
        System.out.println(count);
    }
}
