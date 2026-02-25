package d0225;

import java.io.*;
import java.util.*;


public class SWEA_2948_문자열교집합_최태선 {
    static int T,N,M;
    static String[] s1,s2;
    static int count;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            s1 = new String[N];
            s2 = new String[M];
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<N;i++){
                s1[i] = st.nextToken();
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0;i<M;i++){
                s2[i] = st.nextToken();
            }
            Arrays.sort(s1);
            Arrays.sort(s2);

            count= 0;
            for(int i=0;i<N;i++){
                binarySearch(s1[i]);
            }
            
            System.out.println("#"+t+" "+count);
        }
    }
    static void binarySearch(String s){
        int start = 0;
        int end = M-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(s2[mid].equals(s)){
                count ++;
                return;
            }
            else{
                if(s.compareTo(s2[mid])<0){ // 찾는값이 s2mid 값보다 작다 -> end를 줄여
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
        }
    }
}
