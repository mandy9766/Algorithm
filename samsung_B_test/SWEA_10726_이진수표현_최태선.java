package samsung_B_test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_10726_이진수표현_최태선 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            boolean isOn = true;
            for (int i=0;i<N;i++){
                if((M &(1<<i)) == 0){
                    isOn = false;
                    break;
                }
            }
            if(isOn == false)
                System.out.println("#"+(t+1) + " OFF");
            else
                System.out.println("#"+(t+1) + " ON");
        }

    }
}
