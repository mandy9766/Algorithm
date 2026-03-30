import java.io.*;
import java.util.*;

public class BJ_1644_소수의연속합_최태선 {
    static int N;
    static List<Integer> abNum;
    static boolean[] aristo;
    static int[] abNumArr;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        aristo = new boolean[N+1];
        abNum = new ArrayList<>();
        Arrays.fill(aristo, true);
        for(int i=2;i<N+1;i++){
            for(long j= (long)i*i;j<N+1;j+=i){
                aristo[(int)j] = false;
            }
        }
        for(int i=2;i<N+1;i++){
            if(aristo[i])
                abNum.add(i);
        }
        int size = abNum.size();
        abNumArr= new int[size];
        for(int i=0;i<size;i++){
            abNumArr[i] = abNum.get(i);
        }

        int s = 0;
        int e = 0;
        int nowSum = 0;
        int count =0;
        while(true){
            if(nowSum>=N)
            {
                if(nowSum == N)
                    count ++;
                nowSum -= abNumArr[s];
                s ++;
            }
            // N보다 작은데 e 추가할게없으면
            else if(e == size){
                break;
            // 있으면 e 추가해보기
            }else{
                nowSum += abNumArr[e];
                e++;
            }
        }
        System.out.println(count);
    }    
}
