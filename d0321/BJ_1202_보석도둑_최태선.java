package d0321;

import java.io.*;
import java.util.*;

public class BJ_1202_보석도둑_최태선 {
    static int N,K;
    static TreeMap<Integer,Integer> bagTreeMap;
    static int[][] jewelry;
    static long result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bagTreeMap = new TreeMap<>();
        jewelry = new int[N][2];
        result =0;
        for (int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine()," ");
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewelry[i][0] = m;
            jewelry[i][1] = v;
        }
        for (int i=0;i<K;i++){
            int num = Integer.parseInt(br.readLine());
            if(bagTreeMap.containsKey(num)){
                bagTreeMap.put(num,bagTreeMap.get(num)+1);
            }else{
                bagTreeMap.put(num,1);
            }
        }
        Arrays.sort(jewelry,(a,b)-> Integer.compare(b[1], a[1])); // 쥬얼리 가치순으로 내림차순
        for(int i=0;i<N;i++){
            int nowM = jewelry[i][0];
            int nowV = jewelry[i][1];
            // ceilingKey등을 할때는 값이없을때 null을 리턴하므로 int가아니라 Integer를 쓸것
            Integer minBag = bagTreeMap.ceilingKey(nowM);
            if(minBag == null)
                continue;
            else{
                result+= nowV;
                int count = bagTreeMap.get(minBag);
                if(count == 1){
                    bagTreeMap.remove(minBag);
                }else{
                    bagTreeMap.put(minBag,count-1);
                }
            }
        }
        System.out.println(result);
    }    
}
