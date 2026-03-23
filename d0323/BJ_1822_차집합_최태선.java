package d0323;

import java.io.*;
import java.util.*;

public class BJ_1822_차집합_최태선 {
    static int N , M;
    static int[] A , B;
    static List<Integer> result;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        B = new int[M];
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            A[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<M;i++){
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);
        Arrays.sort(B);
        result = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(Arrays.binarySearch(B, A[i]) < 0){
                result.add(A[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        if(result.size() == 0)
            System.out.println(0);
        else{
            for(int i=0;i<result.size();i++){
                sb.append(result.get(i)).append(" ");
            }
            System.out.println(result.size());
            System.out.println(sb);
        }

    }
}
