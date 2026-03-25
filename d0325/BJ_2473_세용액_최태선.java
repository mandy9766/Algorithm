package d0325;

import java.io.*;
import java.util.*;

public class BJ_2473_세용액_최태선 {
    static int N;
    static int[] arr;
    static long result;
    static int resI,resJ,resK;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        result = Long.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<N;i++){
            for(int j=i+1;j<N;j++){
                int target = -(arr[i]+arr[j]);
                // 선택된값 i , j  binarySearch로 타겟이랑 가장 가까운 인덱스 구하기, 그값과 그 전값 둘다비교
                int selectedIdx = Arrays.binarySearch(arr,j+1,N, target);
                if(selectedIdx<0)
                    selectedIdx = -(selectedIdx+1);
                if(selectedIdx<N){
                    if (result >Math.abs((long)arr[i]+arr[j]+arr[selectedIdx])){
                        result = Math.abs((long)arr[i]+arr[j]+arr[selectedIdx]);
                        resI = i;
                        resJ = j;    
                        resK = selectedIdx;
                    }
                }
                if(selectedIdx == j+1)
                    continue;
                if (result >Math.abs((long)arr[i]+arr[j]+arr[selectedIdx-1])){
                    result = Math.abs((long)arr[i]+arr[j]+arr[selectedIdx-1]);
                    resI = i;
                    resJ = j;
                    resK = selectedIdx-1;
                }
                
                
            }
        }
        System.out.println(arr[resI] + " "+ arr[resJ] + " "+ arr[resK]);
    }
    
}
