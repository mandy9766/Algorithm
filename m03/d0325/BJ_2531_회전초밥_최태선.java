package d0325;

import java.io.*;
import java.util.*;

public class BJ_2531_회전초밥_최태선 {
    static int N,D,K,C;
    static int[] sushi;
    static Map<Integer,Integer> nowMap;
    static int maxVal;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        nowMap = new HashMap<>();
        sushi = new int[N+K];
        for(int i=0;i<N;i++){
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for(int i=N;i<N+K;i++){
            sushi[i] = sushi[i-N];
        }
        maxVal = 0;
        for(int i=0;i<K;i++){
            if(nowMap.containsKey(sushi[i]))
                nowMap.put(sushi[i],nowMap.get(sushi[i])+1);
            else
                nowMap.put(sushi[i],1);
        }
        maxVal = nowMap.size();
        if(!nowMap.containsKey(C))
            maxVal ++;
        for(int i=1;i<N;i++){
            int deleteSushi = sushi[i-1];
            if(nowMap.get(deleteSushi)>1)
                nowMap.put(deleteSushi,nowMap.get(deleteSushi)-1);
            else
                nowMap.remove(deleteSushi);
            if(nowMap.containsKey(sushi[i-1+K]))
                nowMap.put(sushi[i-1+K],nowMap.get(sushi[i-1+K])+1);
            else
                nowMap.put(sushi[i-1+K],1);
            int nowVal = nowMap.size();
            if(!nowMap.containsKey(C))
                nowVal++;
            maxVal = Math.max(maxVal,nowVal);
        }
        System.out.println(maxVal);
    }
}
